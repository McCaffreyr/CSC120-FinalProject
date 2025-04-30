import java.util.Random;

public class HallMonitor extends NPC{
    Random random = new Random();
    LocationMap map = new LocationMap();
    

    /**
     * A constructor for a hall monitor.
     * @param n name of the hall monitor.
     * @param d A physical description of the hall monitor.
     * @param cL The current Location of the hall monitor.
     * @param h The health of the hall monitor.
     * @param a the attackability of the hall monitor.
     */
    HallMonitor(String n, String d, Location cL, int h, Boolean a) {
        super(n, d, cL, h, a);
        h = 100;
        a = true;
    }

    public void move(){
        int randomNum = random.nextInt(map.get(currentLocation.name).size()); 
        System.out.println(map.get(currentLocation.name).get(randomNum));
    }
    
    public static void main(String[] args) {
        //Location HallwayThree = new Location("Hallway Three", "desc", false);
        //HallMonitor Bob = new HallMonitor("Bob", "desc", HallwayThree, 100, true);
        //Bob.move();

}

}