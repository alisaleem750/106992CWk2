
package PathAndMatchGames;

/**
 * MatchGame represents the rules of the game for the Match game. It is a subclass of SuperPathMatch.
 * 
 * @author 106992
 * @version 2.0
 */
public class MatchGame extends SuperPathMatch {

    /**
     * This method takes in the row x and column y as its parameters, in order to check whether a move made in this position would be valid. For player 1, It does so by checking if the cell in this row and column is empty or not, then for player 2 it checks if the last Square used was used in one of the neighbouring cells in addition to checking if the cell at the row and column is already used or not.
     * @param x row of the Square being checked
     * @param y column of the Square being checked
     * @return boolean returns whether the move is valid or not.
     */
    public boolean validMove(int x, int y) {
        if(!Player1Turn){
        if(board.getSquare(x, y).getNumber() != 0){
            validMove = false;
        }
        else if(lastSquare.getRow() == -1 && lastSquare.getColumn() == -1){
            validMove = true;
        }
        else if (x == 0 && y == 0){
            if (lastSquare == board.getSquare(x+1, y) ||
                lastSquare == board.getSquare(x, y+1)){
                validMove = true;
            }
            else{
                validMove = false;
            }
        }
        else if (x == 0 && y == 7){
            if (lastSquare == board.getSquare(x+1, y) ||
                lastSquare == board.getSquare(x, y-1)){
                validMove = true;
            }
            else{
                validMove = false;
            }
        }
        else if (x == 7 && y == 0){
            if (lastSquare == board.getSquare(x-1, y) ||
                lastSquare == board.getSquare(x, y+1)){
                validMove = true;
            }
            else{
                validMove = false;
            }
        }
        else if(x == 7 && y == 7){
            if (lastSquare == board.getSquare(x-1, y) ||
                lastSquare == board.getSquare(x, y-1)){
                validMove = true;
            }
            else{
                validMove = false;
            }
        }
        else if (x == 0 && y != 0){
            if(lastSquare == board.getSquare(x, y+1) ||
               lastSquare == board.getSquare(x, y-1) ||
               lastSquare == board.getSquare(x+1, y)){
               validMove = true;
            }
            else{
                validMove = false;
            }
        }
        else if (y == 0 && x!= 0){
            if(lastSquare == board.getSquare(x, y+1) ||
               lastSquare == board.getSquare(x-1, y) ||
               lastSquare == board.getSquare(x+1, y)){
               validMove = true;
            }
            else {
                validMove = false;
            }
        }
        else if (x == 7 && y != 7){
            if(lastSquare == board.getSquare(x, y+1) ||
               lastSquare == board.getSquare(x, y-1) ||
               lastSquare == board.getSquare(x-1, y)){
                validMove = true;
            }
            else{
                validMove = false;
            }
        }
        else if (y == 7 && x != 7){
            if(lastSquare == board.getSquare(x-1, y) ||
               lastSquare == board.getSquare(x, y-1) ||
               lastSquare == board.getSquare(x+1, y)){
                validMove = true;
            }
            else{
                validMove = false;
            }
        }
        else if(lastSquare == board.getSquare(x-1, y) ||
                lastSquare == board.getSquare(x+1, y) ||
                lastSquare == board.getSquare(x, y+1) ||
                lastSquare == board.getSquare(x, y-1)){
            validMove = true;
        }
        else{
            validMove = false;
        }
        }
        if (Player1Turn) {
            if (board.getSquare(x, y).getNumber() != 0) {
                validMove = false;
            } else {
                validMove = true;
            }
        }
        return validMove;
    }
    
