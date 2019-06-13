import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * This is the Animated Intro class.
 * It will display our company logo, followed by a short animation. It will then allow the user to
 * proceed by clicking on one of 3 buttons
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @version 4 2019.06.09
 * @author Maya Weir
 * @author Filip Milidrag
 */


public class AIntro extends JPanel implements ActionListener{

        /**
         * t creates a new Timer
         *  x represents the coordinates that are being changed
         *  move determines how many coordinates the image moves per millisecond
         *  display will state whether or not the animation is finished or if it is still loading
         *  first states when the first set of the title is displayed
         */
        //animation
        Timer t = new Timer(10,this);
        int x = 460,move = 2;
        boolean display = true, first = false;

        /**
         * This is the paint method
         * It will first display our company logo. When that is finished, it will show an animation
         * of a clock being createad. After that, the rest of the title will appear.
         * The if statements determine what the coordinates of x are, and which booleans are true in
         * order to allow the animations to appear at different times.
         *
         * @param gr creates a new Graphics2D object
         */
        public void paint(Graphics gr) {
            Graphics2D g = (Graphics2D) gr;

                g.setColor(new Color(115, 0, 230)); //purple
                g.fillRect(0, 0, 800, 650); //background
                g.setColor(Color.BLACK);
                g.fillOval(200, 105, 400, 400); //clock big circle
                g.setColor(Color.WHITE);
                g.fillOval(215, 120, 370, 370); //clock inner circle
                g.setColor(Color.BLACK);
                g.fillOval(385, 291, 30, 30); //clock centre circle
                //numbers on the clock
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
                //minute hand
                Polygon poly = new Polygon();
                poly.addPoint(393, 300);//left bottom
                poly.addPoint(393, 205);//left top
                poly.addPoint(386, 205);//left out
                poly.addPoint(401, 175);//top
                poly.addPoint(416, 205);//right out
                poly.addPoint(408, 205);//right top
                poly.addPoint(408, 300);//right bottom
                g.fillPolygon(poly);
                //hour hand
                Polygon poly2 = new Polygon();
                poly2.addPoint(395, 297);//top left
                poly2.addPoint(470, 297);//top middle
                poly2.addPoint(470, 291);//top
                poly2.addPoint(500, 305);//right
                poly2.addPoint(470, 319);//bottom
                poly2.addPoint(470, 313);//bottom middle
                poly2.addPoint(395, 313);//bottom left
                g.fillPolygon(poly2);
                //ensures that the word "loading" only appears while the clock is being created
                if (display == true) {
                    g.setColor(Color.WHITE);
                    g.setFont(new Font("calibri", Font.BOLD, 25));
                    g.drawString("LOADING .  .  .", 350, 550);
                }
                g.setColor(new Color(115, 0, 230));
                g.fillArc(199, 104, 402, 402, 90, x); //purple circle that moves to display clock
                t.start(); //starts the animation
                //has the title display once the clock is completely revealed
                if (x < 1) {
                    g.setColor(Color.BLACK);
                    g.setFont(new Font("Papyrus", Font.BOLD, 80));
                    g.drawString("Rock", 25, 160);
                    g.drawString("Clock", 535, 160);
                    g.setFont(new Font("Papyrus", Font.BOLD, 60));
                    g.drawString("around the", 240, 80);
                    first = true; //shows that the first part of the title has been displayed
                }
                //has the buttons and the bunny appear once the clock and title are shown
                if (x < 1 && first == true) {
                    Image image2 = Toolkit.getDefaultToolkit().getImage("Play.png");
                    g.drawImage(image2, 10, 160, 180, 150, this);
                    Image image3 = Toolkit.getDefaultToolkit().getImage("Bye.png");
                    g.drawImage(image3, 10, 450, 200, 150, this);
                    Image image4 = Toolkit.getDefaultToolkit().getImage("HSB.png");
                    g.drawImage(image4, 0, 300, 210, 150, this);
                    Image image5 = Toolkit.getDefaultToolkit().getImage("Bunny1.png");
                    g.drawImage(image5, 520, 300, 340, 340, this);
                    display = false; //makes "loading" go away
                }
                //makes the company logo appear until x reaches 360 and the clock animation begins
                if (x > 360) {
                    Image im = Toolkit.getDefaultToolkit().getImage("logo1.png");
                    g.drawImage(im, 240, 105, 400, 400, this);
                }
        }

        /**
         * This is the actionPerformed method
         * It allows the animation to occur
         *
         * @param e the ActionEvent
         */
            public void actionPerformed (ActionEvent e){
            if (x > 1) {
                x = x - move;
                repaint();
                }
            }


}
