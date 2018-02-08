import java.io.*;
import java.util.*;

abstract public class Enzyme extends PionJoueur{

    private String color = "";
    private String apparence = "";
    private String skin = (String)color+(String)apparence;
    //private boolean overwritable = true;
    //private boolean pickable = true;
    //private boolean booleanJoueur1 = false;
    //private boolean booleanJoueur2 = false;
    private int nombreMetabolites = 0;
    private String inventaireMetabolites = "";

    public Enzyme(){
        int coordX = (int)(Math.random() * this.getNombreColonnes());
	int coordY = (int)(Math.random() * this.getNombreLignes());
	//this.skin = skin;
	//this.overwritable = overwritable;
        //this.pickable = pickable;
	this.nombreMetabolites = nombreMetabolites;
	this.inventaireMetabolites = inventaireMetabolites;
    }
    
    public Enzyme(int coordX, int coordY){
        super(coordX, coordY);
	//this.skin = skin;
        //this.overwritable = overwritable;
        //this.pickable = pickable;
	this.nombreMetabolites = nombreMetabolites;
	this.inventaireMetabolites = inventaireMetabolites;
    }

    
    public String getColor(){
	return color;
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
    public int getNombreMetabolites(){
	return nombreMetabolites;
    }
    public void setNombreMetabolites(int nbMetabolites){
	nombreMetabolites = nbMetabolites;
    }

    public String getInventaireMetabolites(){
	return inventaireMetabolites;
    }
    public void setInventaireMetabolites(String invMet){
	inventaireMetabolites = invMet;
    }
    
    public void prendreMetabolite(int x, int y, CaseJeu[][] plateau, int nombreMetabolites, String inventaireMetabolites){
	nombreMetabolites = nombreMetabolites+1;
	setNombreMetabolites(nombreMetabolites);
	inventaireMetabolites = inventaireMetabolites+this.getNombreMetabolites()+"/5";
	setInventaireMetabolites(inventaireMetabolites);
    }

    public void prendrePion(int x, int y, CaseJeu[][] plateau){
	int nombreMetabolites = this.getNombreMetabolites();
	String inventaireMetabolites = this.getInventaireMetabolites();
	if(plateau[y][x].getOccupant() == "M" && plateau[y][x].getColor() == this.getColor() && this.getNombreMetabolites() < 5){
	    prendreMetabolite(x, y, plateau, nombreMetabolites, inventaireMetabolites);
	}
    }
    
    public void afficheStatsEnzyme(){
	System.out.println(this.getInventaireMetabolites());
    }

    
    public ArrayList mainDuJoueur(int nombreTours){
	return super.mainDuJoueur(nombreTours);
    }
    

    public ArrayList booleansCaseCible(CaseJeu caseCible, int nombreTours){
	return super.booleansCaseCible(caseCible, nombreTours);
    }    

    public ArrayList orienterDeplacement(int x, int y){
	int xNext;
	int yNext;
	int xCurrent;
	int yCurrent;	
	int xPrevious;
	int yPrevious;
	ArrayList coordsCaseVisee = new ArrayList();
	System.out.println("Quelle direction ?");
	int rep = saisieEntier();
	int nombreDeCases = 1;

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
	coordsCaseVisee.add(xNext);
	coordsCaseVisee.add(yNext);
	coordsCaseVisee.add(nombreDeCases);
	return coordsCaseVisee;
    }


    public void afficheStats(){
	System.out.println(this.getOccupant()+" | x: "+this.getCoordX()+"; y: "+this.getCoordY()+" | Inventaire: "+this.getInventaireMetabolites()+" | ");
    }
}
