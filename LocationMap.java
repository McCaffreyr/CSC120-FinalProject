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
        locationMap.put("Hallway Twelve", new ArrayList<>(Arrays.asList("Hallway Eleven", "Library Room One")));

        locationMap.put("Library Room One", new ArrayList<>(Arrays.asList("Hallway Twelve", "Library Room Two", "Library Room Three")));
        locationMap.put("Library Room Two", new ArrayList<>(Arrays.asList("Library Room One", "Library Room Eight", "Cellar Stairs")));
        locationMap.put("Library Room Three", new ArrayList<>(Arrays.asList("Library Room One", "Library Room Four", "Library Room Six", "Library Room Seven")));
        locationMap.put("Library Room Four", new ArrayList<>(Arrays.asList("Library Room Three", "Library Room Five")));
        locationMap.put("Library Room Five", new ArrayList<>(Arrays.asList("Library Room Four")));
        locationMap.put("Library Room Six", new ArrayList<>(Arrays.asList("Library Room Three")));
        locationMap.put("Library Room Seven", new ArrayList<>(Arrays.asList("Library Room Three", "Library Room Eight")));
        locationMap.put("Library Room Eight", new ArrayList<>(Arrays.asList("Library Room Seven", "Library Room Two")));
        locationMap.put("Library Stairs", new ArrayList<>(Arrays.asList("Library Room Two", "Cellar Stairs")));

        locationMap.put("Cellar Stairs", new ArrayList<>(Arrays.asList("Library Stairs", "Cellar One")));
        locationMap.put("Cellar One", new ArrayList<>(Arrays.asList("Cellar Stairs", "Cellar Two", "Cellar Three")));
        locationMap.put("Cellar Two", new ArrayList<>(Arrays.asList("Cellar One", "Cellar Four", "Cellar Six")));
        locationMap.put("Cellar Three", new ArrayList<>(Arrays.asList("Cellar One", "Cellar Four", "Cellar Five")));
        locationMap.put("Cellar Four", new ArrayList<>(Arrays.asList("Cellar Two")));
        locationMap.put("Cellar Five", new ArrayList<>(Arrays.asList("Cellar Three")));
        locationMap.put("Cellar Six", new ArrayList<>(Arrays.asList("Cellar Two", "Cellar Seven", "Dungeon")));
        locationMap.put("Cellar Seven", new ArrayList<>(Arrays.asList("Cellar Six")));
        locationMap.put("Dungeon", new ArrayList<>(Arrays.asList("Cellar Six")));
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
        map.connectingL("Library Three");
        map.connectingL("Library Two");
        map.connectingL("Hallway Three");

        System.out.println(map.get("Library Three"));

    }
}
