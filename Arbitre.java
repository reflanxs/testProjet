import java.io.Serializable;

public class Arbitre implements Serializable {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean validerCoup(Echequier unEchequier, Case caseDepart, Case caseArriver, Piece unePiece) {
		
    	if (unePiece.nom.equals("pion")){
    		
    		if (validerCoupPion(unEchequier,caseDepart,caseArriver,unePiece)==true)
    			return true;	
    	}
    	
    	if (unePiece.nom.equals("tour")){
    		if (validerCoupTour(unEchequier,caseDepart,caseArriver,unePiece)==true)
    			return true;
    	}
    	
    	if (unePiece.nom.equals("cavalier")){
    		if (validerCoupCavalier(unEchequier,caseDepart,caseArriver,unePiece)==true)
    			return true;
    	}

    	if (unePiece.nom.equals("fou")){
    		if (validerCoupFou(unEchequier,caseDepart,caseArriver,unePiece)==true)
    			return true;
    	}

    	if (unePiece.nom.equals("roi")){
    		if (validerCoupRoi(unEchequier,caseDepart,caseArriver,unePiece)==true)
    			return true;
    	}

    	if (unePiece.nom.equals("dame")){
    		if (validerCoupDame(unEchequier,caseDepart,caseArriver,unePiece)==true)
    			return true;
    	}
		return false;
    }

    public boolean validerCoupPion(Echequier unEchequier, Case caseDepart, Case caseArriver, Piece unePiece){
    	/**Cas noir**/
		if (unePiece.couleur.equals(Couleur.noir)){
			if (caseDepart.getColonne()==caseArriver.getColonne() && caseDepart.getRangee()==caseArriver.getRangee()+1){
				return true;
			}
			
			if (caseDepart.getRangee()==7){
				if (caseDepart.getColonne()==caseArriver.getColonne() && caseDepart.getRangee()==caseArriver.getRangee()+2){
    				return true;
    			}
			}
			
			if (unEchequier.tabCase[unEchequier.recupIndex(8-caseArriver.getRangee(), caseArriver.getColonne()-1)].piece.couleur.equals(Couleur.blanc)){
				if(caseDepart.getColonne()==caseArriver.getColonne()-1 && caseDepart.getRangee()==caseArriver.getRangee()+1){
					return true;
				}
				
				if(caseDepart.getColonne()==caseArriver.getColonne()+1 && caseDepart.getRangee()==caseArriver.getRangee()+1){
					return true;
				}
			}
			
		}
		
		/**Case blanc**/
		if (unePiece.couleur.equals(Couleur.blanc)){
			if (caseDepart.getColonne()==caseArriver.getColonne() && caseDepart.getRangee()==caseArriver.getRangee()-1){
				return true;
			}
			
			if (caseDepart.getRangee()==2){
				if (caseDepart.getColonne()==caseArriver.getColonne() && caseDepart.getRangee()==caseArriver.getRangee()-2){
    				return true;
    			}
			}
			
			if (unEchequier.tabCase[unEchequier.recupIndex(8-caseArriver.getRangee(), caseArriver.getColonne()-1)].piece.couleur.equals(Couleur.noir)){
				if(caseDepart.getColonne()==caseArriver.getColonne()-1 && caseDepart.getRangee()==caseArriver.getRangee()-1){
					return true;
				}
				
				if(caseDepart.getColonne()==caseArriver.getColonne()+1 && caseDepart.getRangee()==caseArriver.getRangee()-1){
					return true;
				}
			}
		}
		
		return false;
    }
    
