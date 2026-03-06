package games.players;

import java.util.Random;
import games.genericgames.Game;

/**
 * Classe représentant un joueur qui choisit ses coups de manière aléatoire.
 * Ce joueur utilise un générateur de nombres aléatoires pour sélectionner un coup parmi les coups valides disponibles 
 * dans le jeu. 
 */
public class RandomPlayer implements Player{
	
	Random random; // L'instance du générateur de nombres aléatoires utilisé pour choisir un joueur aléatoire.
	
	/**
     * Constructeur pour initialiser un joueur aléatoire avec un générateur de nombres aléatoires.
   	 * 
   	 * @param rand Le générateur de nombres aléatoires
   	 */
	public RandomPlayer(Random rand){
		this.random = rand;
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
		int taille = game.validMoves().size();
		int rand = this.random.nextInt(taille);
		return game.validMoves().get(rand);
	}
	
	/**
     * Retourne le nom du joueur.
   	 * 
   	 * @return Le nom du joueur.
   	 */
	@Override
	public String toString(){
		return "Joueur aléatoire n° " + this.hashCode();
	}
	
}
