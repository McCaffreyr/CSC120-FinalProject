
public class Student extends NPC{

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
        super.talk(); 
        double randomNum= Math.random(); 
        if (randomNum <0.25){
            System.out.println("random student response 1");
        }else if(randomNum>=0.25 && randomNum<0.50){
            System.out.println("random student response #2");
        }else if(randomNum>= 0.50 && randomNum<0.75){
            System.out.println("random student response #3");
        }else{
            System.out.println("random student resopnse #4");
        }

    }
}
    

