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

    /**
     * A constuctor for a Location
     * @param n the name of the location
     * @param d the description of the location
     * @param hI T/F wether the location contains and item. 
     */
    Location(String n, String d, boolean hI){
        this.name = n; 
        this.description = d; 
        this.hasItem = hI; 
        this.locationItems = new ArrayList<Item>();
    } 

    /**
     * An accessor for the name of the location
     * @return a string with the name of the location
     */
    public String getName(){
        return this.name; 
    }

    /**
     * an accessor for the description of the location
     * @return a string with the description of the location
     */
    public String getDescription(){
        return this.description; 
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
        System.out.println(school.getDescription());
    }
}
