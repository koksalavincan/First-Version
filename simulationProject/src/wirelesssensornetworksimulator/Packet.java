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

public class Packet {
    // A lightweight class - really just a data structure - for a packet.

    public int x, y;
    public int timestamp, lifespan;    // the amount of time left to display the packet on the radar (once it gets there), and the total time of displaying it
    public Packet(int x, int y, int timestamp) {
        this.x = x;
        this.y = y;
        this.timestamp = 0;
        this.lifespan = timestamp;
    }

}

