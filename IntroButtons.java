import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 * This is the IntroButtons class.
 * It is a mouse listener that is used throught out the game
 * to identify where the mouse is when it is clicked
 * It is also used to progress through the levels
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @version 4 2019.06.09
 * @author Maya Weir
 * @author Filip Milidrag
 */
public class IntroButtons implements MouseListener {

    JFrame frame;
	int[][] coordinates = {{366,439,481,497,485,421,362,281,221,212,223,287},{120,141,197,271,332,397,415,394,339,263,185,130},{388,472,520,538,512,463,383,326,272,257,282,319},{158,182,226,302,384,430,453,438,377,302,232,191}};
	public static boolean hoursPicked = false;
	int[][] Level3Objects = {{692,335,779,395},{456,149,599,351},{47,64,147,193}};
	int [][] Level2Clocks = {{70,185, 205, 320}, {243, 80, 378, 215}, {390, 185, 525, 320}, {551, 80, 686, 215}};
	public static int count = 0;
	String name;
	
	/**Sets the frame variable to the parameter passed
	* @param f represents a JFrame that this mous listener is being used in
	*/
    public IntroButtons(JFrame f)
    {
            frame = f;
    }
	/**Based on which level is being played and where the player clicked executes waht should happen in the game
	* @param e represents a mouse event
	*/
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
		if (RockAroundTheClock.displayingString.equals("Intro"))
		{
			if (x >= 10 && x <= 185 && y >= 240 && y <= 275) {
				frame.remove(RockAroundTheClock.displaying);
				RockAroundTheClock.displaying = new Level1Background();
				RockAroundTheClock.displayingString = "Level1";
				frame.add(RockAroundTheClock.displaying);
				frame.setVisible(true);
			}
			else if (x >= 14 && x <= 207 && y >= 380 && y <= 435) {
				frame.remove(RockAroundTheClock.displaying);
				RockAroundTheClock.displaying = new HighScores();
				RockAroundTheClock.displayingString = "High Scores";
				frame.add(RockAroundTheClock.displaying);
				frame.setVisible(true);
			}
			else if (x >= 24 && x <= 210 && y >= 514 && y <= 601) {
				frame.remove(RockAroundTheClock.displaying);
				RockAroundTheClock.displaying = new GoodBye(frame);
				RockAroundTheClock.displayingString = "Bye";
				frame.add(RockAroundTheClock.displaying);
				frame.setVisible(true);
			}
		}
		else if (RockAroundTheClock.displayingString.equals("High Scores"))
		{
				frame.remove(RockAroundTheClock.displaying);
				RockAroundTheClock.displaying = new Intro();
				RockAroundTheClock.displayingString = "Intro";
				frame.add(RockAroundTheClock.displaying);
				frame.setVisible(true);
		}
		else if (RockAroundTheClock.displayingString.equals("Level1"))
		{
			if (hoursPicked && x >= coordinates[0][Level1Background.min] && x <= coordinates[2][Level1Background.min] && y >= coordinates[1][Level1Background.min] && y <= coordinates[3][Level1Background.min])
			{
				frame.remove(RockAroundTheClock.displaying);
				RockAroundTheClock.displaying = new Level2Background();
				RockAroundTheClock.displayingString = "Level2";
				frame.add(RockAroundTheClock.displaying);
				frame.setVisible(true); 
				Level1Background.wrong = false;
			}
			else if (x >= coordinates[0][Level1Background.hour] && x <= coordinates[2][Level1Background.hour] && y >= coordinates[1][Level1Background.hour] && y <= coordinates[3][Level1Background.hour])
			{
				hoursPicked = true;
			}
			else
			{
				Level1Background.wrong = true;
				RockAroundTheClock.displaying.repaint();
			}
		}
		else if (RockAroundTheClock.displayingString.equals("Level2"))
		{
				if (x >= Level2Clocks[Level2Background.correctClock][0] && x <= Level2Clocks[Level2Background.correctClock][2] && y >= Level2Clocks[Level2Background.correctClock][1] && y <= Level2Clocks[Level2Background.correctClock][3])
				{
					frame.remove(RockAroundTheClock.displaying);
					RockAroundTheClock.displaying = new Level3Background();
					RockAroundTheClock.displayingString = "Level3";
					frame.add(RockAroundTheClock.displaying);
					frame.setVisible(true);
					Level2Background.wrong = false;
				}
				else
				{
					RockAroundTheClock.score-=100;
					Level2Background.wrong = true;
					RockAroundTheClock.displaying.repaint();
				}
        }
		else if (RockAroundTheClock.displayingString.equals("Level3"))
		{
			if (x >= Level3Objects[count][0] && x <= Level3Objects[count][2] && y >= Level3Objects[count][1] && y <= Level3Objects[count][3] && Level3Background.min == Level3Background.Level3Times[count][1] && Level3Background.hour == Level3Background.Level3Times[count][0])
			{
				if (count == 2)
				{
					name = JOptionPane.showInputDialog("You have beaten the game, type in your name to save your score. You will then go back to the main menu.");
					frame.remove(RockAroundTheClock.displaying);
					RockAroundTheClock.displaying = new Intro();
					RockAroundTheClock.displayingString = "Intro";
					frame.add(RockAroundTheClock.displaying);
					frame.setVisible(true);
					HighScores h = new HighScores();
					h.addScore(RockAroundTheClock.score,name);
				}
				else
				{
						count++;
						RockAroundTheClock.displaying.repaint();
				}
			}
			else if (x >= 300&& x <= 435 && y >= 35 && y <= 170)
			{
				if (Level3Background.min==1)
				{
					Level3Background.hour++;
					Level3Background.hour = Level3Background.hour%12;
					Level3Background.min--;
				}	
				else
					Level3Background.min++;
				RockAroundTheClock.displaying.repaint();
			}
			else
			{
				RockAroundTheClock.score-=100;
			}

		}
    }
	/**Implements methods that exist in the mouse listener interface but does not do anything since it is not used by the program
	*/
    public void mouseEntered(MouseEvent e) {}
	/**Implements methods that exist in the mouse listener interface but does not do anything since it is not used by the program
	*/
    public void mouseExited(MouseEvent e) {}
	/**Implements methods that exist in the mouse listener interface but does not do anything since it is not used by the program
	*/
    public void mousePressed(MouseEvent e) {}
	/**Implements methods that exist in the mouse listener interface but does not do anything since it is not used by the program
	*/
    public void mouseReleased(MouseEvent e) {  }
	



}

