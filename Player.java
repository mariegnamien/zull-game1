import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

/**
 * Classe du joueur
 *
 * @author Marie Emilienne Gnamien
 * @version 25/03/2024
 */
public class Player
{
    // variables d'instance
    private String aName;
    private Room aCurrentRoom;
    private int aMaxWeight;
    private ItemList aInventory;
    private Stack<Room> aRoomStack;
    
    /**
     * Constructeur d'objets de classe Player
     */
    public Player(final String pName)
    {
        this.aName = pName;
        this.aInventory = new ItemList();
        this.aRoomStack = new Stack<Room>();
        this.aCurrentRoom = null;
        this.aMaxWeight = 2500;
        // initialisation des variables d'instance
    }
    
    public boolean back(){
        if(!this.aRoomStack.empty()){
        this.changeRoom(this.aRoomStack.pop());
        return true;
        }
        else{
            return false;
        }
    }
    
    public void changeRoom(final Room pRoom){
        this.aCurrentRoom = pRoom;
    }
    
    public void addStackRoom(){
        this.aRoomStack.push(this.aCurrentRoom);
    }
    
    public Room getCurrentRoom(){
        return this.aCurrentRoom;
    }
    
    public void take(final String pItem){
       this.aInventory.addItem(pItem,this.aCurrentRoom.getItems().getItem(pItem));
       this.aCurrentRoom.getItems().removeItem(pItem);
    }
    
    public void drop(final String pItem){
        this.aCurrentRoom.getItems().addItem(pItem,this.aInventory.getItem(pItem));
        this.aInventory.removeItem(pItem);
    }
    
}
