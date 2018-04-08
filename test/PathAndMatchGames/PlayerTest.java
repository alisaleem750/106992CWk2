
package PathAndMatchGames;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * This class tests whether the various properties of the Player class work appropriately.
 * 
 * @author 106992
 */
public class PlayerTest {
    
    public PlayerTest() {
    }

    Player p;
    
    /**
     * Sets up a new player for the tests.
     */
    @Before
    public void setUpPlayer(){
        p = new Player("Jon", 0);
    }
    
    /**
     * Tests whether the name of the player is correct.
     */
    @Test
    public void test_getPlayerName(){
        assertEquals("Jon", p.getName());
    }
    
    /**
     * Tests whether the score of the player is correct.
     */
    @Test
    public void test_getPlayerScore(){
        assertEquals(0, p.getScore());
    }
    
    /**
     * Tests whether the new player name is being set correctly.
     */
    @Test
    public void test_setPlayerName(){
        assertEquals("Jon", p.getName());
        p.setName("Dan");
        assertEquals("Dan", p.getName());
    }
    
    /**
     * Tests whether the new player score is being set correctly.
     */
    @Test
    public void test_setPlayerScore(){
        assertEquals(0, p.getScore());
        p.setScore(50);
        assertEquals(50, p.getScore());
    }
}
