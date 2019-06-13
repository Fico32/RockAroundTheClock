import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This is the Intro class.
 * It will allow the user to
 * proceed by clicking on one of 3 buttons
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @version 4 2019.06.09
 * @author Maya Weir
 * @author Filip Milidrag
 */
public class Intro  extends JPanel {

		/**This method draws the intro screen
		* @param gr represents the Graphics class used to draw on the JPanel
		*/
        public void paint(Graphics gr) {
            Graphics2D g = (Graphics2D) gr;
            //image
            Image image = Toolkit.getDefaultToolkit().getImage("Background.jpg");
            g.drawImage(image, 0, 0, 800, 650, this);
            //drawing
            g.setColor(Color.BLACK);
            g.fillOval(200, 105, 400, 400);
            g.setColor(Color.WHITE);
            g.fillOval(215, 120, 370, 370);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Calibri", Font.BOLD, 37));
            g.drawString("12", 385, 155);
            g.drawString("1", 477, 185);
            g.drawString("2", 530, 235);
            g.drawString("3", 555, 315);
            g.drawString("4", 530, 395);
            g.drawString("5", 465, 455);
            g.drawString("6", 388, 485);
            g.drawString("7", 313, 455);
            g.drawString("8", 241, 395);
            g.drawString("9", 220, 315);
            g.drawString("10", 241, 240);
            g.drawString("11", 300, 185);
            g.fillOval(385, 290, 30, 30);
            Polygon poly = new Polygon();
            poly.addPoint(393, 300);//left bottom
            poly.addPoint(393, 205);//left top
            poly.addPoint(386, 205);//left out
            poly.addPoint(401, 175);//top
            poly.addPoint(416, 205);//right out
            poly.addPoint(408, 205);//right top
            poly.addPoint(408, 300);//right bottom
            g.fillPolygon(poly);
            Polygon poly2 = new Polygon();
            poly2.addPoint(395, 297);//top left
            poly2.addPoint(470, 297);//top middle
            poly2.addPoint(470, 291);//top
            poly2.addPoint(500, 305);//right
            poly2.addPoint(470, 319);//bottom
            poly2.addPoint(470, 313);//bottom middle
            poly2.addPoint(395, 313);//bottom left
            g.fillPolygon(poly2);
            //animate hands

            //title
            g.setFont(new Font("Papyrus", Font.BOLD, 80));
            g.drawString("Rock", 25, 160);
            g.drawString("Clock", 535, 160);
            g.setFont(new Font("Papyrus", Font.BOLD, 60));
            g.drawString("around the", 240, 80);

            //buttons
            Image image2 = Toolkit.getDefaultToolkit().getImage("Play.png");
            g.drawImage(image2, 10, 160, 180, 150, this);
            Image image3 = Toolkit.getDefaultToolkit().getImage("Bye.png");
            g.drawImage(image3, 10, 450, 200, 150, this);
            Image image4 = Toolkit.getDefaultToolkit().getImage("HSB.png");
            g.drawImage(image4, 0, 300, 210, 150, this);
            Image image5 = Toolkit.getDefaultToolkit().getImage("Bunny1.png");
            g.drawImage(image5, 520, 300, 340, 340, this);
        }

}
