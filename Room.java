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
    private HashMap<String,Item> aItems;
    
    /**
    *
    * Crée une pièce avec une description particulière.
    * @param pDescription description de la pièce
    * @param pImage nom d'une image
    */

    public Room(final String pDescription, final String pImage){
        this.aDescription = pDescription;
        this.aExits = new HashMap<String,Room>();
        this.aItems = new HashMap<String,Item>();
        this.aImageName = pImage;
    }// Room()
    
    /**
    *
    * Retourne la description d'une pièce.
    * @return Retourne la description de la pièce courante.
    * 
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
    *   Fonction qui retourne une sortie en fonction de la direction entrée.
    *  @return Retourne la sortie d'une pièce en fonction de la direction entrée.
    * @param pDirection pièce en sortie
    */
    public Room getExit(String pDirection){
        return this.aExits.get(pDirection);
    }//getExit(.)
   
    /** Fonction qui retourne un Item
     *  @param pItem Nom de lItem
     */
    public Item getItem(String pItem){
        return this.aItems.get(pItem);
    }
    
    /**
     * Fonction qui retourne un booléen en fonction de la présence ou non d'un Item dans aItems.
     * @param pKey clé de l'Item
     */
    public boolean containsItem(final String pKey){
        return this.aItems.containsKey(pKey);
    }

    /** Fonction qui retourne la liste de toutes les sorties disponibles de la pièce courante.
    *
    * @return Retourne l'ensemble des sorties d'une pièce.
    * 
    *
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
    
    /** Procédure qui ajoute un Item à l'HashMap aItems
     * @param pNom nom de l'item
     * @param pItem Item
    */
    public void addItem(final String pNom, final Item pItem){
        this.aItems.put(pNom,pItem);
    }//addItem(.)
    
    /** Procédure qui retire un Item de la HashMap aItems
     * @param pNom nom de l'item
     * @param pItem Item
    */
    public void removeItem(final String pNom, final Item pItem){
        this.aItems.remove(pNom,pItem);
    }//removeItem(.)
    

    /** Fonction qui Retourne la liste de tous les Items présents dans la pièce courante.
     * @return Retourne la liste de tous les Items présents dans la pièce courante
    */
    public String getItemString(){
        StringBuilder vReturn = new StringBuilder("Items : ");
        if(this.aItems.keySet().size() == 0){
            return "No Items here...";
        }
        
        for(String nom : this.aItems.keySet()){
            vReturn.append(this.aItems.get(nom).getItemDescription() + "; ");
        }
        return vReturn.toString();
        }//getItemString()
    
    /**
     * Retourne une longue description de cette "room", de la forme 
     *          You are in the kitchen
     *          Exits : north west.
     * @return A description of the room, including exits. 
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

} // Room
