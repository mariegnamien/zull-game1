 

/**
 * Classe Command - une commande du jeu d'aventure Zuul.
 *
 * @author Marie Emilienne Gnamoen
 */
public class Command
{
    private String aCommandWord;
    private String aSecondWord;

    /**
     * Constructeur naturel qui définit une commande en fonction des données entrées par l'utilisateur.
     * @param pWord1 premier mot de la commande
     * @param pWord2 deuxieme mot de la commande
     */
    public Command(final String pWord1, final String pWord2){
        this.aCommandWord = pWord1;
        this.aSecondWord = pWord2;
    }//Command(.)
    /**
     * @return Retourne le premier mot de la commande entrée.
     */  
    public String getCommandWord(){
        return this.aCommandWord;
    }//getCommandWord()
    
    /**
        @return Retourne le second mot de la commande.
     */
    public String getSecondWord(){
        return this.aSecondWord;
    }//getSecondWord
    
    /**
     * @return Retourne un booléen en fonction de si la commande possède un 2e mot ou non.
     */
    public boolean hasSecondWord(){
        return(this.aSecondWord != null);
    }//hasSecondWord()
    
    /**
        @return Retourne un booléen en fonction de si la commande est reconnue ou non.
     */
    public boolean isUnknown(){
        return(this.aCommandWord == null);        
    }//isUnknown()
} // Command
