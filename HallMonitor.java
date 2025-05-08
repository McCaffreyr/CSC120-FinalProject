
import java.util.Random;

public class HallMonitor extends Teacher{
    Random random = new Random();
    LocationMap map = new LocationMap();
    Boolean isAlive; 
    
    /**
     * A constructor for a hall monitor.
     * @param n name of the hall monitor.
     * @param d A physical description of the hall monitor.
     * @param cL The current Location of the hall monitor.
     * @param h The health of the hall monitor.
     */
    HallMonitor(String n, String d, Location cL, int h) {
        super(n, d, cL, h);
        this.isAlive=true; 
    }

    /**
     * a mutator method for the health of the hall monitor
     * @param h the new hwalth of the hall monitor
     */
    public void setHealth(int h){
        this.health= h; 
    }

    /**
     * An accessor method for the is alive attribute
     * @return T/F wether this hall monitor is alive
     */
    public Boolean isAlive(){
        return this.isAlive; 
    }

    /**
     * This method finds an adjacent room of the current location of the hall monitor for the hall monitor to move to.
     * @return The String name of the location for the hall monitor to move to 
     */
    public String nextMove( ){
        if(isAlive){
            String options = this.map.getAll(this.currentLocation.name);
            String[] options2 = options.split(", ");
            int randomNum = random.nextInt(options2.length); 
            String newloc = options2[randomNum];
            if(newloc.equals("Library Room One")){
                newloc= "Hallway Three"; 
            }
            return newloc;
        } else{
            return "null location";
        }
    }

    /**
     * This method removes the hall monitor from their old location, move them to their new location, and then run post move checks.
     * @param l the location for the hall monitor to move to 
     * @param player the player needed for post move checks.
     */
    public void move(Location l, Person player){
        //
        this.getLocation().removeNPC(this); 
        this.setCurrentLocation(l);
        l.addNPC(this); 
        this.postMoveChecks(player);
    }

    /**
     * This method checks to make sure that this hall monitor is still alive and also checks to see if the player is in the same room as the hall monitor.
     * @param player the player to check for in the location of the hall monitor
     */
    public void postMoveChecks(Person player){
        if(isAlive){
            this.checkLocationForPlayer(player);
            this.checkAlive();
        }
    }



    /**
     * This method lowers the health of the hall monitor and checks to see if the hall monitor is still alive.
     * @param the damage done to the hall monitor 
     * @param p the player that attacks the hall monitor
     */
    public void beAttacked(int nHPLoss, Person p){
        if(this.isAlive){
            this.health=this.getHealth()-nHPLoss;
            this.checkAlive();
        }else{
            throw new RuntimeException("You cannot fight a dead man."); 
        }
    }

    /**
     * This method checks to see if the player and the hall monitor are in the same location. If they are the hall monitor fights the player and talks to them.
     * @param p the player to check the location of
     */
    public void checkLocationForPlayer(Person p){
        if(this.getLocation()==p.getLocation()){
            System.out.println(this.getName()+" has entered the room your in! Watch out!");
            this.fight(p); 
            super.talk(); 
            System.out.println("");
        }
    }


    /**
     * This method checks if the hall monitor if their health is greater than zero. If it sets the isAlive boolean to false and prints out a message to the user.
     */
    public void checkAlive(){
        if(health<=0){
            System.out.println(this.getName()+ " has died! A body lying around the school defintely won't be weird at all!");
            this.isAlive=false; 
        }
    }

    /**
     * This method has the hall monitor fight the player; lowering the players health and printing out messages for the player.
     * @param p the player to be fought by the hall monitor
     */
    public void fight(Person p){
        System.out.println(this.getName()+ " attacks you with a wooden ruler. That's gonna leave a bruise.");
        p.setHealth(p.getHealth()-2);
        System.out.println("Your health is now "+p.getHealth());
        System.out.println("");
    }
    
    public static void main(String[] args) {
        // Location HallwayThree = new Location("Hallway Three", "desc", "desc w/key items", false, null);
        // HallMonitor Bob = new HallMonitor("Bob", "desc", HallwayThree);
        // Person testingP= new Person(HallwayThree); 
        // System.out.println(Bob.nextMove());
    }

}