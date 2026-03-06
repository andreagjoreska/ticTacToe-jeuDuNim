package games.genericgames;

import games.players.Player;
import java.util.*;

/**
 * Classe représentant le jeu de Tic Tac Toe (ou Morpion), un jeu à deux joueurs.
 * Le jeu se joue sur une grille 3x3, et les joueurs alternent pour marquer des cases avec un "X" ou un "O".
 * Le premier joueur à aligner trois de ses symboles sur une ligne, une colonne ou une diagonale gagne la partie.
 * Si toutes les cases sont remplies sans qu'un joueur gagne, la partie est un match nul.
 */
public class TicTacToe extends AbstractGame{

	String[][] coups;
	
	/**
     * Constructeur du jeu de Tic Tac Toe.
     * Initialise une grille vide et assigne les joueurs.
     * 
   	 * @param j1 Le joueur 1.
   	 * @param j2 Le joueur 2.
   	 */
	public TicTacToe (Player j1, Player j2){
		super(j1,j2);
		this.coups = new String[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				this.coups[i][j] = ".";
			}
		}
	}
	
	/**
     * Retourne le joueur courant.
     * 
   	 * @return Le joueur courant.
   	 */
	@Override
	public Player getCurrentPlayer() {
		return this.jCourant;
	}
	
	/**
  	 * Exécute un coup dans le jeu.
  	 * Le coup est un indice dans la grille, qui est converti en ligne et colonne pour marquer "X" ou "O".
  	 * 
  	 * @param coup L'indice du coup (0-8) à exécuter.
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
     * Vérifie si un coup est valide.
  	 * 
   	 * @param coup L'indice du coup (0-8) à vérifier.
  	 * @return true si le coup est valide, sinon false.
   	 */
	@Override
	public boolean isValid(int coup) {
		int rangee = coup / 3;
		int colonne = coup % 3;
		if (rangee >= 3 || rangee < 0 || colonne >= 3 || colonne < 0 || this.coups[rangee][colonne] != ".") {
			return false;
		}
		return true;
	}
	
	/**
     * Vérifie si un joueur a gagné.
     * 
   	 * @return Le joueur gagnant, ou null si le jeu n'a pas encore de gagnant.
   	 */
	@Override
	public Player getWinner() {
		Player gagneur = null;
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
     * Exécute un coup et change de joueur.
   	 * 
   	 * @param coup L'indice du coup (0-8) à exécuter.
   	 */
	@Override 
	public void execute(int coup) {
		super.execute(coup);
	}
	 
	/**
     * Vérifie si le jeu est terminé.
   	 * 
   	 * @return true si le jeu est terminé, sinon false.
   	 */
	@Override
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
     * Retourne une représentation sous forme de chaîne de caractères de l'état actuel de la grille.
   	 * 
   	 * @return L'état actuel de la grille sous forme de chaîne de caractères.
   	 */
	@Override
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

	/**
     * Retourne une liste des coups valides (cases vides) que le joueur courant peut effectuer.
   	 * 
   	 * @return Liste des coups valides.
   	 */
	@Override
	public List<Integer> validMoves(){
		List<Integer> liste = new ArrayList<Integer>();
		for (int i=0;i<3;i++){
			for(int j=0;j<3;j++) {
				if (this.coups[i][j]=="."){
					liste.add(i*3+j);
				}
			}
		}
		return liste;
	}
	
	/**
     * Retourne une représentation sous forme de chaîne de caractères d'un coup spécifique dans la grille.
   	 * 
   	 * @param coup L'indice du coup (0-8) à afficher.
   	 * @return La représentation de ce coup sous forme de chaîne.
   	 */
	@Override
    public String moveToString(int coup) {
        int row = coup / 3;
        int col = coup % 3;
        return "Le joueur a joué Ligne: " + row + ", Colonne: " + col;
    }

 	/**
      * Crée une copie du jeu de Tic Tac Toe actuel.
   	 * 
   	 * @return Une nouvelle instance de TicTacToe identique à l'original.
   	 */
	@Override
	public Game copy(){
		TicTacToe res = new TicTacToe(this.joueur1, this.joueur2);
		res.jCourant = this.getCurrentPlayer();
		String[][] tab = new String[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++){
				tab[i][j] = this.coups[i][j];
			}
		}
		res.coups = tab;
		return res;
	}
	
	/**
     * Vérifie si deux objets TicTacToe sont égaux.
   	 * 
   	 * @param o L'objet à comparer.
   	 * @return true si les jeux sont égaux, sinon false.
   	 */
	@Override
	public boolean equals(Object o){
		if (!(o instanceof TicTacToe)) {
			return false;
		}
		TicTacToe t = (TicTacToe) o;
		return Arrays.deepEquals(this.coups, t.coups) && this.jCourant.equals(t.jCourant);
	}
	
	/**
     * Calcule le code de hachage pour cet objet TicTacToe.
   	 * 
   	 * @return Le code de hachage.
   	 */
	@Override
	public int hashCode(){
		return Objects.hash(this.jCourant, Arrays.deepHashCode(this.coups));
	}
}
