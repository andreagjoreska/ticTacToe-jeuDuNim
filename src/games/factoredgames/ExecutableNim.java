package games.factoredgames;

import java.util.Scanner;

/**
 * La classe ExecutableNim est responsable de l'exécution du jeu de Nim dans un environnement
 * en ligne de commande. 
 */
public class ExecutableNim { 

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Mettez le nom du premier joueur s'il vous plaît !");
		String joueur1 = scanner.next();
			
		System.out.println("Mettez le nom du deuxième joueur s'il vous plaît !");
		String joueur2 = scanner.next();
			
		System.out.println("Mettez la taille initiale du tas s'il vous plaît !");
		int nbAll = scanner.nextInt();
			
		System.out.println("Mettez le nombre maximal d'allumettes que le joueur peut retirer s'il vous plaît !");
		int maxAll = scanner.nextInt();
			
		while(maxAll > nbAll) {
			System.out.println("Vous devez mettre un nombre plus petit où égal à " + nbAll);
			maxAll = scanner.nextInt();
		}
			
		startGame(joueur1, joueur2, nbAll, maxAll);
	
			
	}

	/**
     * Démarre une partie de Nim avec les joueurs spécifiés, la taille du tas, 
     * et le nombre maximal d'allumettes que chaque joueur peut retirer par tour.
     * 
     * @param j1 Le nom du joueur 1
   	 * @param j2 Le nom du joueur 2
   	 * @param nbA Le nombre initial d'allumettes dans le tas
   	 * @param maxA Le nombre maximal d'allumettes qu'un joueur peut retirer à chaque tour
  	 */
	public static void startGame(String j1, String j2, int nbA, int maxA) {
	
		Scanner scanner = new Scanner(System.in);
	
		Nim jeux = new Nim(nbA, maxA, j1, j2);
		
		System.out.println("Le jeu commence !");
		
		while(!jeux.isOver()){
			System.out.println("Joueur " + jeux.getCurrentPlayer() + ". Saisissez votre coup s'il vous plait !");
			int coup = scanner.nextInt();
			while (!jeux.isValid(coup)) {
				System.out.println("Desole. Le nombre d'allumettes est invalid. Saisissez votre coup s'il vous plait !");
				coup = scanner.nextInt();
			}
			jeux.execute(coup);
			System.out.println(jeux.situationToString());
		}
		
		System.out.println("Le jeu est termine. Le gagneur est le joueur " + jeux.getWinner());
		scanner.close();
	}
	
}
