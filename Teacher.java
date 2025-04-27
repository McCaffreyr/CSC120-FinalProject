public class Teacher extends NPC{

    /**
     * A constructor for the basic teacher.
     * @param n name of the teacher.
     * @param d A physical description of the teacher.
     * @param cL The current Location of the teacher.
     * @param h The health of the teacher.
     * @param a the attackability of the teacher.
     */
    Teacher(String n, String d, Location cL, int h, Boolean a) {
        super(n, d, cL, h, a);
        h = 100;
        a = true;
    }
    
}
