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
    
    public ItemList(){
        this.aItemList = new HashMap<String,Item>();
    }
    
    /** Procédure qui ajoute un Item à l'HashMap aItemList
     * @param pNom nom de l'item
     * @param pItem Item
    */
    public void addItem(final String pNom, final Item pItem){
        this.aItemList.put(pNom,pItem);
    }//addItem(.)

    /**
     * Procédure qui retourne l'ItemList
     * 
     * 
     */
    public HashMap getItemList(){
        return this.aItemList;
    }
    
    /**
     * Fonction qui retourne la taille du keyset de la liste d'items
     */
    public int keysetSize(){
        return this.aItemList.keySet().size();
    }
    
    /**
     * Fonction qui retourne la keyset de la liste d'items
     * 
     */
    public Set keySetList(){
        return this.aItemList.keySet();
    }
    
    /** Procédure qui retire un Item de la HashMap aItemList
     * @param pNom nom de l'item
     * @param pItem Item
    */
    public void removeItem(final String pNom){
        this.aItemList.remove(pNom);
    }//removeItem(.)
    
    /** Fonction qui retourne un Item
     *  @param pItem Nom de lItem
     */
    public Item getItem(String pItem){
        return this.aItemList.get(pItem);
    }
    
        /**
     * Fonction qui retourne un booléen en fonction de la présence ou non d'un Item dans aItems.
     * @param pKey clé de l'Item
     */
    public boolean containsItem(final String pKey){
        return this.aItemList.containsKey(pKey);
    }
    
    /**
     * Fonction qui retourne un booléen en fonction de la présence ou non d'un Item dans l'inventaire.
     * @param pKey clé de l'Item
     */
    public boolean hasItem(final String pKey){
        return this.aItemList.containsKey(pKey);
    }
}
