 
/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author votre nom
 */
public class Room
{
    private String aDescription = "";
    public Room aNorthExit;
    public Room aSouthExit;
    public Room aWestExit;
    public Room aEastExit;
    
    public Room(final String pLieu){
        this.aDescription += pLieu;
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
} // Room
