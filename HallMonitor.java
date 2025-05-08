
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
     * @param a the attackability of the hall monitor.
     */
    HallMonitor(String n, String d, Location cL, int h) {
        super(n, d, cL, h);
        this.isAlive=true; 
    }

    //just for testing
    public void setHealth(int h){
        this.health= h; 
    }
    public Boolean isAlive(){
        return this.isAlive; 
    }

    public String nextMove( ){
        if(isAlive){
            String options = this.map.get(this.currentLocation.name);
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

    public void move(Location l, Person player){
        //
        this.getLocation().removeNPC(this); 
        this.setCurrentLocation(l);
        l.addNPC(this); 
        this.postMoveChecks(player);
    }

    public void postMoveChecks(Person player){
        if(isAlive){
            this.checkLocationForPlayer(player);
            this.checkAlive();
        }
    }



    public void beAttacked(int nHPLoss, Person p){
        if(this.isAlive){
            this.health=this.getHealth()-nHPLoss;
            this.checkAlive();
        }else{
            throw new RuntimeException("You cannot fight a dead man."); 
        }
    }

    public void checkLocationForPlayer(Person p){
        if(this.getLocation()==p.getLocation()){
            System.out.println(this.getName()+" has entered the room your in! Watch out!");
            this.fight(p); 
            super.talk(); 
            System.out.println("");
        }
    }

    public void checkLocationForPlayer(Person p, String playerMove){
        if(this.getLocation()==p.getLocation()){
            System.out.println("You entered the room with the "+ this.getName()+ ". Watch out!");
            this.fight(p); 
            super.talk(); 
            System.out.println("");
        }
    }

    public void checkAlive(){
        if(health<=0){
            System.out.println(this.getName()+ " has died! A body lying around the school defintely won't be weird at all!");
            this.isAlive=false; 
        }
    }

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