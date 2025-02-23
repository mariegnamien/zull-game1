
/**
 * Classe Item
 *
 * @author Marie Emilienne Gnamien
 * @version 15/03/2024
 */
public class Item
{
   private String aDescription;
   private int aWeight;
   private String aNom;
   
    /** Constructeur de la classe Item
     * @param pNom nom de l'item
     * @param pDescription description de l'item
     * @param pWeight poids de l'item (String)
    */
   public Item(final String pNom,final String pDescription, final int pWeight){
       this.aNom = pNom;
       this.aDescription = pDescription;
       this.aWeight = pWeight;
   }//Item(.)
   
    /** Procédure qui permet de définir le nom d'un Item.
     * @param pName nom de l'item
    */
   public void setItemName(final String pName){
       this.aNom = pName;
   }//setItemName(.)
   
    /**
     * Fonction qui retourne le nom d'un item.
     * @return Retourne le nom d'un Item
    */
   public String getItemName(){
       return this.aNom;
   }//getItemName()
   
    /** Fonction qui retourne la description d'un item.
     * @return Retourne la description d'un Item
    */
   public String getItemDescription(){
       return this.aDescription;
   }//getItemDescription()
    
    /** Fonction qui retourne la liste des Items présents dans la pièce courante.
     * @return Retourne la liste des Items présents dans la pièce courante.
    */
   
   public String getItemString(){
        String vReturn = "Item : ";
        if(this.aDescription != null){
            vReturn += this.aDescription;
        }
        else{
            return "No Item here";
        }
        return vReturn;
    }//getItemString()

    /** Fonction qui retourne le poids d'un Item.
     * @return Retourne le poids d'un Item.
     * 
    */
   public int getItemWeight(){
       return this.aWeight;
   }//getItemWeight()
    
}
