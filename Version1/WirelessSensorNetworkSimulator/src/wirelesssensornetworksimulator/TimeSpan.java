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
package wirelesssensornetworksimulator;

import java.util.Date;

public class TimeSpan {
    private int start, end;
    public int Minutes, Seconds, Milliseconds;
    
    TimeSpan(int s, int e) {
        start = s; // JANUARY_1_2007
        end = e; // APRIL_1_2007
        
        long diffInSeconds = (end - start) / 1000;
    /* sec */Milliseconds = (int )((end-start)%1000);
    /* sec */Seconds = (int )(diffInSeconds >= 60 ? diffInSeconds % 60 : diffInSeconds);
    /* min */Minutes = (int) ((diffInSeconds = (diffInSeconds / 60)) >= 60 ? diffInSeconds % 60 : diffInSeconds);

    }
}
