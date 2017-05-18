import java.io.*;
import java.util.*;


public class Partie {
    private Echequier unEchequier ;

    private Arbitre arbitre;

    private Joueur joueur1;
    private Joueur joueur2;
    
    private String historique;
    private int tour;

	private Scanner sc;

	private Scanner scColonne;

	private Scanner scRangee;

	private Scanner scPaire;

	private Scanner scPiece;
    
    
    public Partie(){
    	this.setEchequier(new Echequier());
    	this.arbitre=null;
    	this.setJoueur1(null);
    	this.setJoueur2(null);
    	this.setHistorique(null);
    	this.tour=0;

    }
    
    private void setEchequier(Echequier echequier) {
    	this.unEchequier=echequier;	
	}

	public Partie(Echequier e,Joueur j1,Joueur j2,Arbitre a){
    	this.arbitre=a;
    	this.setJoueur1(j1);
    	this.setJoueur2(j2);
    	this.setEchequier(e);
    	this.setHistorique("Liste de coup effectuer :");
    	this.tour=0;
    	
    }
    public void initialiser() {
    	int c=1;
    	int r=1;
    	for(int i=0;i<64;i++){
    		if(c>8){
    			c=1;
    			r++;
    		}
    		this.unEchequier.tabCase[i] = new Case(9-r,c) ;
    		c++;
    	}
		
    	for(int Pb = 8;Pb<16;Pb++){
    		
    		this.unEchequier.tabCase[Pb].piece = new Pion(Pb-7,Couleur.noir,"pion");
    	}
    	
    	for(int Pn = 48;Pn<56;Pn++){
    		
    		this.unEchequier.tabCase[Pn].piece = new Pion(Pn-47,Couleur.blanc,"pion");
    	}
    	
    	
    	this.unEchequier.tabCase[0].piece=new Tour(1,Couleur.noir,"tour");
    	this.unEchequier.tabCase[7].piece=new Tour(2,Couleur.noir,"tour");
    	this.unEchequier.tabCase[56].piece=new Tour(1,Couleur.blanc,"tour");
    	this.unEchequier.tabCase[63].piece=new Tour(2,Couleur.blanc,"tour");
    	
    	this.unEchequier.tabCase[1].piece=new Cavalier(1,Couleur.noir,"cavalier");
    	this.unEchequier.tabCase[6].piece=new Cavalier(2,Couleur.noir,"cavalier");
    	this.unEchequier.tabCase[57].piece=new Cavalier(1,Couleur.blanc,"cavalier");
    	this.unEchequier.tabCase[62].piece=new Cavalier(2,Couleur.blanc,"cavalier");
    	
    	this.unEchequier.tabCase[2].piece=new Fou(1,Couleur.noir,"fou");
    	this.unEchequier.tabCase[5].piece=new Fou(2,Couleur.noir,"fou");
    	this.unEchequier.tabCase[58].piece=new Fou(1,Couleur.blanc,"fou");
    	this.unEchequier.tabCase[61].piece=new Fou(2,Couleur.blanc,"fou");
    	
    	this.unEchequier.tabCase[3].piece=new Roi(1,Couleur.noir,"roi");
    	this.unEchequier.tabCase[59].piece=new Roi(1,Couleur.blanc,"roi");
    	
    	this.unEchequier.tabCase[4].piece=new Dame(1,Couleur.noir,"dame");
    	this.unEchequier.tabCase[60].piece=new Dame(1,Couleur.blanc,"dame");
    	
    }

