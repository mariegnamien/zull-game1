/**
 * Classe CommandWords
 *
 * @author Gnamien Marie Emilienne

 */
public class CommandWords
{
    private final String[] aValidCommands = {"go","quit","help","look","eat","start!","back"};
    
    public CommandWords(){
        
    }//CommandWords()
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
    }//isCommand(.)
    
    /**
     * Affiche toutes les commandes valides.
     */
    public String getCommandList(){
        String vList = "";
        for(String command : aValidCommands){
            vList += command + " ";
        }
        return vList;
    }//getCommandList()
}
