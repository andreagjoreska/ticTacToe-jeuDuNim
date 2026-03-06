package games.factoredgames;

/**
 * La classe TicTacToe représente le jeu de Tic-Tac-Toe (ou morpion) avec deux joueurs. 
 * Elle gère la logique du jeu sur un plateau de 3x3 cases.
 */
public class TicTacToe extends AbstractGame{

	String[][] coups; // Tableau représentant le plateau de jeu
	
	/**
     * Constructeur du jeu TicTacToe avec les noms des joueurs
     * 
   	 * @param j1 le nom du joueur 1
   	 * @param j2 le nom du joueur 2
   	 */
	public TicTacToe (String j1, String j2){
		super(j1,j2);
		this.coups = new String[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				this.coups[i][j] = ".";
			}
		}
	}
	
	/**
     * Renvoie le joueur courant.
   	 * 
   	 * @return le nom du joueur courant
   	 */
	public String getCurrentPlayer() {
		return this.jCourant;
	}
	
	/**
   	 * Exécute un coup du joueur courant sur le plateau.
   	 * 
   	 * @param coup l'index du coup (entre 0 et 8)
   	 */
	@Override
	public void doExecute(int coup) {
		int rangee = coup / 3;
		int colonne = coup % 3;
		if (this.jCourant == this.joueur1){
			this.coups[rangee][colonne] = "X";
		}
		else if (this.jCourant == this.joueur2){
			this.coups[rangee][colonne] = "0";
		}
	}
	
	/**
     * Vérifie si un coup est valide. Un coup est valide si :
   	 * 
   	 * @param coup l'index du coup (entre 0 et 8)
  	 * @return true si le coup est valide, sinon false
   	 */
	public boolean isValid(int coup) {
		int rangee = coup / 3;
		int colonne = coup % 3;
		if (rangee >= 3 || rangee < 0 || colonne >= 3 || colonne < 0 || this.coups[rangee][colonne] != ".") {
			return false;
		}
		return true;
	}
	
	/**
   	 * Vérifie s'il y a un gagnant. 
   	 * 
   	 * @return le nom du joueur gagnant, ou null si aucun gagnant
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
     * Vérifie si la partie est terminée. 
     * 
     * @return true si la partie est terminée, sinon false
     */
	public boolean isOver() {
		if (this.getWinner() != null) {
			return true;
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(this.coups[i][j] == "."){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
     * Affiche l'état actuel du plateau sous forme de chaîne de caractères.
   	 * 
   	 * @return une représentation textuelle du plateau de jeu
   	 */
	public String situationToString(){
		String s = "  0 1 2";
		for(int i=0;i<3;i++) {
			s += System.lineSeparator();
			s += (i + " ");
			for(int j=0;j<3;j++) {
				s += (this.coups[i][j] + ' ');
			}
		}
		return s;
	}
}
