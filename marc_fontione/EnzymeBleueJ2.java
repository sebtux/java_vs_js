import java.io.*;
import java.util.*;

public class EnzymeBleueJ2 extends Enzyme{

    private String color = "\033[34m";
    private String apparence = "e";
    private String skin = ((String)color+(String)apparence);
    private boolean booleanJoueur1 = false;
    private boolean booleanJoueur2 = true;

    public EnzymeBleueJ2(){
	super();
	this.skin = skin;
	this.booleanJoueur1 = booleanJoueur1;
	this.booleanJoueur2 = booleanJoueur2;
    }


    public EnzymeBleueJ2(int coordX, int coordY){
        super(coordX, coordY);
	this.skin = skin;
	this.booleanJoueur1 = booleanJoueur1;
	this.booleanJoueur2 = booleanJoueur2;
    }


    public String getOccupant(){
	return skin;
    }

    public boolean getBooleanJoueur1(){
	return booleanJoueur1;
    }

    public boolean getBooleanJoueur2(){
	return booleanJoueur2;
    }


    public ArrayList mainDuJoueur(int nombreTours){
	return super.mainDuJoueur(nombreTours);
    }

    public CaseJeu[][] bougerPion(CaseJeu [][]plateau, int nombreTours, int x, int y){
	return super.bougerPion(plateau, nombreTours, x, y);
    }
}
