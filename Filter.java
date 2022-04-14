
/**
 * This is an interface named Filter to test for conditions and get the name
 * of each class that implements this interface.
 */
public interface Filter
{
    public  boolean satisfies(QuakeEntry qe); 
    
    public String getName();
}
