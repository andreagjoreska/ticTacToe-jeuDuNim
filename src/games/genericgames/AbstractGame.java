package games.genericgames;

import games.players.Player;

/**
 * Classe abstraite représentant un jeu générique à deux joueurs.
 * Cette classe implémente l'interface `Game` et fournit une structure de base pour les jeux où deux joueurs
 * s'affrontent. 
 */
public abstract class AbstractGame implements Game{

	Player joueur1; // Le premier joueur du jeu
	Player joueur2; // Le deuxième joueur du jeu
	Player jCourant; // Le joueur en train de jouer
	
	/**
     * Constructeur de la classe AbstractGame. Initialise les joueurs et définit le joueur courant.
     * 
   	 * @param j1 Le premier joueur.
   	 * @param j2 Le deuxième joueur.
   	 */
	public AbstractGame(Player j1, Player j2){
		this.joueur1 = j1;
		this.joueur2 = j2;
		this.jCourant = j1;
	}
	
	/**
     * Méthode abstraite que chaque jeu concret doit implémenter pour exécuter un coup spécifique.
   	 * 
   	 * @param coup Le coup à exécuter.
   	 */
	protected abstract void doExecute(int coup);
	
	/**
     * Méthode qui exécute un coup pour le joueur courant. Après l'exécution, elle change de joueur.
     * 
   	 * @param coup Le coup joué par le joueur courant.
   	 */
	@Override
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
     * Renvoie le joueur qui est en train de jouer.
   	 * 
   	 * @return Le joueur courant.
   	 */
	@Override
	public Player getCurrentPlayer(){
		return this.jCourant;
	}

}
