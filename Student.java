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
    
}
