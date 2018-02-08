public class ConfigPartie{

    //-------------------------------------------------------------------------
    //Dimensions tableau
    
    private int nombreLignes;
    private int nombreColonnes;

    public int getNombreLignes(){
	return nombreLignes;
    }
    public void setNombreLignes(int nbLignes){
	nombreLignes=nbLignes;
    }

    public int getNombreColonnes(){
	return nombreColonnes;
    }
    public void setNombreColonnes(int nbColonnes){
	nombreColonnes=nbColonnes;
    }


    //-------------------------------------------------------------------------
    //Paramètres joueur 1

    private int nombreLipidesJ1;
    private int nombreEnzymesRougesJ1;
    private int nombreEnzymesVertesJ1;
    private int nombreEnzymesJaunesJ1;
    private int nombreEnzymesBleuesJ1;

    public int getNombreLipidesJ1(){
	return nombreLipidesJ1;
    }
    public void setNombreLipidesJ1(int nbLipidesJ1){
	nombreLipidesJ1=nbLipidesJ1;
    }

    public int getNombreEnzymesRougesJ1(){
	return nombreEnzymesRougesJ1;
    }
    public void setNombreEnzymesRougesJ1(int nbEnzymesRougesJ1){
	nombreEnzymesRougesJ1=nbEnzymesRougesJ1;
    }

    public int getNombreEnzymesVertesJ1(){
	return nombreEnzymesVertesJ1;
    }
    public void setNombreEnzymesVertesJ1(int nbEnzymesVertesJ1){
	nombreEnzymesVertesJ1=nbEnzymesVertesJ1;
    }

    public int getNombreEnzymesJaunesJ1(){
	return nombreEnzymesJaunesJ1;
    }
    public void setNombreEnzymesJaunesJ1(int nbEnzymesJaunesJ1){
	nombreEnzymesJaunesJ1=nbEnzymesJaunesJ1;
    }

    public int getNombreEnzymesBleuesJ1(){
	return nombreEnzymesBleuesJ1;
    }
    public void setNombreEnzymesBleuesJ1(int nbEnzymesBleuesJ1){
	nombreEnzymesBleuesJ1=nbEnzymesBleuesJ1;
    }


    //-------------------------------------------------------------------------
    //Paramètres joueur 2

    private int nombreLipidesJ2;
    private int nombreEnzymesRougesJ2;
    private int nombreEnzymesVertesJ2;
    private int nombreEnzymesJaunesJ2;
    private int nombreEnzymesBleuesJ2;

    public int getNombreLipidesJ2(){
	return nombreLipidesJ2;
    }
    public void setNombreLipidesJ2(int nbLipidesJ2){
	nombreLipidesJ2=nbLipidesJ2;
    }

    public int getNombreEnzymesRougesJ2(){
	return nombreEnzymesRougesJ2;
    }
    public void setNombreEnzymesRougesJ2(int nbEnzymesRougesJ2){
	nombreEnzymesRougesJ2=nbEnzymesRougesJ2;
    }

    public int getNombreEnzymesVertesJ2(){
	return nombreEnzymesVertesJ2;
    }
    public void setNombreEnzymesVertesJ2(int nbEnzymesVertesJ2){
	nombreEnzymesVertesJ2=nbEnzymesVertesJ2;
    }

    public int getNombreEnzymesJaunesJ2(){
	return nombreEnzymesJaunesJ2;
    }
    public void setNombreEnzymesJaunesJ2(int nbEnzymesJaunesJ2){
	nombreEnzymesJaunesJ2=nbEnzymesJaunesJ2;
    }

    public int getNombreEnzymesBleuesJ2(){
	return nombreEnzymesBleuesJ2;
    }
    public void setNombreEnzymesBleuesJ2(int nbEnzymesBleuesJ2){
	nombreEnzymesBleuesJ2=nbEnzymesBleuesJ2;
    }


    //-------------------------------------------------------------------------
    //Paramètres métabolites

    private int nombreMetabolitesRouges;
    private int nombreMetabolitesVerts;
    private int nombreMetabolitesJaunes;
    private int nombreMetabolitesBleus;

    public int getNombreMetabolitesRouges(){
	return nombreMetabolitesRouges;
    }
    public void setNombreMetabolitesRouges(int nbMetabolitesRouges){
	nombreMetabolitesRouges=nbMetabolitesRouges;
    }

    public int getNombreMetabolitesVerts(){
	return nombreMetabolitesVerts;
    }
    public void setNombreMetabolitesVerts(int nbMetabolitesVerts){
	nombreMetabolitesVerts=nbMetabolitesVerts;
    }

    public int getNombreMetabolitesJaunes(){
	return nombreMetabolitesJaunes;
    }
    public void setNombreMetabolitesJaunes(int nbMetabolitesJaunes){
	nombreMetabolitesJaunes=nbMetabolitesJaunes;
    }

    public int getNombreMetabolitesBleus(){
	return nombreMetabolitesBleus;
    }
    public void setNombreMetabolitesBleus(int nbMetabolitesBleus){
	nombreMetabolitesBleus=nbMetabolitesBleus;
    }


    //-------------------------------------------------------------------------
    //Constructeur par défaut

    public ConfigPartie(){      //Config par défaut
	nombreLignes = 15;
	nombreColonnes = 15;
	nombreLipidesJ1 = 23;
	nombreEnzymesRougesJ1 = 2;
	nombreEnzymesVertesJ1 = 2;
	nombreEnzymesJaunesJ1 = 2;
	nombreEnzymesBleuesJ1 = 2;
	nombreLipidesJ2 = 23;
	nombreEnzymesRougesJ2 = 2;
	nombreEnzymesVertesJ2 = 2;
	nombreEnzymesJaunesJ2 = 2;
	nombreEnzymesBleuesJ2 = 2;
	nombreMetabolitesRouges = 10;
	nombreMetabolitesVerts = 10;
	nombreMetabolitesJaunes = 10;
	nombreMetabolitesBleus = 10;
    }
}
