 

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
    /** Fonction qui retourne le premier mot de la commande entrée.
     * @return Retourne le premier mot de la commande entrée.
     */  
    public String getCommandWord(){
        return this.aCommandWord;
    }//getCommandWord()
    
    /**
     * Fonction qui retourne le second mot de la commande entrée.
        @return Retourne le second mot de la commande.
     */
    public String getSecondWord(){
        return this.aSecondWord;
    }//getSecondWord
    
    /**
     * Fonction qui permet de savoir s'il y a un second mot à la commande entrée
     * @return Retourne un booléen en fonction de si la commande possède un 2e mot ou non.
     */
    public boolean hasSecondWord(){
        return(this.aSecondWord != null);
    }//hasSecondWord()
    
    /** Fonction qui permet de vérifier si la commande est inconnue ou non. 
     * @return Retourne un booléen en fonction de si la commande est reconnue ou non.
     */
    public boolean isUnknown(){
        return(this.aCommandWord == null);        
    }//isUnknown()
} // Command
