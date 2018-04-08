
package PathAndMatchGames;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Scores is used to store and update the high scores of the path and match games.
 * 
 * @author 106992
 * @version 2.0
 */
public class Scores implements Serializable {
    
    ArrayList<Player> highscores;
    String scores;

    /**
     * Constructor of class Scores. Initializes the fields.
     */
    public Scores() {
        highscores = new ArrayList<Player>();
        scores = "No High Scores";
    }
       
    /**
     * This method retrieves the number of players who are on the high scores list.
     * @return Integer representing the size of the list of players on the high scores.
     */
    public int getTotalPlayers(){
        return highscores.size();
    }
    
    /**
     * A new player can be added to the high scores by calling this method. It intakes the name and the score of a player and checks if there is already an existing player with the same name. It then adds this player to the ArrayList if the new player's is not already on it or if the new player's score is better than the player with the same name already on the ArrayList, replacing the old player with the new one.
     * @param name String represents the name of the player to be added to the high scores list.
     * @param score Integer represents the score of the player to be added to the high scores list.
     */
    public void addPlayer(String name, int score){
        Player p = new Player(name,score);
        boolean exists = false;
        for(int i = 0; i<getTotalPlayers(); i++){
            if(highscores.get(i).getName().equals(p.getName()) && highscores.get(i).getScore() >= p.getScore()){
                exists = true;
            }
            else if(highscores.get(i).getName().equals(p.getName()) && highscores.get(i).getScore() < p.getScore()){
                highscores.remove(i);
                highscores.add(p);
                exists = true;
            }
        }
        if(score == 0){
            exists = true;
            }
        if(!exists){
                highscores.add(p);
            }
    }
    
    /**
     * Calling this method returns the list of high scores from the high scores ArrayList. It calls on the sortScores method to sort the list from best score to worst, before displaying each score on a new line.
     * @return String representing the high scores for the path or the match game.
     */
    public String highScore(){   
        sortScores();
        if(!highscores.isEmpty()){
            scores = "";
        }
        for(int i = 0; i<getTotalPlayers(); i++){
        scores += "\n"+(i+1) + ". " + highscores.get(i).getName()+ " - " + highscores.get(i).getScore();
        }
        return scores;
    }

    /**
     * Calling this method sorts the scores in the high scores ArrayList from best score to worst score.
     */
    public void sortScores() {
        Player temp = null;
        for(int i = 0; i<getTotalPlayers(); i++){
            for(int j = i+1; j<getTotalPlayers(); j++){
                if(highscores.get(i).getScore() < highscores.get(j).getScore()){
                    temp = highscores.get(j);
                    highscores.remove(j);
                    highscores.add(i, temp);
                }
        }
        }
    }
    
    /**
     * Calling this method removes all the existing high scores.
     */
    public void removeScores(){
        highscores.clear();
        scores = "No High Scores";
    }
}
