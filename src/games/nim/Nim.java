package games.nim;

/**
 * La classe Nim représente une partie du jeu de Nim, où deux joueurs retirent des allumettes d'un tas.
 * Elle gère l'état du jeu, y compris le nombre d'allumettes restantes, les joueurs et les règles du jeu.
 */
public class Nim {
	
    int tailleTas;      // Taille initiale du tas d'allumettes
    int maxAll;         // Nombre maximal d'allumettes qu'un joueur peut retirer à chaque tour
    String nomJ1;       // Nom du joueur 1
    String nomJ2;       // Nom du joueur 2
    int allCourant;     // Nombre d'allumettes restantes
    String jCourant;    // Nom du joueur courant
	
    /**
     * Initialise une partie de Nim avec un tas d'allumettes et deux joueurs.
     *
     * @param tailleTas le nombre d'allumettes initiales
     * @param maxAll le nombre maximum d'allumettes qu'un joueur peut retirer
     * @param j1 le nom du joueur 1
     * @param j2 le nom du joueur 2
     */
    public Nim(int tailleTas, int maxAll, String j1, String j2) {
        this.tailleTas = tailleTas;
        this.maxAll = maxAll;
        this.nomJ1 = j1;
        this.nomJ2 = j2;
        this.allCourant = tailleTas;
        this.jCourant = j1;
    }
    
    /**
     * Renvoie le nombre initial d'allumettes.
     *
     * @return le nombre d'allumettes au début de la partie
     */
    public int getInitialNbMatches() {
        return this.tailleTas;
    }
    
    /**
     * Renvoie le nombre d'allumettes restantes.
     *
     * @return le nombre d'allumettes encore disponibles
     */
    public int getCurrentNbMatches() {
        return this.allCourant;
    }
    
    /**
     * Renvoie le nom du joueur courant.
     *
     * @return le nom du joueur qui doit jouer
     */
    public String getCurrentPlayer() {
        return this.jCourant;
    }

    /**
     * Renvoie une chaîne décrivant la situation actuelle du jeu.
     *
     * @return une description de l'état du tas d'allumettes
     */
    public String situationToString() {
        return "Il reste " + this.allCourant + " allumettes";
    }

    /**
     * Retire un certain nombre d'allumettes du tas.
     *
     * @param nbAll le nombre d'allumettes à retirer
     */
    public void removeMatches(int nbAll) {
        this.allCourant -= nbAll;
        if (this.jCourant == this.nomJ1) {
            this.jCourant = this.nomJ2;
        } else {
            this.jCourant = this.nomJ1;
        }
    }

    /**
     * Vérifie si le nombre d'allumettes à retirer est valide.
     *
     * @param nbAll le nombre d'allumettes à vérifier
     * @return vrai si le nombre d'allumettes est valide, faux sinon
     */
    public boolean isValid(int nbAll) {
        if ((nbAll <= 0) || (nbAll > this.maxAll) || (nbAll > this.allCourant)) {
            return false;
        }
        return true;
    }

    /**
     * Vérifie si la partie est terminée.
     *
     * @return vrai si toutes les allumettes ont été retirées, faux sinon
     */
    public boolean isOver() {
        return this.allCourant == 0;
    }

    /**
     * Renvoie le nom du gagnant, si la partie est terminée.
     *
     * @return le nom du joueur gagnant, ou null s'il n'y a pas encore de gagnant
     */
    public String getWinner() {
        if (isOver()) {
            return this.jCourant;
        }
        return null;
    }
}

