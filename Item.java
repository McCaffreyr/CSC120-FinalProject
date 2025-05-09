public class Item {
    
    protected String name; 
    protected String description; 
    protected Location currentLocation; 
    protected boolean inInventory; 

    /**
     * The constructor for the Item class
     * @param n the name of the item
     * @param d a description of the item
     * @param cL the items current location
     * @param iI if the item is currently located in the inventory or not. 
     */
    Item(String n, String d, Location cL, boolean iI){
        this.name= n; 
        this.description=d; 
        this.currentLocation= cL; 
        this.inInventory= iI; 
    }

    /**
     * an accessor for the item's name
     * @return a string of the item's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * an accessor method for the item's description
     * @return the description for the item 
     */
    public String getDescription(){
        return this.description; 
    }

    /**
     * an accessor for the item's location
     * @return the item's location
     */
    public Location getLocation(){
        return this.currentLocation; 
    }

    /**
     * an accessor for the item's boolean attribute "inInventory"
     * @return T/F wether the item is in the player's inventory 
     */
    public boolean inInventory(){
        return this.inInventory; 
    }

    /**
     * a mutator method for the location attribute of an item 
     * @param l the location for the item to be at. 
     */
    public void setLocation(Location l){
        this.currentLocation=l; 
    }

    /**
     * This method is a filler method so that the use method can be used on any item type when it really only needs to be used on weapons.
     * @param target the target to use the item on
     * @param player the player to use the item
     */
    public void use(NPC target, Person player){
        System.out.println("Error message this should never appear in game!");
    }

    /**
     * a toString method that sets it so when an item is printed it prints out the name
     * @return a string of the name of the item
     */
    public String toString(){
        return this.getName(); 
    }

}
