package games.factoredgames;

/**
 * Classe abstraite représentant un jeu à deux joueurs.
 * Cette classe gère les informations de base des joueurs, comme leurs noms et le joueur courant,
 * ainsi que l'alternance des tours entre les joueurs.
 */
public abstract class AbstractGame {

	String joueur1; // Nom du joueur 1
	String joueur2; // Nom du joueur 2
	String jCourant; // Nom du joueur courant
	
	/**
     * Constructeur de la classe AbstractGame.
     * Initialise les noms des joueurs et définit le joueur courant comme étant le premier joueur.
     * 
     * @param j1 le nom du joueur 1
     * @param j2 le nom du joueur 2
     */
	public AbstractGame(String j1, String j2){
		this.joueur1 = j1;
		this.joueur2 = j2;
		this.jCourant = j1;
	}
	
	/**
     * Méthode abstraite à implémenter dans les sous-classes.
     * Chaque jeu doit définir la façon d'exécuter un coup particulier.
   	 * 
     * @param coup l'indice du coup joué
     */
	protected abstract void doExecute(int coup);
	
	/**
     * Exécute un coup dans le jeu.
     * Cette méthode appelle la méthode doExecute pour appliquer le coup, puis change le joueur courant.
   	 * 
   	 * @param coup l'indice du coup à jouer
   	 */
	public void execute(int coup){
		doExecute(coup);
		if (this.jCourant == this.joueur1){
			this.jCourant = this.joueur2;
		}
		else{
			this.jCourant = this.joueur1;
		}
	}
	
    /**
   	 * Renvoie le nom du joueur courant.
   	 *
   	 * @return le nom du joueur qui doit jouer
   	 */
	public String getCurrentPlayer(){
		return this.jCourant;
	}

}
