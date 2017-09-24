import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        SeaLocation.buildLocations();

        //Write the following SQL calls as functional programming streams

        //Warm-up
        //SELECT * FROM locations WHERE depth > 300

        List<SeaLocation> deepLocations = SeaLocation.locations.stream()
                .filter( e -> e.depth > 300 )
                .collect(Collectors.toList());

        System.out.println(deepLocations);

        //Take it further
        //SELECT name FROM locations WHERE numFish >= 30 AND hasShipWreck = true

        List<String> locationNames = SeaLocation.locations.stream()
                .filter( e -> e.numFish >= 30 )
                .filter( e -> e.hasShipwreck )
                .map( e -> e.name )
                .collect(Collectors.toList());

        System.out.println(locationNames);

        //Stretcher!
        //SELECT depth FROM locations WHERE hasShipwreck = true
        //Then find the average depth of locations with a shipwreck

        double total = SeaLocation.locations.stream()
                .filter( e -> e.hasShipwreck )
                .mapToDouble(e -> e.depth)
                .sum();

        double length = SeaLocation.locations.stream()
                .filter( e -> e.hasShipwreck )
                .count();

        System.out.println(total/length);
    }
}
