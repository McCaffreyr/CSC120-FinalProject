public class DrainedStudent extends Student{

    /**
     * A constructor for a drained student.
     * @param n name of the drained student.
     * @param d A physical description of the drained student.
     * @param cL The current Location of the drained student.
     * @param h The health of the drained student.
     * @param a the attackability of the drained student.
     */
    DrainedStudent(String n, String d, Location cL, int h, Boolean a) {
        super(n, d, cL, h, a);
        a = false;
    }

}