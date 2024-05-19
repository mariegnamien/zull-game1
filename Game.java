/**
 * Classe Game - le moteur du jeu d'aventure Zuul.
 * @author Gnamien Marie Emilienne
 * @version 15/03/2024
 */
public class Game{
    private UserInterface aGui;
    private GameEngine aEngine;
    
    /**
     * Constructeur vide
     */
    public Game(){
        
    }
    
    /**
     * Procédure qui démarre le jeu.
     */
    public void Game() {
    this.aEngine = new GameEngine();
    this.aGui = new UserInterface( this.aEngine );
    this.aEngine.setGUI( this.aGui );   
    }//Game()
} 