import java.awt.*;
import java.awt.*;
import javax.swing.*;

/**
 * This is the Level2Background class.
 * It will display the background for level 2 and contains information used by IntroButtons to check if the user is correct or not
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @version 4 2019.06.09
 * @author Maya Weir
 * @author Filip Milidrag
 */
public class Level2Background extends JPanel{

		public static int hour,min,correctClock;
		int[] clockHours = new int[4];
		int[] clockMin = new int[4];
		public static boolean wrong = false;
		
		public static int[][][] clock1Coords = {{{142, 203},{165, 212},{183, 233},{190, 256},{180, 284},{162, 301},{137, 304},{117, 294},{92, 281},{82, 255},{90, 230},{107, 212}},{{137, 225}, {160, 227},{179, 239},{174, 259},{169, 273}, {154, 290},{139, 307},{120, 285},{103, 272},{95, 251},{115, 239},{123, 227}}};
		public static int[][][] clock2Coords = {{{315, 98},{338, 107},{357, 129},{363, 151},{353, 179},{335, 196},{310, 199},{290, 189},{265, 176},{255, 150}, {263, 125}, {280, 107}},{{310, 120},{333, 122},{342, 134},{347, 154},{342, 168},{327, 185},{312, 202},{293, 180},{276, 167},{276, 146},{288, 134},{296, 122}}};	
		
		/**This constructor sets random times for all the clocks in the level
		* 
		*/
		public Level2Background()
		{
			super();
			hour = (int)(Math.random()*12);
			min = (int)(Math.random()*12);
			correctClock = (int)(Math.random()*4);
			for (int i =0;i<4;i++)
			{
				clockHours[i] = (int)(Math.random()*12);
				clockMin[i] =(int)(Math.random()*12);
			}
			clockHours[correctClock] = hour;
			clockMin[correctClock] = min;
		}
		
