import java.io.*;
import java.util.*;

public class CaseJeu extends ConfigPartie{
    
    private int coordX;
    private int coordY;
    private String color;
    private String apparence;
    private String skin = ((String)color+(String)apparence);
    private boolean overwritable = true;
    private boolean pickable = true;
    private boolean booleanJoueur1 = false;
    private boolean booleanJoueur2 = false;

    public CaseJeu(){
	int coordX = this.getCoordX();
	int coordY = this.getCoordY();
	this.skin = " ";
	this.overwritable = overwritable;
    }

    public CaseJeu(int coordX, int coordY){
	this.coordX = coordX;
	this.coordY = coordY;
	this.skin = " ";
        this.overwritable = overwritable;
    }
    
    /*
    public CaseJeu(int coordX, int coordY){
	coordX = this.getCoordX();
	coordY = this.getCoordY();
	this.skin = " ";
	this.overwritable = overwritable;
    }
    */

    public int getCoordX(){
	return coordX;
    }

    public void setCoordX(int valeurX){
	coordX=valeurX;
    }

    public String getColor(){
	return color;
    }

    public int getCoordY(){
	return coordY;
    }

    public void setCoordY(int valeurY){
	coordY=valeurY;
    }
    
    public String getOccupant(){ //probleme probable pour les coordonnées aléatoires
	return skin;
    }

    public void setOccupant(String pion){
	skin=pion;
    }

    public String getApparence(){
	return apparence;
    }

    public boolean getOverwritable(){
	return overwritable;
    }

    public void setOverwritable(boolean bool){
	overwritable=bool;
    }

    public boolean getPickable(){
	return pickable;
    }

    public void setPickable(boolean bool){
	pickable=bool;
    }

    public boolean getBooleanJoueur1(){
	return booleanJoueur1;
    }

    public void setBooleanJoueur1(boolean j1){
	booleanJoueur1 = j1;
    }

    public boolean getBooleanJoueur2(){
	return booleanJoueur2;
    }

    public void setBooleanJoueur2(boolean j2){
	booleanJoueur2 = j2;
    }

    /*
    public CaseJeu[][] bougerPion(CaseJeu [][]plateau, int nombreTours, int x, int y){
	return plateau;

    }
    */

    

    public ArrayList mainDuJoueur(int nombreTours){// int x, int y -> récupérer les coordonnées et déterminer si les booleens de plateau[x][y] collent
	boolean booleanJoueur1 = this.getBooleanJoueur1();
	boolean booleanJoueur2 = this.getBooleanJoueur2();
	ArrayList booleansQuiALaMain = new ArrayList();
	if(nombreTours%2 == 0){
	    boolean booleanJoueur = booleanJoueur1;
	    boolean booleanNonJoueur = booleanJoueur2;
	    booleansQuiALaMain.add(booleanJoueur);
	    booleansQuiALaMain.add(booleanNonJoueur);	    
	}
	if(nombreTours%2 != 0){
	    boolean booleanJoueur = booleanJoueur2;
	    boolean booleanNonJoueur = booleanJoueur1;
	    booleansQuiALaMain.add(booleanJoueur);
	    booleansQuiALaMain.add(booleanNonJoueur);
	}
	return booleansQuiALaMain;
    }

    public ArrayList booleansCaseCible(CaseJeu caseCible, int nombreTours){// int x, int y -> récupérer les coordonnées et déterminer si les booleens de plateau[x][y] collent
	boolean booleanJoueur1CaseCible = caseCible.getBooleanJoueur1();
	boolean booleanJoueur2CaseCible = caseCible.getBooleanJoueur2();
	ArrayList etatCaseCible = new ArrayList();
	if(nombreTours%2 == 0){
	    boolean booleanJoueurCaseCible = booleanJoueur1;
	    boolean booleanNonJoueurCaseCible = booleanJoueur2;
	    etatCaseCible.add(booleanJoueurCaseCible);
	    etatCaseCible.add(booleanNonJoueurCaseCible);	    
	}
	if(nombreTours%2 != 0){
	    boolean booleanJoueurCaseCible = booleanJoueur2;
	    boolean booleanNonJoueurCaseCible = booleanJoueur1;
	    etatCaseCible.add(booleanJoueurCaseCible);
	    etatCaseCible.add(booleanNonJoueurCaseCible);
	}
	return etatCaseCible;
    }


    public void prendreMetabolite(int x, int y, CaseJeu[][] plateau, int nombreMetabolites, String inventaireMetabolites){
    }
    
    public void prendrePion(int x, int y, CaseJeu[][] plateau){
    }

    
    public ArrayList orienterDeplacement(int x, int y){
	ArrayList coordsCaseVisee = new ArrayList();
	return coordsCaseVisee;
    }
    
    public CaseJeu[][] bougerPion(CaseJeu [][]plateau, int nombreTours, int x, int y){
	return plateau;
    }

    public CaseJeu[][] bougerPion(CaseJeu [][]plateau, int nombreTours){
	return plateau;
    }
    
    public void afficheStats(){
    }
    
    
    public static String saisieChaine(){
	try{
	    BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
	    String chaine = buff.readLine();
	    return chaine;
	}
	catch(IOException e){
	    System.out.println("Vous n'avez rien tapé "+e);
	    return null;
        }
    }

    public static int saisieEntier(){
	try{
	    BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
	    String chaine = buff.readLine();
            if (chaine.equals(null)){
                return 0;
            }
            else{
	        int num = Integer.parseInt(chaine);
	        return num;
            }
	}
	catch(IOException e){
	    System.out.println("Vous n'avez rien tapé "+e);
	    return 0;
	}
	catch(NumberFormatException numE){
	    return 0;
	}
    }
    
/*
    public char getRouge(char caractere) {
        String stringColor = "\033[31m"+caractere;
        char charColor = (char)stringColor;
        return charColor;
    }

    public static String getVert() {
        return "\033[32m";
    }
*/
}
