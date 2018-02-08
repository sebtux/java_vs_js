public class Metabolite extends CaseJeu{

    private String skin = "M";
    private boolean overwritable = true;
    private boolean pickable = true;
    private boolean booleanJoueur1 = false;
    private boolean booleanJoueur2 = false;


    public Metabolite(){
        int coordX = (int)(Math.random() * this.getNombreColonnes());
	int coordY = (int)(Math.random() * this.getNombreLignes());
	//this.skin = skin;
	this.overwritable = overwritable;
        this.pickable = pickable;
    }
    
    public Metabolite(int coordX, int coordY){
        super(coordX, coordY);
	//this.skin = skin;
        this.overwritable = overwritable;
        this.pickable = pickable;
    }

  
    public boolean getOverwritable(){
	return overwritable;
    }

    public boolean getPickable(){
	return pickable;
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

    /*
    public CaseJeu[][] bougerMetabolite(CaseJeu [][]plateau){
	int x = this.getCoordX();
	int y = this.getCoordY();
	int xNext;
	int yNext;
	int xCurrent;
	int yCurrent;	
	int xPrevious;
	int yPrevious;
	int rep = saisieEntier(); //mettre la fonction random ici

	if(rep==1){
	    yNext = y+1;
	    xNext = x-1;
	    yCurrent = y;
	    xCurrent = x;
        }
	else if(rep==2){
	    yNext = y+1;
	    xNext = x;
	    yCurrent = y;
	    xCurrent = x;
	}
	else if(rep==3){
	    yNext = y+1;
	    xNext = x+1;
	    yCurrent = y;
	    xCurrent = x;
	}
	else if(rep==4){
	    yNext = y;
	    xNext = x-1;
	    yCurrent = y;
	    xCurrent = x;
	}
	else if(rep==6){
	    yNext = y;
	    xNext = x+1;
	    yCurrent = y;
	    xCurrent = x;
	}
	else if(rep==7){
	    yNext = y-1;
	    xNext = x-1;
	    yCurrent = y;
	    xCurrent = x;
	}
	else if(rep==8){
	    yNext = y-1;
	    xNext = x;
	    yCurrent = y;
	    xCurrent = x;
	}
	else if(rep==9){
	    yNext = y-1;
	    xNext = x+1;
	    yCurrent = y;
	    xCurrent = x;
	}
	else{
	    yNext = y;
	    xNext = x;
	    yCurrent = y;
	    xCurrent = x;
	}
	
	//mettre une fonction nombre de cases à déplacer (de 1 à 3), prendre en compte les dépassements de tableau

	//virer les références à pickable, les métabolites ne ramassent rien
	
	if(xNext>-1 && xNext<this.getNombreColonnes() && yNext>-1 && yNext<this.getNombreLignes()){
	    CaseJeu contenuCaseSuivante = plateau[yNext][xNext];
	    CaseJeu contenuCaseEnCours = plateau[yCurrent][xCurrent];
	    CaseJeu contenuCasePrecedente = null;
	    this.verrouSortieJoueur(xNext, yNext, plateau);
	    boolean migrationOK = plateau[yNext][xNext].getOverwritable();
	    boolean pickUpOK = plateau[yNext][xNext].getPickable();
	    //System.out.println("Objet écrasable: "+plateau[yNext][xNext].getOverwritable()+" | "+"Objet ramassable: "+plateau[yNext][xNext].getPickable()); //debugging
	    CaseJeu unpickable = plateau[yNext][xNext];
            
	    if(migrationOK == true){
		this.prendreItem(xNext, yNext, plateau);
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
		this.prendreItem(x, y, plateau);
	        this.setCoordY(y);
	        this.setCoordX(x);
		plateau[y][x] = this;
	    }
	}	
	else{
	    this.prendreItem(x, y, plateau);
	    this.setCoordY(y);
	    this.setCoordX(x);
	    plateau[y][x] = this;
	}
        return plateau;
    }
    */
}
