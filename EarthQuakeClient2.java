import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 
    
    //Checks if an ArrayList of quake data satisfies the conditions from the classes
    //MagnitudeFilter and DepthFilter.
    public ArrayList<QuakeEntry> filter2(ArrayList<QuakeEntry> quakeData, Filter magFiltered, 
    Filter depthFiltered) { 
        return filterTwoConditions(quakeData, magFiltered, depthFiltered);
    } 
    
    public ArrayList<QuakeEntry> filterTwoConditions(ArrayList<QuakeEntry> quakeData, 
    Filter condition1, Filter condition2) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (condition1.satisfies(qe) && condition2.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    }
    
    public ArrayList<QuakeEntry> filter3(ArrayList<QuakeEntry> quakeData, Filter distFiltered, 
    Filter phraseFiltered) { 
        return filterTwoConditions(quakeData, distFiltered, phraseFiltered);
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        //String source = "data/nov20quakedata.atom";
        String source = "https://www.dukelearntoprogram.com//course4/data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        /*Filter f = new MinMagFilter(4.0); 
        ArrayList<QuakeEntry> m7  = filter(list, f); 
        for (QuakeEntry qe: m7) { 
            System.out.println(qe);
        } */
        
        Filter filteredMagnitude = new MagnitudeFilter(3.5, 4.5);
        Filter filteredDepth = new DepthFilter(-55000.0, -20000.0);
        ArrayList<QuakeEntry> quakesFiltered = filter2(list, filteredMagnitude, 
                                             filteredDepth);
                                             
        for (QuakeEntry qe : quakesFiltered) {
            System.out.println(qe);
        }
        
        System.out.println("There are " + quakesFiltered.size() + 
        " such earthquakes found.");
        
        /*
        Location loc = new Location(39.7392, -104.9903);
        double distance = 1000000.0;
        
        Filter filteredDistance = new DistanceFilter(loc, distance);
        Filter filteredPhrase = new PhraseFilter("end", "a");
        ArrayList<QuakeEntry> quakesFiltered = filter2(list, filteredDistance, 
                                             filteredPhrase);
                                             
        for (QuakeEntry qe : quakesFiltered) {
            System.out.println(qe);
        }
        
        System.out.println("There are " + quakesFiltered.size() + 
        " such earthquakes found.");
        */
    }

    /**
     * Makes use of the MatchAllFilter class to add several filters, and then
     * uses the filter method to store the QuakeEntry elements in a QuakeEntry's
     * ArrayList that satisfy the conditions of each filter added. Then it prints
     * every match.
       */
    public void testMatchAllFilter() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String fileName = "nov20quakedatasmall.atom";
        //String source = "data/" + fileName;
        String source = "https://www.dukelearntoprogram.com//course4/data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        
        /*
        for (QuakeEntry qe : list){
            System.out.println(qe);
        }
        */
       
       
        System.out.println("There are " + list.size() + 
        " earthquakes from the source " + 
        fileName + ".");
        
        MatchAllFilter maf = new MatchAllFilter();
        
        MagnitudeFilter filteredMagnitude = new MagnitudeFilter(1.0, 4.0);
        filteredMagnitude.setName("Magnitude");
        
        DepthFilter filteredDepth = new DepthFilter(-180000.0, -30000.0);
        filteredDepth.setName("Depth");
        
        PhraseFilter filteredPhrase = new PhraseFilter("any", "o");
        filteredPhrase.setName("Phrase");
        
        
        maf.addFilter(filteredMagnitude);
        maf.addFilter(filteredDepth);
        maf.addFilter(filteredPhrase);
        
        ArrayList<QuakeEntry> appliedFilters = filter(list, maf);
        
        for (QuakeEntry qe : appliedFilters) {
            System.out.println(qe);
        }
        
        System.out.println("There are " + appliedFilters.size() + 
        " such earthquakes found.");
        
        String names = maf.getName();
        System.out.println("Filters used are: " + names + ".");
    }
    
    public void testMatchAllFilter2() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String fileName = "nov20quakedatasmall.atom";
        //String source = "data/" + fileName;
        String source = "https://www.dukelearntoprogram.com//course4/data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("There are " + list.size() + 
        " earthquakes from the file " + fileName + ".");
        
        MatchAllFilter maf = new MatchAllFilter();
        
        Location loc = new Location(55.7308, 9.1153);
        
        MagnitudeFilter filteredMagnitude = new MagnitudeFilter(0.0, 5.0);
        filteredMagnitude.setName("Magnitude");
        
        DistanceFilter filteredDistance = new DistanceFilter(loc, 3000000);
        filteredDistance.setName("Distance");
        
        PhraseFilter filteredPhrase = new PhraseFilter("any", "e");
        filteredPhrase.setName("Phrase");
        
        maf.addFilter(filteredMagnitude);
        maf.addFilter(filteredDistance);
        maf.addFilter(filteredPhrase);
        
        ArrayList<QuakeEntry> appliedFilters = filter(list, maf);
        
        for (QuakeEntry qe : appliedFilters) {
            System.out.println(qe);
        }
        
        System.out.println("There are " + appliedFilters.size() + 
        " such earthquakes found.");
        
        String names = maf.getName();
        System.out.println("Filters used are: " + names + ".");
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

}
