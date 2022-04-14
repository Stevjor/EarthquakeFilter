
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
            result = phrase.startsWith(where);
            break;
            
            case "end":
            result = phrase.endsWith(where);
            break;
            
            case "any":
            switch (phrase.indexOf(where)) {
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
