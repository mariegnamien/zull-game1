package v1;


/**
 * Décrivez votre classe CommandWords ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class CommandWords
{
    private final String[] aValidCommands = {"go","quit","help"};
    
    public boolean isCommand(final String pWord){
        for(String element : aValidCommands){
            if(element.equals(pWord)){
                return true;
            }
        }
        return false;
    }
}
