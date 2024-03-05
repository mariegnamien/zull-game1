 
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
    private HashMap<String, Room> exits;
    private Room aNorthExit;
    private Room aSouthExit;
    private Room aWestExit;
    private Room aEastExit;
    
    // existing methods unchanged
    /**
    *
    * Crée une pièce avec une description particulière.
    * @param pDescription description de la pièce
    */

    public Room(final String pDescription){
        this.aDescription = pDescription;
        exits = new HashMap<String,Room>();
    }// Room()
    
    /**
    *
    * Retourne la description d'une pièce.
    * 
    */
    public String getDescription(){
        return aDescription;
    }

    /**
    *
    * Définit une des sorties de la pièce.
    * @param pDescription Emplacement de la sortie de la pièce courante.
    * @param pExit pièce en sortie 
    */
    public void setExit(final String pDescription, final Room pExit){
        exits.put(pDescription,pExit);
    }
    
    /**
    *
    * Définit toutes les sorties de la pièce courante (Nord, Sud, Ouest, Est).
    * @param pNorth pièce Nord
    * @param pSouth pièce Sud
    * @param pWest pièce Ouest
    * @param pEast pièce Est
    */ 
    public void setExits(final Room pNorth, final Room pSouth,final Room pWest, final Room pEast){
        if(pNorth != null){
            exits.put("north", pNorth);
        }
        if(pSouth != null){
            exits.put("south",pSouth);
        }
        if(pWest != null){
            exits.put("west", pWest);
        }
        if(pEast != null){
            exits.put("east",pEast);
        }
    }

    /**
    *
    * Retourne la sortie d'une pièce en fonction de la direction entrée.
    * @param pDirection direction
    */
    public Room getExit(String pDirection){
        return exits.get(pDirection);
    }
   
    /**
    *
    * Retourne l'ensemble des sorties d'une pièce.
    *
    */
   
    public String getExitString(){
        String vExits = "Exits:";
        Set<String> ensembleDesSorties = exits.keySet();
        for(String vKeys : ensembleDesSorties){
            vExits += " " + vKeys;
        }
        return vExits;
    }
    
    /**
     * Retourne une longue description de cette "room", de la forme 
     *          You are in the kitchen
     *          Exits : north west.
     * @return A description of the room, including exits. 
     */
    public String getLongDescription(){
        return "You are " + this.aDescription + ".\n" + getExitString();
    }
} // Room
