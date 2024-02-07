 
/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author votre nom
 */
public class Room
{
    private String aDescription;
    private Room aNorthExit;
    private Room aSouthExit;
    private Room aWestExit;
    private Room aEastExit;
    
    // existing methods unchanged
    
    public Room(final String pLieu){
        this.aDescription = pLieu;
    }// Room()
    
    public String getDescription(){
        return this.aDescription;
    }
    
    public void setExits(final Room pRoom1, final Room pRoom2,final Room pRoom3, final Room pRoom4){
        this.aNorthExit = pRoom1;
        this.aSouthExit = pRoom2;
        this.aWestExit = pRoom3;
        this.aEastExit = pRoom4;
    }
    
    public Room getExit(String direction){
        if(direction.equals("north")){
            return aNorthExit;
        }
        if (direction.equals("east")){
            return aEastExit;
        }
        if(direction.equals("south")){
            return aSouthExit;
        }
        if(direction.equals("west")){
            return aWestExit;
        }
        return null;
    }
} // Room
