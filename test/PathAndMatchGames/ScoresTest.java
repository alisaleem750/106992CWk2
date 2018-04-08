package PathAndMatchGames;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * This class whether the properties of the Scores class work properly.
 * 
 * @author alisaleem
 */
public class ScoresTest {
    
    public ScoresTest() {
    }
    
    Scores list;
    String name;
    int score;

    /**
     * Sets up a new scores list for the tests.
     */
    @Before
    public void setUpScores(){
        list = new Scores();
        name = "Matt";
        score = 46;
    }
    
    /**
     * Tests whether the size of the high scores list is correct.
     */
    @Test
    public void test_getScoreListSize(){     
        assertEquals(0, list.highscores.size());
        list.addPlayer(name, score);
        assertEquals(1, list.highscores.size());
    }
    
    /**
     * Tests that a player is added to the list properly.
     */
    @Test
    public void test_addPlayerToList(){
        list.addPlayer(name, score);
        assertEquals(list.highscores.get(0).getName(), name);
        assertEquals(list.highscores.get(0).getScore(), score);
    }
    
    /**
     * Tests that a player already existing in the list is not added again.
     */
    @Test
    public void test_noDuplicatePlayers(){
        list.addPlayer(name, score);
        assertEquals(list.highscores.size(), 1);
        list.addPlayer(name, score);
        assertEquals(list.highscores.size(), 1);
    }
    
    /**
     * Tests that the list is sorted from highest score to lowest score.
     */
    @Test
    public void test_sortHighScoresList(){
        String name2 = "Josh";
        String name3 = "Peter";
        int score2 = 70;
        int score3 = 65;
        
        list.addPlayer(name, score);
        list.addPlayer(name2, score2);
        list.addPlayer(name3, score3);
        assertEquals(list.highscores.get(0).getScore(), score);
        assertEquals(list.highscores.get(1).getScore(), score2);
        assertEquals(list.highscores.get(2).getScore(), score3);
        list.sortScores();
        assertEquals(list.highscores.get(0).getScore(), score2);
        assertEquals(list.highscores.get(1).getScore(), score3);
        assertEquals(list.highscores.get(2).getScore(), score);
    }
}
