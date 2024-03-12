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
    * 
    */
    public String getDescription(){
        return this.aDescription;
    }

    /**
    *
    * Définit une des sorties de la pièce.
    * @param pDescription Emplacement de la sortie de la pièce courante.
    * @param pExit pièce en sortie 
    */
    public void setExit(final String pDescription, final Room pExit){
        this.aExits.put(pDescription,pExit);
    }

    /**
    *
    * Retourne la sortie d'une pièce en fonction de la direction entrée.
    * @param pDirection direction
    */
    public Room getExit(String pDirection){
        return this.aExits.get(pDirection);
    }
   
    /**
    *
    * Retourne l'ensemble des sorties d'une pièce.
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
    }
    
    public void addItem(final String pNom, final Item pItem){
        this.aItems.put(pNom,pItem);
    }
    
    public String getItemString(){
        StringBuilder vReturn = new StringBuilder("Items : ");
        if(this.aItems.keySet().size() == 0){
            return "No Items here...";
        }
        
        for(String nom : this.aItems.keySet()){
            vReturn.append(this.aItems.get(nom).getItemDescription() + "; ");
        }
        return vReturn.toString();
        }
    
        /*
        StringBuilder vReturn = new StringBuilder ("Item : ");
        if(this.aDescription != null){
            vReturn.append(this.aDescription);
        }
        else{
            return ("No Item here");
        }
        return vReturn.toString();
        */
    
    
    /**
     * Retourne une longue description de cette "room", de la forme 
     *          You are in the kitchen
     *          Exits : north west.
     * @return A description of the room, including exits. 
     */
    public String getLongDescription(){
        return "You are " + this.aDescription + ".\n" + this.getExitString() + "\n" + this.getItemString();
    }
    
    public String getImageName(){
        return this.aImageName;
    }

} // Room
