import java.awt.*;
import javax.swing.*;

/**
 * This is the Level3Background class.
 * It will display the background for level 3 and contains information used by IntroButtons to check if the user is correct or not
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @version 4 2019.06.09
 * @author Maya Weir
 * @author Filip Milidrag
 */
public class Level3Background extends JPanel{

		public static String[] objects = {"The Pillow","The Window","The painting with the yellow frame"};
		public static int[][] clockMinCoords = {{367, 53},{370, 154}};
		public static int [][] clockHoursCoords = {{369, 73},{382, 76},{400, 87},{410, 106},{404, 127},{382, 135},{369, 144},{346, 135},{338, 127},{328, 106},{334, 87},{346, 73}};
		public static int[][] Level3Times = new int[3][2];
		public static int min=0,hour=0;
		
		/**This constructor sets random times that objects need to be clicked at
		* 
		*/
         public Level3Background()
         {
           for (int i =0;i<=2;i++)
           {
             Level3Times[i][0] = (int)(Math.random()*12);
             Level3Times[i][1] = (int)(Math.random()*2);
           }
         }
         
		/**This method draws the Level 1 Background
		* @param g represents the Graphics class used to draw on the JPanel
		*/
        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            //code
            Image image = Toolkit.getDefaultToolkit().getImage("Lvl3Back.png");
            g2.drawImage(image, 0, 0, 800, 650, this);
            g2.setColor (new Color (224,224,209));
            g2.fillRoundRect (350,460,290,145,15,15); //bottom text box
            Polygon polyA = new Polygon();
            polyA.addPoint (630,500);
            polyA.addPoint (695,530);
            polyA.addPoint (630, 550);
            g2.fillPolygon (polyA); //speech bubble bottom

            g2.setColor(Color.BLACK);
            g2.setFont (new Font ("Calibri", Font.PLAIN, 18));
            g2.drawString ("Follow the instructions below based", 368,477);
            g2.drawString ("on the clock. If it is not time to", 368,497);
            g2.drawString ("click on an object advance the ", 368, 517);
			g2.drawString ("clock by 30min by clicking in the", 368, 537);
			g2.drawString ("center of the clock", 368, 557);
            g2.drawString ("At", 368, 577);
            g2.drawString ("click on ", 435, 577);
            g2.setColor (Color.RED);
			if (Level3Times[IntroButtons.count][0] ==0)
			{
				if (Level3Times[IntroButtons.count][1]==0)
					g2.drawString(12 + " : 0" +Level3Times[IntroButtons.count][1]*30, 387, 577);
				else 
					g2.drawString(12 + " : " + Level3Times[IntroButtons.count][1]*30, 387, 577);
			}
			else
			{
				if (Level3Times[IntroButtons.count][1]==0)
					g2.drawString(Level3Times[IntroButtons.count][0] + " : 0" + Level3Times[IntroButtons.count][1]*30, 387, 577);
				else 
					g2.drawString(Level3Times[IntroButtons.count][0] + " : " + Level3Times[IntroButtons.count][1]*30, 387, 577);
			}
            g2.drawString (objects[IntroButtons.count], 368, 597);

            g2.setFont(new Font("Calibri", Font.BOLD, 14));
            //CLOCK 1
            g2.setColor(Color.BLACK);
            g2.fillOval(300, 35, 135, 135); //clock
            g2.setColor (Color.WHITE);
            g2.fillOval(304, 39, 127, 127); //clock
            g2.setColor(Color.BLACK);
            g2.drawString("12", 362, 53);
            g2.drawString("1", 395, 62);
            g2.drawString("2", 413, 83);
            g2.drawString("3", 420, 110);
            g2.drawString("4", 411, 137);
            g2.drawString("5", 392, 155);
            g2.drawString("6", 365, 164);
            g2.drawString("7", 337, 155);
            g2.drawString("8", 315, 137);
            g2.drawString("9", 306, 110);
            g2.drawString("10", 312, 83);
            g2.drawString("11", 330, 62);
            g2.fillOval(362, 96, 15, 15);
			g2.drawLine(369,103,clockMinCoords[min][0],clockMinCoords[min][1]);
			g2.drawLine(369,103,clockHoursCoords[hour][0],clockHoursCoords[hour][1]);

            //bunny
            Image image5 = Toolkit.getDefaultToolkit().getImage("Bunny1.png");
            g2.drawImage(image5, 630, 410, 220, 220, this);
    }
}

