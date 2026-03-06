package games.players;

import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
import games.genericgames.Game;

/**
 * Classe représentant un joueur utilisant l'algorithme Negamax avec mise en cache des évaluations de situations.
 * Cette classe améliore l'algorithme Negamax en mémorisant les évaluations des situations de jeu précédentes 
 * dans un cache pour éviter de recalculer plusieurs fois les mêmes évaluations, ce qui optimise la performance 
 * lors de la recherche de coups dans des jeux complexes.
 */
public class NegamaxPlayerWithCache extends NegamaxPlayer{
	
	Map<Integer, Game> map = new HashMap<>();  // Cache pour stocker les évaluations des situations précédentes
	
	/**
     * Constructeur pour initialiser un joueur utilisant l'algorithme Negamax avec mise en cache des évaluations.
     */
	public NegamaxPlayerWithCache(){
	}
	
	/**
     * Évalue une situation donnée (état du jeu) en fonction de l'algorithme Negamax avec cache.
     * Avant de calculer une nouvelle évaluation, la méthode vérifie si la situation a déjà été évaluée.
     * Si elle a été précédemment rencontrée, l'évaluation est récupérée à partir du cache.
     * 
     * @param situation La situation (état du jeu) à évaluer.
     * @return Un score évaluant la situation : 1 pour une victoire, -1 pour une défaite, et 0 pour une égalité.
     */
	@Override
	public int evaluate(Game situation){
	
		for(Map.Entry<Integer, Game> entry: map.entrySet()) {
			if(entry.getValue().equals(situation)) {
				return entry.getKey();
			}
		}
		
		if (situation.isOver()) {
			if (situation.getWinner() == situation.getCurrentPlayer()) {
				map.put(1, situation);
				return 1; 
			} else if (situation.getWinner() != null) {
			   	map.put(-1, situation);
				return -1; 
			} else {
				map.put(0, situation);
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
	
}
