import static org.junit.Assert.*; 
import org.junit.Test; 
public class MainTest {
    // getUserInput tests
    @Test
    public void testGrabCommand(){
        //setUp
        Main testingGame= new Main(); 
        //test grab pencil from homeroom
        testingGame.player.setLocation(testingGame.gym);
        testingGame.getUserInput(testingGame.player); 
        assertTrue(testingGame.player.hasItem(testingGame.golfClub));    
    }
}
