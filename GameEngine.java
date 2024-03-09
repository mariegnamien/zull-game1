
/**
 * Décrivez votre classe GameEngine ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class GameEngine
{
    private UserInterface aGui;
    private Parser aParser;
    private Room aCurrentRoom;
    
    /**
    * Constructeur du jeu où les pièces sont créées.
    */
    public GameEngine() {
        createRooms();
        this.aParser = new Parser();
    }
    
    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.printWelcome();
    }
    
        /**
    *
    * Affiche la pièce actuelle et les sorties possibles.
    * 
    */
    private void printLocationInfo(){
        this.aGui.println(aCurrentRoom.getLongDescription());
        this.aGui.showImage(aCurrentRoom.getImageName());
    }

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
    if(this.aCurrentRoom.getImageName() != null){
        this.aGui.showImage(this.aCurrentRoom.getImageName());
    }
    
    }
    
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
        Room vSecretBasement = new Room("at the secret basement","secretbasement.jpg");
        
        //Item vBroom = new Item("a dusty and old broom.", 700);
        
        //vBasement.setItem(vBroom);

        
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
        vSecretBasement.setExit("east", null);         
        
        this.aCurrentRoom = vConvenienceStore;
    }
    
        private void look(){
        this.aGui.println(aCurrentRoom.getLongDescription());
    }
    
    private void eat(){
        this.aGui.println("You have eaten now and you are not hungry any more.");
    }
    
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
        }
        
        String vCommandWord = vCommand.getCommandWord();
        
        if(vCommandWord.equals("help")){
            this.printHelp();
        }
        else if(vCommandWord.equals("go")){
            this.goRoom(vCommand);
        }
        else if(vCommandWord.equals("look")){
            this.look();
        }
        else if(vCommandWord.equals("eat")){
            this.eat();
        }
        
        else if(vCommandWord.equals("start!")){
            printLocationInfo();
        }
        else if (vCommandWord.equals("quit")){
            if ( vCommand.hasSecondWord() ){
                this.aGui.println( "Quit what?" );
            }
            else{
                this.endGame();
            }
        }
        
        else{
            this.aGui.println("Erreur du programmeur : commande non reconnue !");
        }
    }
    
        /**
    *
    * Affiche le message d'aide.
    */
    private void printHelp(){
    this.aGui.println("");
    this.aGui.println("You are in the dairy section. The temperature is cool around you.");
    this.aGui.println("You are arranging yogurts in this section..." + "\n");
    this.aGui.println("Your command words are:");
    this.aGui.println(this.aParser.getCommandString());
    }
    
    /**
    *
    * Permet de se déplacer entre les différentes pièces du jeu.
    * @param pRoom Commande entrée par l'utilisateur.
    */
   
    private void goRoom(final Command pRoom){
        Room vNextRoom = null;
        String vDirection = pRoom.getSecondWord();
        if (!pRoom.hasSecondWord()){
                this.aGui.println("Go where ?");
                return;
            }
        vNextRoom = aCurrentRoom.getExit(vDirection);
        if(vNextRoom != null){
            this.aCurrentRoom = vNextRoom;
            this.aGui.println(this.aCurrentRoom.getLongDescription());
            if(this.aCurrentRoom.getImageName() != null){
                this.aGui.showImage(this.aCurrentRoom.getImageName());
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
    
    private void endGame()
    {
        this.aGui.println( "Thank you for playing.  Good bye." );
        this.aGui.enable( false );
    }

}
