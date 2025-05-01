public class ScienceTeacher extends Teacher{

    ScienceTeacher(String n, String d, Location cL, int h) {
        super(n, d, cL, h);
    }

     /**
     * Science teacher moves to the person
     * @param stu the person / user
     */
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
    

    public static void main(String[] args) {
        Location Library3 = new Location("Library Room Three", "desc","desc pt2", false, null);
        Person Molly = new Person(Library3);
        Librarian Polly = new Librarian("Polly", "desc", Library3, 100);
        Location Library4 = new Location("Library Room Four", "desc","desc pt 2", false, null);
        Molly.move(Library4);
        System.out.println(Polly.nextMove(Molly));
    }

}

    
}