    public boolean validerCoupTour(Echequier unEchequier, Case caseDepart, Case caseArriver, Piece unePiece){
    	for(int i=1;i<9;i++){
			if (caseDepart.getColonne()==caseArriver.getColonne() && caseDepart.getRangee()==caseArriver.getRangee()+i){
				
				for (int j=1;j<i;j++){
					
					if (unEchequier.tabCase[unEchequier.recupIndex((8-(caseArriver.getRangee()+j)), caseArriver.getColonne()-1)].piece.couleur.equals(Couleur.blanc)
							|| unEchequier.tabCase[unEchequier.recupIndex((8-(caseArriver.getRangee()+j)), caseArriver.getColonne()-1)].piece.couleur.equals(Couleur.noir)){
						return false;
					}
				}
				return true;
			}
			
			if (caseDepart.getColonne()==caseArriver.getColonne() && caseDepart.getRangee()==caseArriver.getRangee()-i){
				
				for (int j=1;j<i;j++){
					
					
					
					if (unEchequier.tabCase[unEchequier.recupIndex((8-(caseArriver.getRangee()-j)), caseArriver.getColonne()-1)].piece.couleur.equals(Couleur.blanc) 
							|| unEchequier.tabCase[unEchequier.recupIndex((8-(caseArriver.getRangee()-j)), caseArriver.getColonne()-1)].piece.couleur.equals(Couleur.noir)){
							return false;
						}		
				}
				return true;
			}
			
			if (caseDepart.getColonne()==caseArriver.getColonne()+i && caseDepart.getRangee()==caseArriver.getRangee()){
				
				for (int j=1;j<i;j++){
					if (unEchequier.tabCase[unEchequier.recupIndex((8-(caseArriver.getRangee())), caseArriver.getColonne()-1+j)].piece.couleur.equals(Couleur.blanc)
							|| unEchequier.tabCase[unEchequier.recupIndex((8-(caseArriver.getRangee())), caseArriver.getColonne()-1+j)].piece.couleur.equals(Couleur.noir)){
						return false;
					}
				}
				return true;
			}
			
			if (caseDepart.getColonne()==caseArriver.getColonne()-i && caseDepart.getRangee()==caseArriver.getRangee()){
				
				for (int j=1;j<i;j++){
					if (unEchequier.tabCase[unEchequier.recupIndex((8-(caseArriver.getRangee())), caseArriver.getColonne()-1-j)].piece.couleur.equals(Couleur.blanc)
							|| unEchequier.tabCase[unEchequier.recupIndex((8-(caseArriver.getRangee())), caseArriver.getColonne()-1-j)].piece.couleur.equals(Couleur.noir)){
						return false;
					}
				}
				return true;
			}
		}
    	
    	return false;
    }
    
    public boolean validerCoupCavalier(Echequier unEchequier, Case caseDepart, Case caseArriver, Piece unePiece){
    	if (caseDepart.getColonne()==caseArriver.getColonne()+2 && caseDepart.getRangee()==caseArriver.getRangee()+1){
			return true;
		}
		
		if (caseDepart.getColonne()==caseArriver.getColonne()+2 && caseDepart.getRangee()==caseArriver.getRangee()-1){
			return true;
		}
		
		if (caseDepart.getColonne()==caseArriver.getColonne()-2 && caseDepart.getRangee()==caseArriver.getRangee()-1){
			return true;
		}
		
		if (caseDepart.getColonne()==caseArriver.getColonne()-2 && caseDepart.getRangee()==caseArriver.getRangee()+1){
			return true;
		}
		
		
		
		if (caseDepart.getColonne()==caseArriver.getColonne()+1 && caseDepart.getRangee()==caseArriver.getRangee()+2){
			return true;
		}
		
		if (caseDepart.getColonne()==caseArriver.getColonne()+1 && caseDepart.getRangee()==caseArriver.getRangee()-2){
			return true;
		}
		
		if (caseDepart.getColonne()==caseArriver.getColonne()-1 && caseDepart.getRangee()==caseArriver.getRangee()-2){
			return true;
		}
		
		if (caseDepart.getColonne()==caseArriver.getColonne()-1 && caseDepart.getRangee()==caseArriver.getRangee()+2){
			return true;
		}
		
		return false;
    }
    
