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
import java.util.ArrayList;

public class WirelessSensor {
    // This class represents a single node in a wireless sensor network.

    public ArrayList aPackets = null;																// an array of packets held by this node
    public ArrayList aConnections;																	// an array of connections to downstream nodes (*always* downstream, not upstream) - nodes in the data collector/uplink zone have a connection with a "null" receiver node
    public WirelessSensorConnection connectionCurrent;			// if using directed routing, the currently preferred network connection for transmitting
    public int x, y;																											// the coordinates of the node
    public int iInitialEnergy;																					// the initial power of the node
    public int iResidualEnergy;																			// the current power of the node
    public int iSensorDelay = 0;																			// the timer until the sensor is ready to be tripped again
    public int iSensorRadius;
    // the radius of this sensor

    public WirelessSensor(int x, int y, int iSensorRadius) {
        this.x = x;
        this.y = y;
        this.iSensorRadius = iSensorRadius;
        aConnections = new ArrayList();
        connectionCurrent = null;
        iInitialEnergy = WirelessSensorNetwork.iMaxEnergy;
        iResidualEnergy = iInitialEnergy;

    }
}
