import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class LocationMap {

    public static HashMap<String, ArrayList> locationMap = new HashMap<>();
    
    static{
        locationMap.put("Gym", new ArrayList<>(Arrays.asList("Hallway 1")));
        locationMap.put("Study", new ArrayList<>(Arrays.asList("Hallway 1")));
        locationMap.put("Starter Classroom", new ArrayList<>(Arrays.asList("Hallway 3")));
        locationMap.put("Chem Lab", new ArrayList<>(Arrays.asList("Hallway 8")));
        locationMap.put("Bio Lab", new ArrayList<>(Arrays.asList("Hallway 8")));
        locationMap.put("Math Room", new ArrayList<>(Arrays.asList("Hallway 7")));
        locationMap.put("English Room", new ArrayList<>(Arrays.asList("Hallway 6")));
        locationMap.put("History Room", new ArrayList<>(Arrays.asList("Hallway 6")));
        locationMap.put("Library", new ArrayList<>(Arrays.asList("Hallway 12")));
        locationMap.put("Cafe", new ArrayList<>(Arrays.asList("Hallway 9", "Hallway 10")));

        locationMap.put("Hallway 1", new ArrayList<>(Arrays.asList("Study", "Gym", "Hallway 2")));
        locationMap.put("Hallway 2", new ArrayList<>(Arrays.asList("Hallway 1", "Hallway 3")));
        locationMap.put("Hallway 3", new ArrayList<>(Arrays.asList("Hallway 2", "Hallway 4", "Hallway 5", "Starter Classroom")));
        locationMap.put("Hallway 4", new ArrayList<>(Arrays.asList("Hallway 3")));
        locationMap.put("Hallway 5", new ArrayList<>(Arrays.asList("Hallway 3", "Hallway 6")));
        locationMap.put("Hallway 6", new ArrayList<>(Arrays.asList("Hallway 5", "Hallway 7", "English Room", "History Room")));
        locationMap.put("Hallway 7", new ArrayList<>(Arrays.asList("Hallway 6", "Hallway 8", "Math Room")));
        locationMap.put("Hallway 8", new ArrayList<>(Arrays.asList("Hallway 7", "Hallway 9", "Chem Lab", "Bio Lab")));
        locationMap.put("Hallway 9", new ArrayList<>(Arrays.asList("Hallway 8", "Hallway 10", "Cafe")));
        locationMap.put("Hallway 10", new ArrayList<>(Arrays.asList("Hallway 9", "Hallway 11", "Cafe")));
        locationMap.put("Hallway 11", new ArrayList<>(Arrays.asList("Hallway 10", "Hallway 12")));
        locationMap.put("Hallway 12", new ArrayList<>(Arrays.asList("Hallway 11", "Library 1")));

        locationMap.put("Library 1", new ArrayList<>(Arrays.asList("Hallway 12", "Library 2", "Library 3")));
        locationMap.put("Library 2", new ArrayList<>(Arrays.asList("Library 1", "Library 8", "Cellar Stairs")));
        locationMap.put("Library 3", new ArrayList<>(Arrays.asList("Library 1", "Library 4", "Library 6", "Library 7")));
        locationMap.put("Library 4", new ArrayList<>(Arrays.asList("Library 3", "Library 5")));
        locationMap.put("Library 5", new ArrayList<>(Arrays.asList("Library 4")));
        locationMap.put("Library 6", new ArrayList<>(Arrays.asList("Library 3")));
        locationMap.put("Library 7", new ArrayList<>(Arrays.asList("Library 3", "Library 8")));
        locationMap.put("Library 8", new ArrayList<>(Arrays.asList("Library 7", "Library 2")));
        locationMap.put("Cellar Stairs", new ArrayList<>(Arrays.asList("Library 2")));
    }

    public static void connectingL(String place){
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
    
    public static void main(String[] args) {
        LocationMap.connectingL("Library 3");
        LocationMap.connectingL("Library 2");
        LocationMap.connectingL("Hallway 3");

    }
}
