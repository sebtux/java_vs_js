public class MetaboliteJaune extends Metabolite{

    private String color = "\033[33m";
    private String apparence = super.getOccupant();
    private String skin = ((String)color+(String)apparence);
    private boolean booleanJoueur1 = this.getBooleanJoueur1();
    private boolean booleanJoueur2 = this.getBooleanJoueur2();
    
    public MetaboliteJaune(){
	super();
	this.skin = skin;
    }


    public MetaboliteJaune(int coordX, int coordY){
        super(coordX, coordY);
	this.skin = skin;
    }

    public String getApparence(){
	return apparence;
    }

    public String getOccupant(){
	return skin;
    }
    
    public boolean getOverwritable(){
	return super.getOverwritable();
    }

    public boolean getPickable(){
	return super.getPickable();
    }
    
    public CaseJeu[][] bougerMetabolite(CaseJeu [][]plateau, int nombreTours){
	return super.bougerPion(plateau, nombreTours);
    }
}
