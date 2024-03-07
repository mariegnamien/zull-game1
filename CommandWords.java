/**
 * Classe CommandWords
 *
 * @author Gnamien Marie Emilienne

 */
public class CommandWords
{
    private final String[] aValidCommands = {"go","quit","help","look","eat"};
    
    public CommandWords(){
        
    }
    /**
     * Vérifie que la commande entrée appartient à celles acceptées.
     * @param pWord Commande entrée par l'utilisateur.
     */
    public boolean isCommand(final String pWord){
        for(String element : aValidCommands){
            if(element.equals(pWord)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Affiche toutes les commandes valides.
     */
    public String getCommandList(){
        String vList = "";
        for(String command : aValidCommands){
            vList += command + " ";
        }
        return vList;
    }
}
