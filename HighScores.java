package RockAroundTheClock;

import javax.swing.*;
import java.awt.*;
import java.io.*;


/**
 * This is the HighScores class.
 * It is used to show the uerr the highscores and will also store the in files
 *
 * <h2>Course Info:</h2>
 * ICS4U0 with Krasteva, V.
 *
 * @version 4 2019.06.09
 * @author Maya Weir
 * @author Filip Milidrag
 */
public class HighScores extends JPanel
{
  
  int[] highScores = new int[10];
  String[] highScoreNames = {"no one","no one","no one","no one","no one","no one","no one","no one","no one","no one"};

  /**
   * This method will read the names and high score files and store the information in two wseperate arrays
   */
  public void readFile()
  {
    try
    {
      BufferedReader in = new BufferedReader(new FileReader("HighScores.txt"));
      for (int i = 0;i<10;i++)
      {
        highScores[i] = Integer.parseInt(in.readLine());
      }
      in = new BufferedReader(new FileReader("Names.txt"));
      for (int i = 0;i<10;i++)
      {
        highScoreNames[i] = in.readLine();
      }
    }
    catch(Exception e)
    {
      writeFileNum();
      writeFileNames();
    }
  }

  /**
   * This method will write the current highscores array values into a file
   */
  public void writeFileNum()
  {
    try
    {
      PrintWriter write = new PrintWriter(new FileWriter("HighScores.txt"));
      for (int i = 0;i<10;i++)
      {
        write.println(highScores[i]);
      }
      write.close();
    }
    catch (IOException ie)
    {
    }
  }
  /**
   * This method will write the current names array values into a file
   */
    public void writeFileNames()
  {
    try
    {
      PrintWriter write = new PrintWriter(new FileWriter("Names.txt"));
      for (int i = 0;i<10;i++)
      {
        write.println(highScoreNames[i]);
      }
      write.close();
    }
    catch (Exception e)
    {
    }
  }
  /**
   * This method will output the highscores onto the screen
   * @param g represents an Instance of Graphics that is used to draw onto the JPanel
   */
 public void paint(Graphics g)
 {
   readFile();
   Graphics2D g2 = (Graphics2D) g;
	g2.setColor(new Color(0,255,0));
	g2.fillRect(0,0,800,650);
	g2.setColor(new Color(0,0,0));
    g2.setFont(new Font("Calibri", Font.BOLD, 30));
	g2.drawString("HIGHSCORES",340,50);
   g2.setFont(new Font("Calibri", Font.BOLD, 20));
   g2.drawString("1. "+ highScoreNames [0]+ " " + highScores[0],350,120);
   g2.drawString("2. "+ highScoreNames [1]+ " " + highScores[1],350,160);
   g2.drawString("3. "+ highScoreNames [2]+ " "+ highScores[2],350,200);
   g2.drawString("4. "+ highScoreNames [3]+ " "+ highScores[3],350,240);
   g2.drawString("5. "+ highScoreNames [4]+ " "+ highScores[4],350,280);
   g2.drawString("6. "+ highScoreNames [5]+ " "+ highScores[5],350,320);
   g2.drawString("7. "+ highScoreNames [6]+ " "+ highScores[6],350,360);
   g2.drawString("8. "+ highScoreNames [7]+ " "+ highScores[7],350,400);
   g2.drawString("9. "+ highScoreNames [8]+ " "+ highScores[8],350,440);
   g2.drawString("10. "+ highScoreNames [9]+ " "+ highScores[9],350,480);
   g2.setFont(new Font("Calibri", Font.PLAIN, 20));
   g2.drawString("Click anywhere to go back to the main menu",0,600);
 }

  /**
   * This method will add a score into high scores at the right index
   * @param score is the value that will be added to highscores
   * @param name is the value that will be added to the names array
   */
 public void addScore(int score, String name)
 {
   readFile();
   int count = 0;
   while(count <10 && score <= highScores[count])
   {
     count++;
   }
   for (int i = 9;i>count;i--)
   {
     highScores[i]=highScores[i-1];
   }
   if (count<=9)
   {
     highScores[count] = score;
     addName(count,name);
   }
 }

  /**
   * This method will add a score into high scores at the right index
   * @param count is the index that where the namewill be added
   * @param name is the value that will be added to the names array
   */
 public void addName(int count, String name)
 {
   for (int i = 9;i>count;i--)
   {
     highScoreNames[i]=highScoreNames[i-1];
   }
   highScoreNames[count] = name;
   writeFileNum();
   writeFileNames();
 }
 
}