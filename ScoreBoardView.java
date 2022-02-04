import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.*;

public class ScoreBoardView extends JFrame{
  JLabel teamA = new JLabel("Home team          ");
  JTextField firstEntry  = new JTextField(10);
  JLabel teamB = new JLabel("Away team           ");
  JTextField secondEntry = new JTextField(10);
  JButton startButton = new JButton("Start match");
  JLabel scoreBoard = new JLabel("Scoreboard");
  JLabel teamAScore = new JLabel("Home team score");
  JTextField thirdEntry = new JTextField(10);
  JLabel teamBScore = new JLabel("Away team score");
  JTextField fourthEntry = new JTextField(10);
  JButton updateButton = new JButton("Update score");
  JTextField score = new JTextField(15);
  JButton newMatchButton = new JButton("New Match");
  JLabel summaryLabel = new JLabel("Summary");
  JTextField summary = new JTextField(50);
  
  ScoreBoardView(){		
    // Sets up the view and adds the components
    JPanel startPanel = new JPanel();
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(700, 400);
		
    startPanel.add(teamA);
    startPanel.add(firstEntry);
    startPanel.add(teamB);
    startPanel.add(secondEntry);
    startPanel.add(startButton);
    startPanel.add(teamAScore);
    startPanel.add(thirdEntry);
    startPanel.add(teamBScore);
    startPanel.add(fourthEntry);
    startPanel.add(updateButton);
    startPanel.add(scoreBoard);
    startPanel.add(score);
    startPanel.add(newMatchButton);
    startPanel.add(summaryLabel);
    startPanel.add(summary);
    this.add(startPanel);
		
    // End of setting up the components --------
    }
	
    public void startGame(String initialScore){
      score.setText(initialScore);
    }
    
    public void updateScore(String updatedScore){
      score.setText(updatedScore);
    }
    
    public void finishGame(String summaryGame, ArrayList<String> summaries, ArrayList<Integer> totalScores){
      firstEntry.setText("");
      secondEntry.setText("");
      thirdEntry.setText("");
      fourthEntry.setText("");
      score.setText(" - - ");
      summary.setText(summaries.toString());
    }
    // If the startButton is clicked execute a method
    // in the Controller named actionPerformed
	
    void startListener(ActionListener listenForStartButton){
      startButton.addActionListener(listenForStartButton);
    }
    
    void updateListener(ActionListener listenForUpdateButton){
      updateButton.addActionListener(listenForUpdateButton);
    }
    
    void newMatchListener(ActionListener listenForNewMatchButton){
      newMatchButton.addActionListener(listenForNewMatchButton);
    }
	
    // Open a popup that contains the error message passed
    void displayErrorMessage(String errorMessage){
      JOptionPane.showMessageDialog(this, errorMessage);
    }
}
