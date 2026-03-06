package games.tictactoe;

import java.util.Scanner;

/**
 * La classe Executable contient la méthode principale pour exécuter une partie de Tic Tac Toe.
 * Elle gère l'interaction avec les utilisateurs, y compris la saisie des noms des joueurs et des coups.
 */
public class Executable {
	
    public static void main(String[] args) {
     
        Scanner scanner = new Scanner(System.in);
		
        System.out.println("Mettez le nom du premier joueur s'il vous plaît !");
        String joueur1 = scanner.next();
		
        System.out.println("Mettez le nom du deuxième joueur s'il vous plaît !");
        String joueur2 = scanner.next();
		
        startGame(joueur1, joueur2);
    }	
	
    /**
     * Démarre une partie de Tic Tac Toe entre deux joueurs.
     *
     * @param j1 le nom du joueur 1
     * @param j2 le nom du joueur 2
     */
    static void startGame(String j1, String j2) {
		
        Scanner scanner = new Scanner(System.in);
		
        TicTacToe jeux = new TicTacToe(j1, j2);
		
        System.out.println("Le jeu commence !");
		
        System.out.println(jeux.situationToString());
		
        while (!jeux.isOver()) {
            System.out.println("Joueur " + jeux.getCurrentPlayer() + ". Saisissez votre coup s'il vous plaît !");
			
            System.out.println("- rangée ?");
            int rangee = scanner.nextInt();
			
            System.out.println("- colonne ?");
            int colonne = scanner.nextInt();
			
            while (!jeux.isValid(rangee, colonne)) {
                System.out.println("Le coup est invalide. Saisissez un autre coup s'il vous plaît !");
                System.out.println("- rangée ?");
                rangee = scanner.nextInt();
				
                System.out.println("- colonne ?");
                colonne = scanner.nextInt();
            }
            jeux.execute(rangee, colonne);
            System.out.println(jeux.situationToString());
        }
        if (jeux.getWinner() != null)
            System.out.println("Le jeu est terminé. Le joueur " + jeux.getWinner() + " a gagné !");
        else {
            System.out.println("Le jeu est terminé. Personne n'a gagné.");
        }
    }
}

