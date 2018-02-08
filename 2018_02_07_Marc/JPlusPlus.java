import java.io.*;
import java.util.*;
import java.lang.Math;
import java.awt.*;
import java.awt.event.*;

public class JPlusPlus{

    public static void main(String []arg){

	ConfigPartie config = new ConfigPartie();
        PlateauJeu jeu = new PlateauJeu();
        boolean partieEnCours = true;     
        CaseJeu[][] tableJeu = jeu.initPlateau();
	jeu.poserObjets(tableJeu);
	//jeu.affichePlateau(tableJeu);
	int nombreTours = 0;
	while(partieEnCours == true){
	    jouerTour(jeu, tableJeu, nombreTours);
	    //jeu.affichePlateau(tableJeu);
	    //nombreTours = nombreTours+1;
	}
    }


    public static ArrayList entrerCoordonneesPion(){
	ArrayList coordonneesPion = new ArrayList();
	System.out.print("Entrer une valeur d'abscisse (numéro de colonne): ");
	int x = saisieEntier();
	coordonneesPion.add(x);
	System.out.print("Entrer une valeur d'ordonnée (numéro de ligne): ");
	int y = saisieEntier();
	coordonneesPion.add(y);
	return coordonneesPion;
    }

    public static void jouerTour(PlateauJeu jeu, CaseJeu[][] tableJeu, int nombreTours){

	//if nombreCoups%2 == 0 ->
	//if booleanJoueur1 == true && booleanJoueur2 == false
	//demander coordonnées
	//else
	//ce n'est pas un de vos pions, virez vos pattes
	//if nombreCoups%2 !=0 ->
	//if booleanJoueur1 == false && booleanJoueur2 == true
	//demander coordonnées
	//else
	//ce n'est pas un de vos pions, virez vos pattes
	
	boolean booleanCoordonneesValides = false;
	while(booleanCoordonneesValides == false){
	    if(nombreTours%2 == 0){ //le joueur 1 joue à ce moment-là
		deplacerMetabolites(jeu, tableJeu, nombreTours);
		jeu.affichePlateau(tableJeu);
		System.out.println("Le joueur 1 joue");
		jeu.afficheStats(tableJeu);
		ArrayList coordonneesPion = entrerCoordonneesPion();
		int x = (int)coordonneesPion.get(0);
		int y = (int)coordonneesPion.get(1);
		if(tableJeu[y][x].getBooleanJoueur1() == true && tableJeu[y][x].getBooleanJoueur2() == false){
		    booleanCoordonneesValides = true;
		    tableJeu[y][x].bougerPion(tableJeu, nombreTours, x, y);
		    nombreTours = nombreTours+1;
		}
		else{
		    System.out.println("Ce n'est pas votre pion");
		    jouerTour(jeu, tableJeu, nombreTours);
		}
	    }
	    if(nombreTours%2 != 0){ //le joueur 2 joue
		deplacerMetabolites(jeu, tableJeu, nombreTours);
		jeu.affichePlateau(tableJeu);
		System.out.println("Le joueur 2 joue");
		jeu.afficheStats(tableJeu);
		ArrayList coordonneesPion = entrerCoordonneesPion();
		int x = (int)coordonneesPion.get(0);
		int y = (int)coordonneesPion.get(1);	
		if(tableJeu[y][x].getBooleanJoueur1() == false && tableJeu[y][x].getBooleanJoueur2() == true){
		    booleanCoordonneesValides = true;
		    tableJeu[y][x].bougerPion(tableJeu, nombreTours, x, y);
		    nombreTours = nombreTours+1;
		}
		else{
		    System.out.println("Ce n'est pas votre pion");
		    jouerTour(jeu, tableJeu, nombreTours);
		}
	    }
	}
    }


    public static void deplacerMetabolites(PlateauJeu jeu, CaseJeu[][] tableJeu, int nombreTours){ //problème ici, ne fonctionne pas -> faire une arrayList pour chaque type de pièce?
	for (int y = 0; y < (int)jeu.getNombreLignes(); y++) {
	    for (int x = 0; x < (int)jeu.getNombreColonnes(); x++) {
		if(tableJeu[y][x].getApparence() == "M"){
		    ((Metabolite)tableJeu[y][x]).bougerPion(tableJeu, nombreTours);
		}
	    }
	}	
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
}
