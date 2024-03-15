
/**
 * Décrivez votre classe Item ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Item
{
   private String aDescription;
   private int aWeight;
   private String aNom;
   
    /** Constructeur de la classe Item
     * @param String pNom
     * @param String pDescription
     * @param int pWeight
    */
   public Item(final String pNom,final String pDescription, final int pWeight){
       this.aDescription = pDescription;
       this.aWeight = pWeight;
   }//Item(.)
   
    /** Procédure qui permet de définir le nom d'un Item.
     * @param String pName
    */
   public void setItemName(final String pName){
       this.aNom = pName;
   }//setItemName(.)
   
    /** Fonction qui retourne le nom d'un Item.
    */
   public String getItemName(){
       return this.aNom;
   }//getItemName()
   
    /** Fonction qui retourne la description d'un Item.
    */
   public String getItemDescription(){
       return this.aDescription;
   }//getItemDescription()
    
    /** Fonction qui retourne la liste des Items présents dans la pièce courante.
    */
   
   public String getItemString(){
        StringBuilder vReturn = new StringBuilder ("Item : ");
        if(this.aDescription != null){
            vReturn.append(this.aDescription);
        }
        else{
            return "No Item here";
        }
        return vReturn.toString();
    }//getItemString()

    /** Fonction qui retourne le poids d'un Item.
    */
   public int getItemWeight(){
       return this.aWeight;
   }//getItemWeight()
    
}
