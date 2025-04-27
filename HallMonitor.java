public class HallMonitor extends NPC{

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
    
}