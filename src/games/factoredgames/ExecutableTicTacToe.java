package games.factoredgames;

import java.util.Scanner;

/**
 * Classe permettant de démarrer une partie de Tic Tac Toe entre deux joueurs.
 */
class ExecutableTicTacToe{
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Mettez le nom du premier joueur s'il vous plaît !");
		String joueur1 = scanner.next();
			
		System.out.println("Mettez le nom du deuxième joueur s'il vous plaît !");
		String joueur2 = scanner.next();
			
		startGame(joueur1, joueur2);
	}	
	
	/**
     * Démarre une partie de Tic Tac Toe entre les deux joueurs spécifiés.
   	 * 
   	 * @param j1 le nom du joueur 1
   	 * @param j2 le nom du joueur 2
   	 */
	static void startGame(String j1, String j2) {
		
		Scanner scanner = new Scanner(System.in);
		
		TicTacToe jeux = new TicTacToe(j1,j2);
		
		System.out.println("Le jeu commence");
		System.out.println(jeux.situationToString());
		
		while(!jeux.isOver()){
			System.out.println("Joueur " + jeux.getCurrentPlayer() + ". Saisissez votre coup (0-8) s'il vous plait !");
			int coup = scanner.nextInt();
			while(!jeux.isValid(coup)){
				System.out.println("Le coup est invalid. Saisissez un autre coup s'il vous plait !");
				coup = scanner.nextInt();
			}
			jeux.execute(coup);
			System.out.println(jeux.situationToString());
		}
		
		if (jeux.getWinner() != null)
			System.out.println("Le jeu est terminé. Le joueur " + jeux.getWinner() + " a gagné !");
		else {
			System.out.println("Le jeu est termine. Personne n'a gagné.");
		}
		
		scanner.close();
	}
	
}
