import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Teacher extends NPC{
    Random random = new Random();
    public ArrayList<String> responses = new ArrayList<>(Arrays.asList("Why are you talking to me? You should get back to class.", 
    "Go faster, student.",
    "Stop talking.",
    "I don’t like your shoes.",
    "What are you doing? Whatever it is, stop it.",
    "We are in school. You should be quiet.",
    "Have you considered what would happen if you turned into a robot who just sat silently in class? Because you should work on that.",
    "Why are you talking to me? We aren’t friends.",
    "Your skin looks so youthful.",
    "What kind of skincare do you use?",
    "Let me touch your face. It looks so soft.",
    "Go back to class, unless you want to end up like Joey the golfer.",
    "I’m taller than you. Ha.",
    "Where are you going? Actually, I don’t care.",
    "Hm. Sorry, did you say something?"));


    /**
     * A constructor for the basic teacher.
     * @param n name of the teacher.
     * @param d A physical description of the teacher.
     * @param cL The current Location of the teacher.
     * @param h The health of the teacher.
     * @param a the attackability of the teacher.
     */
    Teacher(String n, String d, Location cL, int h) {
        super(n, d, cL, h, true);
    }

    public int getHealth(){
        return this.health; 
    }

    
    public void talk(){
        int randomNum = random.nextInt(15); 
        System.out.println(responses.get(randomNum));
    }

    public void beAttacked(int nHPLoss, Person p){
        this.health= this.getHealth() -nHPLoss; 
        this.fight(p); 
    }

    public void fight(Person p){
        p.setHealth(p.getHealth()-2); 
        System.out.println("The teacher slaps you back! It does two damage. Your health is now "+p.getHealth());
    }

    public static void main(String[] args) {
        Teacher Paul = new Teacher("Paul", null, null, 100);
        Paul.talk();
    }
}
