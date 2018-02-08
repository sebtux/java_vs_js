import java.io.*;
import java.util.*;

abstract public class PionJoueur extends CaseJeu{

    public PionJoueur(){
	super();
    }

    public PionJoueur(int coordX, int coordY){
        super(coordX, coordY);
    }


    public ArrayList orienterDeplacement(int x, int y){
	return super.orienterDeplacement(x, y);
    }

    
    public CaseJeu[][] bougerPion(/*ArrayList booleansQuiALaMain,*/ CaseJeu [][]plateau, int nombreTours, int x, int y){
	//int x = this.getCoordX();
	//int y = this.getCoordY();
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
