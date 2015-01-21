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

public class WirelessSensorConnection {
    // This class represents a communications link between two wireless sensors.

    public WirelessSensor sSender;				// the upstream sensor
    public WirelessSensor sReceiver;				// the downstream sensor - every node in the data collector/uplink zone will have a connection with a NULL sReceiver.
    public Packet packet = null;									// the packet currently being transmitted on this connection (only one at a time, of course)
    public int iTransmitCost, iReceiveCost;			// the energy costs of transmitting and receiving the packet
    public int iTransmitterDelay;									// the total time this node would normally wait to complete delivery of a packet
    public int iTransmitting;												// the timer for completing delivery of a packet

    public WirelessSensorConnection(WirelessSensor sSender, WirelessSensor sReceiver, int iTransmitCost, int iReceiveCost, int iTransmitterDelay) {
        this.sSender = sSender;
        this.sReceiver = sReceiver;
        this.iTransmitCost = iTransmitCost;
        this.iReceiveCost = iReceiveCost;
        this.iTransmitting = 0;
        this.iTransmitterDelay = iTransmitterDelay;
    }

    public void BeginTransmission() {
        // this function begins transmission of a data packet between these nodes.
        if ((sSender.aPackets.size() > 0) && (iTransmitting == 0)) {
            if (sSender.iResidualEnergy <= iTransmitCost)  // transmission failed - sender has run out of energy
                sSender.iResidualEnergy = 0;
            else if ((sReceiver != null) && (sReceiver.iResidualEnergy <= iReceiveCost))  // transmission failed - receiver has run out of energy
                sReceiver.iResidualEnergy = 0;
            else {  // success - accept the packet and start transmitting it.
                iTransmitting = iTransmitterDelay;
                sSender.iResidualEnergy -= iTransmitCost;
                packet = (Packet) sSender.aPackets.get(0);
                sSender.aPackets.remove(0);
                if (sReceiver != null)
                    sReceiver.iResidualEnergy -= iReceiveCost;
            }
        }
    }

    public Packet Transmit() {
        // this function continues transmission of a previously accepted packet, and completes transmission if appropriate.
        if ((sSender.iResidualEnergy <= 0) || ((sReceiver != null) && (sReceiver.iResidualEnergy <= 0)))  // failed due to depleted energy
            iTransmitting = 0;
        else if (iTransmitting > 0) {  // transmission in progress
            iTransmitting--;
            if (iTransmitting == 0) {
                if (sReceiver != null)
                    sReceiver.aPackets.add(packet);
                else {
                    Packet returnPacket = packet;
                    packet = null;
                    return returnPacket;
                }
            }
        }
        return null;
    }
}
