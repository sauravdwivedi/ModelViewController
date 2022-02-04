import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreBoardController {
  private ScoreBoardView theView;
  private ScoreBoardModel theModel;
	
  public ScoreBoardController(ScoreBoardView theView, ScoreBoardModel theModel) {
    this.theView = theView;
    this.theModel = theModel;
    this.theView.startListener(new StartListener());
    this.theView.updateListener(new UpdateListener());
    this.theView.newMatchListener(new NewMatchListener());
  }
	
  class StartListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      String firstEntry, secondEntry = "";
      try{
        firstEntry = theView.firstEntry.getText();
        secondEntry = theView.secondEntry.getText();
        theModel.startGame(firstEntry, secondEntry);
        theView.startGame(theModel.scoreBoard);
      }
      catch(NullPointerException ex){
        System.out.println(ex);
        theView.displayErrorMessage("Name can't be null");
      }
    }
  }

  class UpdateListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      int thirdEntry, fourthEntry = 0;
      try{
        thirdEntry = Integer.parseInt(theView.thirdEntry.getText());
        fourthEntry = Integer.parseInt(theView.fourthEntry.getText());
        theModel.updateScore(thirdEntry, fourthEntry);
        theView.updateScore(theModel.scoreBoard);
      }
      catch(NullPointerException ex){
        System.out.println(ex);
        theView.displayErrorMessage("Score can't be null");
      }
    }
  }

  class NewMatchListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      theModel.finishGame();
      theModel.summaries.add(0, theModel.summary);
      theModel.totalScores.add(0, theModel.totalScore);
      theView.finishGame(theModel.summary, theModel.summaries, theModel.totalScores);
    }
  }	
}
