package PathAndMatchGames;

import java.util.Random;

/**
 * PathGame represents the rules of the game for the Path game. It is a subclass of SuperPathMatch.
 * 
 * @author 106992
 * @version 2.0
 */
class PathGame extends SuperPathMatch {

    /**
     * This method takes in the row x and column y as its parameters, in order to check whether a move made in this position would be valid. It does so by checking if the cell in this row and column is empty or not, if is empty, it then checks if the last Square used was used in one of the neighbouring cells.
     * @param x row of the Square being checked
     * @param y column of the Square being checked
     * @return boolean returns whether the move is valid or not.
     */
    public boolean validMove(int x, int y) { 
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
                gameOver = true;
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
                gameOver = true;
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
                Player1Score  += getMovesLeft();
                gameOver = true;
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
                Player1Score  += getMovesLeft();
                gameOver = true;
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
                gameOver = true;
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
                gameOver = true;
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
                gameOver = true;
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
                gameOver = true;
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
            gameOver = true;
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
        } else if (!validMove) {
            move = "The move your are trying to make is not allowed!";
        } else if (x == 0 && y == 0) {
            if (board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x, y + 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player2GetName());
                Player2Score += getMovesLeft();
                gameOver = true;
                move = board.player2GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player2GetName());
                lastSquare = board.getSquare(x, y);
                Player1Turn = !Player1Turn;
                move = board.player2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
            }
        }
        else if (x == 7 && y == 7) {
            if (board.getSquare(x - 1, y).getNumber() != 0
                    && board.getSquare(x, y - 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player2GetName());
                Player2Score += getMovesLeft();
                gameOver = true;
                move = board.player2GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player2GetName());
                lastSquare = board.getSquare(x, y);
                move = board.player2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        }
        else if (x == 7 && y == 0) {
            if (board.getSquare(x - 1, y).getNumber() != 0
                    && board.getSquare(x, y + 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player2GetName());
                Player2Score += getMovesLeft();
                gameOver = true;
                move = board.player2GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player2GetName());
                lastSquare = board.getSquare(x, y);
                Player1Turn = !Player1Turn;
                move = board.player2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
            }
        }
        else if (x == 0 && y == 7) {
            if (board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x, y - 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player2GetName());
                Player2Score += getMovesLeft();
                gameOver = true;
                move = board.player2GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player2GetName());
                lastSquare = board.getSquare(x, y);
                Player1Turn = !Player1Turn;
                move = board.player2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
            }
        }
        else if (x == 0 && y != 0) {
            if (board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x, y + 1).getNumber() != 0
                    && board.getSquare(x, y - 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player2GetName());
                Player2Score += getMovesLeft();
                gameOver = true;
                move = board.player2GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player2GetName());
                lastSquare = board.getSquare(x, y);
                move = board.player2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        } else if (y == 0 && x != 0) {
            if (board.getSquare(x, y + 1).getNumber() != 0
                    && board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x - 1, y).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player2GetName());
                Player2Score += getMovesLeft();
                gameOver = true;
                move = board.player2GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player2GetName());
                lastSquare = board.getSquare(x, y);
                move = board.player2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        }  else if (x == 7 && y != 7) {
            if (board.getSquare(x - 1, y).getNumber() != 0
                    && board.getSquare(x, y + 1).getNumber() != 0
                    && board.getSquare(x, y - 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player2GetName());
                Player2Score += getMovesLeft();
                gameOver = true;
                move = board.player2GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player2GetName());
                lastSquare = board.getSquare(x, y);
                move = board.player2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        } else if (y == 7 && x != 7) {
            if (board.getSquare(x, y - 1).getNumber() != 0
                    && board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x - 1, y).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player2GetName());
                Player2Score += getMovesLeft();
                gameOver = true;
                move = board.player2GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.player2GetName());
                lastSquare = board.getSquare(x, y);
                move = board.player2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        }
        else if (board.getSquare(x + 1, y).getNumber() != 0
                && board.getSquare(x - 1, y).getNumber() != 0
                && board.getSquare(x, y + 1).getNumber() != 0
                && board.getSquare(x, y - 1).getNumber() != 0) {
            moveNumber++;
            board.changeSquareNumber(moveNumber, x, y);
            board.changeSquarePlayer(x, y, board.player2GetName());
            Player2Score += getMovesLeft();
            gameOver = true;
            move = board.player2GetName()+" wins. Start a new game to keep playing.";
        } else {
            moveNumber++;
            board.changeSquareNumber(moveNumber, x, y);
            board.changeSquarePlayer(x, y, board.player2GetName());
            lastSquare = board.getSquare(x, y);
            move = board.player2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
            Player1Turn = !Player1Turn;
        }
        return move;
    }
    
    /**
     * This method intakes an Integer representing either a row or a column of the last position and a random generator. It then gives out a random number depending on what the input number was.
     * @param number represents either the row or the column of the move last played.
     * @param random represents a randomizer. 
     * @return Integer is a random number produced by the randomizer.
     */
    public int showRandomInteger(int number, Random random){
        int randomNum = 0;
        if(number == 0){
            randomNum = random.nextInt(2);
        }
        else if(number == 7){
            randomNum = random.nextInt(2)-1;
        }
        else{
            randomNum = random.nextInt(3)-1;
        }
        return randomNum;
    }
    
    /**
     * This method intakes the current position on the board and checks if the random player is making the first move of the game or not. It then stores an appropriate random value in the randomRow and randomColumn fields before calling on the randomPlayer1MakeMove method to initiate the random move for a random player in position of player 1 by putting in the random row and random columns as parameters for the randomPlayer1MakeMove method.
     * @param x represents row of current position on the board.
     * @param y represents row current position on the board.
     */
    public void randomSquare1(int x, int y){
        Random randomGenerator = new Random();
        if(moveNumber == 0){
            randomRow = randomGenerator.nextInt(board.totalRows());
            randomColumn = randomGenerator.nextInt(board.totalColumns());
            randomPlayer1MakeMove(randomRow, randomColumn);
        }
        else{
            randomRow = x + showRandomInteger(x, randomGenerator);
            randomColumn = y + showRandomInteger(y, randomGenerator);
            randomPlayer1MakeMove(randomRow, randomColumn);
        }
        }
    
    /**
     * This method intakes the current position on the board and then stores an appropriate random value for the next move to be made by a random player in position of player 2. It then calls on the method to initiate a random move by a random player in position of player 2 by putting the random row and random column values as parameters.
     * @param x represents row of current position on the board.
     * @param y represents column of current position on the board.
     */
    public void randomSquare2(int x, int y){
        Random randomGenerator = new Random();
        randomRow = x + showRandomInteger(x, randomGenerator);
        randomColumn = y + showRandomInteger(y, randomGenerator);
        randomPlayer2MakeMove(randomRow, randomColumn);
    }
    
    /**
     * This method first of all checks if the new random coordinates are valid, if not, it asks for new randomly generated coordinates until a valid coordinate is found. It then marks the square at the valid coordinate and checks if this new random move is a game winning move or not, printing the outcome as a string.
     * @param x represents a random row depending on the position of the last move.
     * @param y represents a random column depending on the position of the last move. 
     * @return 
     */
    String randomPlayer1MakeMove(int x, int y){
        validMove(x,y);
        if (!validMove) {
            randomSquare1(x, y);
        } else if (x == 0 && y == 0) {
            if (board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x, y + 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer1GetName());
                randomPlayer1Score += getMovesLeft();
                gameOver = true;
                move = board.randomPlayer1GetName() +" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer1GetName());
                lastSquare = board.getSquare(x, y);
                Player1Turn = !Player1Turn;
                move = board.randomPlayer1GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player2GetName() + "'s turn.";
            }
        }
        else if (x == 7 && y == 7) {
            if (board.getSquare(x - 1, y).getNumber() != 0
                    && board.getSquare(x, y - 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer1GetName());
                randomPlayer1Score += getMovesLeft();
                gameOver = true;
                move = board.randomPlayer1GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer1GetName());
                lastSquare = board.getSquare(x, y);
                move = board.randomPlayer1GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player2GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        }
        else if (x == 7 && y == 0) {
            if (board.getSquare(x - 1, y).getNumber() != 0
                    && board.getSquare(x, y + 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer1GetName());
                randomPlayer1Score += getMovesLeft();
                gameOver = true;
                move = board.randomPlayer1GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer1GetName());
                lastSquare = board.getSquare(x, y);
                Player1Turn = !Player1Turn;
                move = board.randomPlayer1GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player2GetName() + "'s turn.";
            }
        }
        else if (x == 0 && y == 7) {
            if (board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x, y - 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer1GetName());
                randomPlayer1Score += getMovesLeft();
                gameOver = true;
                move = board.randomPlayer1GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer1GetName());
                lastSquare = board.getSquare(x, y);
                Player1Turn = !Player1Turn;
                move = board.randomPlayer1GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player2GetName() + "'s turn.";
            }
        }
        else if (x == 0 && y != 0) {
            if (board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x, y + 1).getNumber() != 0
                    && board.getSquare(x, y - 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer1GetName());
                randomPlayer1Score += getMovesLeft();
                gameOver = true;
                move = board.randomPlayer1GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer1GetName());
                lastSquare = board.getSquare(x, y);
                move = board.randomPlayer1GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player2GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        } else if (y == 0 && x != 0) {
            if (board.getSquare(x, y + 1).getNumber() != 0
                    && board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x - 1, y).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer1GetName());
                randomPlayer1Score += getMovesLeft();
                gameOver = true;
                move = board.randomPlayer1GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer1GetName());
                lastSquare = board.getSquare(x, y);
                move = board.randomPlayer1GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player2GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        }  else if (x == 7 && y != 7) {
            if (board.getSquare(x - 1, y).getNumber() != 0
                    && board.getSquare(x, y + 1).getNumber() != 0
                    && board.getSquare(x, y - 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer1GetName());
                randomPlayer1Score += getMovesLeft();
                gameOver = true;
                move = board.randomPlayer1GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer1GetName());
                lastSquare = board.getSquare(x, y);
                move = board.randomPlayer1GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player2GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        } else if (y == 7 && x != 7) {
            if (board.getSquare(x, y - 1).getNumber() != 0
                    && board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x - 1, y).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer1GetName());
                randomPlayer1Score += getMovesLeft();
                gameOver = true;
                move = board.randomPlayer1GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer1GetName());
                lastSquare = board.getSquare(x, y);
                move = board.randomPlayer1GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player2GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        }
        else if (board.getSquare(x + 1, y).getNumber() != 0
                && board.getSquare(x - 1, y).getNumber() != 0
                && board.getSquare(x, y + 1).getNumber() != 0
                && board.getSquare(x, y - 1).getNumber() != 0) {
            moveNumber++;
            board.changeSquareNumber(moveNumber, x, y);
            board.changeSquarePlayer(x, y, board.randomPlayer1GetName());
            randomPlayer1Score += getMovesLeft();
            gameOver = true;
            move = board.randomPlayer1GetName()+" wins. Start a new game to keep playing.";
        } else {
            moveNumber++;
            board.changeSquareNumber(moveNumber, x, y);
            board.changeSquarePlayer(x, y, board.randomPlayer1GetName());
            lastSquare = board.getSquare(x, y);
            move = board.randomPlayer1GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player2GetName() + "'s turn.";
            Player1Turn = !Player1Turn;
        }
        return move;
    }

    /**
     * This method first of all checks if the new random coordinates are valid, if not, it asks for new randomly generated coordinates until a valid coordinate is found. It then marks the square at the valid coordinate and checks if this new random move is a game winning move or not, printing the outcome as a string.
     * @param x represents a random row depending on the position of the last move.
     * @param y represents a random column depending on the position of the last move. 
     * @return 
     */
    String randomPlayer2MakeMove(int x, int y){
        validMove(x, y);
        if (Player1Turn) {
            move = "It is not your turn!";
            validMove = false;
        }
        if (!validMove && !Player1Turn) {
            randomSquare2(x,y);
        } else if (x == 0 && y == 0) {
            if (board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x, y + 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer2GetName());
                randomPlayer2Score += getMovesLeft();
                gameOver = true;
                move = board.randomPlayer2GetName() +" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer2GetName());
                lastSquare = board.getSquare(x, y);
                Player1Turn = !Player1Turn;
                move = board.randomPlayer2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
            }
        }
        else if (x == 7 && y == 7) {
            if (board.getSquare(x - 1, y).getNumber() != 0
                    && board.getSquare(x, y - 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer2GetName());
                randomPlayer2Score += getMovesLeft();
                gameOver = true;
                move = board.randomPlayer2GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer2GetName());
                lastSquare = board.getSquare(x, y);
                move = board.randomPlayer2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        }
        else if (x == 7 && y == 0) {
            if (board.getSquare(x - 1, y).getNumber() != 0
                    && board.getSquare(x, y + 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer2GetName());
                randomPlayer2Score += getMovesLeft();
                gameOver = true;
                move = board.randomPlayer2GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer2GetName());
                lastSquare = board.getSquare(x, y);
                Player1Turn = !Player1Turn;
                move = board.randomPlayer2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
            }
        }
        else if (x == 0 && y == 7) {
            if (board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x, y - 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer2GetName());
                randomPlayer2Score += getMovesLeft();
                gameOver = true;
                move = board.randomPlayer2GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer2GetName());
                lastSquare = board.getSquare(x, y);
                Player1Turn = !Player1Turn;
                move = board.randomPlayer2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
            }
        }
        else if (x == 0 && y != 0) {
            if (board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x, y + 1).getNumber() != 0
                    && board.getSquare(x, y - 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer2GetName());
                randomPlayer2Score += getMovesLeft();
                gameOver = true;
                move = board.randomPlayer2GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer2GetName());
                lastSquare = board.getSquare(x, y);
                move = board.randomPlayer2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        } else if (y == 0 && x != 0) {
            if (board.getSquare(x, y + 1).getNumber() != 0
                    && board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x - 1, y).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer2GetName());
                randomPlayer2Score += getMovesLeft();
                gameOver = true;
                move = board.randomPlayer2GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer2GetName());
                lastSquare = board.getSquare(x, y);
                move = board.randomPlayer2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        }  else if (x == 7 && y != 7) {
            if (board.getSquare(x - 1, y).getNumber() != 0
                    && board.getSquare(x, y + 1).getNumber() != 0
                    && board.getSquare(x, y - 1).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer2GetName());
                randomPlayer2Score += getMovesLeft();
                gameOver = true;
                move = board.randomPlayer2GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer2GetName());
                lastSquare = board.getSquare(x, y);
                move = board.randomPlayer2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        } else if (y == 7 && x != 7) {
            if (board.getSquare(x, y - 1).getNumber() != 0
                    && board.getSquare(x + 1, y).getNumber() != 0
                    && board.getSquare(x - 1, y).getNumber() != 0) {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer2GetName());
                randomPlayer2Score += getMovesLeft();
                gameOver = true;
                move = board.randomPlayer2GetName()+" wins. Start a new game to keep playing.";
            } else {
                moveNumber++;
                board.changeSquareNumber(moveNumber, x, y);
                board.changeSquarePlayer(x, y, board.randomPlayer2GetName());
                lastSquare = board.getSquare(x, y);
                move = board.randomPlayer2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
                Player1Turn = !Player1Turn;
            }
        }
        else if (board.getSquare(x + 1, y).getNumber() != 0
                && board.getSquare(x - 1, y).getNumber() != 0
                && board.getSquare(x, y + 1).getNumber() != 0
                && board.getSquare(x, y - 1).getNumber() != 0) {
            moveNumber++;
            board.changeSquareNumber(moveNumber, x, y);
            board.changeSquarePlayer(x, y, board.randomPlayer2GetName());
            randomPlayer2Score += getMovesLeft();
            gameOver = true;
            move = board.randomPlayer2GetName()+" wins. Start a new game to keep playing.";
        } else {
            moveNumber++;
            board.changeSquareNumber(moveNumber, x, y);
            board.changeSquarePlayer(x, y, board.randomPlayer2GetName());
            lastSquare = board.getSquare(x, y);
            move = board.randomPlayer2GetName()+" has marked the square in row " + x + " and column " + y + ". It is " + board.player1GetName() + "'s turn.";
            Player1Turn = !Player1Turn;
        }
        return move;
    }
}
