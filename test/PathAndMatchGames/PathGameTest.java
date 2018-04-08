package PathAndMatchGames;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * This test class tests whether the various properties and methods in the path game class work properly.
 * @author 106992
 */
public class PathGameTest {
    
    public PathGameTest() {
    }

    PathGame p;

    /**
     * Sets up a new path game for subsequent tests.
     */
    @Before
    public void setUpPathGame(){
        p = new PathGame();
    }

    /**
     * Tests that player 2 cannot start the game.
     */
    @Test
    public void test_player2cannotStartGame(){
        p.player2MakeMove(5, 6);
        assertFalse(p.validMove);
        p.randomPlayer2MakeMove(4, 2);
        assertFalse(p.validMove);
    }
    
    /**
     * Tests if the move the player is making is valid.
     */
    @Test
    public void test_TryIllegalMoves(){
        int row, col;
        
        row = 10;
        col = 10;
        
        p.board = new Board(row, col);
        
        p.player1MakeMove(2, 3);
        p.player2MakeMove(2, 4);
        p.player1MakeMove(6, 5);
        assertFalse(p.validMove);
    }
    
    /**
     * Simulates a game to test if the winner's score is incremented.
     */
    @Test
    public void test_winnerTest(){
        int row, col, expectedScore;
        
        row = 7;
        col = 7;
        expectedScore = 55;
        
        assertEquals(0, p.Player1Score);
        assertEquals(0,p.Player2Score);
        
        p.board = new Board(row, col);
        
        p.player1MakeMove(1, 1);
        p.player2MakeMove(1, 2);
        p.player1MakeMove(1, 3);
        p.player2MakeMove(2,3);
        p.player1MakeMove(3,3);
        p.player2MakeMove(3,2);
        p.player1MakeMove(3,1);
        p.player2MakeMove(2, 1);
        p.player1MakeMove(2,2);
        
        assertEquals(expectedScore,p.Player1Score);
        assertEquals(0,p.Player2Score);
    }
    
    /**
     * Tests whether the appropriate message is being sent to the player after making a move.
     */
    @Test
    public void test_correctMessageSent(){
        int x = 5;
        int y = 6;
        String message = "Player 1 has marked the square in row " + x + " and column " + y + ". It is Player 2's turn.";
        
        p.player1MakeMove(x, y);
        assertEquals(p.move, message);
    }
    
    /**
     * Tests whether a random player has made a valid move.
     */
    @Test
    public void test_randomPlayerMove(){
        int currentRow = 5;
        int currentColumn = 6;
        
        p.randomPlayer1MakeMove(currentRow, currentColumn);
        assertTrue(p.validMove);
        
        p.player1MakeMove(currentRow, currentColumn);
        p.randomSquare2(currentRow, currentColumn);
        assertTrue(p.validMove);
    }
}
