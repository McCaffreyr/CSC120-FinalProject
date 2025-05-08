public class ScienceTeacher extends HallMonitor{
    LocationMap map = new LocationMap();

    /**
     * A constructor for a science teacher
     * @param n the name of the teacher
     * @param d a description of the teacher
     * @param cL the current location of this science teacher
     * @param h the health of the science teacher
     */
    ScienceTeacher(String n, String d, Location cL, int h) {
        super(n, d, cL, h);
    }

     /**
     * Science teacher moves to the person
     * @param stu the person / user
     * @return a string of the name of the location for the science teacher to move to
     */
    public String nextMove(Person stu){
        if(this.isAlive){
            String place = stu.getLocation().getName();
            return place;
        } else{
            return "null Location";
        }
    }

    /**
     * This method lowers the players health and prints out some messages for the user
     * @param p the player to be fought by the science teacher
     */
    public void fight(Person p){
        System.out.println(this.getName()+ " attacks you with a syringe. Ow... god I hate shots.");
        p.setHealth(p.getHealth()-3);
        System.out.println("Your health is now "+p.getHealth());
        System.out.println("");
    }
    

    public static void main(String[] args) {
        Location Library3 = new Location("Library Room Three", "desc","desc pt2", false, null);
        Person Molly = new Person(Library3);
        Librarian Polly = new Librarian("Polly", "desc", Library3, 100);
        

        System.out.println(Polly.nextMove(Molly));
    }

}
