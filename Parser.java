import java.util.StringTokenizer;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This parser reads user input and tries to interpret it as an "Adventure"
 * command. Every time it is called it reads a line from the terminal and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 * 
 * @author  Michael Kolling and David J. Barnes + D.Bureau
 * @version 2008.03.30 + 2013.09.15
 */
public class Parser 
{
    private CommandWords aValidCommands;  // (voir la classe CommandWords)

    /**
     * Constructeur par defaut qui cree les 2 objets prevus pour les attributs
     */
    public Parser() 
    {
        this.aValidCommands = new CommandWords();
    } // Parser()

    /** 
     * Fonction qui retourne une commande entrée par l'utilisateur.
     * @param pInputLine ligne entrée
     * @return The next command from the user.
     */
    public Command getCommand(final String pInputLine) 
    {
        String vWord1;
        String vWord2;
        
        StringTokenizer vTokenizer = new StringTokenizer(pInputLine );
        if ( vTokenizer.hasMoreTokens() ) {     // y a-t-il un mot suivant ?
            vWord1 = vTokenizer.nextToken();      // recupere le premier mot
        }
        else{
            vWord1 = null;
        }
        
        if ( vTokenizer.hasMoreTokens() ) { // y a-t-il encore un mot suivant ?
            vWord2 = vTokenizer.nextToken();  // recupere le deuxieme mot
                // note : on ignore tout le reste de la ligne tapee !} // if
        } 
        else{
            vWord2 = null;
        }

        // Verifie si le premier mot est une commande connue.
        // Si oui, cree un objet Command avec ce mot. (vWord2 peut etre null)
        // Sinon, cree une commande vide avec "null" (pour dire 'commande inconnue').
        if ( this.aValidCommands.isCommand( vWord1 ) ) {
            return new Command( vWord1, vWord2 );
        }
        else {
            return new Command( null, vWord2 ); 
        }

    } // getCommand()
    
    /** Fonction qui retourne la liste de toutes les commandes disponibles.
     * @return retourne la liste de toutes les commandes disponibles.
    */
    public String getCommandString(){
        return this.aValidCommands.getCommandList();
    }//getCommandString()
} // Parser