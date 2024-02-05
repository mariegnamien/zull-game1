package v1;

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
        Room vOutside = new Room("outside the main entrance of the university");
        Room vTheatre = new Room("in a lecture theatre");
        Room vPub = new Room("in the campus pub");
        Room vLab = new Room("in a computing lab");
        Room vOffice = new Room("in the computing admin office");
        
        vOutside.setExits(null,vLab,vPub,vTheatre);
        vTheatre.setExits(null,null,vOutside,null);
        vPub.setExits(null,null,null,vOutside);
        vLab.setExits(vOutside,null,null,vOffice);
        vOffice.setExits(null,null,vLab,null);
        
        this.aCurrentRoom = vOutside;
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