package games.nim;

import java.util.Scanner;
import games.nim.Nim;

/**
 * La classe Executable contient la méthode principale pour exécuter une partie du jeu de Nim.
 * Elle gère l'interaction avec les utilisateurs, y compris la saisie des noms des joueurs, 
 * de la taille du tas d'allumettes et du nombre maximal d'allumettes à retirer.
 */
public class Executable { 

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
     * Démarre une partie de Nim avec les joueurs et les paramètres spécifiés.
     *
     * @param j1 le nom du joueur 1
     * @param j2 le nom du joueur 2
     * @param nbA la taille initiale du tas d'allumettes
     * @param maxA le nombre maximal d'allumettes qu'un joueur peut retirer
     */
    public static void startGame(String j1, String j2, int nbA, int maxA) {
	
        Scanner scanner = new Scanner(System.in);
		
        Nim jeux = new Nim(nbA, maxA, j1, j2);
		
        System.out.println("Le jeu commence !");
		
        while (!jeux.isOver()) {
            System.out.println("Joueur " + jeux.getCurrentPlayer() + ". Saisissez votre coup s'il vous plaît !");
            int coup = scanner.nextInt();
            while (!jeux.isValid(coup)) {
                System.out.println("Désolé. Le nombre d'allumettes est invalide. Saisissez votre coup encore une fois s'il vous plaît !");
                coup = scanner.nextInt();
            }
            jeux.removeMatches(coup);
            System.out.println(jeux.situationToString());
        }
        System.out.println("Félicitations " + jeux.getWinner() + "! Vous avez gagné!");

        scanner.close();
    }
}

