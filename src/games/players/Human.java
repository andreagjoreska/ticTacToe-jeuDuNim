package games.players;

import java.util.Scanner;
import games.genericgames.Game;

/**
 * Classe représentant un joueur humain dans le jeu.
 * Cette classe permet de gérer les interactions d'un joueur humain avec le jeu en lui demandant de choisir un coup 
 * à chaque tour. Le joueur entre son choix via la console, et la classe s'assure que ce choix est valide avant de l'accepter.
 */
public class Human implements Player{
	
	String nom; // Le nom du joueur
	Scanner scan; // L'instance de Scanner utilisée pour lire les entrées de l'utilisateur
	
	/**
     * Constructeur pour initialiser un joueur humain avec un nom et un scanner pour les entrées.
     * 
   	 * @param name Le nom du joueur.
   	 * @param scan Le scanner utilisé pour obtenir les entrées utilisateur.
   	 */
	public Human(String name, Scanner scan){
		this.nom = name;
		this.scan = scan;
	}
	
	/**
     * Demande à l'utilisateur de choisir un coup parmi les coups valides.
   	 * La méthode affiche les coups valides, puis attend que l'utilisateur entre un coup valide.
   	 * 
   	 * @param game Le jeu en cours dans lequel le coup est choisi.
   	 * @return L'indice du coup choisi par le joueur.
     */
	@Override
	public int chooseMove(Game game){
	
		System.out.println("Valides moves : " + System.lineSeparator());
		
		for(int i = 0; i < game.validMoves().size(); i++){
			System.out.println("Option " + i + ": " + game.validMoves().get(i) + System.lineSeparator());
		}
		
		System.out.println("Choissisez votre coup ");
		
		int move = this.scan.nextInt();
		
		while(!game.isValid(move)){
			System.out.println("Choissisez un autre coup ");
			move = this.scan.nextInt();
		}
		
		return move;
	}
	
	/**
     * Retourne le nom du joueur.
   	 * 
   	 * @return Le nom du joueur.
   	 */
	@Override
	public String toString() {
		return this.nom;
	}
	
}
