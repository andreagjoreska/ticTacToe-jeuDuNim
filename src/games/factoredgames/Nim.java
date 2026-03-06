package games.factoredgames;

/**
 * Classe représentant le jeu de Nim, un jeu de stratégie joué avec un tas d'allumettes.
 * Les joueurs alternent pour retirer un nombre d'allumettes du tas. Le joueur qui retire la dernière allumette gagne la partie.
 * À chaque tour, un joueur peut retirer jusqu'à un certain nombre d'allumettes du tas.
 * Le jeu se termine lorsque le tas est vide.
 */
public class Nim extends AbstractGame{
	
	int tailleTas; // Taille initiale du tas d'allumettes
	int maxAll; // Le nombre maximum d'allumettes qu'un joueur peut retirer 
	int allCourant; // Nombre d'allumettes restantes dans le tas
	
	/**
     * Constructeur de la classe Nim.
     * Initialise le jeu avec la taille du tas, le nombre maximum d'allumettes par coup,
   	 * ainsi que les noms des joueurs.
   	 * 
   	 * @param tailleTas Le nombre d'allumettes initial dans le tas
   	 * @param maxAll Le nombre maximum d'allumettes qu'un joueur peut retirer à chaque tour
  	 * @param j1 Le nom du joueur 1
   	 * @param j2 Le nom du joueur 2
   	 */
	public Nim (int tailleTas, int maxAll, String j1, String j2){
		super(j1,j2);
		this.tailleTas = tailleTas;
		this.maxAll = maxAll;
		this.allCourant = tailleTas;
	}
	
	/**
     * Renvoie le nombre d'allumettes initiales dans le tas.
     *
   	 * @return Le nombre d'allumettes au départ
   	 */
	public int getInitialNbMatches() {
		return this.tailleTas;
	}
	
	/**
     * Renvoie le nombre d'allumettes restantes dans le tas.
   	 *
   	 * @return Le nombre d'allumettes restantes
   	 */
	public int getCurrentNbMatches(){
		return this.allCourant;
	}
	
	/**
     * Renvoie une chaîne représentant la situation actuelle du jeu.
   	 *
   	 * @return La situation sous forme de chaîne 
   	 */
	public String situationToString() {
		return "Il reste " + this.allCourant + " allumettes";
	}
	
	/**
     * Applique un coup en retirant un nombre spécifié d'allumettes du tas.
     *
   	 * @param nbAll Le nombre d'allumettes à retirer
   	 */
	@Override
	public void doExecute(int nbAll) {
		this.allCourant -= nbAll;
	}
	
	/**
   	 * Vérifie si un coup est valide.
   	 *
   	 * @param nbAll Le nombre d'allumettes à retirer
   	 * @return true si le coup est valide, false sinon
   	 */
	public boolean isValid(int nbAll){
		if ((nbAll <= 0) || (nbAll > this.maxAll) || (nbAll > this.allCourant)) {
			return false;
		}
		return true;
	}
	
	/**
   	 * Vérifie si le jeu est terminé.
   	 *
   	 * @return true si le jeu est terminé, false sinon
   	 */
	public boolean isOver() {
		if (this.allCourant == 0) {
			return true;
		}
		return false;
	}
	
	/**
   	 * Renvoie le gagnant du jeu.
   	 *
   	 * @return Le nom du gagnant (le joueur courant) si le jeu est terminé, sinon null
   	 */
	public String getWinner() {
		if (isOver()) {
			return this.jCourant;
		}
		return null;
	}
	
}
