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
    private boolean aQuest;
    private int aSteps;
    private Beamer aBeamer;
    private int aWeight;
    
    /**
     * Constructeur d'objets de classe Player
     * @param pName nom du joueur
     */
    public Player()
    {
        this.aName = javax.swing.JOptionPane.showInputDialog( "what is your name ?" );
        this.aInventory = new ItemList();
        this.aRoomStack = new Stack<Room>();
        this.aCurrentRoom = null;
        this.aMaxWeight = 1500;
        this.aSteps = 0;
        this.aQuest = true;
        this.aBeamer = new Beamer();
        this.aWeight = 0;
        // initialisation des variables d'instance
    }
    
    public String getName(){
        return this.aName;
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
    if((!this.aRoomStack.empty())){ 
        if(this.aCurrentRoom.isExit(this.aRoomStack.peek())){
        this.changeRoom(this.aRoomStack.pop());
        return true;
        }
    }
        return false;
    }
    
    /**
     * Procédure qui permet au joueur de changer de pièce.
     * @param pRoom pièce suivante
     */
    public void changeRoom(final Room pRoom){
        this.aCurrentRoom = pRoom;
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
       if (this.aInventory.getItemString().equals("No items here...")){
           return "Your inventory is empty...";
       }
       else{
        return this.aInventory.getItemString() + " total weight : " + this.aWeight;
        
        /*
       String vString = "";
       int vWeight = 0;
       Set<String> vCles = this.aInventory.keySetList();
       for(String item : vCles){
          vString += this.aInventory.getItem(item).getItemName() + ",";
          vWeight += this.aInventory.getItem(item).getItemWeight();
       }
       return "Here are your items :" + vString + " total weight : " + vWeight;
       */
    }
    }
    public boolean verifyWeight(final int pWeight){
        return this.aWeight + pWeight < this.aMaxWeight;
    }
    
    public boolean hasItemRoom(final String pWord){
        return this.aCurrentRoom.containsItem(pWord);
    }
    
    public boolean hasItemInventory(final String pWord){
        return this.aInventory.containsItem(pWord);
    }
    
    /**
     * Fonction qui permet au joueur de prendre un item dans son inventaire.
     * @param pItem nom de l'item
     * @return retourne une chaîne de caractères
     */
    public String take(final String pItem){
       if(this.verifyWeight(this.aCurrentRoom.getItem(pItem).getItemWeight())){
       this.aInventory.addItem(pItem,this.aCurrentRoom.getItem(pItem));
       this.aWeight += this.aCurrentRoom.getItem(pItem).getItemWeight();

       if(this.aInventory.containsItem("beamer")){
        this.aBeamer.changeBeamerLocation(this.aCurrentRoom); // lieu où se trouve le beamer
        }
       this.aCurrentRoom.removeItem(pItem);
           return "The item is now in your inventory.";
        }
       else{
           return "you can't take this item, it is too heavy for you (maybe eating something could help you with that...).";
       }
    }
    
    /**
     * Procédure qui permet au joueur de déposer un item dans une pièce.
     * @param pItem Item à déposer dans la pièce.
     */
    public void drop(final String pItem){
        this.aCurrentRoom.addItem(pItem,this.aInventory.getItem(pItem));
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
    
    public String eat(final String pItem){
        if(pItem.equals("magicCookie")){
            this.changeMaxWeight();
            this.aInventory.removeItem(pItem);
            return "You can carry a lot more items in your inventory now.";
        }
        return "You have eaten now and you are not hungry any more.";
    }
        /**
     * Procédure qui permet de changer la valeur de l'attribut aQuest.
     * @param pValue valeur booléenne
     */
    public void enableQuest(final boolean pValue){
        this.aQuest = pValue;
    }
    
    /**
     * Fonction qui retourne la valeur de l'attribut aQuest
     * @return valeur booléenne
     */
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
    
    public String charge(){
    if(this.aCurrentRoom != this.aBeamer.getBeamerLocation() && this.aInventory.containsItem("beamer")){
        this.aBeamer.chargeBeamer(true);
        this.aBeamer.changeChargingRoom(this.aCurrentRoom);
        return "Your beamer is now charged.";
    }
    else{
        return "Find the beamer or change places to charge it if you already have it.";
    }
    }
    
    public String fire(){
    if(this.aBeamer.getChargingRoom() != null && this.aCurrentRoom != this.aBeamer.getChargingRoom()){
    if(this.aInventory.containsItem("beamer") && this.aBeamer.getBeamerState()){
        this.aCurrentRoom = this.aBeamer.fire();
        return "Your beamer is now discharged. Charge it again if you want to use it.";
    }
    else if(this.aInventory.containsItem("beamer") && (!this.aBeamer.getBeamerState())){
        return "Your beamer is out of charge, you need to charge it...";
    }
    else if((!this.aInventory.containsItem("beamer")) && this.aBeamer.getBeamerState()){
        return "You have no beamer in your inventory";
    }
    }
    else if(this.aBeamer.getChargingRoom() != null && this.aCurrentRoom == this.aBeamer.getChargingRoom()){
        return "To fire your beamer,you have to change places";
    }
    return "You can't do this... Get the beamer first and then charge it.";
    }
}