		/**This method draws the Level 1 Background
		* @param g represents the Graphics class used to draw on the JPanel
		*/
        public void paint(Graphics g) {

			Graphics2D g2 = (Graphics2D) g;
			
			
            Image image = Toolkit.getDefaultToolkit().getImage("Lvl2Back.png");
            g2.drawImage(image, 0, 0, 800, 650, this);
            g2.setColor (new Color (224,224,209));
            g2.fillRoundRect (10,540,580,65,15,15); //bottom text box
            Polygon polyA = new Polygon();
            polyA.addPoint (580,550);
            polyA.addPoint (660,520);
            polyA.addPoint (580, 580);
            g2.fillPolygon (polyA); //speech bubble bottom

            g2.setColor(Color.BLACK);
            g2.setFont (new Font ("Calibri", Font.PLAIN, 18));
			if (wrong)
			{
				g2.drawString ("You lost 100 points for getting it wrong, but you can try again." , 25,560);
				g2.drawString("Hint: The hour hand is not always pointing exactly on the hour,", 25,575); 
				g2.drawString("the last number that the hour hand passsed is the current hour.", 25,590); //bottom text box
			}
			else
			{
				g2.drawString ("Click on the clock that matches the time displayed at the top" , 25,560);
				g2.drawString("Hint: The hour hand is not always pointing exactly on the hour,", 25,575); 
				g2.drawString("the last number that the hour hand passsed is the current hour.", 25,590); //bottom text box
			}
			g2.setColor(Color.BLACK);
			g2.setFont (new Font ("Calibri", Font.PLAIN, 40));
			if (hour ==0)
			{
				if (min*5<10)
					g2.drawString(12 + " : 0" + min*5, 340, 40);
				else 
					g2.drawString(12 + " : " + min*5, 340, 40);
			}
			else
			{
				if (min*5<10)
					g2.drawString(hour + " : 0" + min*5, 340, 40);
				else 
					g2.drawString(hour + " : " + min*5, 340, 40);
			}

            g2.setFont(new Font("Calibri", Font.BOLD, 14));
            //CLOCK 1
            g2.setColor(Color.BLACK);
            g2.fillOval(70, 185, 135, 135); //clock
            g2.setColor (Color.WHITE);
            g2.fillOval(74, 189, 127, 127); //clock
            g2.setColor(Color.BLACK);
            g2.drawString("12", 132, 203);
            g2.drawString("1", 165, 212);
            g2.drawString("2", 183, 233);
            g2.drawString("3", 190, 260);
            g2.drawString("4", 181, 287);
            g2.drawString("5", 162, 305);
            g2.drawString("6", 135, 314);
            g2.drawString("7", 107, 305);
            g2.drawString("8", 85, 287);
            g2.drawString("9", 76, 260);
            g2.drawString("10", 82, 233);
            g2.drawString("11", 100, 212);
            g2.fillOval(132, 246, 15, 15);
			g2.drawLine(139,255,clock1Coords[0][clockMin[0]][0],clock1Coords[0][clockMin[0]][1]);
			g2.drawLine(139,255,clock1Coords[1][clockHours[0]][0],clock1Coords[1][clockHours[0]][1]);

            //CLOCK 2
            g2.setColor(Color.BLACK);
            g2.fillOval(243, 80, 135, 135); //clock
            g2.setColor (Color.WHITE);
            g2.fillOval(247, 84, 127, 127); //clock
            g2.setColor(Color.BLACK);
            g2.drawString("12", 305, 98);
            g2.drawString("1", 338, 107);
            g2.drawString("2", 356, 128);
            g2.drawString("3", 363, 155);
            g2.drawString("4", 354, 182);
            g2.drawString("5", 335, 200);
            g2.drawString("6", 308, 209);
            g2.drawString("7", 280, 200);
            g2.drawString("8", 258, 182);
            g2.drawString("9", 249, 155);
            g2.drawString("10", 255, 128);
            g2.drawString("11", 273, 107);
            g2.fillOval(305, 141, 15, 15);
			g2.drawLine(312,148,clock2Coords[0][clockMin[1]][0],clock2Coords[0][clockMin[1]][1]);
			g2.drawLine(312,148,clock2Coords[1][clockHours[1]][0],clock2Coords[1][clockHours[1]][1]);

            //CLOCK 3
            g2.setColor(Color.BLACK);
            g2.fillOval(390, 185, 135, 135); //clock
            g2.setColor (Color.WHITE);
            g2.fillOval(394, 189, 127, 127); //clock
            g2.setColor(Color.BLACK);
            g2.drawString("12", 452, 203);
            g2.drawString("1", 485, 212);
            g2.drawString("2", 503, 233);
            g2.drawString("3", 510, 260);
            g2.drawString("4", 501, 287);
            g2.drawString("5", 482, 305);
            g2.drawString("6", 455, 314);
            g2.drawString("7", 427, 305);
            g2.drawString("8", 405, 287);
            g2.drawString("9", 396, 260);
            g2.drawString("10", 402, 233);
            g2.drawString("11", 420, 212);
            g2.fillOval(452, 246, 15, 15);
			g2.drawLine(459,253,clock1Coords[0][clockMin[2]][0]+320,clock1Coords[0][clockMin[2]][1]);
			g2.drawLine(459,253,clock1Coords[1][clockHours[2]][0]+320,clock1Coords[1][clockHours[2]][1]);

            //CLOCK 4
            g2.setColor(Color.BLACK);
            g2.fillOval(551, 80, 135, 135); //clock
            g2.setColor (Color.WHITE);
            g2.fillOval(555, 84, 127, 127); //clock
            g2.setColor(Color.BLACK);
            g2.drawString("12", 613, 98);
            g2.drawString("1", 646, 107);
            g2.drawString("2", 664, 128);
            g2.drawString("3", 671, 155);
            g2.drawString("4", 662, 182);
            g2.drawString("5", 643, 200);
            g2.drawString("6", 616, 209);
            g2.drawString("7", 588, 200);
            g2.drawString("8", 566, 182);
            g2.drawString("9", 557, 155);
            g2.drawString("10", 563, 128);
            g2.drawString("11", 581, 107);
            g2.fillOval(613, 141, 15, 15);
			g2.drawLine(620,148,clock2Coords[0][clockMin[3]][0]+308,clock2Coords[0][clockMin[3]][1]);
			g2.drawLine(620,148,clock2Coords[1][clockHours[3]][0]+308,clock2Coords[1][clockHours[3]][1]);


            //bunny
			Image image5 = Toolkit.getDefaultToolkit().getImage("Bunny1.png");
            g2.drawImage(image5, 590, 370, 270, 270, this);
        }
}
