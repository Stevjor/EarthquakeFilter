
/**
 * This class implements Filter to check if a QuakeEntry's
 * depth is between the provided minimum and maximum depths.
 *
 */
public class DepthFilter implements Filter {
    private double minDepth;
    private double maxDepth;
    public String name;
    
    public DepthFilter(double min, double max) {
        minDepth = min;
        maxDepth = max;
    }
    
    public void setName(String addedName) {
        name = addedName;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean satisfies(QuakeEntry qe) {
        return qe.getDepth() >= minDepth && qe.getDepth()<= maxDepth;
    }
}
