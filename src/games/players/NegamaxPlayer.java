package games.players;

import games.genericgames.Game;

/**
 * Classe représentant un joueur utilisant l'algorithme Negamax pour prendre des décisions stratégiques dans un jeu.
 * L'algorithme Negamax est utilisé dans les jeux à deux joueurs pour déterminer 
 * le meilleur coup possible en explorant les différents états du jeu. 
 */
public class NegamaxPlayer implements Player{

	/**
     * Constructeur pour initialiser un joueur utilisant l'algorithme Negamax.
     */
	public NegamaxPlayer(){
	}

	/**
     * Évalue une situation donnée (état du jeu) en fonction de l'algorithme Negamax.
   	 * Cette méthode effectue une recherche récursive pour déterminer si un joueur gagne, perd ou si la partie est nulle.
   	 * 
     * @param situation La situation (état du jeu) à évaluer.
   	 * @return Un score évaluant la situation : 1 pour une victoire, -1 pour une défaite, et 0 pour une égalité.
   	 */
	public int evaluate(Game situation){
		 if (situation.isOver()) {
		    if (situation.getWinner() == situation.getCurrentPlayer()) {
		        return 1; 
		    } else if (situation.getWinner() != null) {
		        return -1; 
		    } else {
		        return 0; 
		    }
		}
        
		Integer res = null;
		
		for (int move : situation.validMoves()) {
		    Game gameCopy = situation.copy();
		    gameCopy.execute(move);
		    int value = -this.evaluate(gameCopy);
		    if (res == null || value > res) {
		        res = value;
		    }
		}
        
		return res;
	}
	
	/**
     * Choisit le meilleur coup possible à jouer en utilisant l'algorithme Negamax.
   	 * L'algorithme explore tous les coups valides et sélectionne celui qui maximise le score évalué.
   	 * 
   	 * @param game Le jeu dans lequel choisir le coup.
   	 * @return Le coup choisi qui maximise la probabilité de gagner.
   	 */
	@Override
	public int chooseMove(Game game) {
		Integer bestValue = null;
		Integer bestMove = -1;

		for (int move : game.validMoves()) {
		    Game gameCopy = game.copy();
		    gameCopy.execute(move);
		    int value = -this.evaluate(gameCopy);
		    if (bestValue == null || value > bestValue) {
		        bestValue = value;
		        bestMove = move;
		    }
		}

		return bestMove;
    }

}