    public void jouer(Joueur joueurActuel) {
    	
    	
    	scPiece = new Scanner(System.in);
    	scPaire = new Scanner(System.in);
    	scRangee = new Scanner(System.in);
    	scColonne = new Scanner(System.in);
    		
    		System.out.println("Quelle type de pièce souhaiter vous déplacer ?");
    		String strPiece = scPiece.nextLine();
    		
    		while (existancePiece(strPiece,joueurActuel)==null){
    			System.out.println("Erreur: vous ne posseder plus ce type de piece sur l'echequier.");
    			
    			System.out.println("Quelle type pièce souhaiter vous déplacer ?");
    			strPiece = scPiece.nextLine();
    		}
    		
    		System.out.println("Quelle doublon de cette piece souhaiter vous déplacer ?(si il n'y qu'un exemplaire de cette pièce (exemple:le roi) ecrivez quand même: 1)");
    		int strPaire = scPaire.nextInt();
    		
    		while (existancePaire(strPaire,joueurActuel,strPiece)==-1){
    			System.out.println("Erreur: vous ne posseder plus ce doublon de cette piece sur l'echequier.");
    			
        		System.out.println("Quelle doublon de cette piece souhaiter vous déplacer ?(si il n'y qu'un exemplaire de cette pièce (exemple:le roi) ecrivez quand même: 1)");
    			strPaire = scPaire.nextInt();
    		}
    		
    		System.out.println("Dans quelle colonne souhaiter vous la déplacer ?(écrire une lettre en MAJUSCULE entre A à H)");
    		String strColonne = scColonne.nextLine();
    		
    		while (indiceValide(convertionLettre(strColonne))==false){
    			System.out.println("Erreur d'indice.");
    			
    			System.out.println("Dans quelle colonne souhaiter vous la déplacer ?(écrire une lettre en MAJUSCULE entre A à H)");
        		strColonne = scColonne.nextLine();
    		}
    		
    		System.out.println("Dans quelle rangée souhaiter vous la déplacer ?(écrire un chiffre entre 1 à 8)");
    		int strRangee = scRangee.nextInt();
    		
    		while (indiceValide(strRangee)==false){
    			System.out.println("Erreur d'indice.");
    			
        		
        		System.out.println("Dans quelle rangée souhaiter vous la déplacer ?(écrire un chiffre entre 1 à 8)");
        		strRangee = scRangee.nextInt();
    		}
    		
    		while(verifCouleurPiece(strRangee,convertionLettre(strColonne),joueurActuel)==true){
    			System.out.println("Impossible de déplacer la pièce ici car vous avez déjà une pièce de même couleur à cet emplacment, veuillez réessayer.");
    			
    			System.out.println("Dans quelle colonne souhaiter vous la déplacer ?(écrire une lettre en MAJUSCULE entre A à H)");
        		 strColonne = scColonne.nextLine();
        		
        		while (indiceValide(convertionLettre(strColonne))==false){
        			System.out.println("Erreur d'indice.");
        			
        			System.out.println("Dans quelle colonne souhaiter vous la déplacer ?(écrire une lettre en MAJUSCULE entre A à H)");
            		strColonne = scColonne.nextLine();
        		}
        		
        		System.out.println("Dans quelle rangée souhaiter vous la déplacer ?(écrire un chiffre entre 1 à 8)");
        		 strRangee = scRangee.nextInt();
        		
        		while (indiceValide(strRangee)==false){
        			System.out.println("Erreur d'indice.");
        			
            		
            		System.out.println("Dans quelle rangée souhaiter vous la déplacer ?(écrire un chiffre entre 1 à 8)");
            		strRangee = scRangee.nextInt();
        		}
    		}
    		//System.out.println("deplacement en  cours du "+strPiece+" de numero "+strPaire+" de la case "+ rangeeDepart(strPiece,strPaire,joueurActuel)+"|"+ colonneDepart(strPiece,strPaire,joueurActuel) +" vers la case "+ strRangee+"|"+ convertionLettre(strColonne));
    		
    	//savePiece(strPiece, strPaire, colonneDepart(strPiece,strPaire,joueurActuel.couleur), rangeeDepart(strPiece,strPaire,joueurActuel.couleur), joueurActuel.couleur).move(colonneDepart(strPiece,strPaire,joueurActuel.couleur), rangeeDepart(strPiece,strPaire,joueurActuel.couleur), strColonne, strRangee);
    	//faire dans piece la vrai fonction déplacement
    		
    		Piece pieceMouvement=existancePiece(strPiece,joueurActuel);
    		int rDepart=rangeeDepart(strPiece,strPaire,joueurActuel);
    		int cDepart=colonneDepart(strPiece,strPaire,joueurActuel);
    		int rArrivee=strRangee;
    		int cArrivee=convertionLettre(strColonne);
    		
    		this.setEchequier(pieceMouvement.move(this.getEchequier(), cDepart, rDepart, cArrivee, rArrivee));
    		
    		this.historique=this.historique+"\nTour "+this.getTour()+": "+joueurActuel.getNom()+" à déplacer "+pieceMouvement.nom+" "+pieceMouvement.paire+" de la case "+rDepart+" "+convertionChiffre(cDepart)+" vers la case "+rArrivee+" "+convertionChiffre(cArrivee);
    	
    	}
    	
    }
      
    public Piece existancePiece(String nomPiece,Joueur joueurActuel){
    	for(int i=0;i<64;i++){
    		if(this.unEchequier.tabCase[i].piece.nom.equals(nomPiece) 
    				&& this.unEchequier.tabCase[i].piece.couleur.equals(joueurActuel.couleur)){
    			
    			return this.unEchequier.tabCase[i].piece;
    		}	
    	}
    	
    	return null;
    }
    
    public Piece existancePaire(Piece pieceVerifier, int paire  ){
    	
    	for(int i=0;i<64;i++){
    		if(this.unEchequier.tabCase[i].piece.paire==paire 
    				&& this.unEchequier.tabCase[i].piece.nom.equals(pieceVerifier.nom) 
    					&& this.unEchequier.tabCase[i].piece.couleur.equals(pieceVerifier.couleur)){
    			
    			return this.unEchequier.tabCase[i].piece;
    			
    		}
    	}	
    	return null;
    }
    
    
    public boolean indiceValide(int indice){
    	if(indice>=1 && indice<=8)
    		return true;
    	return false;
    	
    }
    
    public int convertionLettre(String Lettre){
    	if(Lettre.equals("A"))
    		return 1;
    	if(Lettre.equals("B"))
    		return 2;
    	if(Lettre.equals("C"))
    		return 3;
    	if(Lettre.equals("D"))
    		return 4;
    	if(Lettre.equals("E"))
    		return 5;
    	if(Lettre.equals("F"))
    		return 6;
    	if(Lettre.equals("G"))
    		return 7;
    	if(Lettre.equals("H"))
    		return 8;
    	return 0;
    	
    }
    
    public String convertionChiffre(int Chiffre){
    	if(Chiffre==1)
    		return "A";
    	if(Chiffre==2)
    		return "B";
    	if(Chiffre==3)
    		return "C";
    	if(Chiffre==4)
    		return "D";
    	if(Chiffre==5)
    		return "E";
    	if(Chiffre==6)
    		return "F";
    	if(Chiffre==7)
    		return "G";
    	if(Chiffre==8)
    		return "H";    	
    	return null;
    	
    }
    
    
    
    /*public Piece savePiece(String nomP, int paireP, int colonneP, int rangeeP, Couleur joueurETpiece){
    	for(int i=0;i<10;i++){
    		for(int j=0;j<10;j++){
    			if (this.echequier[i][j].c!=null){
    				if (this.echequier[i][j].c.getColonne() == colonneP && this.echequier[i][j].c.getRangee() == rangeeP){
    					if (this.echequier[i][j].c.piece.nom == nomP && this.echequier[i][j].c.piece.couleur == joueurETpiece )
    						return this.echequier[i][j].c.piece;
    				}
    			}
    		}
    	}
    	return null;
    }*/
    
   /* public int colonneDepart(String nomPiece, int paire, Joueur joueurActuel){
    	//System.out.println("je rentre dans la fonction existancePaire");
    	for(int i=0;i<10;i++){
    		//System.out.println("quand i = "+i);
    		for(int j=0;j<10;j++){
    			//System.out.println("quand j = "+j);
    			if (this.getEchequier()[i][j].c!=null){
    				//System.out.println("La case n'est pas nul.");
    				if(this.getEchequier()[i][j].c.piece.nom.equals(nomPiece) && this.getEchequier()[i][j].c.piece.couleur.equals(joueurActuel.getCouleur()) ){
    					//System.out.println("J'ai trouvé une piece possible");
    					if(this.getEchequier()[i][j].c.piece.paire==paire){
    						//System.out.println("J'ai trouvé la bonne paire");
    						return this.getEchequier()[i][j].c.getColonne();
    					}
    				}	
    			}
    		}
    	
    	return -1;
    }*/
    
    /*public int rangeeDepart(String nomPiece, int paire, Joueur joueurActuel){
    	//System.out.println("je rentre dans la fonction existancePaire");
    	for(int i=0;i<10;i++){
    		//System.out.println("quand i = "+i);
    		for(int j=0;j<10;j++){
    			//System.out.println("quand j = "+j);
    			if (this.getEchequier()[i][j].c!=null){
    				//System.out.println("La case n'est pas nul.");
    				if(this.getEchequier()[i][j].c.piece.nom.equals(nomPiece) && this.getEchequier()[i][j].c.piece.couleur.equals(joueurActuel.getCouleur()) ){
    					//System.out.println("J'ai trouvé une piece possible");
    					if(this.getEchequier()[i][j].c.piece.paire==paire){
    						//System.out.println("J'ai trouvé la bonne paire");
    						return this.getEchequier()[i][j].c.getRangee();
    					}
    				}	
    			}
    		}
    	}
    	return -1;
    }*/
    
    /*public boolean verifCouleurPiece(int r,int c, Joueur joueur){
    	//System.out.println("je rentre dans la fonction verifCouleurPiece");
    	for(int i=0;i<10;i++){
    		//System.out.println("quand i = "+i);
    		for(int j=0;j<10;j++){
    			//System.out.println("quand j = "+j);
    			if (this.getEchequier()[i][j].c!=null){
    				if (this.echequier[i][j].c.getColonne()==c && this.echequier[i][j].c.getRangee()==r){
    					if(this.echequier[i][j].c.piece.couleur.equals(joueur.getCouleur())){
    						System.out.println("meme couleur");
    						return true;
    					}
    				}
    			}
    		}
    	}
    	System.out.println("aucune erreur trouvé");
    	return false;
    }*/

    /*public boolean demanderSpécial(){
    	System.out.println("Voulez effectuer un mouvement spécial ?(écrire oui ou non)");
    	sc = new Scanner(System.in);
    	String str = sc.nextLine();
    	if (str.equals("oui"))
    		return true;
		return false;
    }*/
    
    public void sauvegarder() throws IOException{
    	 final String chemin = "C:/tmp.txt";
         final File fichier =new File(chemin); 
         try {
             // Creation du fichier
             fichier .createNewFile();
             // creation d'un writer (un écrivain)
             final FileWriter writer = new FileWriter(fichier);
             try {
                 writer.write("ceci est un texte\n");
                 writer.write("encore et encore");
             } finally {
                 // quoiqu'il arrive, on ferme le fichier
                 writer.close();
             }
         } catch (Exception e) {
             System.out.println("Impossible de creer le fichier");
         }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Joueur getJoueur1() {
		return joueur2;
	}

	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}

	public Joueur getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}

	public String getHistorique() {
		return historique;
	}

	public void setHistorique(String historique) {
		this.historique = historique;
	}

	public int getTour() {
		return tour;
	}

	public void setTour() {
		this.tour = tour+1;
	}
	
	public Echequier getEchequier(){
		return this.unEchequier;
	}


    
}
