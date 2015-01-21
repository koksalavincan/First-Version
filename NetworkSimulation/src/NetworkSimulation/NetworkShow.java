/**
 *
 * @author Nikzad Babaii Rizvandi (National ICT Australia)- nikzad.b@gmail.com
 * @author Najmeh Kamyabpour (University of Technology, Sydney) - najmeh@it.uts.edu.au
 * This Java-based project is the modified version of the WSN simulator algorithm in
 * http://www.djstein.com/projects/WirelessSensorNetworkSimulator.html
 * definitely, the same Background and License Terms are applied to the Java version
 * of this program
 *
 */
package     NetworkSimulation;

import java.awt.*;
import java.applet.*;

public class NetworkShow extends Applet
{
  public void paint (Graphics g)
  {  setBackground(Color.cyan);
     g.drawString("Here are a selection of blank shapes.",20,40);
     g.drawLine(20,40,200,40);
     g.setColor(Color.blue);
     g.drawLine(20,50,70,90);
     g.setColor(Color.red);
     g.drawRect(100,50,32,55);
     g.setColor(Color.green);
     g.drawOval(150,46,60,60);
     g.setColor(Color.magenta);
     g.drawArc(230,50,65,50,30,270);
     g.setColor(Color.black);
     g.drawString("Here are the filled equivalents.",20,140);
     g.drawLine(20,140,200,140);
     g.setColor(Color.yellow);
     g.fillRect(100,150,32,55);
     g.setColor(Color.pink);
     g.fillOval(150,146,60,60);
     g.setColor(Color.darkGray);
     g.fillArc(230,150,65,50,30,270);
  }
}
