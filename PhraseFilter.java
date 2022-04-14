
/**
 * This class implements Filter to check whether a QuakeEntry's
 * phrase is found at the specified location (start, end, any).
 * 
 * Steven Jordany Guzmán Andrade .
 * Thursday, April 14, 2022.
 */

public class PhraseFilter implements Filter {
    private String where;
    private String phrase;
    
    public PhraseFilter(String whereToSearch, String givenPhrase) {
        where = whereToSearch;
        phrase = givenPhrase;
    }
    
    public boolean satisfies(QuakeEntry qe) {
        boolean result = false;
        switch (where) {
            case "start":
            result = qe.getInfo().startsWith(phrase);
            break;
            
            case "end":
            result = qe.getInfo().endsWith(phrase);
            break;
            
            case "any":
            switch (qe.getInfo().indexOf(phrase)) {
                case -1:
                result = false;
                break;
                
                default:
                result = true;
            }
            
            break;
            
        }
        
        return result;
    }
    
    
}
