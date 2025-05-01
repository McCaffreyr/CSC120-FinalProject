
import java.util.HashMap;
public class LocationMap {

    HashMap<String, String[]> locationMap = new HashMap<>();
    
    LocationMap(){
        locationMap = this.locationMap;
        locationMap.put("Gym", new String[] {"Hallway One"});
        locationMap.put("Study Room", new String[] {"Hallway One"});
        locationMap.put("Home Room", new String[] {"Hallway Three"});
        locationMap.put("Chem Lab", new String[] {"Hallway Eight"});
        locationMap.put("Bio Lab", new String[] {"Hallway Eight"});
        locationMap.put("Math Room", new String[] {"Hallway Seven"});
        locationMap.put("English Room", new String[] {"Hallway Six"});
        locationMap.put("History Room", new String[] {"Hallway Six"});
        locationMap.put("Library", new String[] {"Hallway Twelve"});
        locationMap.put("Cafe", new String[] {"Hallway Nine", "Hallway Ten"});

        locationMap.put("Hallway One", new String[] {"Study Room", "Gym", "Hallway Two"});
        locationMap.put("Hallway Two", new String[] {"Hallway One", "Hallway Three"});
        locationMap.put("Hallway Three", new String[] {"Hallway Two", "Hallway Five", "Home Room"});
        locationMap.put("Hallway Five", new String[] {"Hallway Three", "Hallway Six"});
        locationMap.put("Hallway Six", new String[] {"Hallway Five", "Hallway Seven", "English Room", "History Room"});
        locationMap.put("Hallway Seven", new String[] {"Hallway Six", "Hallway Eight", "Math Room"});
        locationMap.put("Hallway Eight", new String[] {"Hallway Seven", "Hallway Nine", "Chem Lab", "Bio Lab"});
        locationMap.put("Hallway Nine", new String[] {"Hallway Eight", "Hallway Ten", "Cafe"});
        locationMap.put("Hallway Ten", new String[] {"Hallway Nine", "Hallway Eleven", "Cafe"});
        locationMap.put("Hallway Eleven", new String[] {"Hallway Ten", "Hallway Twelve"});
        locationMap.put("Hallway Twelve", new String[] {"Hallway Eleven", "Library Room One"});

        locationMap.put("Library Room One", new String[] {"Library Room Two", "Library Room Three"});
        locationMap.put("Library Room Two", new String[] {"Library Room One", "Library Room Eight", "Library Stairs"});
        locationMap.put("Library Room Three", new String[] {"Library Room One", "Library Room Four", "Library Room Six", "Library Room Seven"});
        locationMap.put("Library Room Four", new String[] {"Library Room Three", "Library Room Five"});
        locationMap.put("Library Room Five", new String[] {"Library Room Four"});
        locationMap.put("Library Room Six", new String[] {"Library Room Three"});
        locationMap.put("Library Room Seven", new String[] {"Library Room Three", "Library Room Eight"});
        locationMap.put("Library Room Eight", new String[] {"Library Room Seven", "Library Room Two"});
        locationMap.put("Library Stairs", new String[] {"Library Room Two", "Cellar Stairs"});

        locationMap.put("Cellar Stairs", new String[] { "Cellar Room One"});
        locationMap.put("Cellar Room One", new String[] {"Cellar Stairs", "Cellar Room Two", "Cellar Room Three"});
        locationMap.put("Cellar Room Two", new String[] {"Cellar Room One", "Cellar Room Four", "Cellar Room Six"});
        locationMap.put("Cellar Room Three", new String[] {"Cellar One", "Cellar Four", "Cellar Five"});
        locationMap.put("Cellar Room Four", new String[] {"Cellar Room Two"});
        locationMap.put("Cellar Room Five", new String[] {"Cellar Room Three"});
        locationMap.put("Cellar Room Six", new String[] {"Cellar Room Two", "Cellar Room Seven", "Dungeon"});
        locationMap.put("Cellar Room Seven", new String[] {"Cellar Room Six"});
        locationMap.put("Dungeon", new String[] {"Cellar Room Six"});
    }

    /**
     * Prints out the locations connected to a location
     * @param place takes in a String location
     */
    public void connectingL(String place){
        if (locationMap.keySet().contains(place)){
            String[] connectingrooms = locationMap.get(place);
            String finalList = "";
            for (String connection : connectingrooms) {
                finalList += connection + ", ";
            }
            System.out.println(place + " connects to: " + finalList);
        }else{
            System.out.println("That place doesn't exist. Try something else.");
        }
    }

    public String get(String place){
        String[] connectingrooms = locationMap.get(place);
        String allPlaces = "";
        for (String connection : connectingrooms) {
            allPlaces += connection + ", ";
        }
        return allPlaces;
    }
    
    public static void main(String[] args) {
        LocationMap map = new LocationMap();
        map.connectingL("Library Room Three");
        map.connectingL("Library Room Two");
        map.connectingL("Hallway Three");

        System.out.println(map.get("Library Room Three"));

    }

    public String[] keySet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keySet'");
    }
}
