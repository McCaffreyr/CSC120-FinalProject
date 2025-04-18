public class Item {
    String name; 
    String description; 
    Location currentLocation; 
    boolean inInventory; 

    Item(String n, String d, Location cL, boolean iI){
        this.name= n; 
        this.description=d; 
        this.currentLocation= cL; 
        this.inInventory= iI; 
    }
}
