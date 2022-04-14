
/**
 * This class implements Filter to check whether a QuakeEntry's
 * distance from a given location is less than the provided maximum
 * distance
 */
public class DistanceFilter implements Filter {
    private Location loc;
    private double maxDist;
    public String name;
    
    public DistanceFilter(Location currentLoc, double max) {
        loc = currentLoc;
        maxDist = max;
    }

    public void setName(String addedName) {
        name = addedName;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean satisfies(QuakeEntry qe) {
        return qe.getLocation().distanceTo(loc) < maxDist;
        
    }
}
