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
 * This class represents the User Interface displayed to the user when they decide to play the path game.
 * @author 106992
 * @version 2.0
 */
class PathGUI extends JFrame{
    
    GameBoard gameBoard;
    JTable board;
    String[] player1box = new String[3];
    String[] player2box = new String[3];
    JLabel messageDisplay, l1, l2;
    JComboBox player1, player2;
    String message, player1Name, player2Name;
    SuperPathMatch moves; 
    PathGame path;
    Scores scores;
    Player player1Info, player2Info;
    boolean player1Turn;
    int moveNumber, row, column;
    private static final String PathFileSave = "Path game high scores";
    private static final String PathFileLoad = PathFileSave;
    
    /**
     * The constructor of the class introduces a new board onto the user interface, which is where the path game is played.
     * @param gameBoard represents the playing board on which the path game is played.
     */
    public PathGUI(GameBoard gameBoard) throws IOException {
        super("Path Game");
        path = new PathGame();
        message = "Play details";
        scores = new Scores();
        board = new JTable(gameBoard);
        moves = new SuperPathMatch();
        player1box[0] = "Click to select player type";
        player1box[1] = path.getPlayer1Name();
        player1box[2] = "CPU 1";
        player2box[0] = "Click to select player type";
        player2box[1] = path.getPlayer2Name();
        player2box[2] = "CPU 2";
        player1 = new JComboBox(player1box);
        player2 = new JComboBox(player2box);
        player1Info = new Player((String)player1.getSelectedItem(),moves.getPlayer1Score());
        player2Info = new Player((String)player2.getSelectedItem(),moves.getPlayer2Score());
        moveNumber = moves.moveNumber;
        player1Turn = new SuperPathMatch().getPlayer1Turn();
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
        JPanel p, players, border, boardBorder, moveSummary, resetButton, highScoreButton, resetHighScores, bottom;
        JButton reset, high, resetHigh;
        
        p = new JPanel();
        p.setLayout(new GridLayout(3, 1));
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        p.setName("Path Game");
        
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
        moveSummary.setBorder(BorderFactory.createTitledBorder("Game Details"));
        
        player1.setForeground(Color.red);
        players.add(player1);
        l1 = new JLabel("Score: " + player1Info.getScore());
        players.add(l1);
        player2.setForeground(Color.blue);
        players.add(player2);
        l2 = new JLabel("Score: " + player2Info.getScore());
        players.add(l2);
        messageDisplay = new JLabel(message);
        moveSummary.add(messageDisplay);
        
        player1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            JComboBox playertype = (JComboBox)e.getSource();
            if(playertype.getSelectedIndex() == 1){
                path.Player1Score = 0;
                path.Player2Score = 0;
                path.randomPlayer1Score = 0;
                path.randomPlayer2Score = 0;
                l1.setText("Score: " + path.getPlayer1Score());
                if(player2.getSelectedIndex() == 1){
                    l2.setText("Score: " + path.getPlayer2Score());
                }
                if(player2.getSelectedIndex() == 2){
                    l2.setText("Score: " + path.getRandomPlayer2Score());
                }
                String player = JOptionPane.showInputDialog(null,
                        "Enter the name for player 1: ",
                        "Player 1 Name",
                        JOptionPane.QUESTION_MESSAGE);
                path.setPlayer1Name(player);
                player1box[1] = path.getPlayer1Name();
                player1Info.setName(path.getPlayer1Name());
                player1.removeAllItems();
                for(String item : player1box){
                    player1.addItem(item);
                }
                player1.setSelectedIndex(1);
                newGame();
            }
            if(playertype.getSelectedIndex() == 2){
                path.Player1Score = 0;
                path.Player2Score = 0;
                path.randomPlayer1Score = 0;
                path.randomPlayer2Score = 0;
                l1.setText("Score: " + path.getRandomPlayer1Score());
                if(player2.getSelectedIndex() == 1){
                    l2.setText("Score: " + path.getPlayer2Score());
                }
                if(player2.getSelectedIndex() == 2){
                    l2.setText("Score: " + path.getRandomPlayer2Score());
                }
                newGame();
            }
            }
        });
        player2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            JComboBox playertype = (JComboBox)e.getSource();
            if(playertype.getSelectedIndex() == 1){
                path.Player1Score = 0;
                path.Player2Score = 0;
                path.randomPlayer1Score = 0;
                path.randomPlayer2Score = 0;
                if(player1.getSelectedIndex() == 1){
                    l1.setText("Score: " + path.getPlayer1Score());
                }
                if(player1.getSelectedIndex() == 2){
                    l1.setText("Score: " + path.getRandomPlayer1Score());
                }
                l2.setText("Score: " + path.getPlayer2Score());
                String player = JOptionPane.showInputDialog(null,
                        "Enter the name for player 2: ",
                        "Player 2 Name",
                        JOptionPane.QUESTION_MESSAGE);
                path.setPlayer2Name(player);
                player2box[1] = path.getPlayer2Name();
                player2Info.setName(path.getPlayer2Name());
                player2.removeAllItems();
                for(String item : player2box){
                    player2.addItem(item);
                }
                player2.setSelectedIndex(1);
                newGame();
                if(player1.getSelectedIndex() == 2){
                    randomPlayerMove();
                }
            }
            if(playertype.getSelectedIndex() == 2){
                path.Player1Score = 0;
                path.Player2Score = 0;
                path.randomPlayer1Score = 0;
                path.randomPlayer2Score = 0;
                if(player1.getSelectedIndex() == 1){
                    l1.setText("Score: " + path.getPlayer1Score());
                }
                if(player1.getSelectedIndex() == 2){
                    l1.setText("Score: " + path.getRandomPlayer1Score());
                }
                l2.setText("Score: " + path.getRandomPlayer2Score());
                newGame();
                if(player1.getSelectedIndex() == 2){
                    randomPlayerMove();
                }
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
            row = cell.getSelectedRow();
            column = cell.getSelectedColumn();
            
            if (pressed.getClickCount() == 1) {
                if(path.Player1Turn){
                    path.validMove(row, column);
                    if(path.validMove == false){
                        path.player1MakeMove(row,column);
                        board.setSelectionBackground(Color.white);
                        Component frame = null;
                        JOptionPane.showMessageDialog(frame,
                        path.move,
                        "Invalid move warning",
                        JOptionPane.WARNING_MESSAGE);
                    }
                    if(path.validMove){
                        if(player1.getSelectedIndex() == 0){
                            Component frame = null;
                            JOptionPane.showMessageDialog(frame,
                            "Please select player type for player 1",
                            "Player type not chosen",
                            JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                        path.setPlayer1Name((String) player1.getSelectedItem());
                        path.player1MakeMove(row, column);
                        board.setSelectionBackground(Color.red);
                        board.setSelectionForeground(Color.black);
                        messageDisplay.setText(path.move);
                        l1.setText("Score: " + path.getPlayer1Score());
                        player1Info.setScore(path.getPlayer1Score());
                        if(player1.getSelectedIndex() == 1){
                        scores.addPlayer(player1Info.getName(), player1Info.getScore());
                        }
                        if(player2.getSelectedIndex() == 1){
                        scores.addPlayer(player2Info.getName(), player2Info.getScore());
                        }
                        try {
                                saveData();
                            } catch (IOException ex) {
                                Logger.getLogger(PathGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        if(player2.getSelectedItem() == gameBoard.getRandomPlayer2Name() && path.gameOver == false){
                            randomPlayerMove();
                        }
                        }
                    }
                }  
                else if(path.Player1Turn == false){
                    path.validMove(row, column);
                    if(path.validMove == false){
                        path.player2MakeMove(row,column);
                        board.setSelectionBackground(Color.white);
                        Component frame = null;
                        JOptionPane.showMessageDialog(frame,
                        path.move,
                        "Invalid move warning",
                        JOptionPane.WARNING_MESSAGE);
                    }
                    if(path.validMove){
                        if(player2.getSelectedIndex() == 0){
                            Component frame = null;
                            JOptionPane.showMessageDialog(frame,
                            "Please select player type for player 2",
                            "Player type not chosen",
                            JOptionPane.WARNING_MESSAGE);
                        }
                        else{
                        path.setPlayer2Name((String) player2.getSelectedItem());
                        path.player2MakeMove(row, column);
                        board.setSelectionBackground(Color.blue);
                        board.setSelectionForeground(Color.white);
                        messageDisplay.setText(path.move);
                        l2.setText("Score: " + path.getPlayer2Score());
                        player2Info.setScore(path.getPlayer2Score());
                        if(player1.getSelectedIndex() == 1){
                        scores.addPlayer(player1Info.getName(), player1Info.getScore());
                        }
                        if(player2.getSelectedIndex() == 1){
                        scores.addPlayer(player2Info.getName(), player2Info.getScore());
                        }
                        try {
                                saveData();
                            } catch (IOException ex) {
                                Logger.getLogger(PathGUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        if(player1.getSelectedItem() == gameBoard.getRandomPlayer1Name() && path.gameOver == false){
                            randomPlayerMove();
                        }
                        }
                    }
                }
            }
        }
        });
        
        reset = new JButton("New Game");
        
        reset.addMouseListener(new MouseAdapter() {
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
                    "Path Game High Scores",
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
        resetButton.add(reset);
        bottom.add(resetButton);
        highScoreButton.add(high);
        bottom.add(highScoreButton);
        resetHighScores.add(resetHigh);
        bottom.add(resetHighScores);
        border.add(bottom, BorderLayout.SOUTH);
        
        getContentPane().add(border);
    }  
    
    /**
     * Initiates the move for the randomPlayer.
     */
    private void randomPlayerMove(){
        if(player1.getSelectedItem() == gameBoard.getRandomPlayer1Name() && path.gameOver == false){
            path.randomSquare1(row, column);
            messageDisplay.setText(path.move);
            l1.setText("Score: " + path.getRandomPlayer1Score());
            if(player2.getSelectedItem() == gameBoard.getRandomPlayer2Name() && path.gameOver == false){
                path.randomSquare2(row, column);
                messageDisplay.setText(path.move);
                l2.setText("Score: " + path.getRandomPlayer2Score());
                randomPlayerMove();
            }
        }
        else if(player1.getSelectedItem() != gameBoard.getRandomPlayer1Name() && path.gameOver == false){
            path.randomSquare2(row, column);
            messageDisplay.setText(path.move);
            l2.setText("Score: " + path.getRandomPlayer2Score());
        }
    }
    
    /**
     * Calling this method resets the board to start a new path game between the two players playing the game.
     */
    private void newGame(){
        gameBoard.resetSquares();
        board.setSelectionBackground(Color.white);
        board.setSelectionForeground(Color.black);
        path.resetMoveNumber();
        path.setPlayer1Turn();
        path.setValidMove(false);
        path.Player1Turn = true;
        path.gameOver = false;
        path.lastSquare = new Square(-1,-1);
        messageDisplay.setText("New game started. It is " + player1.getSelectedItem() + "'s turn.");
        if(player1.getSelectedIndex() == 2){
            randomPlayerMove();
        }
    }
    
    /**
     * Calling this method saves the high scores of the path game to a file.
     * @throws IOException 
     */
    private void saveData() throws IOException {
        File f = new File(PathFileSave);
        ObjectOutputStream os = new ObjectOutputStream(
            new FileOutputStream(f));
        os.writeObject(scores.highscores);
        os.close();
    }
    
    /**
     * Calling this method loads the high scores for the path game from a file.
     * @throws IOException 
     */
    private void loadData() throws IOException{
        File f = new File(PathFileLoad);
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
