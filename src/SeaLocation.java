import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SeaLocation {

    String name;
    boolean hasShipwreck;
    int numFish;
    int depth;

    static List<SeaLocation> locations;

    public SeaLocation(String name, boolean hasShipwreck, int numFish, int depth) {
        this.name = name;
        this.hasShipwreck = hasShipwreck;
        this.numFish = numFish;
        this.depth = depth;
    }

    @Override
    public String toString() {
        return name + ", Depth = " + depth;
    }

    public static void main(String[] args) {
        buildLocations();

        //Write the following SQL calls as functional programming streams

        //Warm-up
        //SELECT * FROM locations WHERE depth > 300

        List<SeaLocation> deepLocations = locations.stream()
                .filter( e -> e.depth > 300 )
                .collect(Collectors.toList());

        System.out.println(deepLocations);

        //Take it further
        //SELECT name FROM locations WHERE numFish >= 30 AND hasShipWreck = true

        List<String> locationNames = locations.stream();

        System.out.println(locationNames);

        //Stretcher!
        //SELECT depth FROM locations WHERE hasShipwreck = true
        //Then find the average depth of locations with a shipwreck

        double average = locations.stream();

        System.out.println(average);
    }

    public static void buildLocations () {
        locations = new ArrayList<>();
        //Not at all scientific/accurate
        locations.add(new SeaLocation("Marianas Trench", false, 15, 2000));
        locations.add(new SeaLocation("Atlantis", true, 3000, 500));
        locations.add(new SeaLocation("Ariel's Trove", true, 2, 300));
        locations.add(new SeaLocation("Sea Witch Lair", false, 1, 1000));
        locations.add(new SeaLocation("Great Barrier Reef", true, 5000, 300));
        locations.add(new SeaLocation("Port Royal Jamaica", false, 50, 10));
        locations.add(new SeaLocation("Cleopatra's Palace", true, 20, 50));
    }
}