import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

/**
 * Moteur du jeu d'aventure
 *
 * @author Marie Emilienne Gnamien
 * @version 15/03/2024
 */
public class GameEngine
{
    private UserInterface aGui;
    private Parser aParser;
    private Player aPlayer;
    
    /**
    * Constructeur du jeu où les pièces sont créées.
    */
    public GameEngine() {
        String vPrenom = javax.swing.JOptionPane.showInputDialog( "what is your name ?" );
        this.aPlayer = new Player(vPrenom);
        this.createRooms();
        this.aParser = new Parser();
        //this.aRoomStack = new Stack<Room>();
    }//GameEngine()
    
    /**
     * Création de l'interface et appel du message de bienvenue.
     * @param pUserInterface UserInterface
     */   
    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.printWelcome();
    }//setGUI()
    
    /**
    *
    * Affiche la pièce actuelle et les sorties possibles.
    * 
    */
    private void printLocationInfo(){
        this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
        this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
    }//printLocationInfo()

    /**
    *
    * Affiche le message de bienvenue dès le lancement du jeu.
    *
    */
    private void printWelcome(){
    this.aGui.print("\n");
    this.aGui.println("Welcome to 3417.");
    this.aGui.print("\n");
    this.aGui.println("Another day in this boring place..."); 
    this.aGui.println("Grandpa asked me to help with stuff at the store today.");
    this.aGui.println("\n");
    this.aGui.println("Type 'help' if you need help."); 
    this.aGui.print("\n");
    if(this.aPlayer.getCurrentRoom().getImageName() != null){
        this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
    }
    }//printWelcome()
    
    /**
    *
    * Création de toutes les pièces du jeu.
    */
   
    private void createRooms() {
        Room vConvenienceStore = new Room("at grandpa's convenience store","conveniencestore.jpg");
        Room vStreet1 = new Room("in the first street","street1.jpg");
        Room vStreet2 = new Room("in the Second street","street2.jpg");
        Room vStreet3 = new Room("in the Third street","street3.jpg");
        Room vRoom = new Room("in her room","bedroom.jpg");
        Room vBasement = new Room("in the basement","basement.jpg");
        Room vSecretWorkShop = new Room("at the Secret workshop","secretworkshop.jpg");
        Room vBricABrac = new Room("at the bric-a-brac","bricabrac.jpg");
        Room vTrainStation = new Room("at the Train Station","trainstation.jpg");
        Room vPlatform = new Room("on the Platform","platform.jpg");
        Room vSecretBasement = new Room("at the secret basement entrance","secretbasement.jpg");
        Room vArena = new Room("in the arena","arena.jpg");
        
        Item vKeyCard = new Item("keyCard","keyCard - a transparent keycard made out of glass.", 5);
        Item vBroom = new Item("broom","broom - an old and dusty broom.", 700);
        Item vMilk = new Item("milk"," milk - \"fresh milk from your favorite laboratory !\" ",800);
        Item vGums = new Item("gums", "gums - a box of gums \"for bad breath\" ", 100);
        Item vArticulatedArmV1 = new Item("armV1"," armV1 - Articulated Arm V1 \" based on a low technology quality \" ", 1250);
        Item vPills = new Item("pills", " pills - purple pills : \" do not consume these without a doctor's advice. \" ", 5);
       
        vSecretBasement.addItem("pills",vPills);
        vBricABrac.addItem("armV1", vArticulatedArmV1);
        
        vConvenienceStore.addItem("gums",vGums);
        vRoom.addItem("keyCard",vKeyCard);
        vBasement.addItem("broom",vBroom);
        vBasement.addItem("pack of milk", vMilk);
        
        vConvenienceStore.setExit("north",vStreet2);
        vConvenienceStore.setExit("down", vBasement);
        vConvenienceStore.setExit("south",vRoom);
        vConvenienceStore.setExit("west",vStreet1);
        vConvenienceStore.setExit("east",vStreet3);
        
        vStreet1.setExit("north", vBricABrac);
        vStreet1.setExit("south", null);
        vStreet1.setExit("west", null);
        vStreet1.setExit("east", vConvenienceStore);
        
        vStreet2.setExit("north", null);
        vStreet2.setExit("south", vConvenienceStore);
        vStreet2.setExit("west", null);
        vStreet2.setExit("east", null);
        
        vStreet3.setExit("north", null);
        vStreet3.setExit("south", vTrainStation);
        vStreet3.setExit("west", vConvenienceStore);
        vStreet3.setExit("east", null);
        

        vRoom.setExit("north", vConvenienceStore);
        vRoom.setExit("south", null);
        vRoom.setExit("west", null);
        vRoom.setExit("east", null);
        
        vBasement.setExit("north", null);
        vBasement.setExit("south", null);
        vBasement.setExit("west", null);
        vBasement.setExit("up",vConvenienceStore);
        vBasement.setExit("east", vSecretWorkShop);
        
        
        vSecretWorkShop.setExit("north", null);
        vSecretWorkShop.setExit("south", null);
        vSecretWorkShop.setExit("west", vBasement);
        vSecretWorkShop.setExit("east", null);
        
        vBricABrac.setExit("north", null);
        vBricABrac.setExit("south", vStreet1);
        vBricABrac.setExit("west", null);
        vBricABrac.setExit("east", null);
        
        vTrainStation.setExit("north", vStreet3);
        vTrainStation.setExit("south", vPlatform);
        vTrainStation.setExit("west", null);
        vTrainStation.setExit("east", null);      

        vPlatform.setExit("north", vTrainStation);
        vPlatform.setExit("south", null);
        vPlatform.setExit("west", null);
        vPlatform.setExit("east", vSecretBasement); 

        vSecretBasement.setExit("north", null);
        vSecretBasement.setExit("south", null);
        vSecretBasement.setExit("west", vPlatform);
        vSecretBasement.setExit("east", vArena); 
        
        vArena.setExit("north",null);
        vArena.setExit("south",null);
        vArena.setExit("west",vSecretBasement);
        vArena.setExit("east",null);
        
        this.aPlayer.changeRoom(vConvenienceStore);
    }//createRooms()
    
        /**
        *
        * Affiche la description du lieu actuel.
        */
    private void look(){
        this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
    }//look()
    
        /**
        *   Affiche un message dans la fenêtre lorsque l'utilisateur entre la commande eat 
        * 
        */
    private void eat(){
        this.aGui.println("You have eaten now and you are not hungry any more.");
    }//eat()
    
        /**
        * Permet de revenir dans la salle précédente une fois la commande entrée par l'utilisateur.
        */
    private void back(){
        if(this.aPlayer.back()){
            this.printLocationInfo();
        }
        else{
            this.aGui.println("You can't go back...");
        return;
        }
    }//back()
    
    /**
     * Permet de lire le fichier texte mis en paramètre
     * @param pTextFichier fichier texte
     */
    private void lecture(final String pTextFichier){
        Scanner vSc;
        try{
        vSc = new Scanner(new File(pTextFichier));
        while(vSc.hasNextLine()){
            String vLigne = vSc.nextLine();
            this.interpretCommand(vLigne);
        }
        
        vSc.close();
        }
        catch(final FileNotFoundException pFNFE){
            
        }
        
    }//lecture()
    
        /**
        *
        * Retourne un booléen après traitement de la commande entrée par l'utilisateur.
        * @param pWord Commande entrée par l'utilisateur.
        */
       
        public void interpretCommand(final String pWord){
        this.aGui.println( "> " + pWord );
        Command vCommand = this.aParser.getCommand(pWord); 
        
        if(vCommand.isUnknown()) {
            this.aGui.println("I don't know what you mean ?");
            return;
        }
        
        String vCommandWord = vCommand.getCommandWord();
    
        if(vCommandWord.equals("help")){
            this.printHelp();
        }

        else if(vCommandWord.equals("go")){
            this.aPlayer.addStackRoom();
            this.goRoom(vCommand);
        }
        else if(vCommandWord.equals("look")){
            this.look();
        }
        else if(vCommandWord.equals("eat")){
            if(vCommand.hasSecondWord()){
                this.aGui.println("You can't do that");
            }
            else{
            this.eat();
        }
        }
        
        else if(vCommandWord.equals("back")){
            if(vCommand.hasSecondWord()){
                this.aGui.println("You can't do that...");
            }
            else{
                this.back();
            }
        }
        else if(vCommandWord.equals("take")){
            if(vCommand.hasSecondWord()){
                if(this.aPlayer.getCurrentRoom().containsItem(vCommand.getSecondWord())){
                this.aPlayer.take(vCommand.getSecondWord());
            } 
            
            else{
                this.aGui.println("This item is unavailable..");
            }
            
            }
            else{
                this.aGui.println("You can't do that...");
            }
        }
        
        else if(vCommandWord.equals("drop")){
            if(vCommand.hasSecondWord()){
                if(this.aPlayer.hasItem(vCommand.getSecondWord())){
                this.aPlayer.drop(vCommand.getSecondWord());
                }
                else{
                this.aGui.println("This item is unavailable..");
                }
            }
            else{
                this.aGui.println("You can't do that...");
            }
        }

        else if (vCommandWord.equals("quit")){
            if (vCommand.hasSecondWord()){
                this.aGui.println( "Quit what?" );
            }
            else{
                this.endGame();
            }
        }
        else if(vCommandWord.equals("test")){
            if(vCommand.hasSecondWord() && vCommand.getSecondWord().equals("essai")){
                this.lecture("essai.txt");
            }
            else if(vCommand.hasSecondWord() && vCommand.getSecondWord().equals("victoire")){
                this.lecture("victoire.txt");
            }
            else if(vCommand.hasSecondWord() && vCommand.getSecondWord().equals("court")){
                this.lecture("court.txt");
            }
            else if(vCommand.hasSecondWord() && vCommand.getSecondWord().equals("all")){
                this.lecture("all.txt");
            }
        }
        else{
            this.aGui.println("Erreur du programmeur : commande non reconnue !");
        }
    
    }//interpretCommand()
    
        /**
    *
    * Affiche le message d'aide.
    */
    private void printHelp(){
    this.aGui.println("");
    this.aGui.println("You are wandering around Nydia...");
    this.aGui.println("If you lost your way, your command words are : ");
    this.aGui.println("");
    this.aGui.println(this.aParser.getCommandString());
    }//printHelp()
    
    /**
    *
    * Permet de se déplacer entre les différentes pièces du jeu.
    * @param pRoom pièce dans laquelle l'utilisateur veut se rendre
    */
   
    private void goRoom(final Command pRoom){
        Room vNextRoom = null;
        String vDirection = pRoom.getSecondWord();
        
        if(!pRoom.hasSecondWord()){
                this.aGui.println("Go where ?");
                return;
            }
        vNextRoom = this.aPlayer.getCurrentRoom().getExit(vDirection);
        
        if(vNextRoom != null){
            this.aPlayer.changeRoom(vNextRoom);
            this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
            if(this.aPlayer.getCurrentRoom().getImageName() != null){
                this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
            }
        }
        else if(vNextRoom == null){
            this.aGui.println("There is no path!");
            return;
        }
        else{
            this.aGui.println("Unknown direction !");
        }
    } // Game
    
    /** Procédure d'arrêt du jeu.
    */
    private void endGame()
    {
        this.aGui.println( "Thank you for playing.  Good bye." );
        this.aGui.enable( false );
    }

}
