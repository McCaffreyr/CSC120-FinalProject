public class NPC {
    String name; 
    String description; 
    Location currentLocation; 
    int health; 
    Boolean attackable; 

    /**
     * A constructor for an NPC
     * @param n the name of the NPC
     * @param d the visual description of the NPC 
     * @param cL the current location of the NPC
     * @param h the current health points of the NPC
     * @param a T/F whether the player can attack this NPC 
     */
    NPC(String n, String d, Location cL, int h, Boolean a){
        this.name=n; 
        this.description=d; 
        this.currentLocation= cL; 
        this.health= h; 
        this.attackable= a; 
    }

    /**
     * This is an acessor for the name of the NPC
     * @return a String which is the name of the NPC 
     */
    public String getName(){
        return this.name;
    }

    /**
     * This is an acessor for the visual description of the NPC
     * @return a string with the description of the NPC
     */
    public String getDescription(){
        return this.description; 
    }

    /**
     * an acessor for the current location of the NPC
     * @return the current Location of the NPC 
     */
    public Location getLocation(){
        return this.currentLocation; 
    }

    /**
     * A mutator method for the current location of the NPC 
     * @param l the location the NPC is moved too 
     */
    public void setCurrentLocation(Location l){
        this.currentLocation= l; 
    }

    /**
     * an acessor for the health of the NPC
     * @return an int of the NPC's health
     */
    public int getHealth(){
        return this.health; 
    }

    /**
     * An mutator for the health of the NPC
     * @param n the int of health you want the NPC to have 
     */
    public void setHealth(int n){
        this.health= n; 
    }

    /**
     * A acessor for the attackable boolean of the NPC 
     * @return T/F wether or not the NPC is attackable
     */
    public Boolean isAttackable(){
        return this.attackable; 
    }

    
}
