/**
 * Classe CommandWords
 *
 * @author Gnamien Marie Emilienne

 */
public class CommandWords
{
    private final String[] aValidCommands = {"go","quit","help","look","eat","back"};
    
    public CommandWords(){
        
    }//CommandWords()
    /**
     * Vérifie que la commande entrée appartient à celles acceptées.
     * @param pWord Commande entrée par l'utilisateur.
     * @return retourne un booléen
     */
    public boolean isCommand(final String pWord){
        for(String element : aValidCommands){
            if(element.equals(pWord)){
                return true;
            }
        }
        return false;
    }//isCommand(.)
    
    /**
     * Affiche toutes les commandes valides.
     * @return retourne la liste entière de toutes les commandes disponibles.
     */
    public String getCommandList(){
        String vList = "";
        for(String command : aValidCommands){
            vList += command + " ";
        }
        return vList;
    }//getCommandList()
}
