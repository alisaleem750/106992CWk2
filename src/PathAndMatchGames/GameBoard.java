package PathAndMatchGames;

import javax.swing.table.AbstractTableModel;

/**
 * The GameBoard class represents the board the games are played on in the User Interface. It creates a new board of 8 rows and 8 integers, on which
 * the user can play either the path or the match game.
 * 
 * @author 106992
 * @version 2.0
 */
public class GameBoard extends AbstractTableModel{ 
    
    Board gameBoard;
    SuperPathMatch game;
    
    /**
     * The constructor of the class creates a new playing board with 8 rows and 8 columns.
     */
    public GameBoard(){
        gameBoard = new Board(8,8);
    }

    @Override
    public boolean isCellEditable(int row, int column){  
          return false;  
    }

    @Override
    public int getRowCount() {
        return gameBoard.totalRows();
    }

    @Override
    public int getColumnCount() {
        return gameBoard.totalColumns();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return gameBoard.getNumber(rowIndex, columnIndex); 
    }
    
    /**
     * This method gets a square from the table by asking for the row and column on which it is placed.
     * @param row represents the row in which the square is.
     * @param column represents the column in which the square is.
     * @return 
     */
    public Object getSquare(int row, int column){
        return gameBoard.getSquare(row, column);
    }
    
    /**
     * This method gets the name of the first player in the game.
     * @return String represents name of player one.
     */
    String getPlayer1Name(){
        return gameBoard.player1GetName();
    }
    
    /**
     * This method gets the name of the second player in the game.
     * @return String represents name of player two.
     */
    String getPlayer2Name(){
        return gameBoard.player2GetName();
    }
    
    /**
     * This method gets the name of the random CPU player in place of player 1.
     * @return String represents name of random player.
     */
    String getRandomPlayer1Name(){
        return gameBoard.randomPlayer1GetName();
    }
    
    /**
     * This method gets the name of the random CPU player in place of player 2.
     * @return String represents name of random player.
     */
    String getRandomPlayer2Name(){
        return gameBoard.randomPlayer2GetName();
    }
    
    /**
     * This method sets the move number of the Square at row x and column y, by giving it the value z.
     * @param x Row of the Square.
     * @param y Column of the Square.
     * @param z Number entered in the Square.
     */
    void setMoveNumber(int x, int y, int z){
        gameBoard.setNumber(x, y, z);
    }
    
    /**
     * Calling this method resets the board and puts all the Squares on it in their original state.
     */
    void resetSquares(){
        gameBoard.resetSquares();
    }
}
