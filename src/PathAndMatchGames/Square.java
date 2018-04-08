package PathAndMatchGames;

/**
 * This class represents a single square on the table/board used for the Path and Match games. It prompts the user to enter two integers, which it stores as row and column values to refer to as positions for the board
 * 
 * @author 106992
 * @version 2.0
 */
public class Square {
    String playerName;
    int moveNumber;
    int row;
    int column;
    
    /**
     * The constructor of this class prompts the user to enter two ints which it then uses as row and column where the Square will be stored on the board.
     * @param row row of Square.
     * @param column column of Square.
     */
    public Square(int row, int column){
        playerName = null;
        moveNumber = 0;
        this.row = row;
        this.column = column;
    }
    
    /**
     * This method retrieves the name of the player who marked the cell.
     * @return Returns the name of the player that marked this cell.
     */
    String getPlayer(){
        return playerName;
    }
    
    /**
     * This method retrieves the move number from the Square.
     * @return integer representing the move number of the Square.
     */
    int getNumber(){
        return moveNumber;
    }
    
    /**
     * This method retrieves the row of the square.
     * @return integer representing the row on which square is placed.
     */
    int getRow(){
        return row;
    }
    
    /**
     * This method retrieves the column of the square.
     * @return integer representing the column on which square is placed.
     */
    int getColumn(){
        return column;
    }
    
    /**
     * This method allows the storage of the name of the player who played a move on this square.
     * @param name 
     */
    void setName(String name){
        playerName = name;
    }
    
    /**
     * This method allows for the move number stored within the Square to be altered by taking in an integer as a parameter.
     * @param n is an integer representing the number of the move that was played on this cell.
     */
    void setNumber(int n){
        moveNumber = n;
    }
    
    /**
     * This method allows for Square to change the row it is placed on by taking in an integer.
     * @param row represents the new row on which Square will be placed.
     */
    void setRow(int row){
        this.row = row;
    }
    
    /**
     * This method allows for Square to change the column it is placed on by taking in an integer.
     * @param column represents the new column on which Square will be placed.
     */
    void setColumn(int column){
        this.column = column;
    }
}
