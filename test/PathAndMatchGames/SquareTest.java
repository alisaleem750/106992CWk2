
package PathAndMatchGames;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * This test class tests whether the various properties of the Square on a single cell of the board is implemented correctly.
 * @author 106992
 */
public class SquareTest {
    
    public SquareTest() {
    }
    
    Square s;

    /**
     * Sets up a new square for subsequent tests.
     */
    @Before
    public void setUpSquare(){
        
        s = new Square(5,6);
    }

    /**
     * Tests whether we can effectively get the number we entered in the Square out and return it.
     */
    @Test
    public void test_getNumber(){
        int expectedValue;
        
        expectedValue = 7;
        s.setNumber(7);
        
        assertEquals(expectedValue, s.getNumber());
    }
    
    /**
     * Tests whether the row field of the square holds the proper row value in it.
     */
    @Test
    public void test_getRowOfSquare(){
        int row;
        
        row = 5;
        
        assertEquals(row, s.getRow());
    }
    
    /** 
     * Tests whether the column field of the square holds the proper column value in it.
     */
    @Test
    public void test_getColumnOfSquare(){
        int col;
        
        col = 6;
        
        assertEquals(col, s.getColumn());
    }
    
    /**
     * Tests whether we can call on the setNumber() method to alter the number present in a Square.
     */
    @Test
    public void test_setNumber(){
        int num;
        
        num = 4;
        
        assertEquals(0, s.getNumber());
        s.setNumber(num);
        assertEquals(num, s.getNumber());
    }
    
    /**
     * Tests whether we can set the row of the Square by calling the setRow() method.
     */
    @Test
    public void test_setRow(){
        int row;
        
        row = 8;
        
        assertEquals(5, s.getRow());
        s.setRow(row);
        assertEquals(row, s.getRow());
    }
    
    /**
     * Tests whether we can set the column of the Square by calling the setColumn() method.
     */
    @Test
    public void test_setColumn(){
        int col;
        
        col = 3;
        
        assertEquals(6, s.getColumn());
        s.setColumn(col);
        assertEquals(col, s.getColumn());
    }
}
