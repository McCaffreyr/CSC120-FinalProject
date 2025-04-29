import java.util.ArrayList;
public class Location {

    String name; 
    String description; 
    boolean hasItem; 
    ArrayList<Item> locationItems; 
    ArrayList<NPC> npcList; 

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
        this.npcList= new ArrayList<NPC>(); 
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
    public Boolean hasItem(Item i){
       if(this.locationItems.contains(i)){
        return true; 
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
    /**
     * This adds an NPC to the location's NPC List.
     * @param n the NPC to be added to the location
     */
    public void addNPC(NPC n){
        this.npcList.add(n); 
    }
    /**
     * This removes an NPC from the location's NPC list.
     * @param n the NPC to be removed from the location.
     */
    public void removeNPC(NPC n){
        this.npcList.remove(n); 
    }

    public static void main(String[] args) {
        Location school = new Location("school", "school desc", true);
        System.out.println(school.getDescription());

        // Location bioLab = new Location("Bio Lab", "You enter a biology lab with shiny gray counter tops. It looks like a class was just in here. Small beakers sit on the drying rack next to the sink. In the corner is a beaker with a solution still inside..."
        // , true);
        // Location chemLab = new Location("Chem Lab", "desc", 
        // true);
        // Location cafe = new Location("Cafe", "This is the school's cafeteria. Dozens of long tables sit in organized rows. Near the front of the room is a kitchen. What could be back there?"
        // , true);
        // Location englishRoom = new Location("English Room", "english room desc", true);
        // Location gym = new Location("Gym", "gym desc", true);
        // Location historyRoom = new Location("History Room", "desc", true);
        // Location mathRoom = new Location("Math Room", "desc", true);
        // Location studyRoom = new Location("Study Room", "desc", true);

    }
}
