public class DrainedStudent extends Student{

    boolean isSaved; 

    /**
     * A constructor for a drained student.
     * @param n name of the drained student.
     * @param d A physical description of the drained student.
     * @param cL The current Location of the drained student.
     * @param h The health of the drained student.
     * @param a the attackability of the drained student.
     */
    DrainedStudent(String n, String d, Location cL) {
        super(n, d, cL, 2, false);
        this.isSaved=false; 
    }

    public void beSaved(Location currentLocation){
        System.out.println(this.getName()+ " has been saved! They will now help you fight the science teacher.");
        this.isSaved=true; 
        this.currentLocation.removeNPC(this); 
    }

    public boolean isSaved(){
        return this.isSaved; 
    }

    public void fight(NPC scienceTeacher, Person player){
        System.out.println(this.getName()+ " punches the science teacher.");
        scienceTeacher.beAttacked(2, player); 
        System.out.println("");

    }

}