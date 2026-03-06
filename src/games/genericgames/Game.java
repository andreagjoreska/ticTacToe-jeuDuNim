package games.genericgames;

import java.util.List;
import games.players.Player;

/**
 * Interface représentant un jeu générique à deux joueurs.
 * Cette interface définit les méthodes nécessaires pour interagir avec n'importe quel type de jeu, qu'il soit
 * abstrait ou spécifique. Elle permet de gérer les joueurs, l'état du jeu, l'exécution des coups, et la vérification
 * de la fin du jeu et du gagnant.
 */
public interface Game{

	// Méthode pour obtenir le joueur courant
    public Player getCurrentPlayer();

   	// Méthode pour vérifier si un coup est valide
   	public boolean isValid(int coup);

   	// Méthode pour exécuter un coup
   	public void execute(int coup);

    // Méthode pour vérifier si le jeu est terminé
   	public boolean isOver();

    // Méthode pour obtenir le gagnant du jeu
   	public Player getWinner();

   	// Méthode pour obtenir la liste des coups valides possibles
   	public List<Integer> validMoves();

   	// Méthode pour obtenir une représentation textuelle d'un coup
   	public String moveToString(int coup);

   	// Méthode pour obtenir une représentation textuelle de la situation du jeu
   	public String situationToString();

   	// Méthode pour copier le jeu actuel
   	public Game copy();
	
}
