package games.tictactoe;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe TicTacToe représente une partie de Tic Tac Toe entre deux joueurs avec des indices.
 */
public class TicTacToeWithHints extends TicTacToe{

    /**
     * Crée une instance de TicTacToeWithHints avec deux joueurs.
     *
     * @param j1 le nom du joueur 1
     * @param j2 le nom du joueur 2
     */
    public TicTacToeWithHints(String j1, String j2) {
        super(j1,j2);
    }
    
    /**
     * Fournit des indices en trouvant les positions où l'adversaire est sur le point de gagner.
     * Ces positions sont les menaces pour le joueur actuel.
     * 
     * @return une ArrayList d'entiers représentant les positions sur la grille où 
     *         le joueur actuel devrait bloquer l'adversaire.
     */
    
    public ArrayList<Integer> hints(){
    	ArrayList<Integer> hint = new ArrayList<Integer>();
    	
    	String adversaire;
    	if(this.getCurrentPlayer().equals(this.joueur1)){
    		adversaire = "0";
    	}
    	else{
    		adversaire = "X";
    	}
    	
    	for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (this.coups[row][col] == ".") {
                    this.coups[row][col] = adversaire;
                    if (this.getWinner() != null) {
                        hint.add(row * 3 + col);
                    }
                    this.coups[row][col] = ".";
                }
            }
        }
        
        return hint;	
    }
    
    /**
     * Convertit l'état actuel du jeu en une chaîne de caractères, ajoutant les indices
     * sur les menaces potentielles de l'adversaire.
     * 
     * @return une chaîne représentant l'état actuel du jeu, incluant les menaces pour le joueur actuel.
     */
    
    @Override
    public String situationToString() {
        String res = super.situationToString();
		res += System.lineSeparator();
        ArrayList<Integer> hints = hints();
        if (!hints.isEmpty()) {
            res += ("Menaces pour le joueur " + this.getCurrentPlayer() + ": ");
            for (int hint : hints) {
                int row = hint / 3;
                int col = hint % 3;
                res += ("(" + row + ", " + col + ") ");
            }
            res += System.lineSeparator();
        }

        return res;
    }

}
