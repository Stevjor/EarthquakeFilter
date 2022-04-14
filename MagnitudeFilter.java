
/**
 * This class implements Filter to check if a QuakeEntry's
 * is between the provided minimum and maximum magnitudes.
 */
public class MagnitudeFilter implements Filter {
    private double minMag;
    private double maxMag;
    public String name;
    
    public MagnitudeFilter(double min, double max) {
        minMag = min;
        maxMag = max;
    }
    
    public void setName(String addedName) {
        name = addedName;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean satisfies(QuakeEntry qe) {
        
        return qe.getMagnitude() >= minMag
        && qe.getMagnitude() <= maxMag;
        
    }
}
