package games.genericgames;

import games.players.Player;
import java.util.*;

/**
 * Classe représentant le jeu Nim, un jeu de stratégie à deux joueurs.
 * Dans ce jeu, les joueurs se relaient pour retirer un certain nombre d'allumettes d'un tas.
 * Le joueur qui retire la dernière allumette perd la partie. 
 */
public class Nim extends AbstractGame implements Game{
	
	int tailleTas;  // Nombre initial d'allumettes dans le tas
    int maxAll;     // Nombre maximal d'allumettes qu'un joueur peut retirer par tour
   	int allCourant; // Nombre actuel d'allumettes dans le tas
	
	/**
   	 * Constructeur de la classe Nim.
     * 
   	 * @param tailleTas Nombre initial d'allumettes dans le tas.
   	 * @param maxAll Nombre maximal d'allumettes qu'un joueur peut retirer par tour.
     * @param j1 Le joueur 1.
   	 * @param j2 Le joueur 2.
   	 */
	public Nim (int tailleTas, int maxAll, Player j1, Player j2){
		super(j1,j2);
		this.tailleTas = tailleTas;
		this.maxAll = maxAll;
		this.allCourant = tailleTas;
	}
	
	/**
     * Retourne le joueur courant.
   	 * 
   	 * @return Le joueur courant.
   	 */
	@Override
	public Player getCurrentPlayer(){
		return this.jCourant;
	}
	
	/**
     * Retourne le nombre initial d'allumettes dans le tas.
   	 * 
   	 * @return Le nombre initial d'allumettes.
   	 */
	public int getInitialNbMatches() {
		return this.tailleTas;
	}
	
	/**
     * Retourne le nombre actuel d'allumettes restantes dans le tas.
   	 * 
   	 * @return Le nombre actuel d'allumettes.
   	 */
	public int getCurrentNbMatches(){
		return this.allCourant;
	}
	
	/**
     * Retourne une chaîne représentant l'état actuel du jeu.
   	 * 
   	 * @return L'état actuel du jeu sous forme de chaîne.
   	 */
	@Override
	public String situationToString() {
		return "Il reste " + this.allCourant + " allumettes";
	}
	
	/**
     * Exécute un coup en retirant un nombre d'allumettes spécifié du tas.
   	 * 
   	 * @param nbAll Le nombre d'allumettes à retirer du tas.
   	 */
	@Override
	public void doExecute(int nbAll) {
		this.allCourant -= nbAll;
	}
	
	/**
     * Méthode surchargée qui appelle la méthode de la classe parente pour exécuter le coup et changer de joueur.
   	 * 
   	 * @param nbAll Le nombre d'allumettes à retirer.
  	 */
	@Override 
	public void execute(int nbAll) {
		super.execute(nbAll);
	}
	
	/**
     * Vérifie si un coup est valide.
   	 * 
   	 * @param nbAll Le nombre d'allumettes à retirer.
   	 * @return true si le coup est valide, false sinon.
   	 */
	@Override
	public boolean isValid(int nbAll){
		if ((nbAll <= 0) || (nbAll > this.maxAll) || (nbAll > this.allCourant)) {
			return false;
		}
		return true;
	}
	
	/**
     * Vérifie si le jeu est terminé.
     * 
     * @return true si le jeu est terminé, false sinon.
     */
	@Override
	public boolean isOver() {
		if (this.allCourant == 0) {
			return true;
		}
		return false;
	}
	
	/**
     * Retourne le joueur gagnant si le jeu est terminé.
   	 * 
   	 * @return Le joueur gagnant si le jeu est terminé, null sinon.
   	 */
	@Override
	public Player getWinner() {
		if (isOver()) {
			return this.jCourant;
		}
		return null;
	}
	
	/**
     * Retourne une liste des coups valides que le joueur courant peut effectuer.
   	 * 
   	 * @return Liste des coups valides.
   	 */
	public List<Integer> validMoves(){
		List<Integer> liste = new ArrayList<Integer>();
		for (int i=1;i<=this.maxAll;i++){
			if (isValid(i)) {
				liste.add(i);
			}
		}
		return liste;
	}
	
	/**
     * Convertit un coup en une chaîne représentant ce coup.
   	 * 
   	 * @param coup Le nombre d'allumettes à retirer.
   	 * @return Une chaîne représentant le coup.
   	 */
	@Override
    public String moveToString(int coup) {
        return "Le joueur a retiré " + coup + " allumette(s)";
    }
	
	/**
   	 * Crée et retourne une copie du jeu Nim actuel.
   	 * 
   	 * @return Une nouvelle instance du jeu Nim avec les mêmes paramètres.
   	 */
	@Override
	public Game copy(){
		Nim res = new Nim(this.tailleTas, this.maxAll, this.joueur1, this.joueur2);
		res.allCourant = this.getCurrentNbMatches();
		res.jCourant = super.getCurrentPlayer();
		return res;
	}
	
	/**
   	 * Vérifie si deux objets Nim sont égaux.
   	 * 
   	 * @param o L'objet à comparer.
   	 * @return true si les deux objets sont égaux, false sinon.
  	 */
	@Override
	public boolean equals(Object o){
		if (this == o) return true;
		if (!(o instanceof Nim)) {
			return false;
		}
		return this.allCourant == ((Nim) o).allCourant && this.tailleTas == ((Nim) o).tailleTas && this.jCourant.equals(((Nim) o).jCourant) && this.maxAll == ((Nim) o).maxAll;
	}
	
	/**
     * Retourne un code de hachage pour l'objet Nim.
  	 * 
  	 * @return Un code de hachage pour l'objet Nim.
   	 */
	@Override
	public int hashCode(){
		return Objects.hash(this.jCourant, this.allCourant);
	}
	
}
