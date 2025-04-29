public class Teacher extends NPC{

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
        double randomNum= Math.random(); 
        if (randomNum <0.25){
            System.out.println("random teacher response 1");
        }else if(randomNum>=0.25 && randomNum<0.50){
            System.out.println("random teacher response #2");
        }else if(randomNum>= 0.50 && randomNum<0.75){
            System.out.println("random teacher response #3");
        }else{
            System.out.println("random teacher resopnse #4");
        }

    }

    public void beAttacked(int nHPLoss, Person p){
        this.health= this.getHealth() -nHPLoss; 
        this.fight(p); 
    }

    public void fight(Person p){
        p.setHealth(p.getHealth()-2); 
    }
}
