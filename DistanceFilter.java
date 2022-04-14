
/**
 * This class implements Filter to check whether a QuakeEntry's
 * distance from a given location is less than the provided maximum
 * distance
 * 
 * Steven Jordany Guzmán Andrade .
 * Thursday, April 14, 2022.
 */
public class DistanceFilter implements Filter {
    private Location loc;
    private double maxDist;
    
    public DistanceFilter(Location currentLoc, double max) {
        loc = currentLoc;
        maxDist = max;
    }

    public boolean satisfies(QuakeEntry qe) {
        return qe.getLocation().distanceTo(loc) < maxDist;
        
    }
}
