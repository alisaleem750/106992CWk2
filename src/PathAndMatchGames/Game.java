
package PathAndMatchGames;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Game is the main class of the package. It contains a main method, that is used to launch the game.
 *
 * @author 106992
 * @version 2.0
 */
public class Game {
    /**
     * This is the main method of the file. It is called when the project is ran and it then asks the user to choose between the Path or the Match game, before displaying the game of their choice to them.
     * @param args 
     */
    public static void main(String[] args) throws IOException {
        GameBoard gameBoard;
        
        gameBoard = new GameBoard();
        
        Object[] gameChoice = {"Path", "Match", };
        String s = (String)JOptionPane.showInputDialog(
                    null,
                    "Which game would you like to play:\n",
                    "Choose a Game",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    gameChoice,
                    "Path");

        switch (s) {
            case "Path":
                new PathGUI(gameBoard);
                break;
            case "Match":
                new MatchGUI(gameBoard);
                break;
        }
        
        
    }
    
}
