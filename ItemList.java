import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

/**
 * Classe ItemList
 *
 * @author Gnamien Marie Emilienne
 * @version 01/04/2024
 */
public class ItemList
{
    private HashMap<String,Item> aItemList;
    /**
     * constructeur de l'ItemList du joueur
     */
    public ItemList(){
        this.aItemList = new HashMap<String,Item>();
    }
    
    /** Procédure qui ajoute un Item à l'HashMap aItemList
     * @param pNom nom de l'item
     * @param pItem Item choisi
    */
    public void addItem(final String pNom, final Item pItem){
        this.aItemList.put(pNom,pItem);
    }//addItem(.)
    
    /** Procédure qui retire un Item de la HashMap aItemList
     * @param pNom nom de l'item
    */
    public void removeItem(final String pNom){
        this.aItemList.remove(pNom);
    }//removeItem(.)
    
    /** Fonction qui retourne un Item
     *  @param pItem Nom de l'Item
     *  @return retourne un item
     */
    public Item getItem(String pItem){
        return this.aItemList.get(pItem);
    }
    
        /**
     * Fonction qui retourne un booléen en fonction de la présence ou non d'un Item dans aItems.
     * @param pKey clé de l'Item
     * @return retourne un booléen
     */
    public boolean containsItem(final String pKey){
        return this.aItemList.containsKey(pKey);
    }

    /** Fonction qui Retourne la liste de tous les Items présents dans l'ItemList.
     * @return Retourne la liste de tous les Items présents dans l'ItemList.
    */
    public String getItemString(){
        String vReturn = "Items : ";
        Set<String> vMesCles;
        vMesCles = this.aItemList.keySet();
        
        if(vMesCles.size() == 0){
            return "No items here...";
        }
        
        for(String nom : vMesCles){
            vReturn += this.getItem(nom).getItemDescription() + " -  " + this.getItem(nom).getItemWeight() + " ; ";
        }
        return vReturn;
        }//getItemString()

}
