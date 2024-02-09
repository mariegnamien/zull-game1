/**
 * Classe CommandWords
 *
 * @author Gnamien Marie Emilienne

 */
public class CommandWords
{
    private final String[] aValidCommands = {"go","quit","help"};
    
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
}
