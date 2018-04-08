/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PathAndMatchGames;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author 106992
 */
public class BoardTest {
    
    public BoardTest() {
    }
    
    Board b;
    
    @Before
    public void setBoard(){      
        b = new Board(10,10);
    }

    @Test
    public void test_boardSize(){
        Board b2;
        int expectedResult1, expectedResult2;
        
        b = new Board(10,10);
        b2 = new Board(8,8);
        expectedResult1 = 10*10;
        expectedResult2 = 8*8;
        
        assertEquals(expectedResult1, b.getBoardSize());
        assertEquals(expectedResult2, b2.getBoardSize());
    }
    
    @Test
    public void test_playerNames(){
        String player1, player2;
        
        b = new Board(10,10);
        player1 = "George";
        player2 = "Dan";
        
        b.setPlayer1Name(player1);
        assertEquals(player1, b.player1GetName());
        b.setPlayer2Name(player2);
        assertEquals(player2, b.player2GetName());  
    }
    
    @Test
    public void test_getSquare(){
        int row, col;
        
        row = 7;
        col = 7;

        assertEquals(8,b.getSquare(row, col).getRow());
        assertEquals(8, b.getSquare(row, col).getColumn());
    }
    
    @Test
    public void test_getTotalRowsColumns(){
        int expectedRow, expectedCol;
        
        expectedRow = 10;
        expectedCol = 10;
        
        assertEquals(expectedRow, b.totalRows());
        assertEquals(expectedCol, b.totalColumns());
    }
    
    @Test
    public void test_getRowColumnOfSquare(){
        int row, col;
        
        row = 4;
        col = 5;
        
        assertEquals(5, b.getRow(row, col));
        assertEquals(6, b.getColumn(row, col));
    }
    
    @Test
    public void test_getSquareNumber(){
        int row, col, expectedResult; 
        
        expectedResult = 0;
        row = 2;
        col = 3;
        
        assertEquals(expectedResult, b.getNumber(row, col));
        assertFalse(3 == b.getNumber(row, col));
    }
    
    @Test
    public void test_changeNum(){
        int row, col, expectedResult, expectedResult2, number;
        
        row = 6;
        col = 7;
        expectedResult = 0;
        number = 5;
        
        assertEquals(expectedResult, b.getNumber(row, col));
        b.setNumber(row, col, number);
        assertEquals(number, b.getNumber(row, col));
    }
    
    @Test
    public void test_resetSquare(){
        int row,col, number;
        
        row = 4;
        col = 7;
        number = 6;
        
        b.setNumber(row, col, number);
        assertEquals(number, b.getNumber(row, col));
        b.resetSquares();
        assertEquals(0, b.getNumber(row, col));
    }
}
