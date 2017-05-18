
public class Echequier {
	public Case [] tabCase;
	
	public Echequier(){
		this.tabCase = new Case[64];
	}
	
	public int recupIndex(int rangee,int colonne){
		
		return (8*rangee)+colonne;
	}
	
	
	
}
