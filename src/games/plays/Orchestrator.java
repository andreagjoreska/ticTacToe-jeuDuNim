package games.plays;

import games.genericgames.Game;
import games.players.Player;

/**
 * Classe Orchestrator qui gère le déroulement d'une partie de jeu.
 * Cette classe orchestre l'exécution d'un jeu en alternant les tours entre les joueurs 
 * jusqu'à ce que la partie soit terminée. Elle affiche les informations de la situation actuelle 
 * et gère la prise de décision de chaque joueur en appelant leurs méthodes pour choisir un coup.
 */
public class Orchestrator{

	Game game; // Instance du jeu à orchestrer
	
	public Orchestrator(Game game) {
		this.game = game;
	}

	/**
     * Constructeur pour initialiser l'orchestrateur avec un jeu spécifique.
     * 
     * @param game Le jeu à orchestrer.
     */
	public void play(){
	
		while(!this.game.isOver()){
			System.out.println(this.game.situationToString() + "\n");
			System.out.println("C'est la tournée de " + this.game.getCurrentPlayer());	
			int coup = this.game.getCurrentPlayer().chooseMove(game);
			System.out.println(this.game.moveToString(coup) + "\n");
			this.game.execute(coup);
		}
		System.out.println(this.game.situationToString() + "\n");
		if(this.game.getWinner() != null){
			System.out.println("Le jeu est terminé. Le gagneur est " + this.game.getWinner().toString() + "!");
		} else{
			System.out.println("Le jeu est terminé. Il n'y a pas de gagneur.");
		}
		
	}

}
