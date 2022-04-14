
/**
 * This class implements Filter to check if a QuakeEntry's
 * is between the provided minimum and maximum magnitudes.
 * 
 * Steven Jordany Guzmán Andrade. 
 * Thursday, April 14, 2022.
 */
public class MagnitudeFilter implements Filter {
    private double minMag;
    private double maxMag;
    
    public MagnitudeFilter(double min, double max) {
        minMag = min;
        maxMag = max;
    }
    
    public boolean satisfies(QuakeEntry qe) {
        
        return qe.getMagnitude() >= minMag
        && qe.getMagnitude() <= maxMag;
        
    }
}
