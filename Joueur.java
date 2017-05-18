import java.util.ArrayList;
import java.util.List;

public class Joueur {
    protected Couleur couleur;
    
    private String nom;


    Couleur getCouleur() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.couleur;
    }

    void setCouleur(Couleur value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.couleur = value;
    }

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Joueur(String n, Couleur c){
		this.nom=n;
		this.couleur=c;
	}
	
	public Joueur(){
		this.nom=null;
		this.couleur=null;
	}
	
	public String toString (){
		return "Bonjour je m'appelle "+this.nom+" et je suis le joueur "+this.couleur+"."; 
	}

}
