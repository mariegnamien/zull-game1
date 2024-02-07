 

/**
 * Classe Game - le moteur du jeu d'aventure Zuul.
 *
 * @author votre nom
 */
public class Game
{
    private Room aCurrentRoom;
    private Parser aParser;
    
    private void printWelcome(){
    System.out.println("Welcome to the World of Zuul!"); 
    System.out.println("World of Zuul is a new, incredibly boring adventure game.");
    System.out.println("Type 'help' if you need help."); 
    System.out.println("");
    System.out.println("You are "+ this.aCurrentRoom.getDescription());
    System.out.print("Exits : ");
        if(this.aCurrentRoom.aNorthExit != null){
            System.out.print("north ");
        }
        if(this.aCurrentRoom.aSouthExit != null){
            System.out.print("south ");
        }
        if(this.aCurrentRoom.aWestExit != null){
            System.out.print("west ");
        }
        if(this.aCurrentRoom.aEastExit != null){
            System.out.print("east ");
        }
    
    
    
    }

    private void printHelp(){
    System.out.println("");
    System.out.println("You are lost. You are alone.");
    System.out.println("You wander around at the university");
    System.out.println("");
    System.out.println("Your command words are:");
    System.out.println("  go quit help");
    }
    
    private boolean quit(final Command pWord){
        if(pWord.hasSecondWord()) {
            System.out.println("Quit what ?");
            return false;
        }
        return true;
    }
    
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
        
        else if (vWord.equals("quit")){
            return quit(pWord);
        }
        
        else{
            System.out.println("Erreur du programmeur : commande non reconnue !");
            return false;
        }
        
    }
    
    public Game() {
        createRooms();
        this.aParser = new Parser();
    }
    
    public void play() {
        boolean vFinished = false;
        this.printWelcome();
        while(vFinished == false){
            Command vCommand = this.aParser.getCommand();
            vFinished = this.processCommand(vCommand);
        }
        System.out.println("Thank you for playing. Good bye.");
    }// play()
    
    private void createRooms() {
        Room vGroceryStore = new Room("in grandpa's grocery store");
        Room vStreet1 = new Room("in the first street");
        Room vStreet2 = new Room("in the Second street");
        Room vStreet3 = new Room("in the Third street");
        Room vRoom = new Room("in her room");
        Room vBasement = new Room("in the basement");
        Room vSecretWorkShop = new Room("in the Secret workshop");
        Room vBricABrac = new Room("at the bric-a-brac");
        Room vTrainStation = new Room("at the Train Station");
        Room vPlatform = new Room("on the Platform");
        Room vSecretBasement = new Room("in the secret basement");
        
        
        vGroceryStore.setExits(vStreet2,vRoom,vStreet1,vStreet3); // rajouter plus tard une seconde entrée pour le sous sol
        vStreet1.setExits(null,null,vGroceryStore,vBricABrac);
        vStreet2.setExits(null,vGroceryStore,null,null);
        vStreet3.setExits(null,vTrainStation,vGroceryStore,null);
        vRoom.setExits(vGroceryStore,null,null,null);
        vBasement.setExits(null,null,null,vSecretWorkShop); // escalier vers le bas
        vSecretWorkShop.setExits(null,null,vBasement,null);
        vBricABrac.setExits(null,null,vStreet1,null);
        vTrainStation.setExits(vStreet3,vPlatform,null,null);
        vPlatform.setExits(vTrainStation,null,null,vSecretBasement);
        vSecretBasement.setExits(null,null,vPlatform,null);
        
        this.aCurrentRoom = vGroceryStore;
    }
    
    private void goRoom(final Command pRoom){
        Room vNextRoom = null;
        String vDirection = pRoom.getSecondWord();
        String vDirections = "";
        if (!pRoom.hasSecondWord()){
                System.out.println("Go where ?");
                return;
            }
            
        if(vDirection.equals("north")){
            vNextRoom = this.aCurrentRoom.aNorthExit;
            if(vNextRoom == null){
                System.out.println("There is no door !");
                return;
            }
            this.aCurrentRoom = vNextRoom;
            System.out.println(this.aCurrentRoom.getDescription());
        }
        else if(vDirection.equals("south")){
            vNextRoom = this.aCurrentRoom.aSouthExit;
            if(vNextRoom == null){
                System.out.println("There is no door !");
                return;
            }
            this.aCurrentRoom = vNextRoom;
            System.out.println(this.aCurrentRoom.getDescription());
        }
        else if(vDirection.equals("west")){
            vNextRoom = this.aCurrentRoom.aWestExit;
            if(vNextRoom == null){
                System.out.println("There is no door !");
                return;
            }
            this.aCurrentRoom = vNextRoom;
            System.out.println(this.aCurrentRoom.getDescription());
        }
        else if(vDirection.equals("east")){
            vNextRoom = this.aCurrentRoom.aEastExit;
            if(vNextRoom == null){
                System.out.println("There is no door !");
                return;
            }
            this.aCurrentRoom = vNextRoom;
            System.out.println(this.aCurrentRoom.getDescription());;
        }
        
        else{
            System.out.println("Unknown direction !");
        }
        
        System.out.print("Exits : ");
        if(this.aCurrentRoom.aNorthExit != null){
            System.out.print("north ");
        }
        if(this.aCurrentRoom.aSouthExit != null){
            System.out.print("south ");
        }
        if(this.aCurrentRoom.aWestExit != null){
            System.out.print("west ");
        }
        if(this.aCurrentRoom.aEastExit != null){
            System.out.print("east ");
        }
        
        
    } // Game
}