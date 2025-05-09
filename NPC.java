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
     * This is an accessor for the name of the NPC
     * @return a String which is the name of the NPC 
     */
    public String getName(){
        return this.name;
    }

    /**
     * This is an accessor for the visual description of the NPC
     * @return a string with the description of the NPC
     */
    public String getDescription(){
        return this.description; 
    }

    /**
     * an accessor for the current location of the NPC
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
     * A accessor for the attackable boolean of the NPC 
     * @return T/F wether or not the NPC is attackable
     */
    public Boolean isAttackable(){
        return this.attackable; 
    }

    /**
     * A stand in for the fight method which is usable in the hall monitor, teacher, librarian, or science teacher classes
     * @param p the player to be fought
     */
    public void fight(Person p){
        System.out.println("Error this message should not appear in game.");
    }

    /**
     * This prints out the player that talks names and a : to set up the first part of the players speech.
     */
    public void talk(){
        System.out.print(this.getName()+ ": "); 
    }

    /**
     * Thie method is a stand in for the be attacked method which is usable in some child classes.
     * @param nHPLoss the health to be lost
     * @param p the player to attack the NPC
     */
    public void beAttacked(int nHPLoss, Person p){
        System.out.println("Error this message should not appear in game"); 
    }

    /**
     * A to string method that changes the print output to the name of the NPC
     * @return a string of the NPC's name
     */
    public String toString(){
        return this.getName(); 
    }

    /**
     * This is a stand in method for the beSaved method which is usable in the drained student class.
     */
    public void beSaved(){
        System.out.println("Error this message should not appear in game");
    }

    
}
