public class LipideJ1 extends Lipide{

    //private String color = "\033[33m";
    private String skin = "L";
    private boolean booleanJoueur1 = true;
    private boolean booleanJoueur2 = false;

    public LipideJ1(){
	super();
	this.skin = skin;
	this.booleanJoueur1 = booleanJoueur1;
	this.booleanJoueur2 = booleanJoueur2;
    }


    public LipideJ1(int coordX, int coordY){
        super(coordX, coordY);
	this.skin = skin;
	this.booleanJoueur1 = booleanJoueur1;
	this.booleanJoueur2 = booleanJoueur2;
    }


    public boolean getOverwritable(){
	return super.getOverwritable();
    }

    public boolean getPickable(){
	return super.getPickable();
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
    public CaseJeu[][] bougerLipide(CaseJeu [][]plateau){
	super.bougerLipide(plateau);
    }
    */
}
