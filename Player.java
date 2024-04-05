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
    private UserInterface aGui;
    
    
        /**
     * Création de l'interface et appel du message de bienvenue.
     * @param pUserInterface UserInterface
     */   
    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
    }
    
    /**
     * Constructeur d'objets de classe Player
     */
    public Player(final String pName)
    {
        this.aName = pName;
        this.aInventory = new ItemList();
        this.aRoomStack = new Stack<Room>();
        this.aCurrentRoom = null;
        this.aMaxWeight = 1500;
        // initialisation des variables d'instance
    }
    
    /**
     * Procédure qui change le poids maximal de l'inventaire.
     */
    public void changeMaxWeight(){
        this.aMaxWeight = 3000;
    }
    
    
    
    /**
     * Procédure qui nous permet de repartir dans la pièce précédente.
     */
    public boolean back(){
        if(!this.aRoomStack.empty()){
        this.changeRoom(this.aRoomStack.pop());
        return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Procédure qui permet au joueur de changer de pièce.
     */
    public void changeRoom(final Room pRoom){
        this.aCurrentRoom = pRoom;
    }
    
    /**
     * Accesseur qui permet d'obtenir l'inventaire du joueur
     */
    public ItemList getInventory(){
        return this.aInventory;
    }
    
    /**
     * Procédure qui permet d'ajouter une nouvelle pièce à notre Stack.
     */
    public void addStackRoom(){
        this.aRoomStack.push(this.aCurrentRoom);
    }
    
    /**
     * Accesseur qui permet d'obtenir la pièce courante.
     */
    public Room getCurrentRoom(){
        return this.aCurrentRoom;
    }
    
    /**
     * Fonction qui retourne l'inventaire du joueur ainsi que son poids total.
     */
    public String items(){
       String vString = "";
       int vWeight = 0;
       Set<String> vCles = this.aInventory.keySetList();
       for(String item : vCles){
          vString += this.aInventory.getItem(item).getItemName() + ",";
          vWeight += this.aInventory.getItem(item).getItemWeight();
       }
       return "Here are your items :" + vString + " and this is the total weight : " + vWeight;
    }
    
    /**
     * Fonction qui permet au joueur de prendre un item dans son inventaire.
     * @param pItem nom de l'item
     */
    public String take(final String pItem){
       int vWeight = 0;
       Set<String> vCles = this.aInventory.keySetList();
       for(String item : vCles){
           vWeight += this.aInventory.getItem(item).getItemWeight();
       }
       if(vWeight < this.aMaxWeight){
       this.aInventory.addItem(pItem,this.aCurrentRoom.getItems().getItem(pItem));
       this.aCurrentRoom.getItems().removeItem(pItem);
           return "The item is now in your inventory.";
        }
       else{
           return "Your inventory is full, you can't take this item...";
       }
    }
    
    /**
     * Procédure qui permet au joueur de déposer un item dans une pièce.
     */
    public void drop(final String pItem){
        this.aCurrentRoom.getItems().addItem(pItem,this.aInventory.getItem(pItem));
        this.aInventory.removeItem(pItem);
    }
    
}
