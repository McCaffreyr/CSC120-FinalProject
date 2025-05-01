import java.util.Arrays;
import java.util.Random;

public class HallMonitor extends NPC{
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
    HallMonitor(String n, String d, Location cL) {
        super(n, d, cL, 10, true);
        this.isAlive=true; 
    }

    public String nextMove(Person stu){
        if(isAlive){
            String options = this.map.get(stu.currentLocation.name);
            String[] options2 = options.split(", ");
            int randomNum = random.nextInt(options2.length); 
            String newloc = options2[randomNum];
        return newloc;
        } else{
            return "You are dead:(";
        }
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
    }
    
    public static void main(String[] args) {
        Location HallwayThree = new Location("Hallway Three", "desc", "desc w/key items", false, null);
        HallMonitor Bob = new HallMonitor("Bob", "desc", HallwayThree);
        Person testingP= new Person(HallwayThree); 
        System.out.println(Bob.nextMove(testingP));
}

}