import java.util.ArrayList;

public class Person {
    public ArrayList<Item> inventory;
    public int health = 100;
    public int points = 0;
    Location starterClassroom = new Location("starter classroom","desc",true);
    Location currentLocation = starterClassroom;

    public Person(int health, int points) {
        this.health = health;
        this.points = points;
        this.inventory = new ArrayList<>(); 
    }

    public int getHealth(){
        return health;
    }

    public int getPoints(){
        return points;
    }

    public String checkInventory(){
        String inven = "";
        if (inventory.size() == 0){
            return ("No items in inventory");
        } for (int i = 0; i < inventory.size(); i++){
            inven += inventory.get(i).name;
        }
        return inven;
        }
    
    public Boolean hasItem(Item item){
        return inventory.contains(item);
    }

    public Location getLocation(){
        return currentLocation;
    }

    public void move(Location place){
        System.out.println(locationMap.get(place));
    }

    public String lookAround(){
        return currentLocation.description;
    }

    //uses NPCs who are in the current location
    public void talk(NPC npc){
        //give random response
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

    public void pickUp(Item item){
        inventory.add(item);
    }

    public void drop(Item item){
        inventory.remove(item);
    }

    //unlocked once stage 3 reached
    protected void save(DrainedStudent drainedstu){
    }

    public static void main(String[] args) {
        Person Abby = new Person(100,0);
        Location Starterclassroom = new Location("starter classroom","desc",true);
        Item pencil = new Item("Pencil","sharp tool",Starterclassroom,false);

        System.out.println(Abby.checkInventory());
        Abby.pickUp(pencil);
        System.out.println(Abby.checkInventory());

    }

}