# Jeux en Java - Java OOP Games (Jeu du Nim & Tic Tac Toe)

## 🇬🇧 English

### Overview
A Java object-oriented programming project implementing two classic two-player games - **Nim** (matchstick game) and **Tic Tac Toe** - developed as a university project at the University of Caen Normandy.

### Project Structure
```
src/
├── games/
│   ├── tictactoe/          # Phase 1 - Standalone Tic Tac Toe
│   │   ├── TicTacToe.java
│   │   ├── TicTacToeWithHints.java
│   │   ├── Executable.java
│   │   ├── ExecutableWithHints.java
│   │   ├── Test.java
│   │   └── TestWithHints.java
│   │
│   ├── nim/                # Phase 2 - Standalone Nim
│   │   ├── Nim.java
│   │   ├── Executable.java
│   │   └── Test.java
│   │
│   ├── factoredgames/      # Phase 3 - Refactored with AbstractGame
│   │   ├── AbstractGame.java
│   │   ├── Nim.java
│   │   ├── TicTacToe.java
│   │   ├── ExecutableNim.java
│   │   ├── ExecutableTicTacToe.java
│   │   ├── AbstractGameTest.java
│   │   └── JeuxTest.java
│   │
│   ├── genericgames/       # Phase 4 - Generic Game interface + AI players
│   │   ├── Game.java           (interface)
│   │   ├── AbstractGame.java
│   │   ├── Nim.java
│   │   ├── TicTacToe.java
│   │   └── Test.java
│   │
│   ├── players/            # Player types
│   │   ├── Player.java         (interface)
│   │   ├── Human.java
│   │   ├── RandomPlayer.java
│   │   ├── NegamaxPlayer.java
│   │   ├── NegamaxPlayerWithCache.java
│   │   ├── Test.java
│   │   ├── TestNegamax.java
│   │   └── TestNegamaxPlayerWithCache.java
│   │
│   └── plays/              # Orchestrator + unified launcher
│       ├── Orchestrator.java
│       ├── Executable.java
│       └── Test.java
```

### Technologies Used
- **Java** - Core language
- **OOP** - Interfaces, abstract classes, inheritance, polymorphism
- **Negamax algorithm** - Recursive minimax variant for optimal AI play
- **HashMap caching** - Memoization to optimise Negamax performance
- **JUnit-style unit tests** - Custom test classes for each module

### Architecture & Key Concepts

The project is built in four progressive phases:

**Phase 1 - Standalone games:** `TicTacToe` and `TicTacToeWithHints` implemented directly with string-based players. `TicTacToeWithHints` extends `TicTacToe` and adds a `hints()` method that detects opponent threats on the board.

**Phase 2 - Nim:** Standalone implementation of the Nim matchstick game with configurable pile size and max removal per turn.

**Phase 3 - Factored games (`factoredgames`):** Both games refactored to extend a shared `AbstractGame` class, extracting common player-switching logic into `execute()` / `doExecute()`.

**Phase 4 - Generic games + AI (`genericgames`, `players`, `plays`):** A `Game` interface defines a contract for any two-player game. Player types implement a `Player` interface: `Human` (console input), `RandomPlayer` (random valid move), `NegamaxPlayer` (optimal AI via recursive Negamax), and `NegamaxPlayerWithCache` (Negamax with HashMap memoization). An `Orchestrator` drives any game with any combination of players.

### Player Modes (Executable in `games/plays`)
7 configurable modes:
1. Human vs Human
2. Human vs Random
3. Human vs Negamax
4. Human vs NegamaxWithCache
5. Random vs Random
6. Random vs NegamaxWithCache
7. Negamax vs NegamaxWithCache

### How to Run
1. Compile all source files from the `src/` directory
2. Run `games.plays.Executable` for the full interactive launcher (choose game + player mode)
3. Or run individual `Executable` classes within each package for isolated demos

### Author
Andrea Gjoreska - L2 student, University of Caen Normandy 

---

## 🇫🇷 Français

### Présentation
Un projet de programmation orientée objet en Java implémentant deux jeux classiques à deux joueurs - **le jeu de Nim** et **le Morpion (Tic Tac Toe)** - réalisé dans le cadre d'un projet universitaire à l'Université de Caen Normandie. 

### Structure du projet
```
src/
├── games/
│   ├── tictactoe/          # Phase 1 - Morpion autonome
│   ├── nim/                # Phase 2 - Nim autonome
│   ├── factoredgames/      # Phase 3 - Refactoring avec AbstractGame
│   ├── genericgames/       # Phase 4 - Interface Game générique + IA
│   ├── players/            # Types de joueurs
│   └── plays/              # Orchestrateur + lanceur unifié
```

### Technologies utilisées
- **Java** - Langage principal
- **POO** - Interfaces, classes abstraites, héritage, polymorphisme
- **Algorithme Negamax** - Variante récursive du minimax pour une IA optimale
- **Cache HashMap** - Mémoïsation pour optimiser les performances du Negamax
- **Tests unitaires** - Classes de test personnalisées pour chaque module

### Architecture & Concepts clés

Le projet est construit en quatre phases progressives :

**Phase 1 - Jeux autonomes :** `TicTacToe` et `TicTacToeWithHints` implémentés directement avec des joueurs sous forme de chaînes. `TicTacToeWithHints` étend `TicTacToe` et ajoute une méthode `hints()` qui détecte les menaces adverses sur le plateau.

**Phase 2 - Nim :** Implémentation autonome du jeu de Nim avec taille du tas et nombre maximal de retraits configurables.

**Phase 3 - Jeux factorisés (`factoredgames`) :** Les deux jeux sont refactorisés pour étendre une classe `AbstractGame` commune, qui extrait la logique de changement de joueur dans `execute()` / `doExecute()`.

**Phase 4 - Jeux génériques + IA (`genericgames`, `players`, `plays`) :** Une interface `Game` définit un contrat pour tout jeu à deux joueurs. Les types de joueurs implémentent une interface `Player` : `Human` (saisie console), `RandomPlayer` (coup aléatoire valide), `NegamaxPlayer` (IA optimale via Negamax récursif), et `NegamaxPlayerWithCache` (Negamax avec mémoïsation HashMap). Un `Orchestrator` pilote n'importe quel jeu avec n'importe quelle combinaison de joueurs.

### Modes de jeu (Executable dans `games/plays`)
7 modes configurables :
1. Humain contre Humain
2. Humain contre Joueur aléatoire
3. Humain contre Negamax
4. Humain contre NegamaxWithCache
5. Joueur aléatoire contre Joueur aléatoire
6. Joueur aléatoire contre NegamaxWithCache
7. Negamax contre NegamaxWithCache

### Exécution
1. Compiler tous les fichiers sources depuis le répertoire `src/`
2. Lancer `games.plays.Executable` pour le lanceur interactif complet (choix du jeu + mode de jeu)
3. Ou lancer les classes `Executable` individuelles dans chaque package pour des démonstrations isolées

### Auteure
Andrea Gjoreska - Étudiante de L2, Université de Caen Normandie 
