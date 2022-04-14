
/**
 * Write a description of class DistanceFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
