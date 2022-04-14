
/**
 * This class implements filter to check if a QuakeEntry's magnitude is 
 * greater than or equal to the provided minimum magnitude.
 */
public class MinMagFilter implements Filter
{
    private double magMin; 
    public String name;
    
    public MinMagFilter(double min) { 
        magMin = min;
    } 

    public void setName(String addedName) {
        name = addedName;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean satisfies(QuakeEntry qe) { 
        return qe.getMagnitude() >= magMin; 
    } 

}
