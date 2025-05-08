public class Acid extends Weapon{
    Boolean hasAcid; 

    /**
     * A constructor for Acid which is a weapon
     * @param cL the current location of the acid 
     * @param iI if the acid is currently in the players inventory
     */
    Acid(Location cL, Boolean iI){
        super("Acid", "A bright green acid solution in a clear beaker, originally found in the chemistry lab. It bubbles and hisses at you.", 
        "You throw the acid at your opponent. They let out a yelp as it burns them.", cL, iI, 8); 
        this.hasAcid=true; 
    }

    /**
     * An override of the weapon's use method. If the acid is still full it will run the super classes use method and then it will empty itself 
     * If the acid is already empty when the player tries to use it it will throw  a runtime exception
     * @param target the target to be attacked by the acid. 
     */
    public void use(NPC target, Person player) {
        if(hasAcid){
            super.use(target, player);
            this.empty(); 
        }else{
            throw new RuntimeException("There is no more acid left in the bottle. You didn't think that one through."); 
        }
        
    }

    /**
     * This method sets the hasAcid boolean to false and changes the name and description to indicate that the beaker 
     * no longer has acid. 
     */
    public void empty(){
        this.hasAcid= false; 
        this.name= "empty acid beaker"; 
        this.description= "A clear empty glass beaker. It smells faintly acidic."; 
    }

    public static void main(String[] args) {
        //Location testingLocation= new Location("testingLocal", "n/a", false); 
        //NPC test= new NPC("test NPC", "blah blah", testingLocation, 3, true); 
        // Acid testAcid= new Acid(testingLocation, true); 
        // testAcid.use(test); 
        //System.out.println(test.getHealth());
    }

    
}
