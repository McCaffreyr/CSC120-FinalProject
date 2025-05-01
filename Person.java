import java.util.ArrayList;


public class Person {
    protected ArrayList<Item> inventory;
    protected int health; 
    protected int points; 
    protected Location currentLocation; 
    protected LocationMap map = new LocationMap(); 
    AudioPlayWav audio = new AudioPlayWav();

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

    public void setHealth(int h){
        this.health=h; 
    }

    /**
     * An accessor for the person's points
     * @return the number of points the person has
     */
    public int getPoints(){
        return points;
    }

    /**
     * An method that print's the person's inventory
     */
    public void checkInventory(){
        if (inventory.size() == 0){
            System.out.println("You have no items in your inventory");
        }else{
            System.out.println("-----------------Inventory---------------");
            for (int i = 0; i < inventory.size(); i++){
            System.out.println("-"+inventory.get(i).getName());
            }
            System.out.println("-----------------------------------------");
        }
        
        }
    
    /**
     * Checks if an item is in the inventory
     * @param item the item they want to know if it's in their inventory
     * @return T/F whether the item is in the person's inventory
     */
    public Boolean hasItem(Item item){
        return this.inventory.contains(item);
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
    public void move(Location place, Location libraryStairs, Item tangled, Item historyOf, Item dracula){
        if (map.get(currentLocation.name).contains(place.name)&& place!=libraryStairs){
            this.currentLocation = place;
            System.out.println("Currect location is now: " + place.name);
            this.points= this.getPoints()+1; 
        }else if(map.get(currentLocation.name).contains(place.name)&& place==libraryStairs){
            if(this.hasItem(dracula)==true && this.hasItem(historyOf)==true && this.hasItem(tangled)==true){
                System.out.println("You put the three books on a pedstal and the bookshlef pops open revealing a secret set of stairs! Huzzah! \n You enter and hear the librarian slam the secret door shut behind you. You try to open it again, but it's barricaded shut.");
                this.currentLocation = place;
                System.out.println("Currect location is now: " + place.name);
                this.points= this.getPoints()+4; 
            }else{
                System.out.println();
            }
        }
        
        else{
            System.out.println(place.name + " isn't connected to where you are.");
            System.out.println("The following rooms are connected: "); 
            System.out.println( map.get(this.currentLocation.name));
        }
    }

    /**
     * An accessor for the description of the person's current location
     * @return the description of the person's current location
     */
    public String lookAround(){
        return this.currentLocation.getDescription();
    }

    public void talk(NPC npc){
        if(npc.getLocation()==this.getLocation()){
            try{
                npc.talk(); 
                this.points= this.getPoints()+1;
            }catch(RuntimeException e){
                System.out.println(e.getLocalizedMessage());
            }
        }else{
            System.out.println("This person is not in"+ this.getLocation()+ " . You look silly talking to a wall.");
        }
    }

    //searchs bookshelves for book
    public void search(Item rapunzel, Item historyOf, Item dracula){
        if(this.getLocation().hasItem(rapunzel)){
            System.out.println("You found a book that might fit on one of the pedastals.");
            this.grab(rapunzel, this.getLocation()); 
        }else if(this.getLocation().hasItem(rapunzel)){
            System.out.println("You found a book that might fit on one of the pedastals.");
            this.grab(historyOf, this.getLocation());  
        }else if(this.getLocation().hasItem(rapunzel)){
            System.out.println("You found a book that might fit on one of the pedastals.");
            this.grab(historyOf, this.getLocation());
        }else{
            System.out.println("There are no intersting books in this section of the library...");
        }
    }

    public void fight(NPC npc, Item item){
        if(npc.isAttackable()==false){
            throw new RuntimeException("You cannot fight a fellow student! That would lead to automatic expulsion. Especially if you try and fight a fellow student with a weapon."); 

        }else if(this.getLocation()!= npc.getLocation()){
            
            throw new RuntimeException("You cannot fight someone who is not in the same room as you. You look quite silly attempting to fight no one."); 

        }else if(this.hasItem(item)==false){
            throw new RuntimeException("You cannot fight someone with a weapon you don't have."); 


        }else{
            try{
                item.use(npc, this); 
                this.points= this.getPoints()+3; 
            }catch (RuntimeException e){
                System.out.println(e.getLocalizedMessage());
            }
        }
        //health goes down a random number between 5-10

    }

    //with fist
    public void fight(NPC npc){
        if(npc.isAttackable()==false){
            throw new RuntimeException("You cannot fight a fellow student! That would lead to automatic expulsion."); 

        }else if(this.getLocation()== npc.getLocation()){
            System.out.println("You punch the "+ npc.getName());
            npc.beAttacked(2, this); 
            this.points=this.getPoints()+3;

        }else{
            throw new RuntimeException("You cannot fight someone who is not in the same room as you. You look quite silly swinging your fists at no one."); 
        }
        //health goes down a random number between 1-10
    }

    //gives desc of item
    public String lookAt(Item item){
        if(this.hasItem(item)){
            String desc = "The " +item.name + " is a " + item.description;
            return desc;
        }else if(this.getLocation()==item.getLocation()){
            String desc = "The " +item.name + " is " + item.description;
            return desc;
        }else{
            throw new RuntimeException("You must have the item in your inventory or be in the same room as an item to look at it!"); 
        }
        
    }

    /**
     * Adds an item to the person's inventory
     * @param item item that is being added to the inventory
     */
    public void grab(Item item, Location nullL){
        if (this.currentLocation== item.getLocation()){
            this.inventory.add(item);
            this.getLocation().removeItem(item);
            item.setLocation(nullL);
            System.out.println(item.getName()+ " grabbed!");
            this.points= this.getPoints()+2; 
        }else{
            throw new RuntimeException("This item is not in your current location. You can't grab something that is not there. duh."); 
        }
        
    }

    /**
     * Removes an item from the person's inventory
     * @param item item that is leaving the inventory
     */
    public void drop(Item item){
        if (this.hasItem(item)) {
            this.inventory.remove(item);
            item.setLocation(this.currentLocation);
            currentLocation.addItem(item);
            System.out.println(item.getName()+ " dropped!");
        }else{
            throw new RuntimeException("This item is not in your inventory. You can't drop something you don't have. duh."); 
        }
        
    }

    public Boolean isdead(){
        if (this.health<=0){
            audio.playAudio();
            System.out.println("You died! Whoops! You had "+ this.getPoints());
            return true; 
        }else{
            return false; 
        }
    }

    protected void save(NPC drainedstu){
        if(this.getLocation()==drainedstu.getLocation()){
            System.out.println("You are attempting to save "+ drainedstu.getName());

        }else{
            throw new RuntimeException("You cannot save a drained student you are not in the room with."); 
        }
    }

    public static void main(String[] args) {
        Location starterClassroom = new Location("Starter Classroom","desc", "desc2", true, null);
        Person Abby = new Person(starterClassroom);
        // Location Hallway3 = new Location("Hallway 3","desc",true);
        // Location Hallway7 = new Location("Hallway 7","desc",true);
        Abby.health = 0;
        System.out.println(Abby.isdead());


        // Item pencil = new Item("Pencil","sharp tool",starterClassroom,false);

      
        
        

        // Abby.move(Hallway3);
        // Abby.move(starterClassroom);
        // Abby.move(Hallway7);

    }

}