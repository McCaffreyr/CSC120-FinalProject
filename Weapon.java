public class Weapon extends Item {
    int hitPower; 
    String attackDescription; 

    /**
     * This is the construcotr for a weapon which is an item.
     * @param n name of the weapon
     * @param d visual description of the weapon
     * @param aL a description of the attack when using this weapon.
     * @param cL current location of the weapon
     * @param iI if the item is currently in your inventory
     * @param hP how many points of damage, or hitPoints the item does
     */
    Weapon(String n, String d, String aL, Location cL, boolean iI, int hP){
        super(n, d, cL,iI); 
        this.hitPower=hP; 
        this.attackDescription= aL; 
    }

    /**
     * This method uses the weapon and subtracts however many hit points the weapon has from the target.
     * @param target the target that is being attacked
     */
    public void use(NPC target){
        target.setHealth(target.getHealth() - this.hitPower); 
        System.out.println(attackDescription);
    }
        
 }



