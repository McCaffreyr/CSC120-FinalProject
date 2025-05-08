public class Note extends Item{
    String noteContents; 

    /**
     * A constructor for a note, which is an item.
     * @param n the name for the note
     * @param d the description of what the note visually looks like
     * @param cL the current location of the note 
     * @param iI T/F the note is currently in the inventory of the player
     * 
     */
    Note(String n, String d, Location cL, boolean iI){
        super(n,d,cL, iI); 
    }

    

   
}
