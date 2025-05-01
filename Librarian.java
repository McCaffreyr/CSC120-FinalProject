import java.util.Random;

public class Librarian extends HallMonitor{
    Random random = new Random();
    LocationMap map = new LocationMap();
    
    /**
     * Constructor for the Librarian Class
     * @param n name of the librarian
     * @param d description of the librarian
     * @param cL current location of the librarian
     * @param h health of the librarian
     */
    Librarian(String n, String d, Location cL, int h) {
        super(n, d, cL, h);
        super.responses.add("Where you looking for a book?");
        super.responses.add("You are looking for a physical book!? I can't believe it.");
        super.responses.add("Did you never learn the dewey decimal system?");
        super.responses.add("I'm surprised you can read at all.");
        super.responses.add("You've been standing there staring for so long. Do you know the alphabet?");
        super.responses.add("You aren't stealing books are you?");
        super.responses.add("A student? Here? No one uses the library anymore.");
        super.responses.add("Don't I look younger today?");
        super.responses.add("Don't you love the science teacher?");
        super.responses.add("Ignore any muffled yells you hear. It's just the floor.");
    }
    
    /**
     * Librarian moves to a random adaject location to the person
     * @param stu the person / user
     */
    public String nextMove(Person stu){
        if(isAlive){
            String options = this.map.get(stu.getLocation().getName());
            System.out.println(options);
            String[] options2 = options.split(", ");
            int randomNum = random.nextInt(options2.length); 
            String newloc = options2[randomNum];
        return newloc;
        } else{
            return "null location";
        }
    }

    public void beAttacked(int nHPLoss, Person p){
        if(this.isAlive){
            this.health=this.getHealth()-nHPLoss;
            this.checkAlive();
        }else{
            throw new RuntimeException("You cannot fight a dead woman."); 
        }
    }

    public void fight(Person p){
        System.out.println(this.getName()+ " attacks you with a dictionary. That's gonna leave a bruise.");
        p.setHealth(p.getHealth()-4);
        System.out.println("Your health is now "+p.getHealth());
        System.out.println("");
    }
    

    public static void main(String[] args) {
        Location Library3 = new Location("Library Room Three", "desc","desc pt2", false, null);
        Person Molly = new Person(Library3);
        Librarian Polly = new Librarian("Polly", "desc", Library3, 100);
        // Location Library4 = new Location("Library Room Four", "desc","desc pt 2", false, null);
        // Molly.move(Library4);
        System.out.println(Polly.nextMove(Molly));
    }

}
