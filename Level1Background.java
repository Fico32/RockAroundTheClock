import java.awt.*;
import javax.swing.*;

/**
 * This is the Level1Background class.
 * It will display the background for level 1 and contains information used by IntroButtons to check if the user is correct or not
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @version 4 2019.06.09
 * @author Maya Weir
 * @author Filip Milidrag
 */
public class Level1Background extends JPanel{

		public static int hour,min;
		public static boolean wrong = false;

		/**This constructor sets random values for the time
		* 
		*/
		public Level1Background()
		{
			hour = (int)(Math.random()*12);
			min = (int)(Math.random()*12);
		}
		
		/**This method draws the Level 1 Background
		* @param g represents the Graphics class used to draw on the JPanel
		*/
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
			//colours
            Color hours = new Color (0,179,0);
            Color minutes = new Color (0,0,204);
            //code
            Image image = Toolkit.getDefaultToolkit().getImage("Background.jpg");
            g2.drawImage(image, 0, 0, 800, 650, this);
            g2.setColor(Color.BLACK);
            g2.fillOval(185, 70, 370, 370); //clock
            g2.setColor (Color.WHITE);
            g2.fillOval(200, 85, 340, 340); //clock
            g2.setColor (new Color (224,224,209));
            g2.fillRoundRect (10,470,580,135,15,15); //bottom top text box
            Polygon polyA = new Polygon();
            polyA.addPoint (580,500);
            polyA.addPoint (650,490);
            polyA.addPoint (580, 570);
            g2.fillPolygon (polyA); //speech bubble bottom
            g2.fillRoundRect (593, 88, 200, 264,15,15); //right text box
            Polygon polyB = new Polygon();
            polyB.addPoint(700,350);
            polyB.addPoint(710,410);
            polyB.addPoint(770,350);
            g2.fillPolygon (polyB); //speech bubble right
            g2.fillRoundRect (272, 0, 186, 54,15,15); //time box
			g2.setColor(Color.BLACK);
            g2.setFont (new Font ("Calibri", Font.PLAIN, 40));
			if (hour ==0)
			{
				if (min*5<10)
					g2.drawString(12 + " : 0" + min*5, 310, 40);
				else 
					g2.drawString(12 + " : " + min*5, 310, 40);
			}
			else
			{
				if (min*5<10)
					g2.drawString(hour + " : 0" + min*5, 310, 40);
				else 
					g2.drawString(hour + " : " + min*5, 310, 40);
			}
            g2.setColor(Color.BLACK);
            g2.setFont (new Font ("Calibri", Font.PLAIN, 18));
			if (wrong)
			{
				g2.drawString ("Try again, its ok to keep trying this level will", 25,495);
				g2.drawString ("not affect your score. HINT: If the minute", 25,520);
				g2.drawString ("is not 0, the hour hand should be between the current hour", 25, 545);
				if (IntroButtons.hoursPicked)
				{
					g2.drawString ("and the next one. You go tthe right hour now find the minutes.", 25, 570);
				}
				else
					g2.drawString ("and the next one.", 25, 570);
			}
			else
			{
				g2.drawString ("Use your mouse to show where the hour hand should be ", 25,495); //top text box
				g2.drawString ("click on the number that the hours hand should point to, then", 25, 520);
				g2.drawString ("on the number the minute hand should point to. HINT: If the minutes", 25, 545);
				g2.drawString ("is not 0, the hour hand should be between the current hour", 25, 570);
				g2.drawString ("and the next one.", 25, 595);
			}
			
            g2.drawString ("Find the minutes by", 600, 115); //right text box
            g2.drawString ("counting by 5:", 600, 135);
            g2.drawString ("1 = 5", 600, 165);
            g2.drawString ("2 = 10", 600, 185);
            g2.drawString ("3 = 15", 600, 205);
            g2.drawString ("4 = 20", 600, 225);
            g2.drawString ("5 = 25", 600, 245);
            g2.drawString ("6 = 30", 600, 265);
            g2.drawString ("7 = 35", 690, 165);
            g2.drawString ("8 = 40", 690, 185);
            g2.drawString ("9 = 45", 690, 205);
            g2.drawString ("10 = 50", 680, 225);
            g2.drawString ("11 = 55", 680, 245);
            g2.drawString ("12 = 0", 680, 265);
            g2.drawString ("Remember: After", 600, 300);
            g2.drawString ("59, the minutes", 600, 320);
            g2.drawString ("go back to 0!", 600,340);
            g2.setColor (hours);
            g2.setFont(new Font("Calibri", Font.BOLD, 27));
            g2.drawString("12", 355, 110);
            g2.drawString("1", 447, 135);
            g2.drawString("2", 500, 185);
            g2.drawString("3", 520, 265);
            g2.drawString("4", 500, 345);
            g2.drawString("5", 435, 405);
            g2.drawString("6", 358, 423);
            g2.drawString("7", 283, 403);
            g2.drawString("8", 222, 345);
            g2.drawString("9", 200, 265);
            g2.drawString("10", 220, 190);
            g2.drawString("11", 270, 135);
            g2.setColor (minutes);
            g2.setFont (new Font ("Calibri", Font.BOLD, 20));
            g2.drawString ("0", 365, 130);
            g2.drawString ("5", 433,150);
            g2.drawString ("10", 470, 195);
            g2.drawString ("15", 487, 265);
            g2.drawString ("20", 470,330);
            g2.drawString ("25", 425, 380);
            g2.drawString ("30", 356, 400);
            g2.drawString ("35", 300, 380);
            g2.drawString ("40", 246, 330);
            g2.drawString ("45", 220,265);
            g2.drawString ("50",253, 195);
            g2.drawString ("55", 300,150);
            Polygon poly = new Polygon();//minute hand
            poly.addPoint(365, 250);
            poly.addPoint(365, 167);
            poly.addPoint(358, 167);
            poly.addPoint(371, 137);
            poly.addPoint(384, 167);
            poly.addPoint(376, 167);
            poly.addPoint(376, 250);
            g2.fillPolygon(poly);
            g2.setColor (hours);
            Polygon poly2 = new Polygon(); //hour hand
            poly2.addPoint(365, 249);
            poly2.addPoint(430, 249);
            poly2.addPoint(430, 243);
            poly2.addPoint(460, 255);
            poly2.addPoint(430, 267);
            poly2.addPoint(430, 261);
            poly2.addPoint(365, 261);
            g2.fillPolygon(poly2);
            g2.setColor (Color.BLACK);
            g2.fillOval(360, 245, 20, 20);
            //bunny
            Image image5 = Toolkit.getDefaultToolkit().getImage("Bunny1.png");
            g2.drawImage(image5, 570, 350, 290, 290, this);
        }
	
}
