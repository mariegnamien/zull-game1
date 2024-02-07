 

/**
 * Classe Command - une commande du jeu d'aventure Zuul.
 *
 * @author votre nom
 */
public class Command
{
    private String aCommandWord;
    private String aSecondWord;
    
    public Command(final String pWord1, final String pWord2){
        this.aCommandWord = pWord1;
        this.aSecondWord = pWord2;
    }
    
    public String getCommandWord(){
        return this.aCommandWord;
    }
    
    public String getSecondWord(){
        return this.aSecondWord;
    }
    
    public boolean hasSecondWord(){
        return(this.aSecondWord != null);
    }
    
    public boolean isUnknown(){
        return(this.aCommandWord == null);        
    }
} // Command
