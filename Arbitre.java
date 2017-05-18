
public class Arbitre {
	
	
    public boolean validerCoup(String unePiece, String uneCase) {
		return true;
    }

    public boolean verifierEchec(String unRoi, String unEchequier) {
		return false;
    }

    public boolean verifierEtMat(String unRoi, String unEchequier) {
		return false;
    }
    
    
    
    
    private String nomArbitre;
	
	public Arbitre(){
    	this.setNomArbitre("Michel");
    }

	public String getNomArbitre() {
		return nomArbitre;
	}

	public void setNomArbitre(String nomArbitre) {
		this.nomArbitre = nomArbitre;
	}
	
	public String toString(){
		return "Bonjour je suis l'arbitre "+getNomArbitre()+".";
	}
}
