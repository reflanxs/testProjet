
abstract public class Piece {
    protected Couleur couleur;
    protected int paire;
    protected String nom;
   

    Couleur getCouleur() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.couleur;
    }

    void setCouleur(Couleur value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.couleur = value;
    }
    
    abstract Echequier move(Echequier unEchequier, int departC, int departR, int arriveC , int arriveR );
    
    
    public Piece(int p,Couleur c,String n){
    	this.couleur=c;
    	this.paire=p;
    	this.nom=n;
    }
}