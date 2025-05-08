public class BreakableWeapon extends Weapon {
    int nUses; 
    Boolean isBroken; 

    /**
     * A constructor for a breakable weapon which is a weapon
     * @param n String name of the weapon
     * @param d String of description of the weapon
     * @param aL String of the description of the attack when using this weapon.
     * @param cL the current location of the weapon
     * @param iI T/F is the weapon is currently in your inventory
     * @param hP int of how much damage the weapon does
     * @param nU int of how many uses this object has before it breaks
     */
    BreakableWeapon(String n, String d, String aL, Location cL, boolean iI, int hP, int nU ){
        super(n, d, aL, cL, iI, hP); 
        this.nUses= nU; 
        this.isBroken= false; 
    }

    /**
     * A accessor method for the isBroken attribute
     * @return T/F wether the item is broken
     */
    public Boolean isItemBroken(){
        return this.isBroken; 
    }

    /**
     * This method changes the isBrokean boolean to be true and modifies the name and 
     * description to indicate the weapon is broken. As well as printing out a message to let the plater know the message is broken.
     */
    public void fallApart(){
        this.isBroken= true;
        System.out.println("Your"+ this.getName()+ " has broken! Oh no!");
        this.name= "broken " + this.name; 
        this.description= this.description + "It is broken."; 
    }

    /**
     * This overrides the use method of the weapon class. It subrtacts the number of hit points from the health of the enemy. 
     * It also decreases the number of uses the object have left. If it is zero it makes the object fall apart. 
     * @param target the targert to be attacked when using this weapon
     * @param player the person who uses the weapon
     */
    public void use(NPC target, Person player){
        if(isBroken){
            throw new RuntimeException("This weapon is broken and can no longer be used."); 
        }else{
            super.use(target, player); 
            this.nUses= nUses-1; 
            if(nUses== 0){
                this.fallApart();
            }
        }
    }
    
    public static void main(String[] args) {
        //Location testingLocation= new Location("testingLocal", "n/a", false); 
        //NPC test= new NPC("test NPC", "blah blah", testingLocation, 3, true); 
        //BreakableWeapon testWeapon= new BreakableWeapon("testing weapon", "n/a", "you attack", testingLocation, true, 1, 3); 
        // testWeapon.use(test); 
        //System.out.println(test.getHealth()); 
        // testWeapon.use(test);
        //System.out.println(test.getHealth()); 
        // testWeapon.use(test); 
        //System.out.println(test.getHealth()); 
        //System.out.println(testWeapon.isItemBroken()); 
        // try{
            // testWeapon.use(test); 
        // }catch( RuntimeException e){
            // System.out.println(e.getLocalizedMessage()); 
        // }
    }
}