    public boolean validerCoupFou(Echequier unEchequier, Case caseDepart, Case caseArriver, Piece unePiece){
    	for (int i=1;i<9;i++){
			if (caseDepart.getColonne()==caseArriver.getColonne()+i && caseDepart.getRangee()==caseArriver.getRangee()+i){
				for (int j=1;j<i;j++){
					if (unEchequier.tabCase[unEchequier.recupIndex((8-(caseArriver.getRangee()+j)), caseArriver.getColonne()-1+j)].piece.couleur.equals(Couleur.blanc)
							|| unEchequier.tabCase[unEchequier.recupIndex((8-(caseArriver.getRangee()+j)), caseArriver.getColonne()-1+j)].piece.couleur.equals(Couleur.noir)){
						return false;
					}
				}
				return true;
			}
			
			if (caseDepart.getColonne()==caseArriver.getColonne()+i && caseDepart.getRangee()==caseArriver.getRangee()-i){
				for (int j=1;j<i;j++){
					if (unEchequier.tabCase[unEchequier.recupIndex((8-(caseArriver.getRangee()-j)), caseArriver.getColonne()-1+j)].piece.couleur.equals(Couleur.blanc)
							|| unEchequier.tabCase[unEchequier.recupIndex((8-(caseArriver.getRangee()-j)), caseArriver.getColonne()-1+j)].piece.couleur.equals(Couleur.noir)){
						return false;
					}
				}
				return true;
			}
			
			if (caseDepart.getColonne()==caseArriver.getColonne()-i && caseDepart.getRangee()==caseArriver.getRangee()+i){
				for (int j=1;j<i;j++){
					if (unEchequier.tabCase[unEchequier.recupIndex((8-(caseArriver.getRangee()+j)), caseArriver.getColonne()-1-j)].piece.couleur.equals(Couleur.blanc)
							|| unEchequier.tabCase[unEchequier.recupIndex((8-(caseArriver.getRangee()+j)), caseArriver.getColonne()-1-j)].piece.couleur.equals(Couleur.noir)){
						return false;
					}
				}
				return true;
			}
			
			if (caseDepart.getColonne()==caseArriver.getColonne()-i && caseDepart.getRangee()==caseArriver.getRangee()-i){
				for (int j=1;j<i;j++){
					if (unEchequier.tabCase[unEchequier.recupIndex((8-(caseArriver.getRangee()-j)), caseArriver.getColonne()-1-j)].piece.couleur.equals(Couleur.blanc)
							|| unEchequier.tabCase[unEchequier.recupIndex((8-(caseArriver.getRangee()-j)), caseArriver.getColonne()-1-j)].piece.couleur.equals(Couleur.noir)){
						return false;
					}
				}
				return true;
			}
		}
    	return false;
    }
    
    public boolean validerCoupRoi(Echequier unEchequier, Case caseDepart, Case caseArriver, Piece unePiece){
    	if (caseDepart.getColonne()==caseArriver.getColonne()+1 && caseDepart.getRangee()==caseArriver.getRangee()){
			return true;
		}
		
		if (caseDepart.getColonne()==caseArriver.getColonne()+1 && caseDepart.getRangee()==caseArriver.getRangee()+1){
			return true;
		}
		
		if (caseDepart.getColonne()==caseArriver.getColonne()+1 && caseDepart.getRangee()==caseArriver.getRangee()-1){
			return true;
		}
		
		if (caseDepart.getColonne()==caseArriver.getColonne()-1 && caseDepart.getRangee()==caseArriver.getRangee()){
			return true;
		}
		
		if (caseDepart.getColonne()==caseArriver.getColonne()-1 && caseDepart.getRangee()==caseArriver.getRangee()+1){
			return true;
		}
		
		if (caseDepart.getColonne()==caseArriver.getColonne()-1 && caseDepart.getRangee()==caseArriver.getRangee()-1){
			return true;
		}
		
		if (caseDepart.getColonne()==caseArriver.getColonne() && caseDepart.getRangee()==caseArriver.getRangee()-1){
			return true;
		}
		
		if (caseDepart.getColonne()==caseArriver.getColonne() && caseDepart.getRangee()==caseArriver.getRangee()+1){
			return true;
		}
		
		return false;
    }
    
    public boolean validerCoupDame(Echequier unEchequier, Case caseDepart, Case caseArriver, Piece unePiece){
    	
    	if (validerCoupTour(unEchequier,caseDepart,caseArriver,unePiece)==true 
    			|| validerCoupFou(unEchequier,caseDepart,caseArriver,unePiece)==true){
    		return true;
    	}

    	return false;
    }
    

    
    public int verifierEchec(Piece piece, Echequier unEchequier) {
    	Case caseDuRoi= new Case(rangeeRoi(piece,unEchequier),colonneRoi(piece,unEchequier));
    	int echec=0;
    	
    	for(int i= 0;i<64;i++){
    		if(piece.couleur.equals(Couleur.noir)){
    			if(unEchequier.tabCase[i].piece.couleur.equals(Couleur.blanc)){
    				Case casePieceAtt= new Case(unEchequier.tabCase[i].getRangee(),unEchequier.tabCase[i].getColonne());
    				if(validerCoup(unEchequier,casePieceAtt,caseDuRoi,unEchequier.tabCase[i].piece)==true){
    					echec++;
    				}
    			}
    		}
    		
    		if(piece.couleur.equals(Couleur.blanc)){
    			if(unEchequier.tabCase[i].piece.couleur.equals(Couleur.noir)){
    				Case casePieceAtt= new Case(unEchequier.tabCase[i].getRangee(),unEchequier.tabCase[i].getColonne());
    				if(validerCoup(unEchequier,casePieceAtt,caseDuRoi,unEchequier.tabCase[i].piece)==true){
    					echec++;
    				}
    			}
    		}
    		
    		
    	}
    	
    	if(echec>0){
    		System.out.println("Attention joueur "+piece.couleur+" votre roi est en danger");
    	}
    	
		return echec;
    }

