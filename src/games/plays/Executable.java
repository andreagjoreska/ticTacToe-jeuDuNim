package games.plays;

import java.util.*;
import games.players.*;
import games.genericgames.*;

/**
 * Classe principale pour l'exécution du jeu.
 * Cette classe permet à l'utilisateur de choisir un jeu (par exemple, Nim ou Morpion), ainsi que le mode de jeu 
 * et la configuration des joueurs. Elle orchestre ensuite le déroulement de la partie en fonction des choix 
 * effectués par l'utilisateur.
 * 
 * Le programme permet les choix suivants :
 * - Choisir entre deux jeux : Jeu du Nim ou Morpion.
 * - Choisir le mode de jeu, qui détermine les types de joueurs (humain, aléatoire, ou joueur AI basé sur l'algorithme Negamax).
 */
public class Executable{
	public static void main(String[] args) {
	
		Random rand = new Random(123);
		Scanner scanner = new Scanner(System.in);
		
		Player player1;
		Player player2;
		
		// Demande à l'utilisateur de choisir quel jeu il souhaite jouer
		System.out.println("Choisissez le jeu que vous voulez jouer. \n Option 1 : Jeu du Nim\n Option 2 : Morpion");
		int reponse = scanner.nextInt();
		
		// Validation de la réponse de l'utilisateur pour le choix du jeu
		while (reponse != 1 && reponse != 2) {
			System.out.println("Choisissez entre 1 et 2 !");
			reponse = scanner.nextInt();
		}
		
		System.out.println("Choisissez le mode de jeu. \n Option 1 : Humain contre humain \n Option 2 : Humain contre un joueur aléatoire \n Option 3 : Humain contre le joueur Negamax \n Option 4 : Humain contre le joueur NegamaxWithCache \n Option 5 : Joueur aléatoire contre un autre joueur aléatoire \n Option 6 : Joueur aléatoire contre joueur NegamaxWithCache \n Option 7 : Joueur Negamax contre Joueur NegamaxWithCache \n");
		
		int mode = scanner.nextInt();
		
		while (mode < 1 && mode > 7) {
			System.out.println("Choisissez un nombre entre 1 et 7 !");
			mode = scanner.nextInt();
		}
		
		// Configuration des joueurs en fonction du mode choisi
		if (mode == 1) {
			System.out.println("Mettez le nom du premier joueur.");
			String j1 = scanner.next();
			player1 = new Human(j1, scanner);
			System.out.println("Mettez le nom du deuxième joueur.");
			String j2 = scanner.next();
			player2 = new Human(j2, scanner);
		} 
		else if (mode <= 4) {
			System.out.println("A quelle position voulez-vous jouer ? (1 ou 2) ");
			
			int pos = scanner.nextInt();
		
			while (pos < 1 && pos > 2) {
				System.out.println("Choisissez un nombre entre 1 et 2 !");
				pos = scanner.nextInt();
			}
			if (pos == 1) {
				System.out.println("Mettez votre nom !");
				String j1 = scanner.next();
				player1 = new Human(j1, scanner);
				if (mode == 2) {
					player2 = new RandomPlayer(rand);
				} else if (mode == 3) {
					player2 = new NegamaxPlayer();
				} else {
					player2 = new NegamaxPlayerWithCache();
				}
			} else {
				System.out.println("Mettez votre nom !");
				String j2 = scanner.next();
				player2 = new Human(j2, scanner);
				if (mode == 2) {
					player1 = new RandomPlayer(rand);
				} else if (mode == 3) {
					player1 = new NegamaxPlayer();
				} else {
					player1 = new NegamaxPlayerWithCache();
				}
			}
		} else if (mode <= 6) {
				player1 = new RandomPlayer(rand);
				if (mode == 5) {
					player2 = new RandomPlayer(rand);
				} else {
					player2 = new NegamaxPlayerWithCache();
				}
		} else {
			player1 = new NegamaxPlayer();
			player2 = new NegamaxPlayerWithCache();
		}
		
		// Si le jeu choisi est "Jeu du Nim"
		if (reponse == 1){
			System.out.println("Mettez la taille initiale du tas s'il vous plaît !");
			int nbAll = scanner.nextInt();
			System.out.println("Mettez le nombre maximal d'allumettes que le joueur peut retirer s'il vous plaît !");
			int maxAll = scanner.nextInt();
			while(maxAll > nbAll) {
				System.out.println("Vous devez mettre un nombre plus petit où égal à " + nbAll);
				maxAll = scanner.nextInt();
			}
			// Création du jeu du Nim et lancement de l'orchestrateur
			Nim game = new Nim(nbAll, maxAll, player1, player2);
			Orchestrator orchestrator = new Orchestrator(game);
			orchestrator.play();
		} else {
			// Si le jeu choisi est "Morpion"
			TicTacToe game = new TicTacToe(player1, player2);
			Orchestrator orchestrator = new Orchestrator(game);
			orchestrator.play();
		}
			
		scanner.close();
    
	}
}
