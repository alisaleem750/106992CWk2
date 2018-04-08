package PathAndMatchGames;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author 106992
 */
public class MatchGameTest {
    
    public MatchGameTest() {
    }

    MatchGame m;

    @Before
    public void setUpPathGame(){
        m = new MatchGame();
    }

    @Test
    public void test_player2cannotStartGame(){
        m.player2MakeMove(5, 6);
        assertFalse(m.validMove);
    }
    
    @Test
    public void test_TryIllegalMoves(){
        int row, col;
        
        row = 10;
        col = 10;

        
        m.board = new Board(row, col);
        
        m.player1MakeMove(3, 4);
        m.player2MakeMove(7, 5);
        assertFalse(m.validMove);
    }
    
    @Test
    public void test_winnerTest(){
        int row, col, expectedScore;
        
        row = 7;
        col = 7;
        expectedScore = 55;
        
        assertEquals(0, m.Player1Score);
        assertEquals(0,m.Player2Score);
        
        m.board = new Board(row, col);
        
        m.player1MakeMove(1, 1);
        m.player2MakeMove(1, 2);
        m.player1MakeMove(1, 3);
        m.player2MakeMove(2,3);
        m.player1MakeMove(3,3);
        m.player2MakeMove(3,2);
        m.player1MakeMove(3,1);
        m.player2MakeMove(2, 1);
        m.player1MakeMove(2,2);
        
        assertEquals(expectedScore,m.Player1Score);
        assertEquals(0,m.Player2Score);
    }
    
    /**
     * Tests whether the appropriate message is being sent to the player after making a move.
     */
    @Test
    public void test_correctMessageSent(){
        int x = 5;
        int y = 6;
        String message = "Player 1 has marked the square in row " + x + " and column " + y + ". It is Player 2's turn.";
        
        m.player1MakeMove(x, y);
        assertEquals(m.move, message);
    }
}
