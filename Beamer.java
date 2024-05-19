
/**
 * Décrivez votre classe Beamer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Beamer extends Item
{
    private Room aLocation;
    private boolean aCharged;
    private Room aChargingRoom;
    
    /**
     * Constructeur d'objets de classe Beamer
     */
    public Beamer()
    { super("beamer","beamer - allows you to get back to the room you charged it in.",900);
      this.aCharged = false;
      this.aLocation = null;
      this.aChargingRoom = null;
    }
    
    public boolean getBeamerState(){
        return this.aCharged;
    }
    
    public Room getChargingRoom(){
        return this.aChargingRoom;
    }
    
    public void changeChargingRoom(final Room pRoom){
        this.aChargingRoom = pRoom;
    }
    
    public void chargeBeamer(final boolean pValue){
        this.aCharged = pValue;
    }
    
    public void changeBeamerLocation(final Room pRoom){
        this.aLocation = pRoom;
    }
    
    public Room getBeamerLocation(){
        return this.aLocation;
    }
    
    public Room fire(){
        this.chargeBeamer(false);
        return this.getBeamerLocation();
    }
}
