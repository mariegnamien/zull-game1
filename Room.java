import java.util.HashMap;
import java.util.Set;

/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author Gnamien Marie Emilienne 
 */
public class Room
{
    private String aDescription;
    private HashMap<String, Room> aExits;
    private String aImageName;
    private ItemList aItems;
    
    /**
    * Crée une pièce avec une description particulière.
    * @param pDescription description de la pièce.
    * @param pImage nom d'une image.
    */

    public Room(final String pDescription, final String pImage){
        this.aDescription = pDescription;
        this.aExits = new HashMap<String,Room>();
        this.aItems = new ItemList();
        this.aImageName = pImage;
    }// Room()

    /** Procédure qui ajoute un Item à l'HashMap aItems
     * @param pNom nom de l'item
     * @param pItem Item
    */
    public void addItem(final String pNom, final Item pItem){
        this.aItems.addItem(pNom,pItem);
    }//addItem(.)
    
    /**
     * Procédure qui permet de retirer un item de la pièce.
     * @param pNom - nom de l'item
     */
    public void removeItem(final String pNom){
        this.aItems.removeItem(pNom);
    }
    
    /**
     * Fonction qui permet de savoir si un certain item est présent dans la pièce.
     * @return retourne un booléen
     * @param pNom - nom de l'item
     */
    public boolean containsItem(final String pNom){
        return this.aItems.containsItem(pNom);
    }
    
    /**
    * Retourne la description d'une pièce.
    * @return Retourne la description de la pièce courante.
    */
    public String getDescription(){
        return this.aDescription;
    }//getDescription()

    /**
    *
    * Définit une des sorties de la pièce.
    * @param pDescription nom de la sortie
    * @param pExit pièce en sortie de la pièce courante
    */
    public void setExit(final String pDescription, final Room pExit){
        this.aExits.put(pDescription,pExit);
    }//setExit(.)

    /**
    *  Fonction qui retourne une sortie en fonction de la direction entrée.
    *  @return Retourne la sortie d'une pièce en fonction de la direction entrée.
    *  @param pDirection pièce en sortie
    */
    public Room getExit(String pDirection){
        return this.aExits.get(pDirection);
    }//getExit(.)

    /** Fonction qui retourne la liste de toutes les sorties disponibles de la pièce courante.
    * @return Retourne l'ensemble des sorties d'une pièce.
    */
   
    public String getExitString(){
        StringBuilder returnString = new StringBuilder( "Exits :" );
        for(String vKeys : this.aExits.keySet()){
            if(aExits.get(vKeys) != null){
            returnString.append( " " + vKeys );
        }
        }
        return returnString.toString();
    }//getExitString()
    
    
    
    /** Fonction qui Retourne la liste de tous les Items présents dans la pièce courante.
     * @return Retourne la liste de tous les Items présents dans la pièce courante
    */
    public String getItemString(){
        String vReturn = "Items : ";
        if(this.aItems.getItemString().equals("No items here...")){
            return "No items here...";
        }
        else{
            return this.aItems.getItemString();
        }
        }//getItemString()
    
    /**
     * Retourne une longue description de cette "room", de la forme 
     *          You are in the kitchen
     *          Exits : north west.
     * @return A description of the room, including exits and items.
     */
    public String getLongDescription(){
        return "You are " + this.aDescription + ".\n" + this.getExitString() + "\n" + this.getItemString();
    }//getLongDescription()
    
    /** Fonction qui retourne le nom d'une image.
     * @return Retourne le nom d'une Image.
    */
    public String getImageName(){
        return this.aImageName;
    }//getImageName()
    
    /**
     * Fonction qui retourne un des Items présents dans la liste en fonction de nom entré en paramètres.
     * @return retourne un item
     * @param pNom nom de l'item
     */
    public Item getItem(final String pNom){
        return this.aItems.getItem(pNom);
    }
    
    /** 
     * Fonction qui retourne une booléen le bon fonctionnement de back pour la TrapDoor
     * @return retourne un booléen
     * @param pRoom pièce entrée
     */
    public boolean isExit(final Room pRoom){
        return this.aExits.containsValue(pRoom);
    }
} // Room
