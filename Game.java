/**
 * Classe Game - le moteur du jeu d'aventure Zuul.
 *
 * @author votre nom
 */
public class Game
{
    private Room aCurrentRoom;
    private Parser aParser;

    /**
    * Constructeur du jeu où les pièces sont créées.
    */
    public Game() {
        createRooms();
        this.aParser = new Parser();
    }
    
    /**
    *
    * Création de toutes les pièces du jeu.
    */
    private void createRooms() {
        Room vConvenienceStore = new Room("at grandpa's convenience store");
        Room vStreet1 = new Room("in the first street");
        Room vStreet2 = new Room("in the Second street");
        Room vStreet3 = new Room("in the Third street");
        Room vRoom = new Room("in her room");
        Room vBasement = new Room("in the basement");
        Room vSecretWorkShop = new Room("at the Secret workshop");
        Room vBricABrac = new Room("at the bric-a-brac");
        Room vTrainStation = new Room("at the Train Station");
        Room vPlatform = new Room("on the Platform");
        Room vSecretBasement = new Room("at the secret basement");
        
        
        vConvenienceStore.setExits(vStreet2,vRoom,vStreet1,vStreet3); // rajouter plus tard une entrée pour le sous sol (basement)
        vStreet1.setExits(vBricABrac,null,null,vConvenienceStore);
        vStreet2.setExits(null,vConvenienceStore,null,null);
        vStreet3.setExits(null,vTrainStation,vConvenienceStore,null);
        vRoom.setExits(vConvenienceStore,null,null,null);
        vBasement.setExits(null,null,null,vSecretWorkShop); // escalier vers le bas
        vSecretWorkShop.setExits(null,null,vBasement,null);
        vBricABrac.setExits(null,vStreet1,null,null);
        vTrainStation.setExits(vStreet3,vPlatform,null,null);
        vPlatform.setExits(vTrainStation,null,null,vSecretBasement);
        vSecretBasement.setExits(null,null,vPlatform,null);
        
        this.aCurrentRoom = vConvenienceStore;
    }
    
    /**
    *
    * Démarre le jeu et contrôle son arrêt.
    */
    public void play() {
        boolean vFinished = false;
        this.printWelcome();
        while(vFinished == false){
            Command vCommand = this.aParser.getCommand();
            vFinished = this.processCommand(vCommand);
        }
        System.out.println("Thank you for playing. Good bye.");
    }// play()
    

    /**
    *
    * Affiche la pièce actuelle et les sorties possibles.
    * 
    */
    private void printLocationInfo(){
        System.out.println(aCurrentRoom.getLongDescription());
    }

    /**
    *
    * Affiche le message de bienvenue dès le lancement du jeu.
    *
    */
    private void printWelcome(){
    System.out.println("                   Welcome to 3417.");
    System.out.println();
    System.out.println("Another day in this boring place..."); 
    System.out.println("Grandpa asked me to help with stuff at the store today.");
    System.out.println("Type 'help' if you need help."); 
    System.out.println();
    printLocationInfo();
    
    }
    /**
    *
    * Affiche le message d'aide.
    */
    private void printHelp(){
    System.out.println("");
    System.out.println("You are in the dairy section. The temperature is cool around you.");
    System.out.println("You are arranging yogurts in this section...");
    System.out.println("");
    System.out.println("Your command words are:");
    System.out.println(aParser.getCommandString());
    }

    /**
    *
    * Retourne un booléen en fonction de la commande entrée.
    * @param pWord Commande entrée par l'utilisateur.
    */
    private boolean quit(final Command pWord){
        if(pWord.hasSecondWord()) {
            System.out.println("Quit what ?");
            return false;
        }
        return true;
    }
    
    /** Affiche la description de la pièce courante et ses sorties.
     * 
     */
    private void look(){
        System.out.println(aCurrentRoom.getLongDescription());
    }
    
    private void eat(){
        System.out.println("You have eaten now and you are not hungry any more.");
    }
    
    /**
    *
    * Retourne un booléen après traitement de la commande entrée par l'utilisateur.
    * @param pWord Commande entrée par l'utilisateur.
    */
    private boolean processCommand(final Command pWord){
        String vWord = pWord.getCommandWord();
        if(pWord.isUnknown()) {
            System.out.println("I don't know what you mean ?");
            return false;
        }
        else if(vWord.equals("help")){
            printHelp();
            return false;
        }
        else if(vWord.equals("go")){
            goRoom(pWord);
            return false;
        }
        else if(vWord.equals("look")){
            look();
            return false;
        }
        else if(vWord.equals("eat")){
            eat();
            return false;
        }
        else if (vWord.equals("quit")){
            return quit(pWord);
        }
        
        else{
            System.out.println("Erreur du programmeur : commande non reconnue !");
            return false;
        }
        
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
                System.out.println("Go where ?");
                return;
            }
        vNextRoom = aCurrentRoom.getExit(vDirection);
        if(vNextRoom != null){
            aCurrentRoom = vNextRoom;
        }
        else if(vNextRoom == null){
            System.out.println("There is no door !");
            return;
        }
        else{
            System.out.println("Unknown direction !");
        }
        printLocationInfo();
    } // Game
}