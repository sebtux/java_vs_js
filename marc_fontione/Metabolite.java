import java.io.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

abstract public class Metabolite extends CaseJeu{

    private String color = "";
    private String apparence = "M";
    private String skin = ((String)color+(String)apparence);
    //private boolean overwritable = true;
    //private boolean pickable = true;
    //private boolean booleanJoueur1 = false;
    //private boolean booleanJoueur2 = false;


    public Metabolite(){
        int coordX = (int)(Math.random() * this.getNombreColonnes());
	int coordY = (int)(Math.random() * this.getNombreLignes());
	this.skin = skin;
	//this.overwritable = overwritable;
        //this.pickable = pickable;
    }
    
    public Metabolite(int coordX, int coordY){
        super(coordX, coordY);
	this.skin = skin;
        //this.overwritable = overwritable;
        //this.pickable = pickable;
    }

    
    public String getColor(){
	return color;
    }

    public String getApparence(){
	return apparence;
    }

    public String getOccupant(){
	return skin;
    }
    
    /*
    public boolean getOverwritable(){
	return overwritable;
    }

    public boolean getPickable(){
	return pickable;
    }

    public boolean getBooleanJoueur1(){
	return booleanJoueur1;
    }

    public boolean getBooleanJoueur2(){
	return booleanJoueur2;
    }
    */

    public ArrayList orienterDeplacement(){
	int x = this.getCoordX();
	int y = this.getCoordY();
	System.out.println("Current: "+x+" | "+y);
	int xNext;
	int yNext;
	int xCurrent;
	int yCurrent;	
	int xPrevious;
	int yPrevious;
	ArrayList coordsCaseVisee = new ArrayList();
	//System.out.println("Quelle direction ?");
	//int rep = saisieEntier();
	int rep = ThreadLocalRandom.current().nextInt(1, 9 + 1);
	int nombreDeCases = ThreadLocalRandom.current().nextInt(1, 3 + 1);

	if(rep==1){
	    yNext = y+nombreDeCases;
	    xNext = x-nombreDeCases;
	    yCurrent = y;
	    xCurrent = x;
        }
	else if(rep==2){
	    yNext = y+nombreDeCases;
	    xNext = x;
	    yCurrent = y;
	    xCurrent = x;
	}
	else if(rep==3){
	    yNext = y+nombreDeCases;
	    xNext = x+nombreDeCases;
	    yCurrent = y;
	    xCurrent = x;
	}
	else if(rep==4){
	    yNext = y;
	    xNext = x-nombreDeCases;
	    yCurrent = y;
	    xCurrent = x;
	}
	else if(rep==6){
	    yNext = y;
	    xNext = x+nombreDeCases;
	    yCurrent = y;
	    xCurrent = x;
	}
	else if(rep==7){
	    yNext = y-nombreDeCases;
	    xNext = x-nombreDeCases;
	    yCurrent = y;
	    xCurrent = x;
	}
	else if(rep==8){
	    yNext = y-nombreDeCases;
	    xNext = x;
	    yCurrent = y;
	    xCurrent = x;
	}
	else if(rep==9){
	    yNext = y-nombreDeCases;
	    xNext = x+nombreDeCases;
	    yCurrent = y;
	    xCurrent = x;
	}
	else{
	    yNext = y;
	    xNext = x;
	    yCurrent = y;
	    xCurrent = x;
	}
	System.out.println("Next: "+xNext+" | "+yNext);
	coordsCaseVisee.add(xNext);
	coordsCaseVisee.add(yNext);
	coordsCaseVisee.add(nombreDeCases);
	return coordsCaseVisee;
    }
    
    public CaseJeu[][] bougerPion(CaseJeu [][]plateau, int nombreTours){
	int x = this.getCoordX();
	int y = this.getCoordY();
	//ArrayList booleansQuiALaMain = mainDuJoueur(tourJoueur, booleanJoueur1, booleanJoueur2);
	int xCurrent = x;
	int yCurrent = y;
		
	ArrayList coordsCaseVisee = orienterDeplacement(x, y);
	int xNext = (int)coordsCaseVisee.get(0);
	int yNext = (int)coordsCaseVisee.get(1);
	int nombreDeCases = (int)coordsCaseVisee.get(2);
	
	ArrayList booleansQuiALaMain = mainDuJoueur(nombreTours);
	if(xNext>-nombreDeCases && xNext<this.getNombreColonnes() && yNext>-nombreDeCases && yNext<this.getNombreLignes()){
	    ArrayList booleansCaseCible = booleansCaseCible(plateau[yNext][xNext], nombreTours);
	    if((boolean)booleansCaseCible.get(0) == false && (boolean)booleansQuiALaMain.get(0) == false){
		plateau[yNext][xNext].setOverwritable(true);
	    }
	}
	
	if(xNext>-nombreDeCases && xNext<this.getNombreColonnes() && yNext>-nombreDeCases && yNext<this.getNombreLignes()){
	    CaseJeu contenuCaseSuivante = plateau[yNext][xNext];
	    CaseJeu contenuCaseEnCours = plateau[yCurrent][xCurrent];
	    CaseJeu contenuCasePrecedente = null;
	    boolean booleanJoueur = (boolean)booleansQuiALaMain.get(0);
	    boolean booleanNonJoueur = (boolean)booleansQuiALaMain.get(1);
	    //this.verrouSortieJoueur(xNext, yNext, plateau);
	    boolean migrationOK = plateau[yNext][xNext].getOverwritable(); //a revoir
	    boolean pickUpOK = plateau[yNext][xNext].getPickable(); //a revoir
	    //System.out.println("Objet écrasable: "+plateau[yNext][xNext].getOverwritable()+" | "+"Objet ramassable: "+plateau[yNext][xNext].getPickable()); //debugging
	    CaseJeu unpickable = plateau[yNext][xNext];
            
	    if(migrationOK == true){
		this.prendrePion(xNext, yNext, plateau);
	        this.setCoordY(yNext);
	        this.setCoordX(xNext);
		if(pickUpOK==true){
		
		    plateau[yNext][xNext] = this;
		    plateau[y][x] = new CaseJeu((int)x, (int)y);
		}
		else if(pickUpOK==false){
	      	    plateau[yNext][xNext] = unpickable;
		    plateau[y][x] = new CaseJeu((int)x, (int)y);
		}			
	    }
	    else if(migrationOK == false){		
		this.prendrePion(x, y, plateau);
	        this.setCoordY(y);
	        this.setCoordX(x);
		plateau[y][x] = this;
	    }
	}	
	else{
	    this.prendrePion(x, y, plateau);
	    this.setCoordY(y);
	    this.setCoordX(x);
	    plateau[y][x] = this;
	}
        return plateau;
    }
}
