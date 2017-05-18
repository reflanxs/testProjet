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
    	System.out.println("Veuillez saisir la couleur des pièces du joueur 1 (Attention il faut confirmer à 3 reprises:");
    	sc = new Scanner(System.in);
    	String str = sc.nextLine();	
    	
    	if(str.equals("noir") || str.equals("blanc")){
    		if (str.equals("noir")){
    			System.out.println("Le joueur 1 possède les pièces noires et le joueur 2 les pièces blanches");
    			return Couleur.noir;}
    		else{
    			System.out.println("Le joueur 1 possède les pièces blanches et le joueur 2 les pièces noires");
    			return Couleur.blanc;}
    	}
    	
    	else
    		return null;
    }


    public String jeu(Echequier unEchequier, Joueur joueurActuel) {
    	int indexTab = 1;
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
    			
    			if (b==0 && d==0)
    				s=s+"*       ";
    			else if (b==0 && d==9)
    				s=s+"*       ";
    			else if (b==9 && d==0)
    				s=s+"*       ";
    			else if (b==9 && d==9)
    				s=s+"*       ";
    			
    			else if(b==0){
    				s=s+"*   "+afficherColonne(d)+"   ";
    			}
    			else if(b==9){
    				s=s+"*   "+afficherColonne(d)+"   ";    			
    			}
    		
    			else if (d==0){
    				s=s+"*   "+b+"   ";  
    			}
    			
    			else if (d==9){
    				s=s+"*   "+b+"   ";  
    			}
    			
    			else{
    				s=s+"*  "+unEchequier.tabCase[unEchequier.recupIndex(b-1, d-1)/*(8*(b-1))+(d-1)*/].piece.toString()+"  ";
    				
    			}
    			
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
    
    private String afficherColonne(int Colonne) {
    	if(Colonne==1)
    		return "A";
    	if(Colonne==2)
    		return "B";
    	if(Colonne==3)
    		return "C";
    	if(Colonne==4)
    		return "D";
    	if(Colonne==5)
    		return "E";
    	if(Colonne==6)
    		return "F";
    	if(Colonne==7)
    		return "G";
    	if(Colonne==8)
    		return "H";    	
    	return null;
		
	}


	public Affichage (){}
    
	
	
	
	
    public void check(Echequier tab ){
    	for(int i=0;i<64;i++){
    		System.out.println("Case numero "+i+"/ rangée: "+tab.tabCase[i].getRangee()+"/colonne: "+tab.tabCase[i].getColonne()+" / "+ tab.tabCase[i].piece.toString());
    	}
    }
    
    public void historiqueCoup(String move){
    	System.out.println(move);
    }

}