    /**
     * This method first checks if it is the turn of player 1, then it checks if the move is valid or not, passing both of these tests, it finally checks whether or not the move made by the user is a game winning move or not and returns the outcome as a String.
     * @param x row of Square selected by player 1.
     * @param y column of Square selected by player 1.
     * @return String represents the outcome of the move played by player 1.
     */
        String player1MakeMove(int x, int y) {
        validMove(x, y);
        if (!Player1Turn) {
            move = "It is not your turn!";
            validMove = false;
        } else if (!validMove) {
            move = "The move your are trying to make is not allowed!";
        } else if (x == 0 && y == 0) {
            if (board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x, y + 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player1GetName());
                Player1Score += getMovesLeft();
                move = board.player1GetName() +" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player1GetName());
                lastSquare = board.getSquare(x, y);
                Player1Turn = !Player1Turn;
                move = board.player1GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player2GetName() + "'s turn.";
            }
        }
        else if (x == 0 && y == 7) {
            if (board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x, y - 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player1GetName());
                Player1Score += getMovesLeft();
                Player1Turn = false;
                move = board.player1GetName()+" wins. Start a new game to keep playing.";
                
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player1GetName());
                lastSquare = board.getSquare(x, y);
                Player1Turn = !Player1Turn;
                move = board.player1GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player2GetName() + "'s turn.";
            }
        } else if (x == 7 && y == 7) {
            if (board.getSquare(x - 1, y).getNumber() != 0
                    && board.getSquare(x, y - 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player1GetName());
                Player1Score += getMovesLeft();
                Player1Turn = false;
                move = board.player1GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player1GetName());
                lastSquare = board.getSquare(x, y);
                move = board.player1GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player2GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        }
        else if (x == 7 && y == 0) {
            if (board.getSquare(x - 1, y).getNumber() != 0
                    && board.getSquare(x, y + 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player1GetName());
                Player1Score += getMovesLeft();
                Player1Turn = false;
                move = board.player1GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player1GetName());
                lastSquare = board.getSquare(x, y);
                Player1Turn = !Player1Turn;
                move = board.player1GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player2GetName() + "'s turn.";
            }
        }
            else if (x == 0 && y != 0) {
            if (board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x, y + 1).getNumber() != 0
                    && board.getSquare(x, y - 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player1GetName());
                Player1Score += getMovesLeft();
                Player1Turn = false;
                move = board.player1GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player1GetName());
                lastSquare = board.getSquare(x, y);
                move = board.player1GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player2GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
                    }
        } else if (y == 0 && x != 0) {
            if (board.getSquare(x, y + 1).getNumber() != 0
                    && board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x - 1, y).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player1GetName());
                Player1Score += getMovesLeft();
                Player1Turn = false;
                move = board.player1GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player1GetName());
                lastSquare = board.getSquare(x, y);
                move = board.player1GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player2GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        } else if (x == 7 && y != 7) {
            if (board.getSquare(x - 1, y).getNumber() != 0
                    && board.getSquare(x, y + 1).getNumber() != 0
                    && board.getSquare(x, y - 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player1GetName());
                Player1Score += getMovesLeft();
                Player1Turn = false;
                move = board.player1GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player1GetName());
                lastSquare = board.getSquare(x, y);
                move = board.player1GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player2GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        } else if (y == 7 && x != 7) {
            if (board.getSquare(x, y - 1).getNumber() != 0
                    && board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x - 1, y).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player1GetName());
                Player1Score += getMovesLeft();
                Player1Turn = false;
                move = board.player1GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player1GetName());
                lastSquare = board.getSquare(x, y);
                move = board.player1GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player2GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        } else if (board.getSquare(x + 1, y).getNumber() != 0
                && board.getSquare(x - 1, y).getNumber() != 0
                && board.getSquare(x, y + 1).getNumber() != 0
                && board.getSquare(x, y - 1).getNumber() != 0) {
            moveNumber++;
            board.changeSquareNumber(moveNumber, x, y);
            board.changeSquarePlayer(x, y, board.player1GetName());
            Player1Score += getMovesLeft();
            Player1Turn = false;
            move = board.player1GetName()+" wins. Start a new game to keep playing.";
        } else {
            moveNumber++;
            board.changeSquareNumber(moveNumber, x, y);
            board.changeSquarePlayer(x, y, board.player1GetName());
            lastSquare = board.getSquare(x, y);
            move = board.player1GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player2GetName() + "'s turn.";
            Player1Turn = !Player1Turn;
        }
        return move;
    }

    /**
     * This method first checks if it is the turn of player 2, then it checks if the move is valid or not, passing both of these tests, it finally checks whether or not the move made by the user is a game winning move or not and returns the outcome as a String.
     * @param x row of Square selected by player 2.
     * @param y column of Square selected by player 2.
     * @return String represents the outcome of the move played by player 2.
     */
    String player2MakeMove(int x, int y) {
        validMove(x, y);
        if (Player1Turn) {
            move = "It is not your turn!";
            validMove = false;
        } 
        else if (!validMove) {
            move = "The move your are trying to make is not allowed!";
        } 
        else if (getMovesLeft() == 1) {
            moveNumber++;
            board.changeSquareNumber(moveNumber, x, y);
            board.changeSquarePlayer(x, y, board.player2GetName());
            Player2Score += moveNumber;
            Player1Turn = true;
            move = board.player2GetName()+" wins. Start a new game to keep playing.";
        }
        else {
            moveNumber++;
            board.changeSquareNumber(moveNumber, x, y);
            board.changeSquarePlayer(x, y, board.player2GetName());
            lastSquare = board.getSquare(x, y);
            move = board.player2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
            Player1Turn = !Player1Turn;
        }
        return move;
    }
}
