import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map; 
public class Location {

    String name; 
    String description; 
    boolean hasItem; 
    ArrayList<Item> locationItems; 
    public static HashMap<String, ArrayList> locationMap = new HashMap<>();


    /**
     * A constuctor for a Location
     * @param n the name of the location
     * @param d the description of the location
     * @param hI T/F wether the location contains and item. 
     */
    Location(String n, String d, boolean hI){
        this.name=n; 
        this.description=d; 
        this.hasItem= hI; 
        this.locationItems= new ArrayList<Item>();
    } 
    
    public void addLocationMap() {
        locationMap.put("Gym", new ArrayList<>(Arrays.asList("Hallway 1")));
        locationMap.put("Study", new ArrayList<>(Arrays.asList("Hallway 1")));
        locationMap.put("Starter Classroom", new ArrayList<>(Arrays.asList("Hallway 3")));
        locationMap.put("Chem Lab", new ArrayList<>(Arrays.asList("Hallway 8")));
        locationMap.put("Bio Lab", new ArrayList<>(Arrays.asList("Hallway 8")));
        locationMap.put("Math Room", new ArrayList<>(Arrays.asList("Hallway 7")));
        locationMap.put("English Room", new ArrayList<>(Arrays.asList("Hallway 6")));
        locationMap.put("History Room", new ArrayList<>(Arrays.asList("Hallway 6")));
        locationMap.put("Library", new ArrayList<>(Arrays.asList("Hallway 12")));
        locationMap.put("Cafeteria", new ArrayList<>(Arrays.asList("Hallway 9", "Hallway 10")));

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
    

    /**
     * An accessor for the name of the location
     * @return a string with the name of the location
     */
    public String getName(){
        return this.getName(); 
    }

    /**
     * an accessor for the description of the location
     * @return a string with the description of the location
     */
    public String getDescription(){
        return this.getDescription(); 
    }
    
    /**
     * an accessor method for whether the Location has an item in it or not
     * @return T/F wether the location contains at least one item. 
     */
    public Item getItem(Item i){
       if(this.locationItems.contains(i)){
        return i; 
       }else{
        throw new RuntimeException("This Item is not present at your current location."); 
       }
    }

    /**
     * This adds an item to the location's array list of items
     * @param i the item to be added to the location
     */
    public void addItem(Item i){
        this.locationItems.add(i); 
    }

    /**
     * This removes an item from the location's array list of items 
     * @param i the item to be removed from the array list of items
     */
    public void removeItem(Item i){
        this.locationItems.remove(i); 
    }

    public static void main(String[] args) {
        Location school = new Location("school", "school desc", true);
        school.addLocationMap();
        //System.out.println(locationMap);
        System.out.println(locationMap.size());
    }
}
