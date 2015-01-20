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
import java.lang.Math;

public class CreateRandomNodes {
    private int numNodes;
    public void getNumNodes(){
        System.out.println("Enter the number of nodes:   " );
        numNodes = 10;
    }
    public void showNodes() {
        System.out.println("X = " + numNodes);
    }
}
