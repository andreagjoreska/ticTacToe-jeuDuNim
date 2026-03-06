package games.tictactoe;

/**
 * La classe TicTacToe représente une partie de Tic Tac Toe entre deux joueurs.
 * Elle gère l'état du jeu, y compris les noms des joueurs, le joueur courant et les coups joués sur le plateau.
 */
public class TicTacToe {

    String joueur1;     // Nom du joueur 1
    String joueur2;     // Nom du joueur 2
    String[][] coups;   // Plateau de jeu représenté sous forme de tableau 2D
    String jCourant;    // Nom du joueur en cours

    /**
     * Crée une instance de TicTacToe avec deux joueurs.
     *
     * @param j1 le nom du joueur 1
     * @param j2 le nom du joueur 2
     */
    public TicTacToe(String j1, String j2) {
        this.joueur1 = j1;
        this.joueur2 = j2;
        this.coups = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.coups[i][j] = ".";
            }
        }
        this.jCourant = j1;
    }

    /**
     * Renvoie le nom du joueur courant.
     *
     * @return le nom du joueur en cours
     */
    public String getCurrentPlayer() {
        return this.jCourant;
    }

    /**
     * Effectue un coup pour le joueur courant à la position spécifiée.
     *
     * @param rangee l'indice de la ligne (0, 1 ou 2) où le coup est joué
     * @param colonne l'indice de la colonne (0, 1 ou 2) où le coup est joué
     */
    public void execute(int rangee, int colonne) {
        if (this.jCourant == this.joueur1) {
            this.coups[rangee][colonne] = "X";
            this.jCourant = this.joueur2;
        } else {
            this.coups[rangee][colonne] = "0";
            this.jCourant = this.joueur1;
        }
    }

    /**
     * Vérifie si un coup à la position spécifiée est valide.
     *
     * @param rangee l'indice de la ligne à vérifier
     * @param colonne l'indice de la colonne à vérifier
     * @return vrai si le coup est valide, faux sinon
     */
    public boolean isValid(int rangee, int colonne) {
        if (rangee >= 3 || rangee < 0 || colonne >= 3 || colonne < 0 || this.coups[rangee][colonne] != ".") {
            return false;
        }
        return true;
    }


    /**
     * Détermine le gagnant de la partie, s'il y en a un.
     *
     * @return le nom du gagnant, ou null s'il n'y a pas encore de gagnant
     */
    public String getWinner() {
        String gagneur = null;
		for (int i = 0; i < 3; i++) {
			 if (this.coups[i][0] == this.coups[i][1] && this.coups[i][1] == this.coups[i][2]) {
				if(this.coups[i][0] == "X"){
					gagneur = this.joueur1;
				}
				else if(this.coups[i][0] == "0"){
					gagneur = this.joueur2;
				}
			  }
			 if (this.coups[0][i] == this.coups[1][i] && this.coups[1][i] == this.coups[2][i]) {
				if(this.coups[0][i] == "X"){
					gagneur = this.joueur1;
				}
				else if(this.coups[0][i] == "0"){
					gagneur = this.joueur2;
				}
	  		}
		}
		if (this.coups[0][0] == this.coups[1][1] && this.coups[1][1] == this.coups[2][2]) {
		  		if(this.coups[0][0] == "X"){
					gagneur = this.joueur1;
				}
				else if(this.coups[0][0] == "0"){
					gagneur = this.joueur2;
				}
		}
		if (this.coups[0][2] == this.coups[1][1] && this.coups[1][1] == this.coups[2][0]) {
		  		if(this.coups[2][0] == "X"){
					gagneur = this.joueur1;
				}
				else if(this.coups[2][0] == "0"){
					gagneur = this.joueur2;
				}
		}
		return gagneur;
    }

    /**
     * Vérifie si la partie est terminée, que ce soit par une victoire ou par un plateau plein.
     *
     * @return vrai si la partie est terminée, faux sinon
     */
    public boolean isOver() {
        if (this.getWinner() != null) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.coups[i][j] == ".") {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Renvoie une représentation sous forme de chaîne du plateau de jeu actuel.
     *
     * @return une chaîne montrant la situation actuelle du plateau
     */
    public String situationToString() {
        String s = "  0 1 2";
        for (int i = 0; i < 3; i++) {
            s += System.lineSeparator();
            s += (i + " ");
            for (int j = 0; j < 3; j++) {
                s += (this.coups[i][j] + ' ');
            }
        }
        return s;
    }
}

