 

/**
 * Classe Command - une commande du jeu d'aventure Zuul.
 *
 * @author Gnamien Marie Emilienne
 */
public class Command
{
    private String aCommandWord;
    private String aSecondWord;

    /**
     * Constructeur naturel qui définit une commande en fonction des données entrées par l'utilisateur.
     * @param String premier mot entré
     * @param String second mot entré
     */
    public Command(final String pWord1, final String pWord2){
        this.aCommandWord = pWord1;
        this.aSecondWord = pWord2;
    }
    /**
     * Retourne le premier mot de la commande entrée.
     */  
    public String getCommandWord(){
        return this.aCommandWord;
    }
    
    /**
        Retourne le second mot de la commande.
     */
    public String getSecondWord(){
        return this.aSecondWord;
    }
    
    /**
     * Retourne un booléen en fonction de si la commande possède un 2e mot ou non.
     */
    public boolean hasSecondWord(){
        return(this.aSecondWord != null);
    }
    /**
        Retourne un booléen en fonction de si la commande est reconnue ou non.
     */
    public boolean isUnknown(){
        return(this.aCommandWord == null);        
    }
} // Command
