package PathAndMatchGames;
/**
 * The Board class represents the board the games are played on in the model. It prompts the user to add two integers to the
 * constructor, which it then uses to represent the number of rows and columns on the board.
 * 
 * @author 106992
 * Version 2.0
 */
class Board {
    
    public static Square[][] board;
    public String player1, player2, randomPlayer1, randomPlayer2;
    public int row = 0;
    public int column = 0;
   
    /**
     * This is the constructor of the class Board, it asks the user to enter two integers, which it uses to then fill out the board with, using them as row and column values.
     * @param x represents the amount of rows on the board.
     * @param y represents the amount of columns on the board.
     */
    public Board(int x, int y){
        player1 = "Player 1";
        player2 = "Player 2";
        randomPlayer1 = "CPU 1";
        randomPlayer2 = "CPU 2";
        board = new Square[x][y];
        for (int i = 0; i < board.length;i++){
            row++;
            for(int j = 0; j < board.length; j++){
                if(column == y){
                    column = 0;
                }
                column++;
                board[i][j] = new Square(row, column);
            }
        }
        row = x;
        column = y;
    }
     
    /**
     * This method gets the size of the board.
     * @return integer returned is the size of the board.
     */
    int getBoardSize() {
        return row * column;
    }
    
    /**
     * This method gets the name of the first player in the game.
     * @return String returned is the name of player one.
     */
    String player1GetName(){
        return player1;
    }
    
    /**
     * This method gets the name of the second player in the game.
     * @return String returned is the name of player two.
     */
    String player2GetName(){
        return player2;
    }
    
    /**
     * This method gets the name of the random player.
     * @return String returned is the name of random player.
     */
    String randomPlayer1GetName(){
        return randomPlayer1;
    }
    
    String randomPlayer2GetName(){
        return randomPlayer2;
    }
    
    /**
     * This method prompts the user to enter a string, which it then uses to change the name of player one on the playing board.
     * @param name is the name that will be set as the name of player one. 
     */
    public void setPlayer1Name(String name){
        player1 = name;
    }
    
    /**
     * This method prompts the user to enter a string, which it then uses to change the name of player two on the playing board.
     * @param name is the name that will be set as the name of player two. 
     */
    public void setPlayer2Name(String name){
        player2 = name;
    }
    
    /**
     * This method fetches the square on a particular area on the board and returns it for the user.
     * @param x is the row of the square that is being fetched.
     * @param y is the column of the square that is being fetched.
     * @return Square returned is the Square on the specified row and column area on the board.
     */
    Square getSquare(int x, int y){
        return board[x][y];
    }
    
    /**
     * This method returns the total amount of rows on the board table.
     * @return integer returned is the number of rows on the board in total.
     */
    int totalRows(){
        return row;
    }
    
    /**
     * This method returns the total amount of columns on the board table.
     * @return integer returned is the number of columns on the board table.
     */
    int totalColumns(){
        return column;
    }
    
    /**
     * This method takes two integers that it uses as row and column values to then get the row of the Square at that value.
     * @param x represents the row.
     * @param y represents the column.
     * @return integer represents the row on which the Square of row x and column y is placed.
     */
    int getRow(int x, int y){
        return board[x][y].getRow();
    }
    
    /**
     * This method takes two integers that it uses as row and column values to then get the column of the Square at that value.
     * @param x represents the row.
     * @param y represents the column.
     * @return integer represents the column on which the Square of row x and column y is placed.
     */
    int getColumn(int x, int y){
        return board[x][y].getColumn();
    }
    
    /**
     * This method retrieves a number from the Square at row x and column y, which represents the number of move that was played on that square.
     * @param x represents the row of the Square.
     * @param y represents the column of the Square.
     * @return integer represents the move number this Square was used for (no move used it if it equals 0)
     */
    int getNumber(int x, int y){
        return board[x][y].getNumber();
    }
    
    /**
     * This method takes three integers as parameters. It uses the first two as row and column values, and uses the third one to populate the square at that position with the third integer, representing the move number played at that Square.
     * @param row represents the row of the Square.
     * @param col represents the column of the Square.
     * @param num represents the move number of the game at that square.
     */
    void setNumber(int row, int col, int num){
        board[row][col].setNumber(num);
    }
    
    void changeSquareNumber(int num, int row, int col){
        board[row][col].setNumber(num);
    }
    
    /**
     * This method retrieves the number of the move at which that square was used in the game, by taking the position of the square in the table through the row and column.
     * @param x represents the row in which the square is.
     * @param y represents the column in which the square is.
     * @return Integer representing the number of the move played on a square.
     */
    public int getSquareNumber(int x, int y){
        return board[x][y].getNumber();
    }
    
    /**
     * This method allows the user to enter the name of the player who used this square on the game board.
     * @param row represents the row in which the square is.
     * @param col represents the column in which the square is.
     * @param name represents the name of the player who used the square.
     */
    public void changeSquarePlayer(int row, int col, String name){
        board[row][col].setName(name);
    }
    
    /**
     * This method allows the user to retrieve the name of the player who used this square on the game board.
     * @param x represents the row in which the square is.
     * @param y represents the column in which the square is.
     * @return String representing the name of the player who marked the square.
     */
    public String getSquarePlayer(int x, int y){
        return board[x][y].getPlayer();
    }
    
    /**
     * This method can be called to reset the values of all the Squares on the playing board to their original values. It is used to reset the board for a new game.
     */
    public void resetSquares(){
        int x = 0;
        int y = 0;
        for (int i = 0; i < board.length;i++){
            if(x == row){
                x = 0;
            }
            x++;
            for(int j = 0; j < board.length; j++){
                if(y == column){
                    y = 0;
                }
                y++;
                board[i][j] = new Square(x, y);
            }
        }
    }
}
