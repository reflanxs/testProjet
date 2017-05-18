
public class Fou extends Piece {

	public Fou(int p, Couleur c, String n) {
		super(p, c, n);
	}

	
	
	public String toString(){
		if (this.couleur==Couleur.blanc)
			return "F"+this.paire+"b";
		else
			return "F"+this.paire+"n";
	}

	

	



	@Override
	Echequier move(Echequier unEchequier, int departC, int departR, int arriveC , int arriveR ) {
		/*Piece pieceMove=null;
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(unEchequier[i][j].c!=null){
					if(unEchequier[i][j].c.getRangee()==departR && unEchequier[i][j].c.getColonne()==departC){
						pieceMove=unEchequier[i][j].c.piece;
						unEchequier[i][j].c.piece= new Vide(1,Couleur.invisible,"vide");
					}
				}
			}
		}
		//System.out.println("pieceMove est un "+pieceMove.nom+" de paire "+pieceMove.paire+" et de couleur "+pieceMove.getCouleur());
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				if(unEchequier[i][j].c!=null){
					if(unEchequier[i][j].c.getRangee()==arriveR && unEchequier[i][j].c.getColonne()==arriveC){
						unEchequier[i][j].c.piece= pieceMove;
					}
				}
			}
		}
		*/
		return unEchequier;
	}
}
