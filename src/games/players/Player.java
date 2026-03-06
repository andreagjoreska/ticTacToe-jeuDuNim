package games.players;

import games.genericgames.Game;

/**
 * Interface représentant un joueur dans un jeu.
 * Cette interface définit la méthode `chooseMove` que chaque type de joueur doit implémenter. 
 */
public interface Player{

	/**
     * Demande à l'utilisateur de choisir un coup parmi les coups valides.
   	 * 
   	 * @param game Le jeu en cours dans lequel le coup est choisi.
   	 * @return L'indice du coup choisi par le joueur.
   	 */
	public int chooseMove(Game game);

}
