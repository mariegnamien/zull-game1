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
    private boolean aQuest;
    private int aSteps;
    
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
     * @param pName nom du joueur
     */
    public Player(final String pName)
    {
        this.aName = pName;
        this.aInventory = new ItemList();
        this.aRoomStack = new Stack<Room>();
        this.aCurrentRoom = null;
        this.aMaxWeight = 1500;
        this.aSteps = 0;
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
     * @return retourne un booléen
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
     * @param pRoom pièce suivante
     */
    public void changeRoom(final Room pRoom){
        this.aCurrentRoom = pRoom;
    }
    
    /**
     * Accesseur qui permet d'obtenir l'inventaire du joueur
     * @return retourne une TtemList (inventaire du joueur)
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
     * @return retourne la pièce courante
     */
    public Room getCurrentRoom(){
        return this.aCurrentRoom;
    }
    
    /**
     * Fonction qui retourne l'inventaire du joueur ainsi que son poids total.
     * @return retourne une chaîne de caractères
     */
    public String items(){
       String vString = "";
       int vWeight = 0;
       Set<String> vCles = this.aInventory.keySetList();
       for(String item : vCles){
          vString += this.aInventory.getItem(item).getItemName() + ",";
          vWeight += this.aInventory.getItem(item).getItemWeight();
       }
       return "Here are your items :" + vString + " total weight : " + vWeight;
    }
    
    /**
     * Fonction qui permet au joueur de prendre un item dans son inventaire.
     * @param pItem nom de l'item
     * @return retourne une chaîne de caractères
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
     * @param pItem Item à déposer dans la pièce.
     */
    public void drop(final String pItem){
        this.aCurrentRoom.getItems().addItem(pItem,this.aInventory.getItem(pItem));
        this.aInventory.removeItem(pItem);
    }

    /**
     * Procédure de la première quête qui nous permet de compter le nombre de pas effectués.
     */ 
    public void quest(){
        if(this.aQuest == true){
        this.aSteps += 1;
        }
        else{
        return;
    }
    }
    
        /**
     * Procédure qui permet de changer la valeur de l'attribut aQuest.
     * @param pRoom valeur booléenne
     */
    public void enableQuest(final boolean pValue){
        this.aQuest = pValue;
    }
    
    public boolean getQuest(){
        return this.aQuest;
    }
    
    /**
     * Procédure qui retourne le nombre de pas effectués.
     * @return nombre de pas effectués pendant une quête
     */
    public int getSteps(){
        return this.aSteps;
    }
    
}
