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
     * an acessor for the item's name
     * @return a string of the item's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * an acessor method for the item's description
     * @return the description for the item 
     */
    public String getDescription(){
        return this.description; 
    }

    /**
     * an acessor for the item's location
     * @return the item's location
     */
    public Location getLocation(){
        if(this.inInventory== false){
            return this.getLocation();
        }else{
            throw new RuntimeException("This item is in your inventory! It moves with you! It was found at "+ this.getLocation()); 

        }

    }

    /**
     * an acessor for the item's boolean attribute "inInventory"
     * @return T/F wether the item is in the player's inventory 
     */
    public boolean inInventory(){
        return this.inInventory; 
    }

    /**
     * an mutator method for the location attribute of an item 
     * @param l the location for the item to be at. 
     */
    public void setLocation(Location l){
        this.currentLocation=l; 
    }

}
