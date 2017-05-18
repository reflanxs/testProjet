import java.util.Scanner;


public class Affichage {
    private Scanner scj1;
	private Scanner scj2;
	private Scanner sc;


    public void demanderNom(Joueur joueur1, Joueur joueur2) {
    	
    	System.out.println("Veuillez saisir le nom du joueur 1 :");
		scj1 = new Scanner(System.in);
		 joueur1.setNom(scj1.nextLine());
		
		System.out.println("Veuillez saisir le nom du joueur 2 :");
		scj2 = new Scanner(System.in);
		joueur2.setNom(scj2.nextLine());
		
		System.out.println("Le joueur 1 s'appelle "+joueur1.getNom()+" et le joueur 2 s'appelle "+joueur2.getNom()+".");
    	
    }


    public Couleur demanderCouleur() {
    	System.out.println("Veuillez saisir la couleur des pi�ces du joueur 1 (Attention il faut confirmer � 3 reprises:");
    	sc = new Scanner(System.in);
    	String str = sc.nextLine();	
    	
    	if(str.equals("noir") || str.equals("blanc")){
    		if (str.equals("noir")){
    			System.out.println("Le joueur 1 poss�de les pi�ces noires et le joueur 2 les pi�ces blanches");
    			return Couleur.noir;}
    		else{
    			System.out.println("Le joueur 1 poss�de les pi�ces blanches et le joueur 2 les pi�ces noires");
    			return Couleur.blanc;}
    	}
    	
    	else
    		return null;
    }


    public String jeu(Echequier[][] unEchequier, Joueur joueurActuel) {

    	String s="\n";
    	for (int a=0; a<10; a++){
    		s=s+"********";
    	}
    	
    	s=s+"*\n";
    	
    	for (int b=0; b<10; b++){
    		
    		for (int c=0; c<10; c++){
    			s=s+"*       ";
    		}
    		s=s+"*\n";
    		
    		for (int d=0; d<10; d++){
    			s=s+"*  "+unEchequier[b][d]+"  ";
    		}
    		s=s+"*\n";
    		
    		for (int e=0; e<10; e++){
    			s=s+"*       ";
    		}
    		s=s+"*\n";
    		
    		for (int f=0; f<10; f++){
        		s=s+"********";
        	}
        	s=s+"*\n";
    	}
		return s;
    }
    
    public Affichage (){}
    
    public void check(Echequier tab[][] ){
    	for(int i=0;i<10;i++){
    		for(int j=0;j<10;j++){
    			
    			if(tab[i][j].c==null){
    				System.out.println("l'emplacment "+i+"|"+j+" est une bordure");
    			}
    			else{
    				System.out.println("Emplacment "+i+"|"+j+": "+ tab[i][j].c.piece.nom+" de couleur "+tab[i][j].c.piece.getCouleur()+ " de paire "+tab[i][j].c.piece.paire+ " a la case de colonne "+tab[i][j].c.getColonne()+" et de rang�e "+tab[i][j].c.getRangee() );
    			}
    		}
    	}
    }
    
    public void historiqueCoup(String move){
    	System.out.println(move);
    }

}
