
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
    private boolean aFired;
    
    /**
     * Constructeur d'objets de classe Beamer
     */
    public Beamer()
    { super("beamer","beamer - allows you to get back to the room you charged it in.",900);
      this.aCharged = false;
      this.aLocation = null;
      this.aChargingRoom = null;
      this.aFired = false;
    }//Beamer()
    
    /**
     * Permet de changer la valeur de notre attribut aFired
     * @param pValue valeur booléenne
     */
    public void changeFired(final boolean pValue){
        this.aFired = pValue;
    }
    
    /**
     * Permet de retourner la valeur de l'attribut aFired
     * @return valeur booléenne
     */
    public boolean getFired(){
        return this.aFired;
    }
    
    /**
     * Permet de savoir si le beamer est chargé ou non.
     * @return retourne un booléen.
     */
    public boolean getBeamerState(){
        return this.aCharged;
    }//getBeamerState()
    
    /**
     * Permet de connaître la pièce où le beamer a été chargé.
     * @return retourne la pièce a été chargé le beamer.
     */
    public Room getChargingRoom(){
        return this.aChargingRoom;
    }//getChargingRoom()
    
    /**
     * Permet de changer la pièce où le beamer a été chargé.
     * @param pRoom pièce où le beamer a été chargé.
     */
    public void changeChargingRoom(final Room pRoom){
        this.aChargingRoom = pRoom;
    }//changeChargingRoom(.)
    
    /**
     * Permet de charger/décharger le beamer.
     * @param pValue valeur booléenne
     */
    public void chargeBeamer(final boolean pValue){
        this.aCharged = pValue;
    }//chargeBeamer(.)
    
    /**
     * Permet de changer l'endroit où le beamer a été ramassé.
     * @param pRoom pièce où le beamer a été ramassé.
     */
    public void changeBeamerLocation(final Room pRoom){
        this.aLocation = pRoom;
    }//changeBeamerLocation(.)
    
    /**
     * Renvoie l'endroit où le beamer a été ramassé.
     * @return renvoie une pièce du jeu.
     */
    public Room getBeamerLocation(){
        return this.aLocation;
    }//getBeamerLocation()
    
    /**
     * Renvoie le lieu où le beamer a été ramassé.
     * @return renvoie une pièce du jeu.
     */
    public Room fire(){
        this.chargeBeamer(false);
        return this.getBeamerLocation();
    }//fire()
}
