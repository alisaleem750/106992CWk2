package PathAndMatchGames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 * This class represents the User Interface displayed to the user when they decide to play the match game.
 * @author 106992
 * @version 2.0
 */
class MatchGUI extends JFrame{
    
    GameBoard gameBoard;
    JTable board;
    JLabel l1,l2, messageDisplay;
    String message;
    String[] player1box = new String[1];
    String[] player2box = new String[1];
    JComboBox player1, player2;
    SuperPathMatch moves; 
    MatchGame match; 
    Scores scores;
    Player player1Info, player2Info;
    boolean player1Turn;
    int player1score, player2score, moveNumber;
    private static final String MatchFileSave = "Match game high scores";
    private static final String MatchFileLoad = MatchFileSave;
    
    /**
     * The constructor of the class introduces a new board onto the user interface, which is where the match game is played.
     * @param gameBoard represents the playing board on which the match game is played.
     */
    public MatchGUI(GameBoard gameBoard) throws IOException {
        super("Match Game");
        board = new JTable(gameBoard);
        moves = new SuperPathMatch();
        message = "Play details";
        scores = new Scores();
        player1box[0] = "Player 1";
        player2box[0] = "Player 2";
        player1 = new JComboBox(player1box);
        player2 = new JComboBox(player2box);
        player1Info = new Player((String)player1.getSelectedItem(),moves.getPlayer1Score());
        player2Info = new Player((String)player2.getSelectedItem(),moves.getPlayer2Score());
        moveNumber = moves.moveNumber;
        player1Turn = new SuperPathMatch().getPlayer1Turn();
        match = new MatchGame();
        this.gameBoard = gameBoard;
        createPathGame();
        loadData();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    /**
     * This method creates the user interface
     */
    private void createPathGame() {
        JPanel p, players, border, boardBorder, moveSummary, resetButton, bottom, highScoreButton, resetHighScores;
        JButton newGameButton, high, resetHigh;
        
        p = new JPanel();
        p.setLayout(new GridLayout(3, 1));
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        p.setName("Match Game");
        
        bottom = new JPanel();
        bottom.setLayout(new GridLayout(1,3));
        resetButton = new JPanel();
        highScoreButton = new JPanel();
        resetHighScores = new JPanel();
        
        players = new JPanel();
        players.setLayout(new GridLayout(3,2));
        players.setBorder(BorderFactory.createTitledBorder("Player info"));
        moveSummary = new JPanel();
        moveSummary.setLayout(new GridLayout(1,1));
        moveSummary.setBorder(BorderFactory.createTitledBorder("Game Move Details"));
        
        player1.setForeground(Color.red);
        players.add(player1);
        l1 = new JLabel("Score: " + player1score);
        players.add(l1);
        player2.setForeground(Color.blue);
        players.add(player2);
        l2 = new JLabel("Score: " + player2score);
        players.add(l2);
        messageDisplay = new JLabel(message);
        moveSummary.add(messageDisplay);
        
        player1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            JComboBox playertype = (JComboBox)e.getSource();
            if(playertype.getSelectedIndex() == 0){
                match.Player1Score = 0;
                match.Player2Score = 0;
                l1.setText("Score: " + match.getPlayer1Score());
                l2.setText("Score: " + match.getPlayer2Score());
                String player = JOptionPane.showInputDialog(null,
                        "Enter the name for player 1: ",
                        "Player 1 Name",
                        JOptionPane.QUESTION_MESSAGE);
                match.setPlayer1Name(player);
                player1box[0] = match.getPlayer1Name();
                player1Info.setName(match.getPlayer1Name());
                player1.removeAllItems();
                for(String item : player1box){
                    player1.addItem(item);
                }
                newGame();
            }
            }
        });
        player2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            JComboBox playertype = (JComboBox)e.getSource();
            if(playertype.getSelectedIndex() == 0){
                match.Player1Score = 0;
                match.Player2Score = 0;
                l1.setText("Score: " + match.getPlayer1Score());
                l2.setText("Score: " + match.getPlayer2Score());
                String player = JOptionPane.showInputDialog(null,
                        "Enter the name for player 2: ",
                        "Player 2 Name",
                        JOptionPane.QUESTION_MESSAGE);
                match.setPlayer2Name(player);
                player2box[0] = match.getPlayer2Name();
                player2Info.setName(match.getPlayer2Name());
                player2.removeAllItems();
                for(String item : player2box){
                    player2.addItem(item);
                }
                newGame();
            }
            }
        });
                       
        p.add(players);
        p.add(moveSummary);
        
        board.setVisible(true);        
        board.setGridColor(Color.black);
        board.setCellSelectionEnabled(true);
        board.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent pressed) {
            JTable cell = (JTable)pressed.getSource();
            int row = cell.getSelectedRow();
            int column = cell.getSelectedColumn();
            
            if (pressed.getClickCount() == 1) {
                if(match.Player1Turn){
                    match.validMove(row, column);
                    if(match.validMove == false){
                        match.player1MakeMove(row,column);
                        board.setSelectionBackground(Color.white);
                        Component frame = null;
                        JOptionPane.showMessageDialog(frame,
                        match.move,
                        "Invalid move warning",
                        JOptionPane.WARNING_MESSAGE);
                    }
                    if(match.validMove){
                        match.setPlayer1Name((String)player1.getSelectedItem());
                        match.player1MakeMove(row, column);
                        board.setSelectionBackground(Color.red);
                        board.setSelectionForeground(Color.black);
                        messageDisplay.setText(match.move);
                        l1.setText("Score: " + match.getPlayer1Score());
                        player1Info.setScore(match.getPlayer1Score());
                        scores.addPlayer(player1Info.getName(), player1Info.getScore());
                        scores.addPlayer(player2Info.getName(), player2Info.getScore());
                        try {
                            saveData();
                        } catch (IOException ex) {
                            Logger.getLogger(MatchGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }  
                else if(match.Player1Turn == false){
                    match.validMove(row, column);
                    if(match.validMove == false){
                        match.player2MakeMove(row,column);
                        board.setSelectionBackground(Color.white);
                        Component frame = null;
                        JOptionPane.showMessageDialog(frame,
                        match.move,
                        "Invalid move warning",
                        JOptionPane.WARNING_MESSAGE);
                    }
                    if(match.validMove){
                        match.setPlayer2Name((String)player2.getSelectedItem());
                        match.player2MakeMove(row, column);
                        board.setSelectionBackground(Color.blue);
                        board.setSelectionForeground(Color.white);
                        messageDisplay.setText(match.move);
                        l2.setText("Score: " + match.getPlayer2Score());
                        player2Info.setScore(match.getPlayer2Score());
                        scores.addPlayer(player1Info.getName(), player1Info.getScore());
                        scores.addPlayer(player2Info.getName(), player2Info.getScore());
                        try {
                            saveData();
                        } catch (IOException ex) {
                            Logger.getLogger(MatchGUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        }
                    }
            }
        }
        });
        
        newGameButton = new JButton("New Game");
        
        newGameButton.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent newGame) {
        newGame();
        }
        });
        
        high = new JButton("Show High Scores");        
        high.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent highScores) {
            Component frame = null; 
            JOptionPane.showMessageDialog(frame,
                    scores.highScore(),
                    "Match Game High Scores",
                    JOptionPane.PLAIN_MESSAGE);
        }
        });
        
        resetHigh = new JButton("Reset High Scores");
        
        resetHigh.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent highScores) {
            scores.removeScores();
            try {
                saveData();
            } catch (IOException ex) {
                Logger.getLogger(PathGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        });
        
        border = new JPanel();
        border.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        border.setLayout(new BorderLayout());
        
        boardBorder = new JPanel();
        boardBorder.setBorder(BorderFactory.createTitledBorder("Game Board"));        
        boardBorder.add(board);
        
        p.add(boardBorder);
        border.add(p, BorderLayout.CENTER);
        resetButton.add(newGameButton);
        bottom.add(resetButton);
        highScoreButton.add(high);
        bottom.add(highScoreButton);
        resetHighScores.add(resetHigh);
        bottom.add(resetHighScores);
        border.add(bottom, BorderLayout.SOUTH);
        
        border.add(p, BorderLayout.CENTER);
        
        
        getContentPane().add(border);
    }
    
    /**
     * Calling this method resets the board to start a new match game between the two players playing the game.
     */
    private void newGame(){
        gameBoard.resetSquares();
        board.setSelectionBackground(Color.white);
        board.setSelectionForeground(Color.black);
        match.resetMoveNumber();
        match.setPlayer1Turn();
        match.setValidMove(false);
        match.Player1Turn = true;
        match.lastSquare = new Square(-1,-1);
        messageDisplay.setText("New game started.");
    }
    
    /**
     * Calling this method saves the high scores of the match game to a file.
     * @throws IOException 
     */
    private void saveData() throws IOException {
        File f = new File(MatchFileSave);
        ObjectOutputStream os = new ObjectOutputStream(
            new FileOutputStream(f));
        os.writeObject(scores.highscores);
        os.close();
    }
    
    /**
     * Calling this method loads the high scores for the match game from a file.
     * @throws IOException 
     */
    private void loadData() throws IOException{
        File f = new File(MatchFileLoad);
        ObjectInputStream is = new ObjectInputStream(
            new FileInputStream(f));
        try {
            scores.highscores = (ArrayList<Player>) is.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Scores.class.getName()).log(Level.SEVERE, null, ex);
        }
        is.close();
    }
}
