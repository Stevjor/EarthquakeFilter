import java.util.ArrayList;
/**
 * This class implements Filter to check if a QuakeEntry's element satisfy
 * all filter conditions added here.
 * 
 * Steven Jordany Guzmán Andrade.
 * Thursday, April 14, 2022.
 */
public class MatchAllFilter implements Filter {
    private ArrayList<Filter> list;
    
    public MatchAllFilter() {
        list = new ArrayList<Filter>();
    }
    
    public void addFilter(Filter f) {
        list.add(f);
    }
    
    public boolean satisfies(QuakeEntry qe) {
        
        for (Filter ft : list) {
            
            if (!ft.satisfies(qe)) {
                return false;
            }
            
        }
        
        return true;
    }
}
