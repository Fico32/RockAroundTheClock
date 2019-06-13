import java.awt.*;
import javax.swing.*;


/**
 * This is the RockAroundTheClock class.
 * It will run all the other classes together in a main method
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @version 4 2019.06.09
 * @author Maya Weir
 * @author Filip Milidrag
 */
public class RockAroundTheClock
{

	public static JPanel displaying = new AIntro();
	public static String displayingString = "Intro";
	public static int score = 10000;

	/**This method runs the game
		* 
		*/
    public static void main(String[]args)
    {
        JFrame j = new JFrame();
		IntroButtons ib = new IntroButtons(j);
        j.addMouseListener(ib);
		j.add(displaying);
        j.setSize(800,650);
        j.setVisible(true);
		j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}