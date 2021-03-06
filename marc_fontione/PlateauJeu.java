import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class PlateauJeu extends ConfigPartie{

    public PlateauJeu(){
	int nombreColonnes = this.getNombreColonnes();
        int nombreLignes = this.getNombreLignes();
    }

    
    public CaseJeu[][] initPlateau(){
	//int nombreCases = (this.getNombreLignes()*this.getNombreColonnes());
	CaseJeu [][]plateau = new CaseJeu[this.getNombreColonnes()][this.getNombreLignes()];
        //for(int i=0; i<(int)nombreCases; i++){
	    for(int y=0; y<(int)this.getNombreColonnes(); y++){  
	        for(int x=0; x<(int)this.getNombreLignes(); x++){
                    CaseJeu emplacement = new CaseJeu((int)x, (int)y);
		    plateau[y][x] = emplacement;
		    emplacement.setOccupant(emplacement.getOccupant());
		    emplacement.setOverwritable(emplacement.getOverwritable());
		}
	    }
	    //}
        return plateau;
    }

    /*
    public ArrayList listerObjets(CaseJeu objet, CaseJeu [][]plateau, int nombre){ //modifier listerObjets de manière à disposer les pièces du joueur 1, les pièces du joueur 2 et les pièces neutres comme dans l'énoncé.
	ArrayList objets = new ArrayList();
        for(int i=0; i<nombre; i++){
	    boolean poseOK = false;
	    int xObjet = objet.getCoordX();
	    int yObjet = objet.getCoordY();
	    xObjet = (int)(Math.random() * this.getNombreColonnes());
	    yObjet = (int)(Math.random() * this.getNombreLignes());
	    while(poseOK == false){
	        if(plateau[yObjet][xObjet].getOccupant() == " "){
		    objet.setCoordX(xObjet);
	            objet.setCoordY(yObjet);
		    plateau[yObjet][xObjet].setOccupant(objet.getOccupant());
		    plateau[yObjet][xObjet].setOverwritable(objet.getOverwritable());
		    plateau[yObjet][xObjet].setPickable(objet.getPickable());
	            poseOK=true;               
	        }
                else{
	            xObjet = (int)(Math.random() * this.getNombreColonnes());
	            yObjet = (int)(Math.random() * this.getNombreLignes());
	        }
	    }
	    objet = plateau[yObjet][xObjet];
	    //System.out.println(xObjet+" | "+yObjet+" | "+objet.getOccupant()); //debugging
	    objets.add(objet);
	}
	return objets;
    }
    */

    public CaseJeu[][] poserMetabolites(Metabolite metabolite, CaseJeu [][]plateau, int nombre){
	ArrayList metabolites = new ArrayList();
        for(int i=0; i<nombre; i++){
	    boolean poseOK = false;
	    int xObjet = (int)(Math.random() * this.getNombreColonnes());
	    int yObjet = ThreadLocalRandom.current().nextInt(4, 10 + 1);
	    //Metabolite metabolite = new Metabolite(xObjet, yObjet);
	    //metabolite.setCoordX();
	    //metabolite.setCoordY();
	    while(poseOK == false){
	        if(plateau[yObjet][xObjet].getOccupant() == " "){
		    metabolite.setCoordX(xObjet);
	            metabolite.setCoordY(yObjet);
		    //plateau[yObjet][xObjet].setOccupant(metabolite.getOccupant());
		    //plateau[yObjet][xObjet].setOverwritable(metabolite.getOverwritable());
		    //plateau[yObjet][xObjet].setPickable(metabolite.getPickable());
	            poseOK=true;               
	        }
                else{
		    xObjet = (int)(Math.random() * this.getNombreColonnes());
		    yObjet = ThreadLocalRandom.current().nextInt(4, 10 + 1);
	        }
	    }
	    plateau[yObjet][xObjet] = (Metabolite)metabolite;
	    //(Metabolite)metabolite = plateau[yObjet][xObjet];
	    //System.out.println(xObjet+" | "+yObjet+" | "+objet.getOccupant()); //debugging
	    metabolites.add(metabolite);
	}
	plateau = this.genererObjets(metabolites, plateau);
	return plateau;
    }
    
    
    public CaseJeu[][] poserLipidesJ1(CaseJeu [][]plateau, int nombre){
	ArrayList lipidesJ1 = new ArrayList();
	int nombrePionsPoses = 0;
	int positionPremierPion = this.getNombreColonnes();	    
	for(int y=(this.getNombreLignes())-2; y>(this.getNombreLignes())-5; y--){
	    if(y%2==0){
		positionPremierPion=positionPremierPion-1;
	    }
	    else if(y%2!=0){
		positionPremierPion=this.getNombreColonnes();
	    }
	    for(int x = positionPremierPion; x>=0; x--){
		if(y%2!=0){
		    if(x%2 == 0 && plateau[y][x].getOccupant() == " "){
			LipideJ1 lipideJ1 = new LipideJ1(x, y);
			lipidesJ1.add(lipideJ1);
			nombrePionsPoses=nombrePionsPoses+1;
			nombre=nombre-1;
		    }	   
		}
		else if(y%2==0){
		    if(x%2 != 0 && plateau[y][x].getOccupant() == " "){
			LipideJ1 lipideJ1 = new LipideJ1(x, y);
			lipidesJ1.add(lipideJ1);
			nombrePionsPoses=nombrePionsPoses+1;
			nombre=nombre-1;
		    }	   
		}
		if(nombre <= 0){
		    break;
		}
		//System.out.println(nombre+" | "+ nombrePionsPoses);
	    }
	}
	plateau = this.genererObjets(lipidesJ1, plateau);
	return plateau;
    }

    public CaseJeu[][] poserLipidesJ2(CaseJeu [][]plateau, int nombre){
	ArrayList lipidesJ2 = new ArrayList();
	int nombrePionsPoses = 0;
	int positionPremierPion = 0;	    
	for(int y=1; y<4; y++){
	    if(y%2==0){
		positionPremierPion=positionPremierPion+1;
	    }
	    else if(y%2!=0){
		positionPremierPion=0;
	    }
	    for(int x = positionPremierPion; x<this.getNombreColonnes(); x++){
		if(y%2!=0){
		    if(x%2 == 0 && plateau[y][x].getOccupant() == " "){
			LipideJ2 lipideJ2 = new LipideJ2(x, y);
			lipidesJ2.add(lipideJ2);
			nombrePionsPoses=nombrePionsPoses+1;
			nombre=nombre-1;
		    }	   
		}
		else if(y%2==0){
		    if(x%2 != 0 && plateau[y][x].getOccupant() == " "){
			LipideJ2 lipideJ2 = new LipideJ2(x, y);
			lipidesJ2.add(lipideJ2);
			nombrePionsPoses=nombrePionsPoses+1;
			nombre=nombre-1;
		    }	   
		}
		if(nombre <= 0){
		    break;
		}
		//System.out.println(nombre+" | "+ nombrePionsPoses);
	    }
	}
	plateau = this.genererObjets(lipidesJ2, plateau);
	return plateau;
    }

    public CaseJeu[][] poserEnzymesBleuesJ1(CaseJeu [][]plateau, int nombre){
	ArrayList enzymesBleuesJ1 = new ArrayList();
	for(int i = 0; i<nombre; i++){
	    //for(int y=0; y<(int)this.getNombreColonnes(); y++){
	    int positionPremierPion = (this.getNombreColonnes()-1);
	    int y = (this.getNombreLignes()-1);
	    //for(int x=0; x<(int)this.getNombreLignes(); x++){
		for(int x=positionPremierPion; x>(int)positionPremierPion-nombre-1; x--){
		    if(x%2 == 0 && plateau[y][x].getOccupant() == " "){
			EnzymeBleueJ1 enzymeBleueJ1 = new EnzymeBleueJ1(x, y);
			enzymesBleuesJ1.add(enzymeBleueJ1);
		    }
		   
		}
		//}
	}
	plateau = this.genererObjets(enzymesBleuesJ1, plateau);
	return plateau;
    }

    public CaseJeu[][] poserEnzymesBleuesJ2(CaseJeu [][]plateau, int nombre){
	ArrayList enzymesBleuesJ2 = new ArrayList();
	for(int i = 0; i<nombre; i++){
	    //for(int y=0; y<(int)this.getNombreColonnes(); y++){
	    int positionPremierPion = 0;
	    int y = 0;
	    //for(int x=0; x<(int)this.getNombreLignes(); x++){
		for(int x=positionPremierPion; x<(int)positionPremierPion+nombre+1; x++){
		    if(x%2 == 0 && plateau[y][x].getOccupant() == " "){
			EnzymeBleueJ2 enzymeBleueJ2 = new EnzymeBleueJ2(x, y);
			enzymesBleuesJ2.add(enzymeBleueJ2);
		    }
		   
		}
		//}
	}
	plateau = this.genererObjets(enzymesBleuesJ2, plateau);
	return plateau;
    }


    public CaseJeu[][] poserEnzymesVertesJ1(CaseJeu [][]plateau, int nombre){
	ArrayList enzymesVertesJ1 = new ArrayList();
	for(int i = 0; i<nombre; i++){
	    //for(int y=0; y<(int)this.getNombreColonnes(); y++){
	    int positionPremierPion = (this.getNombreColonnes()-1)-4;
	    int y = (this.getNombreLignes()-1);
	    //for(int x=0; x<(int)this.getNombreLignes(); x++){
		for(int x=positionPremierPion; x>(int)positionPremierPion-nombre-1; x--){
		    if(x%2 == 0 && plateau[y][x].getOccupant() == " "){
			EnzymeVerteJ1 enzymeVerteJ1 = new EnzymeVerteJ1(x, y);
			enzymesVertesJ1.add(enzymeVerteJ1);
		    }
		   
		}
		//}
	}
	plateau = this.genererObjets(enzymesVertesJ1, plateau);
	return plateau;
    }

    public CaseJeu[][] poserEnzymesVertesJ2(CaseJeu [][]plateau, int nombre){
	ArrayList enzymesVertesJ2 = new ArrayList();
	for(int i = 0; i<nombre; i++){
	    //for(int y=0; y<(int)this.getNombreColonnes(); y++){
	    int positionPremierPion = 4;
	    int y = 0;
	    //for(int x=0; x<(int)this.getNombreLignes(); x++){
		for(int x=positionPremierPion; x<(int)positionPremierPion+nombre+1; x++){
		    if(x%2 == 0 && plateau[y][x].getOccupant() == " "){
			EnzymeVerteJ2 enzymeVerteJ2 = new EnzymeVerteJ2(x, y);
			enzymesVertesJ2.add(enzymeVerteJ2);
		    }
		   
		}
		//}
	}
	plateau = this.genererObjets(enzymesVertesJ2, plateau);
	return plateau;
    }


    public CaseJeu[][] poserEnzymesJaunesJ1(CaseJeu [][]plateau, int nombre){
	ArrayList enzymesJaunesJ1 = new ArrayList();
	for(int i = 0; i<nombre; i++){
	    //for(int y=0; y<(int)this.getNombreColonnes(); y++){
	    int positionPremierPion = (this.getNombreColonnes()-1)-8;
	    int y = (this.getNombreLignes()-1);
	    //for(int x=0; x<(int)this.getNombreLignes(); x++){
		for(int x=positionPremierPion; x>(int)positionPremierPion-nombre-1; x--){
		    if(x%2 == 0 && plateau[y][x].getOccupant() == " "){
			EnzymeJauneJ1 enzymeJauneJ1 = new EnzymeJauneJ1(x, y);
			enzymesJaunesJ1.add(enzymeJauneJ1);
		    }
		   
		}
		//}
	}
	plateau = this.genererObjets(enzymesJaunesJ1, plateau);
	return plateau;
    }

    public CaseJeu[][] poserEnzymesJaunesJ2(CaseJeu [][]plateau, int nombre){
	ArrayList enzymesJaunesJ2 = new ArrayList();
	for(int i = 0; i<nombre; i++){
	    //for(int y=0; y<(int)this.getNombreColonnes(); y++){
	    int positionPremierPion = 8;
	    int y = 0;
	    //for(int x=0; x<(int)this.getNombreLignes(); x++){
		for(int x=positionPremierPion; x<(int)positionPremierPion+nombre+1; x++){
		    if(x%2 == 0 && plateau[y][x].getOccupant() == " "){
			EnzymeJauneJ2 enzymeJauneJ2 = new EnzymeJauneJ2(x, y);
			enzymesJaunesJ2.add(enzymeJauneJ2);
		    }
		   
		}
		//}
	}
	plateau = this.genererObjets(enzymesJaunesJ2, plateau);
	return plateau;
    }


    public CaseJeu[][] poserEnzymesRougesJ1(CaseJeu [][]plateau, int nombre){
	ArrayList enzymesRougesJ1 = new ArrayList();
	for(int i = 0; i<nombre; i++){
	    //for(int y=0; y<(int)this.getNombreColonnes(); y++){
	    int positionPremierPion = (this.getNombreColonnes()-1)-12;
	    int y = (this.getNombreLignes()-1);
	    //for(int x=0; x<(int)this.getNombreLignes(); x++){
		for(int x=positionPremierPion; x>(int)positionPremierPion-nombre-1; x--){
		    if(x%2 == 0 && plateau[y][x].getOccupant() == " "){
			EnzymeRougeJ1 enzymeRougeJ1 = new EnzymeRougeJ1(x, y);
			enzymesRougesJ1.add(enzymeRougeJ1);
		    }
		   
		}
		//}
	}
	plateau = this.genererObjets(enzymesRougesJ1, plateau);
	return plateau;
    }

    public CaseJeu[][] poserEnzymesRougesJ2(CaseJeu [][]plateau, int nombre){
	ArrayList enzymesRougesJ2 = new ArrayList();
	for(int i = 0; i<nombre; i++){
	    //for(int y=0; y<(int)this.getNombreColonnes(); y++){
	    int positionPremierPion = 12;
	    int y = 0;
	    //for(int x=0; x<(int)this.getNombreLignes(); x++){
		for(int x=positionPremierPion; x<(int)positionPremierPion+nombre+1; x++){
		    if(x%2 == 0 && plateau[y][x].getOccupant() == " "){
			EnzymeRougeJ2 enzymeRougeJ2 = new EnzymeRougeJ2(x, y);
			enzymesRougesJ2.add(enzymeRougeJ2);
		    }
		   
		}
		//}
	}
	plateau = this.genererObjets(enzymesRougesJ2, plateau);
	return plateau;
    }




    public CaseJeu[][] genererObjets(ArrayList objets, CaseJeu [][]plateau){
	for (Enumeration e = Collections.enumeration(objets); e.hasMoreElements();){
	    CaseJeu objet = (CaseJeu)e.nextElement();
	    for(int y=0; y<(int)this.getNombreColonnes(); y++){  
	        for(int x=0; x<(int)this.getNombreLignes(); x++){
	            int xObjet = ((CaseJeu)objet).getCoordX();
	            int yObjet = ((CaseJeu)objet).getCoordY();
		    if(x==xObjet && y==yObjet){
	                plateau[y][x] = objet;
		    }
		}
	    }
	}
	return plateau;
    }

    public void poserObjets(CaseJeu [][]plateau){
	this.poserEnzymesBleuesJ2(plateau, this.getNombreEnzymesBleuesJ2());
	this.poserEnzymesVertesJ2(plateau, this.getNombreEnzymesVertesJ2());
	this.poserEnzymesJaunesJ2(plateau, this.getNombreEnzymesJaunesJ2());
	this.poserEnzymesRougesJ2(plateau, this.getNombreEnzymesRougesJ2());
	this.poserEnzymesBleuesJ1(plateau, this.getNombreEnzymesBleuesJ1());
	this.poserEnzymesVertesJ1(plateau, this.getNombreEnzymesVertesJ1());
	this.poserEnzymesJaunesJ1(plateau, this.getNombreEnzymesJaunesJ1());
	this.poserEnzymesRougesJ1(plateau, this.getNombreEnzymesRougesJ1());
	this.poserLipidesJ2(plateau, this.getNombreLipidesJ2());
	this.poserLipidesJ1(plateau, this.getNombreLipidesJ1());
	MetaboliteRouge metaboliteRouge = new MetaboliteRouge();
	this.poserMetabolites(metaboliteRouge, plateau, this.getNombreMetabolitesRouges());
	MetaboliteVert metaboliteVert = new MetaboliteVert();
	this.poserMetabolites(metaboliteVert, plateau, this.getNombreMetabolitesVerts());
	MetaboliteJaune metaboliteJaune = new MetaboliteJaune();
	this.poserMetabolites(metaboliteJaune, plateau, this.getNombreMetabolitesJaunes());
	MetaboliteBleu metaboliteBleu = new MetaboliteBleu();
	this.poserMetabolites(metaboliteBleu, plateau, this.getNombreMetabolitesBleus());
    }
    /*
    public void poserObjets(CaseJeu [][]plateau){ //modifier la fonction pour l'adapter aux nouveaux types d'objets
	//Joueur joueur = new Joueur();
	//this.genererObjets(joueur, plateau, this.getNombreJoueurs());

	LipideJ1 lipideJ1 = new LipideJ1();
	ArrayList lipidesJ1 = listerObjets(lipideJ1, plateau, this.getNombreLipidesJ1());
	plateau = genererObjets(lipidesJ1, plateau);

	EnzymeRougeJ1 enzymeRougeJ1 = new EnzymeRougeJ1();
	ArrayList enzymesRougesJ1 = listerObjets(enzymeRougeJ1, plateau, this.getNombreEnzymesRougesJ1());
	plateau = genererObjets(enzymesRougesJ1, plateau);

	EnzymeVerteJ1 enzymeVerteJ1 = new EnzymeVerteJ1();
	ArrayList enzymesVertesJ1 = listerObjets(enzymeVerteJ1, plateau, this.getNombreEnzymesVertesJ1());
	plateau = genererObjets(enzymesVertesJ1, plateau);

	EnzymeJauneJ1 enzymeJauneJ1 = new EnzymeJauneJ1();
	ArrayList enzymesJaunesJ1 = listerObjets(enzymeJauneJ1, plateau, this.getNombreEnzymesJaunesJ1());
	plateau = genererObjets(enzymesJaunesJ1, plateau);

	EnzymeBleueJ1 enzymeBleueJ1 = new EnzymeBleueJ1();
	ArrayList enzymesBleuesJ1 = listerObjets(enzymeBleueJ1, plateau, this.getNombreEnzymesBleuesJ1());
	plateau = genererObjets(enzymesBleuesJ1, plateau);


	LipideJ2 lipideJ2 = new LipideJ2();
	ArrayList lipidesJ2 = listerObjets(lipideJ2, plateau, this.getNombreLipidesJ2());
	plateau = genererObjets(lipidesJ2, plateau);

	EnzymeRougeJ2 enzymeRougeJ2 = new EnzymeRougeJ2();
	ArrayList enzymesRougesJ2 = listerObjets(enzymeRougeJ2, plateau, this.getNombreEnzymesRougesJ2());
	plateau = genererObjets(enzymesRougesJ2, plateau);

	EnzymeVerteJ2 enzymeVerteJ2 = new EnzymeVerteJ2();
	ArrayList enzymesVertesJ2 = listerObjets(enzymeVerteJ2, plateau, this.getNombreEnzymesVertesJ2());
	plateau = genererObjets(enzymesVertesJ2, plateau);

	EnzymeJauneJ2 enzymeJauneJ2 = new EnzymeJauneJ2();
	ArrayList enzymesJaunesJ2 = listerObjets(enzymeJauneJ2, plateau, this.getNombreEnzymesJaunesJ2());
	plateau = genererObjets(enzymesJaunesJ2, plateau);

	EnzymeBleueJ2 enzymeBleueJ2 = new EnzymeBleueJ2();
	ArrayList enzymesBleuesJ2 = listerObjets(enzymeBleueJ2, plateau, this.getNombreEnzymesBleuesJ2());
	plateau = genererObjets(enzymesBleuesJ2, plateau);


	MetaboliteRouge metaboliteRouge = new MetaboliteRouge();
	ArrayList metabolitesRouges = listerObjets(metaboliteRouge, plateau, this.getNombreMetabolitesRouges());
	plateau = genererObjets(metabolitesRouges, plateau);

	MetaboliteVert metaboliteVert = new MetaboliteVert();
	ArrayList metabolitesVerts = listerObjets(metaboliteVert, plateau, this.getNombreMetabolitesVerts());
	plateau = genererObjets(metabolitesVerts, plateau); 

	MetaboliteJaune metaboliteJaune = new MetaboliteJaune();
	ArrayList metabolitesJaunes = listerObjets(metaboliteJaune, plateau, this.getNombreMetabolitesJaunes());
	plateau = genererObjets(metabolitesJaunes, plateau); 

	MetaboliteBleu metaboliteBleu = new MetaboliteBleu();
	ArrayList metabolitesBleus = listerObjets(metaboliteBleu, plateau, this.getNombreMetabolitesBleus());
	plateau = genererObjets(metabolitesBleus, plateau); 
    }
    */
    
    public void affichePlateau(CaseJeu [][]plateau){        
	String whiteColor = "\033[39m";
	String header = new String(new char[(int)this.getNombreColonnes()+2]).replace("\0", whiteColor+"|x");
        String leftside = new String(whiteColor+"|x");
        String line = new String(new char[(int)this.getNombreColonnes()+1]).replace("\0", whiteColor+"| ");
        String rightside = new String(whiteColor+"|x|");
        String bottom = new String(new char[(int)this.getNombreColonnes()+2]).replace("\0", whiteColor+"|x");
        System.out.println((String)header+whiteColor+"|");
	//System.out.println("|x");
        for (int y = 0; y < (int)this.getNombreLignes(); y++) {
	    System.out.print(leftside);
            for (int x = 0; x < (int)this.getNombreColonnes(); x++) {
		//System.out.println((String)leftside+(String)line+(String)rightside);
		System.out.print(whiteColor+"|");
                System.out.print((plateau[y][x]).getOccupant());
		//System.out.print();
	    }
            System.out.println(rightside);
        }
        System.out.println((String)bottom+whiteColor+"|");
	    //System.out.println(" | "+"x"+" x |"+"\n");
    }


    public void afficheStats(CaseJeu[][] plateau){
        for (int y = 0; y < (int)this.getNombreLignes(); y++) {
	    for (int x = 0; x < (int)this.getNombreColonnes(); x++) {
		plateau[y][x].afficheStats();
	    }
	}
    }
}


