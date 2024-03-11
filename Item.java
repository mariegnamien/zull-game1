
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
   
   public Item(final String pNom,final String pDescription, final int pWeight){
       this.aNom = pNom;
       this.aDescription = pDescription;
       this.aWeight = pWeight;
   }
   
   public String getItemName(){
       return this.aNom;
   }
   
   public String getItemDescription(){
       return this.aDescription;
   }
    
   public String getItemString(){
        StringBuilder vReturn = new StringBuilder ("Item : ");
        if(this.aDescription != null){
            vReturn.append(this.aDescription);
        }
        else{
            return "No Item here";
        }
        return vReturn.toString();
        }

   public int getItemWeight(){
       return this.aWeight;
   }
    
}
