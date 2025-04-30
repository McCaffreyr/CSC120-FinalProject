import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Student extends NPC{
    Random random = new Random();
    List<String> responses = Arrays.asList("I haven’t seen you before. Hi.", 
    "Be careful of the hall monitor down the hall in front of you.",
    "I like your hair. It looks good today.",
    "Don’t let the teachers touch your skin.",
    "Be careful in the library…there’s a weird vibe.",
    "It’s always good to have a pencil ready…to attack!",
    "You should get new shoes. Yours are really loud.",
    "Have you seen Joey the golfer?",
    "Do you know how the golf team is doing this season? I haven’t heard much about them.",
    "Do you see the ghosts too?",
    "Shhhh, talk quietly.",
    "Are you new here? You seem new.",
    "Walk with your head down. Don’t let them see your face.",
    "I hate Mr. Paulson.",
    "Our science teacher sucks.");

    /**
     * A constructor for the basic student.
     * @param n name of the student.
     * @param d A physical description of the student.
     * @param cL The current Location of the student.
     * @param h The health of the student.
     * @param a the attackability of the student.
     */
    Student(String n, String d, Location cL, int h, Boolean a) {
        super(n, d, cL, h, a);
        h = 100;
        a = false;
    }

    public void talk(){
        int randomNum = random.nextInt(15); 
        System.out.println(responses.get(randomNum));

    }

    public static void main(String[] args) {
        Student Abby = new Student("Abby", "desc", null, 100, false);
        Abby.talk();
    
}


}
    


