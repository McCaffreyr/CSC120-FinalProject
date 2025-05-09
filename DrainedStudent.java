public class DrainedStudent extends Student{

    boolean isSaved; 

    /**
     * A constructor for a drained student.
     * @param n name of the drained student.
     * @param d A physical description of the drained student.
     * @param cL The current Location of the drained student.
     */
    DrainedStudent(String n, String d, Location cL) {
        super(n, d, cL, 2, false);
        this.isSaved=false; 
    }

    /**
     * This method prints out a message the the drained student has been saved and sets the isSaved boolean to be true. 
     * It also removes them from their current location so they no longer appear as people who need to be saved.
     */
    public void beSaved(){
        System.out.println(this.getName()+ " has been saved! They will now help you fight the science teacher.");
        this.isSaved=true; 
        this.currentLocation.removeNPC(this); 
    }

    /**
     * This method is an acessor method for the isSaved boolean
     * @return T/F wether the drained student has been saved.
     */
    public boolean isSaved(){
        return this.isSaved; 
    }

    /**
     * This method has the drained students fight the science teacher. However, since the drained students act like an extension of the player so the person attacking the science teacher is technically the player.
     * @param scienceTeacher the science teacher to be fought
     * @param player the player the drained students are an extension of.
     */
    public void fight(NPC scienceTeacher, Person player){
        System.out.println(this.getName()+ " punches the science teacher.");
        scienceTeacher.beAttacked(2, player); 
        System.out.println("");

    }

}