package PathAndMatchGames;

import java.io.Serializable;

/**
 * Player represents a player in the path or match game.
 * 
 * @author 106992
 * @version 2.0
 */
public class Player implements Serializable {
    String name;
    int score;
    
    /**
     * Constructor of the Player class. It intakes a String and an Integer as parameters, representing the name and the score of the player.
     * @param name
     * @param score 
     */
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
    
    /**
     * This method retrieves the name of the player.
     * @return String representing name of the player.
     */
    String getName(){
        return name;
    }
    
    /**
     * Calling this method sets a new name for the player.
     * @param newName String representing the new name of the player.
     */
    void setName(String newName){
        name = newName;
    }
    
    /**
     * This method retrieves the score of the player.
     * @return Integer representing the score.
     */
    int getScore(){
        return score;
    }
    
    /**
     * Calling this method sets a new score for the player.
     * @param newScore Integer represents the new score.
     */
    void setScore(int newScore){
        score = newScore;
    }
}
