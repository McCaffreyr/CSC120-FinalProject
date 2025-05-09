import java.util.ArrayList;
import java.util.Arrays;
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
    Boolean isAlive; 


    /**
     * A constructor for the basic teacher.
     * @param n name of the teacher.
     * @param d A physical description of the teacher.
     * @param cL The current Location of the teacher.
     * @param h The health of the teacher.
     */
    Teacher(String n, String d, Location cL, int h) {
        super(n, d, cL, h, true);
        this.isAlive=true; 
    }

    /**
     * An acessor method for the health of the teacher
     * @return an int of the health
     */
    public int getHealth(){
        return this.health; 
    }

    /**
     * A method that prints out a random response from a teacher.
     */
    public void talk(){
        if(isAlive){
            int randomNum = random.nextInt(15); 
            System.out.println(this.getName()+ ": "+responses.get(randomNum));
        }else{
            throw new RuntimeException("You cannot talk to a dead man."); 
        }
       
    }

    /**
     * A method that lowers the health of a teacher and fights the player that attacked them
     * @param nHPLoss the health amount that the teacher looses 
     * @param p the person that attacked the teacher and that the teachers attacks
     */
    public void beAttacked(int nHPLoss, Person p){
        if(isAlive){
            this.health= this.getHealth() -nHPLoss; 
            this.fight(p);
        }else{
            throw new RuntimeException("You cannot fight a dead man."); 
        }
    }

    /**
     * A method that lowers the health of the players and prints out some messages for the user.
     * @param p the player to be fought by the teacher
     */
    public void fight(Person p){
        
        p.setHealth(p.getHealth()-2);
        System.out.println("The teacher slaps you back! It does two damage. Your health is now "+p.getHealth());
        System.out.println("");

    }

    /**
     * A method that checks to see if the teachers health is greater than zero. If so it changes the isAlive boolean to false and prints out some messages to the user.
     */
    public void checkAlive(){
        if(health<=0){
            System.out.println(this.getName()+ " has died! A body lying around the school defintely won't be weird at all!");
            this.isAlive=false; 
        }
    }

    public static void main(String[] args) {
        Teacher Paul = new Teacher("Paul", null, null, 100);
        Paul.talk();
    }
}
