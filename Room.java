 
import java.util.HashMap;
import java.util.Set;

/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author votre nom
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
    
    public Room(final String pDescription){
        this.aDescription = pDescription;
        exits = new HashMap<String,Room>();
    }// Room()
    
    public String getDescription(){
        return aDescription;
    }
    
    public void setExit(final String pDescription, final Room pExit){
        exits.put(pDescription,pExit);
    }
    
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
    
    public Room getExit(String pDirection){
        return exits.get(pDirection);
    }
   
    public String getExitString(){
        String vExits = "";
        Set<String> ensembleDesSorties = exits.keySet();
        for(String vKeys : ensembleDesSorties){
            if(exits.get(vKeys) != null){
            vExits += exits.get(vKeys);
        }
    }
        //vExits += this.aNorthExit +" "+ this.aSouthExit + " " +this.aEastExit + " " + this.aWestExit;
        return vExits;
    }

} // Room
