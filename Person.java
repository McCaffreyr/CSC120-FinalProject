import java.util.ArrayList;

public class Person {
    protected ArrayList<Item> inventory;
    protected int health; 
    protected int points; 
    protected Location currentLocation; 
    protected LocationMap map = new LocationMap(); 

    /**
     * Constructor for the Person class
     */
    public Person(Location sL) {
        this.health = 20;
        this.points = 0;
        this.currentLocation= sL; 
        this.inventory = new ArrayList<>(); 
    }

    /**
     * An accessor for the person's health
     * @return the health of the person
     */
    public int getHealth(){
        return health;
    }

    /**
     * An accessor for the person's points
     * @return the number of points the person has
     */
    public int getPoints(){
        return points;
    }

    /**
     * An accessor for the person's inventory
     * @return the items in the inventory
     */
    public String checkInventory(){
        String inven = "";
        if (inventory.size() == 0){
            return ("No items in inventory");
        } for (int i = 0; i < inventory.size(); i++){
            inven += inventory.get(i).name;
        }
        return inven;
        }
    
    /**
     * Checks if an item is in the inventory
     * @param item the item they want to know if it's in their inventory
     * @return T/F whether the item is in the person's inventory
     */
    public Boolean hasItem(Item item){
        return inventory.contains(item);
    }

    /**
     * An accessor for the person's location
     * @return the person's current location
     */
    public Location getLocation(){
        return currentLocation;
    }

    //just for testing
    public void setLocation(Location l){
        this.currentLocation= l; 
    }

    /**
     * A method to change a person's current location
     * @param place the place the person hopes to move to
     */
    public void move(Location place){
        if (map.get(currentLocation.name).contains(place.name)){
            currentLocation = place;
            System.out.println("Currect location is now: " + place.name);
        } else{
            System.out.println(place.name + " isn't connected to where you are.");
            System.out.println("The following rooms are connected: " + map.get(currentLocation.name));
        }
    }

    /**
     * An accessor for the description of the person's current location
     * @return the description of the person's current location
     */
    public String lookAround(){
        return currentLocation.description;
    }

    public void talk(NPC npc){
    }

    //searchs bookshelves for book
    //FIXXXXXX
    public String search(){
        return "books!";
    }

    public void fight(NPC npc, Item item){
        //health goes down a random number between 5-10

    }

    //with fist
    public void fight(NPC npc){
        //health goes down a random number between 1-10
    }

    //gives desc of item
    public String lookAt(Item item){
        String desc = item.name + ", " + item.description;
        return desc;
    }

    /**
     * Adds an item to the person's inventory
     * @param item item that is being added to the inventory
     */
    public void grab(Item item){
        if (this.currentLocation== item.getLocation()){
            inventory.add(item);
            System.out.println(item.getName()+ " grabbed");
        }else{
            throw new RuntimeException("This item is not in your current location. You can't grab something that is not there. duh."); 
        }
        
    }

    /**
     * Removes an item from the person's inventory
     * @param item item that is leaving the inventory
     */
    public void drop(Item item){
        inventory.remove(item);
    }

    protected void save(DrainedStudent drainedstu){
    }

    public static void main(String[] args) {
        Location starterClassroom = new Location("Starter Classroom","desc",true);
        Person Abby = new Person(starterClassroom);
        Location Hallway3 = new Location("Hallway 3","desc",true);
        Location Hallway7 = new Location("Hallway 7","desc",true);


        Item pencil = new Item("Pencil","sharp tool",starterClassroom,false);

        System.out.println(Abby.checkInventory());
        Abby.grab(pencil);
        System.out.println(Abby.checkInventory());

        Abby.move(Hallway3);
        Abby.move(starterClassroom);
        Abby.move(Hallway7);

    }

}