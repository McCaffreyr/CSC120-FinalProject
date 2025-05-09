import java.util.ArrayList;


public class Person {
    protected ArrayList<Item> inventory;
    protected int health; 
    protected int points; 
    protected Location currentLocation; 
    protected LocationMap map = new LocationMap();
    protected boolean isDead; 
    AudioPlayWav audio = new AudioPlayWav();

    /**
     * Constructor for the Person class
     * @param cL the current location of the player
     */
    public Person(Location cL) {
        this.health = 40;
        this.points = 0;
        this.currentLocation= cL; 
        this.inventory = new ArrayList<>();
        this.isDead= false;  
    }

    /**
     * An accessor for the person's health
     * @return the health of the person
     */
    public int getHealth(){
        return health;
    }

    /**
     * A mutator method for the players health
     * @param h the new health of the player
     */
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

    /**
     * A mutator method for the players location
     * @param l the new location for the player
     */
    public void setLocation(Location l){
        this.currentLocation= l; 
    }

    /**
     * A method to change a person's current location. If the player is trying to move to the library stairs they must have the three required books.
     * @param place the place the person hopes to move to
     * @param libraryStairs the library stairs which has special requirements to move to 
     * @param tangled a book the player needs to move to the library stairs
     * @param historyOf a book the player needs to move to the library stairs
     * @param dracula a book the player needs to move to the library stairs
     */
    public void move(Location place, Location libraryStairs, Item tangled, Item historyOf, Item dracula){
        if (map.getAll(currentLocation.name).contains(place.name)&& place!=libraryStairs){
            this.currentLocation = place;
            System.out.println("Current location is now: " + place.name);
            this.points= this.getPoints()+1; 
        }else if(map.getAll(currentLocation.name).contains(place.name)&& place==libraryStairs){
            if(this.hasItem(dracula)==true && this.hasItem(historyOf)==true && this.hasItem(tangled)==true){
                System.out.println("You put the three books on a pedstal and the bookshlef pops open revealing a secret set of stairs! Huzzah! \n You enter and hear the librarian slam the secret door shut behind you. You try to open it again, but it's barricaded shut.");
                this.currentLocation = place;
                System.out.println("Currect location is now: " + place.name);
                this.points= this.getPoints()+4; 
            }else{
                System.out.println("You don't see any stairs to move too... just the same bookshelf with the three pedastals for books.");
            }
        }
        
        else{
            System.out.println(place.name + " isn't connected to where you are.");
            System.out.println("The following rooms are connected: "); 
            System.out.println( map.getAll(this.currentLocation.name));
        }
    }

    /**
     * An accessor for the description of the person's current location
     * @return the description of the person's current location
     */
    public String lookAround(){
        return this.currentLocation.getDescription();
    }

    /**
     * A method that calls the npc's talk methods
     * @param npc the npc to speak to
     */
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

    /**
     * This method lets the player search the shelves for the three critical books in the library
     * @param rapunzel one of the critical books
     * @param historyOf one of the critical books
     * @param dracula one of the critical books
     * @param nullL new location for the books once removed from the library room (null location)
     */
    public void search(Item rapunzel, Item historyOf, Item dracula, Location nullL){
        if(this.getLocation().getLocationItemsAndNPCS().contains(rapunzel)){
            System.out.println("You found a book that might fit on one of the pedastals.");
            this.grab(rapunzel, nullL); 
        }else if(this.getLocation().getLocationItemsAndNPCS().contains(historyOf)){
            System.out.println("You found a book that might fit on one of the pedastals.");
            this.grab(historyOf, nullL);  
        }else if(this.getLocation().getLocationItemsAndNPCS().contains(dracula)){
            System.out.println("You found a book that might fit on one of the pedastals.");
            this.grab(dracula, nullL);
        }else{
            System.out.println("There are no intersting books in this section of the library...");
        }
    }

    /**
     * This method has a player use a weapon against an NPC to fight them
     * @param npc the npc to be fought
     * @param item the item to figh the npc with
     */
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

    /**
     * This method has the player fight the given npc with the player's fist that does two damage 
     * @param npc the npc to be fought 
     */
    public void fight(NPC npc){
        if(npc.isAttackable()==false){
            throw new RuntimeException("You cannot fight a fellow student! That would lead to automatic expulsion."); 

        }else if(this.getLocation()== npc.getLocation()){
            System.out.println("You punch the "+ npc.getName()+". It does 2 damage!");
            npc.beAttacked(2, this); 
            this.points=this.getPoints()+3;

        }else{
            throw new RuntimeException("You cannot fight someone who is not in the same room as you. You look quite silly swinging your fists at no one."); 
        }
        //health goes down a random number between 1-10
    }

    /**
     * This method gets the description of the item the player has
     * @param item the item to get the description of 
     * @return a string of the item description
     */
    public String lookAt(Item item){
        if(this.hasItem(item)){
            String desc = item.name + ": " + item.description;
            return desc;
        }else if(this.getLocation()==item.getLocation()){
            String desc = item.name + ": " + item.description;
            return desc;
        }else{
            throw new RuntimeException("You must have the item in your inventory or be in the same room as an item to look at it!"); 
        }
        
    }

    /**
     * Adds an item to the person's inventory and changes the items location to a null location
     * @param item item that is being added to the inventory
     * @param nullL the null location to change the item's location to
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

    /**
     * an acessor method for the isDead boolean
     * @return T/F wether or not the player is dead
     */
    public boolean getIsDead(){
        return this.isDead; 
    }

    /**
     * This method checks to see if the players health is less than or equal to zero. If it is the scary audio plays and the isDead boolean is set to true.
     * @return T/F wether or not this player is dead
     */
    public Boolean isDead(){
        if (this.health<=0){
            this.isDead=true; 
            AudioPlayWav.playAudio();
            System.out.println("You died! Whoops! You had "+ this.getPoints()+ " points.");
            return true; 
        }else{
            return false; 
        }
    }


    /**
     * This method calls the beSaved method on the drained students and prints out messages for players.
     * @param drainedstu the drained student to be saved
     */
    protected void save(NPC drainedstu){
        if(this.getLocation()==drainedstu.getLocation()){
            System.out.println("You are attempting to save "+ drainedstu.getName());
            drainedstu.beSaved(); 

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
        System.out.println(Abby.isDead());


        // Item pencil = new Item("Pencil","sharp tool",starterClassroom,false);

      
        
        

        // Abby.move(Hallway3);
        // Abby.move(starterClassroom);
        // Abby.move(Hallway7);

    }

}