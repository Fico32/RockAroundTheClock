import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This is the Goodbye class.
 * It will display a short animation, followed by a goodbye message
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @version 2019.06.09
 * @author Maya Weir
 * @author Filip Milidrag
 */

public class GoodBye extends JPanel implements ActionListener{
    /**
     * t creates a new Timer
     * x represents the coordinates that are being changed
     * frame represents the JFrame this is being painted in
     */
    Timer t = new Timer (2,this);
    int x = 0, move = 5;
	JFrame frame;

	
	/**Sets the frame variable to the parameter passed
	* @param f represents a JFrame that this mous listener is being used in
	*/
	public GoodBye(JFrame f)
	{
		frame =f;
	}
	
    /**
     * This is the paint method
     * It will display the clock and the bunny in opposite corners. Each will move across the screen.
     * When they are off the screen, a goodbye message will be displayed
     *
     * The if statements determine what the coordinates of x are
     *
     * @param gr creates a new Graphics2D object
     */
    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        //code
        Image image = Toolkit.getDefaultToolkit().getImage("Background.jpg");
        g.drawImage(image, 0, 0, 800, 650, this);

        g.setColor(Color.BLACK);
        g.fillOval(15+x, 20+x, 370, 370); //clock big circle
        g.setColor(Color.WHITE);
        g.fillOval(30+x, 35+x, 340, 340); //clock inner circle
        g.setColor(Color.BLACK);
        //numbers on the clock
        g.setFont(new Font("Calibri", Font.BOLD, 27));
        g.drawString("12", 185+x, 60+x);
        g.drawString("1", 277+x, 85+x);
        g.drawString("2", 330+x, 135+x);
        g.drawString("3", 350+x, 215+x);
        g.drawString("4", 330+x, 295+x);
        g.drawString("5", 265+x, 355+x);
        g.drawString("6", 188+x, 373+x);
        g.drawString("7", 113+x, 353+x);
        g.drawString("8", 52+x, 295+x);
        g.drawString("9", 30+x, 215+x);
        g.drawString("10", 50+x, 140+x);
        g.drawString("11", 100+x, 85+x);
        //minute hand
        Polygon poly = new Polygon();
        poly.addPoint(195+x, 200+x);
        poly.addPoint(195+x, 117+x);
        poly.addPoint(188+x, 117+x);
        poly.addPoint(201+x, 87+x);
        poly.addPoint(214+x, 117+x);
        poly.addPoint(206+x, 117+x);
        poly.addPoint(206+x, 200+x);
        g.fillPolygon(poly);
        //hour hand
        Polygon poly2 = new Polygon();
        poly2.addPoint(195+x, 199+x);
        poly2.addPoint(260+x, 199+x);
        poly2.addPoint(260+x, 193+x);
        poly2.addPoint(290+x, 205+x);
        poly2.addPoint(260+x, 217+x);
        poly2.addPoint(260+x, 211+x);
        poly2.addPoint(195+x, 211+x);
        g.fillPolygon(poly2);
        g.setColor(Color.BLACK);
        g.fillOval(190+x, 195+x, 20, 20); //clock centre circle

        //bunny
        Image image5 = Toolkit.getDefaultToolkit().getImage("Bunny1.png");
        g.drawImage(image5, 570-x, 350-x, 290, 290, this);
        t.start(); //starts the animation
        //if the clock and bunny are off screen, the message will appear
        if (x > 815) {
            g.setFont(new Font("Papyrus", Font.BOLD, 100));
            g.drawString("Thank You", 150, 200);
            g.drawString("For", 300, 300);
            g.drawString("Playing", 210, 400);
        }
		if (x>5000)
			frame.dispose();
    }

        /**
        * This is the actionPerformed method
        * It allows the animation to occur
        *
        * @param e the ActionEvent
        */
        public void actionPerformed (ActionEvent e){
            x = x + move;
            repaint();
        }
}
