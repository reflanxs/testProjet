import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		
		Joueur j1 = new Joueur();
		Joueur j2 = new Joueur();
		Echequier echequier = new Echequier();
		Affichage a = new Affichage();
		
		a.demanderNom(j1, j2);
		
		Couleur saveCouleur=a.demanderCouleur();
		
		while (saveCouleur==null){
			System.out.println("Erreur de saisie; tapez noir ou blanc");
			saveCouleur=a.demanderCouleur();;
		}

		if (saveCouleur.equals(Couleur.noir)){
			j1.setCouleur(Couleur.noir);
			j2.setCouleur(Couleur.blanc);
		}
		else{
			j1.setCouleur(Couleur.blanc);
			j2.setCouleur(Couleur.noir);
		}
		
		Arbitre arbitre = new Arbitre();
		
		Partie p= new Partie(echequier,j1,j2,arbitre);//ne plus utiliser echequier mais p.echequier
		p.initialiser();
		
		System.out.println(j1);
		System.out.println(j2);
		System.out.println(arbitre);
		
		System.out.println(a.jeu(p.getEchequier(),j1));
		
		//a.check(p.getEchequier());
		
		
		//p.sauvegarder();
		
		/*int cpt = 1;
		int controlBoucle = 0;
		while ( controlBoucle<5){//arbitre.verifierEtMat(null, null) == false || arbitre.verifierEtMat(null, null) == false ||
			//a.check(echequier);

			if(cpt==1){
				p.setTour();
				System.out.println("Tour "+p.getTour()+"\nC'est au tour de "+j1.getNom());
				System.out.println(a.jeu(p.getEchequier(),j1));
				a.historiqueCoup(p.getHistorique());
				p.jouer(j1);
				cpt=2;
				//a.check(echequier);
			}
			else{
				p.setTour();
				System.out.println("Tour "+p.getTour()+"\nC'est au tour de "+j2.getNom());
				System.out.println(a.jeu(p.getEchequier(),j2));
				a.historiqueCoup(p.getHistorique());
				p.jouer(j2);
				cpt=1;
				//a.check(echequier);

			}
			/*controlBoucle++;
			System.out.println("Boucle numero: "+controlBoucle);*/
		//}
	
	}

}
