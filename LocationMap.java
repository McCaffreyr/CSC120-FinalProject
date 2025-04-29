import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class LocationMap {

    HashMap<String, ArrayList> locationMap = new HashMap<>();
    
    LocationMap(){
        locationMap = this.locationMap;
        locationMap.put("Gym", new ArrayList<>(Arrays.asList("Hallway One")));
        locationMap.put("Study Room", new ArrayList<>(Arrays.asList("Hallway One")));
        locationMap.put("Home Room", new ArrayList<>(Arrays.asList("Hallway Three")));
        locationMap.put("Chem Lab", new ArrayList<>(Arrays.asList("Hallway Eight")));
        locationMap.put("Bio Lab", new ArrayList<>(Arrays.asList("Hallway Eight")));
        locationMap.put("Math Room", new ArrayList<>(Arrays.asList("Hallway Seven")));
        locationMap.put("English Room", new ArrayList<>(Arrays.asList("Hallway Six")));
        locationMap.put("History Room", new ArrayList<>(Arrays.asList("Hallway Six")));
        locationMap.put("Library", new ArrayList<>(Arrays.asList("Hallway Twelve")));
        locationMap.put("Cafe", new ArrayList<>(Arrays.asList("Hallway Nine", "Hallway Ten")));

        locationMap.put("Hallway One", new ArrayList<>(Arrays.asList("Study", "Gym", "Hallway Two")));
        locationMap.put("Hallway Two", new ArrayList<>(Arrays.asList("Hallway One", "Hallway Three")));
        locationMap.put("Hallway Three", new ArrayList<>(Arrays.asList("Hallway Two", "Hallway Five", "Home Room")));
        locationMap.put("Hallway Five", new ArrayList<>(Arrays.asList("Hallway Three", "Hallway Six")));
        locationMap.put("Hallway Six", new ArrayList<>(Arrays.asList("Hallway Five", "Hallway Seven", "English Room", "History Room")));
        locationMap.put("Hallway Seven", new ArrayList<>(Arrays.asList("Hallway Six", "Hallway Eight", "Math Room")));
        locationMap.put("Hallway Eight", new ArrayList<>(Arrays.asList("Hallway Seven", "Hallway Nine", "Chem Lab", "Bio Lab")));
        locationMap.put("Hallway Nine", new ArrayList<>(Arrays.asList("Hallway Eight", "Hallway Ten", "Cafe")));
        locationMap.put("Hallway Ten", new ArrayList<>(Arrays.asList("Hallway Nine", "Hallway Eleven", "Cafe")));
        locationMap.put("Hallway Eleven", new ArrayList<>(Arrays.asList("Hallway Ten", "Hallway Twelve")));
        locationMap.put("Hallway Twelve", new ArrayList<>(Arrays.asList("Hallway Eleven", "Library One")));

        locationMap.put("Library One", new ArrayList<>(Arrays.asList("Hallway Twelve", "Library Two", "Library Three")));
        locationMap.put("Library Two", new ArrayList<>(Arrays.asList("Library One", "Library Eight", "Cellar Stairs")));
        locationMap.put("Library Three", new ArrayList<>(Arrays.asList("Library One", "Library Four", "Library Six", "Library Seven")));
        locationMap.put("Library Four", new ArrayList<>(Arrays.asList("Library Three", "Library Five")));
        locationMap.put("Library Five", new ArrayList<>(Arrays.asList("Library Four")));
        locationMap.put("Library Six", new ArrayList<>(Arrays.asList("Library Three")));
        locationMap.put("Library Seven", new ArrayList<>(Arrays.asList("Library Three", "Library Eight")));
        locationMap.put("Library Eight", new ArrayList<>(Arrays.asList("Library Seven", "Library Two")));
        locationMap.put("Cellar Stairs", new ArrayList<>(Arrays.asList("Library Two")));
    }

    /**
     * Prints out the locations connected to a location
     * @param place takes in a location
     */
    public void connectingL(String place){
        if (locationMap.keySet().contains(place)){
            ArrayList connectingrooms = locationMap.get(place);
            String finallist = "";
            for (int i = 0; i < connectingrooms.size(); i++) {
                finallist += connectingrooms.get(i) + ", ";
            }
            System.out.println(place + " connects to: " + finallist);
        }else{
            System.out.println("That place doesn't exist. Try something else.");
        }
    }

    public ArrayList get(String place){
        return locationMap.get(place);
    }
    
    public static void main(String[] args) {
        LocationMap map = new LocationMap();
        map.connectingL("Library 3");
        map.connectingL("Library 2");
        map.connectingL("Hallway 3");

        System.out.println(map.get("Library 3"));

    }
}