    public boolean verifierEtMat(Joueur adverse,Joueur joueurActuel,Piece piece, Echequier unEchequier) throws NullPointerException {
    	if(piece==null){
   		 throw new NullPointerException("Félicitation "+adverse.getNom()+", vous avez gagné.");
   		 
   	 }
   	 if(unEchequier==null){
   		throw new NullPointerException("Félicitation "+adverse.getNom()+", vous avez gagné.");
   	 }
    	if (verifierEchec(piece,unEchequier)>1 || exitenceRoi(piece,unEchequier)==false  ){
    		
    		System.out.println("Echec et mat !!");
    		return true;
    	}
		return false;
    }
    
    public int colonneRoi(Piece piece, Echequier unEchequier){
 	   for(int i=0;i<64;i++){
 		   if(unEchequier.tabCase[i].piece.couleur.equals(piece.couleur) 
 				   && unEchequier.tabCase[i].piece.nom.equals(piece.nom) 
 				   		&& unEchequier.tabCase[i].piece.paire==piece.paire){
 			   return unEchequier.tabCase[i].getColonne();
 		   }
 	   }
     	return -1;
     }
 	   
     
     public int rangeeRoi(Piece piece, Echequier unEchequier){
    	 

     	for(int i=0;i<64;i++){
 		   if(unEchequier.tabCase[i].piece.couleur.equals(piece.couleur) 
 				   && unEchequier.tabCase[i].piece.nom.equals(piece.nom) 
 				   		&& unEchequier.tabCase[i].piece.paire==piece.paire){
 			   return unEchequier.tabCase[i].getRangee();
 		   }
 	   }
     	return -1;
     }
    
    
    private boolean exitenceRoi(Piece piece, Echequier unEchequier) {
    	
    	for(int i=0;i<64;i++){
    		if(unEchequier.tabCase[i].piece.nom.equals(piece.nom) 
    					&& unEchequier.tabCase[i].piece.couleur.equals(piece.couleur)){
    			System.out.println("il existe tjr un "+unEchequier.tabCase[i].piece.nom+"de couleur "+unEchequier.tabCase[i].piece.couleur);
    			return true;
    		}
    	}	
    	System.out.println("il existe plus la piece");
		return false;
	}

    public Piece existancePiece(Echequier unEchequier, String nomPiece,Joueur joueurActuel) {
    	
    	for(int i=0;i<64;i++){
    		if(unEchequier.tabCase[i].piece.nom.equals(nomPiece) 
    				&& unEchequier.tabCase[i].piece.couleur.equals(joueurActuel.couleur)){
    			
    			return unEchequier.tabCase[i].piece;
    		}	
    	}
    	
    	return null;
    }
    
    public Piece existancePaire(Echequier unEchequier, Piece pieceVerifier, int paire  ){
    	
    	for(int i=0;i<64;i++){
    		if(unEchequier.tabCase[i].piece.paire==paire 
    				&& unEchequier.tabCase[i].piece.nom.equals(pieceVerifier.nom) 
    					&& unEchequier.tabCase[i].piece.couleur.equals(pieceVerifier.couleur)){
    			
    			return unEchequier.tabCase[i].piece;
    			
    		}
    	}	
    	return null;
    }
    
    
    public boolean indiceValide(int indice){
    	if(indice>=1 && indice<=8)
    		return true;
    	return false;
    	
    }
    
public boolean verifCouleurPiece(Echequier unEchequier, Case caseArriver, Joueur joueur){
    	
    	for (int i=0;i<64;i++){
    		if(unEchequier.tabCase[i].getColonne()==caseArriver.getColonne() 
    				&& unEchequier.tabCase[i].getRangee()==caseArriver.getRangee()){
    			if(unEchequier.tabCase[i].piece.couleur.equals(joueur.couleur)){
    				System.out.println("meme couleur");
    				return true;
    			}
    		}
    	}
    	
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
