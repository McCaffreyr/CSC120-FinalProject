public class ScienceTeacher extends HallMonitor{

    ScienceTeacher(String n, String d, Location cL, int h) {
        super(n, d, cL, h);
    }

    LocationMap map = new LocationMap();

     /**
     * Science teacher moves to the person
     * @param stu the person / user
     */
    public String nextMove(Person stu){
        if(this.isAlive){
            String place = this.map.get(stu.getLocation().getName());
            return place;
        } else{
            return "null Location";
        }
    }

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
        Location Library4 = new Location("Library Room Four", "desc","desc pt 2", false, null);

        System.out.println(Polly.nextMove(Molly));
    }

}
