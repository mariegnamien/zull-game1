/**
 * Classe Game - le moteur du jeu d'aventure Zuul.
 *
 * @author Gnamien Marie Emilienne
 */
public class Game
{
    private UserInterface aGui;
    private GameEngine aEngine;
    /**
    *
    * Démarre le jeu.
    */
    public void Game() {
    this.aEngine = new GameEngine();
    this.aGui = new UserInterface( this.aEngine );
    this.aEngine.setGUI( this.aGui );   
    }//Game()
} 