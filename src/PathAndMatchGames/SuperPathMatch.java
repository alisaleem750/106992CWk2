
package PathAndMatchGames;

import java.io.Serializable;

/**
 * SuperPathMatch is a superclass for the PathGame and MatchGame classes. It stores the values that are common to both the games.
 * @author 106992
 * @version 2.0
 */
public class SuperPathMatch implements Serializable {
    
    boolean Player1Turn;
    boolean validMove;
    boolean gameOver;
    Board board;
    String move;
    int movesPlayer2;
    int movesPlayer1;
    Square lastSquare, randomSquare;
    int Player1Score;
    int Player2Score;
    int randomPlayer1Score, randomPlayer2Score;
    int moveNumber;
    int totalMoves;
    int randomRow;
    int randomColumn;

    /**
     * Constructor of the superclass SuperPathMatch. Initializes the fields.
     */
    public SuperPathMatch() {
        lastSquare = new Square(-1, -1);
        randomSquare = new Square(-1, -1);
        Player1Turn = true;
        gameOver = false;
        board = new Board(8,8);
        Player1Score = 0;
        Player2Score = 0;
        moveNumber = 0;
        totalMoves = board.getBoardSize();
        move = "";
    }
    
    /**
     * This method tells the user whether it is player 1's turn or not. 
     * @return boolean true if it is player 1's turn, false otherwise.
     */
    boolean getPlayer1Turn(){
        return Player1Turn;
        }

    /**
     * This method retrieves the score of player 1 in the game.
     * @return Integer representing the score of player 1.
     */
    int getPlayer1Score() {
        return Player1Score;
    }

    /**
     * This method retrieves the score of player 2 in the game.
     * @return Integer representing the score of player 2.
     */
    int getPlayer2Score() {
        return Player2Score;
    }
    
    /**
     * This method retrieves the score of a random player in position of player 1.
     * @return Integer representing the score of random player 1.
     */
    int getRandomPlayer1Score(){
        return randomPlayer1Score;
    }
    
    /**
     * This method retrieves the score of a random player in position of player 2.
     * @return Integer representing the score of random player 2.
     */
    int getRandomPlayer2Score(){
        return randomPlayer2Score;
    }

    /**
     * This method retrieves the number of current move in the game. 
     * @return Integer representing the number of the current move.
     */
    int getMoveNumbers(){
        return moveNumber;
    }
    
    /**
     * This method tells the user how many moves are left in the game. Used to compute the winning player's score. 
     * @return Integer representing how many moves are left in the game.
     */
    int getMovesLeft(){
        return (totalMoves - moveNumber);
    }
    
    /**
     * Calling this method resets the number of moves played to 0. Used when starting a new game.
     */
    void resetMoveNumber(){
        moveNumber = 0;
    }
    
    /**
     * Calling this method sets the turn to player 1's turn.
     */
    void setPlayer1Turn(){
        Player1Turn = true;
    }
    
    /**
     * Calling this method sets whether the move is valid or not depending on the parameter boolean.
     * @param valid boolean represents a boolean that is true if a move is valid and false otherwise.
     */
    void setValidMove(boolean valid){
        validMove = valid;
    }
    
    /**
     * This method retrieves the name of player 1.
     * @return String representing the name of player 1.
     */
    String getPlayer1Name(){
        return board.player1GetName();
    }
    
    /**
     * This method retrieves the name of player 2.
     * @return String representing the name of player 2.
     */
    String getPlayer2Name(){
        return board.player2GetName();
    }
    
    /**
     * This method retrieves the name of random player 1.
     * @return String representing the name of random player 1.
     */
    String getRandom1Name(){
        return board.randomPlayer1GetName();
    }
    
    /**
     * This method retrieves the name of random player 2.
     * @return String representing the name of random player 2.
     */
    String getRandom2Name(){
        return board.randomPlayer2GetName();
    }
    
    /**
     * The name of player 1 can be changed by calling this method.
     * @param n String represents the new name to be assigned to player 1.
     */
    void setPlayer1Name(String n){
        board.setPlayer1Name(n);
    }
    
    /**
     * The name of player 2 can be changed by calling this method.
     * @param n String represents the new name to be assigned to player 2.
     */
    void setPlayer2Name(String n){
        board.setPlayer2Name(n);
    }
    
}
