/**
 *
 * @author Nikzad Babaii Rizvandi (National ICT Australia & University of Sydney)- nikzad@it.usyd.edu.au
 * @author Najmeh Kamyabpour (University of Technology, Sydney) - najmeh@it.uts.edu.au
 * This project is the java version of the program written originally in C#. The C# code is available in
 * http://www.djstein.com/projects/WirelessSensorNetworkSimulator.html
 * definitely, the same Background and License Terms are applied to the Java version of this program
 *
 */

package wirelesssensornetworksimulator;

import java.lang.Runnable;
import java.awt.*;
import java.awt.event.*;
import java.lang.String;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.applet.*;
import java.awt.event.WindowAdapter;
import java.awt.Font;
import java.text.Format;
import javax.swing.JComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.geom.Ellipse2D;
import javax.swing.event.AncestorEvent;
import javax.swing.Timer;


public class Main {
    JFrame MainFrame = new JFrame("Wireless Sensor Network Simulator");
    private WirelessSensorNetwork network = null;
    private int iSetupDisplay = -1;
    private PicNetworkDrawing picNetwork;
    private javax.swing.JPanel MainFramePanel;

    private java.awt.Button bMeanLifetimeTest;
    private java.awt.Button btnReplay;
    private java.awt.Button btnStart;
    private java.awt.Button button1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSlider jSlider18;
    private java.awt.Label label10;
    private java.awt.Label label11;
    private java.awt.Label label12;
    private java.awt.Label label13;
    private java.awt.Label label14;
    private java.awt.Label label15;
    private java.awt.Label label16;
    private java.awt.Label label17;
    private java.awt.Label label18;
    private java.awt.Label label19;
    private java.awt.Label lblTime;
    private java.awt.Label lblPower;
    private java.awt.Label lblSensors;
    private java.awt.Label lblLivePackets;
    private java.awt.Label lblRecdPackets;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private java.awt.Label lblStatus;
    private PicRadarDrawing picRadar;
    private javax.swing.JComboBox radioDirected;
    private javax.swing.JSlider trackEnergyCost;
    private javax.swing.JSlider trackInitialEnergy;
    private javax.swing.JSlider trackNetworkSize;
    private javax.swing.JSlider trackReceiveCost;
    private javax.swing.JSlider trackResidualEnergy;
    private javax.swing.JSlider trackSensorCost;
    private javax.swing.JSlider trackSensorDelay;
    private javax.swing.JSlider trackSensorRadius;
    private javax.swing.JSlider trackTransmissionCost;
    private javax.swing.JSlider trackTransmissionRadius;
    private javax.swing.JSlider trackTransmitterDelay;
    private Timer RefreshTimer;

    Main() {
        initComponents();
    }
    private void initComponents() {
        jPanel3 = new javax.swing.JPanel();
        btnStart = new java.awt.Button();
        btnReplay = new java.awt.Button();
        bMeanLifetimeTest = new java.awt.Button();
        jPanel4 = new javax.swing.JPanel();
        lblStatus = new java.awt.Label();
        lblTime = new java.awt.Label();
        lblPower = new java.awt.Label();
        lblSensors = new java.awt.Label();
        lblLivePackets = new java.awt.Label();
        lblRecdPackets = new java.awt.Label();
        jPanel5 = new javax.swing.JPanel();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        trackEnergyCost = new javax.swing.JSlider();
        trackResidualEnergy = new javax.swing.JSlider();
        label10 = new java.awt.Label();
        trackInitialEnergy = new javax.swing.JSlider();
        jSlider18 = new javax.swing.JSlider();
        radioDirected = new javax.swing.JComboBox();
        label9 = new java.awt.Label();
        label19 = new java.awt.Label();
        jPanel6 = new javax.swing.JPanel();
        button1 = new java.awt.Button();
        label11 = new java.awt.Label();
        trackNetworkSize = new javax.swing.JSlider();
        label12 = new java.awt.Label();
        trackSensorRadius = new javax.swing.JSlider();
        label13 = new java.awt.Label();
        trackSensorDelay = new javax.swing.JSlider();
        label14 = new java.awt.Label();
        trackSensorCost = new javax.swing.JSlider();
        label15 = new java.awt.Label();
        trackTransmissionRadius = new javax.swing.JSlider();
        label16 = new java.awt.Label();
        trackTransmitterDelay = new javax.swing.JSlider();
        label17 = new java.awt.Label();
        trackTransmissionCost = new javax.swing.JSlider();
        label18 = new java.awt.Label();
        
        
        RefreshTimer = new Timer(50,null);
        RefreshTimer.setInitialDelay(10);
        RefreshTimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timerUpdate_Elapsed(evt);
            }
        });
        
        picNetwork = new PicNetworkDrawing();
        picNetwork.setBorder(javax.swing.BorderFactory.createTitledBorder("Network Monitor"));
        picNetwork.setToolTipText("Network Monitor");
        picNetwork.setLayout(null);
        picNetwork.setBounds(200, 30, 640, 540);
        

        picRadar = new PicRadarDrawing();
        picRadar.setBorder(javax.swing.BorderFactory.createTitledBorder("Radar"));
        picRadar.setBounds(690, 580, 160, 150);

        MainFramePanel = new javax.swing.JPanel() ;

        trackReceiveCost = new javax.swing.JSlider();
        trackReceiveCost.setBounds(20, 490, 120, 40);
        trackReceiveCost.setMajorTickSpacing(10);
        trackReceiveCost.setMinimum(1);
        trackReceiveCost.setMinorTickSpacing(10);
        trackReceiveCost.setValue(15);
        jPanel6.add(trackReceiveCost);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Simulation Control"));
        jPanel3.setToolTipText("Simulation Control");
        jPanel3.setLayout(null);

        btnStart.setActionCommand("stopSimulation");
        btnStart.setLabel("Start Simulation");
        btnStart.setName("startSimulation"); // NOI18N
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStart_Click(evt);
            }
        });
        jPanel3.add(btnStart);
        btnStart.setBounds(10, 20, 120, 30);

        btnReplay.setActionCommand("replySimulation");
        btnReplay.setLabel("Reply Simulation");
        btnReplay.setName("replySimulation"); // NOI18N
        btnReplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplay_Click(evt);
            }
        });
        jPanel3.add(btnReplay);
        btnReplay.setBounds(10, 60, 120, 30);

        bMeanLifetimeTest.setActionCommand("meanLifetimeTest");
        bMeanLifetimeTest.setLabel("Mean Lifetime Test");
        bMeanLifetimeTest.setName("meanLifetimeTest"); // NOI18N
        bMeanLifetimeTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMeanLifetimeTest_Click(evt);
            }
        });
        jPanel3.add(bMeanLifetimeTest);
        bMeanLifetimeTest.setBounds(10, 100, 120, 30);

        jPanel3.setBounds(380, 580, 140, 150);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Simulation Status"));
        jPanel4.setLayout(null);

        lblStatus.setText("Status: Ready");
        jPanel4.add(lblStatus);
        lblStatus.setBounds(10, 20, 110, 19);

        lblTime.setText("Time: ");
        jPanel4.add(lblTime);
        lblTime.setBounds(10, 40, 120, 20);

        lblPower.setText("Power: ");
        jPanel4.add(lblPower);
        lblPower.setBounds(10, 60, 120, 19);

        lblSensors.setText("Sensors: ");
        jPanel4.add(lblSensors);
        lblSensors.setBounds(10, 80, 130, 19);

        lblLivePackets.setText("Live Packets: ");
        jPanel4.add(lblLivePackets);
        lblLivePackets.setBounds(10, 100, 130, 19);

        lblRecdPackets.setText("Rec'd Packets: ");
        jPanel4.add(lblRecdPackets);
        lblRecdPackets.setBounds(10, 120, 130, 19);

        jPanel4.setBounds(530, 580, 150, 150);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Routing Parameters"));
        jPanel5.setLayout(null);

        label7.setText("Routing Period");
        jPanel5.add(label7);
        label7.setBounds(240, 90, 88, 19);

        label8.setText("Exchange Cost");
        jPanel5.add(label8);
        label8.setBounds(130, 30, 88, 20);

        trackEnergyCost.setMaximum(1);
        trackEnergyCost.setValue(0);
        trackEnergyCost.setAlignmentX(0.3F);
        trackEnergyCost.setAlignmentY(0.3F);
        trackEnergyCost.setPreferredSize(new java.awt.Dimension(200, 28));
        jPanel5.add(trackEnergyCost);
        trackEnergyCost.setBounds(130, 50, 88, 40);
        jPanel5.add(trackResidualEnergy);
        trackResidualEnergy.setBounds(240, 50, 80, 40);

        label10.setText("Initial Power");
        jPanel5.add(label10);
        label10.setBounds(140, 90, 73, 19);
        jPanel5.add(trackInitialEnergy);
        trackInitialEnergy.setBounds(130, 100, 90, 40);
        jPanel5.add(jSlider18);
        jSlider18.setBounds(240, 100, 80, 40);

        radioDirected.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Directed", "Random", " " }));
        radioDirected.setName("routingOption"); // NOI18N
        jPanel5.add(radioDirected);
        radioDirected.setBounds(20, 50, 91, 27);
        radioDirected.getAccessibleContext().setAccessibleName("routingOption");

        label9.setText("Residual Power");
        jPanel5.add(label9);
        label9.setBounds(240, 30, 92, 20);

        label19.setName("Routing Method"); // NOI18N
        label19.setText("Routing Method");
        jPanel5.add(label19);
        label19.setBounds(20, 30, 100, 19);

        jPanel5.setBounds(20, 580, 350, 150);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Network Configuration"));
        jPanel6.setLayout(null);

        button1.setLabel("Dploy Network");
        button1.setName("deployNetwork"); 
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeploy_Click(evt);
            }
        });
        jPanel6.add(button1);
        button1.setBounds(18, 31, 115, 23);
        button1.getAccessibleContext().setAccessibleName("DeployNetwork");

        label11.setText("Network Size");
        jPanel6.add(label11);
        label11.setBounds(18, 63, 117, 19);

        trackNetworkSize.setMaximum(410);
        trackNetworkSize.setMinimum(10);
        trackNetworkSize.setValue(35);
        trackNetworkSize.setName("trackNetworkSize"); 
        jPanel6.add(trackNetworkSize);
        trackNetworkSize.setBounds(18, 83, 120, 26);

        label12.setText("Sensor Radius");
        jPanel6.add(label12);
        label12.setBounds(18, 119, 111, 19);

        trackSensorRadius.setMajorTickSpacing(10);
        trackSensorRadius.setMaximum(120);
        trackSensorRadius.setMinimum(20);
        trackSensorRadius.setMinorTickSpacing(10);
        trackSensorRadius.setValue(45);
        jPanel6.add(trackSensorRadius);
        trackSensorRadius.setBounds(20, 130, 120, 24);

        label13.setText("Sensor Period");
        jPanel6.add(label13);
        label13.setBounds(20, 170, 83, 19);

        trackSensorDelay.setMajorTickSpacing(10);
        trackSensorDelay.setMaximum(101);
        trackSensorDelay.setMinimum(1);
        trackSensorDelay.setMinorTickSpacing(10);
        trackSensorDelay.setValue(15);
        jPanel6.add(trackSensorDelay);
        trackSensorDelay.setBounds(20, 190, 120, 20);

        label14.setText("Sensor Cost");
        jPanel6.add(label14);
        label14.setBounds(20, 230, 71, 19);

        trackSensorCost.setMajorTickSpacing(10);
        trackSensorCost.setMinimum(1);
        trackSensorCost.setMinorTickSpacing(10);
        trackSensorCost.setValue(20);
        jPanel6.add(trackSensorCost);
        trackSensorCost.setBounds(20, 240, 120, 40);

        label15.setText("Transmission Radius");
        jPanel6.add(label15);
        label15.setBounds(20, 290, 123, 19);

        trackTransmissionRadius.setMajorTickSpacing(20);
        trackTransmissionRadius.setMaximum(230);
        trackTransmissionRadius.setMinimum(30);
        trackTransmissionRadius.setMinorTickSpacing(20);
        trackTransmissionRadius.setValue(130);
        jPanel6.add(trackTransmissionRadius);
        trackTransmissionRadius.setBounds(20, 300, 120, 40);

        label16.setText("Transmission Period");
        jPanel6.add(label16);
        label16.setBounds(20, 350, 121, 19);

        trackTransmitterDelay.setMajorTickSpacing(10);
        trackTransmitterDelay.setMaximum(101);
        trackTransmitterDelay.setMinimum(1);
        trackTransmitterDelay.setMinorTickSpacing(10);
        trackTransmitterDelay.setValue(10);
        jPanel6.add(trackTransmitterDelay);
        trackTransmitterDelay.setBounds(20, 370, 120, 40);

        label17.setText("Transmit Cost");
        jPanel6.add(label17);
        label17.setBounds(20, 420, 84, 19);

        trackTransmissionCost.setMajorTickSpacing(1000);
        trackTransmissionCost.setMaximum(10001);
        trackTransmissionCost.setMinimum(1);
        trackTransmissionCost.setMinorTickSpacing(1000);
        trackTransmissionCost.setValue(200);
        jPanel6.add(trackTransmissionCost);
        trackTransmissionCost.setBounds(20, 430, 120, 40);

        label18.setText("Receive Cost");
        jPanel6.add(label18);
        label18.setBounds(20, 475, 77, 19);

        //getContentPane().add(jPanel6);
        jPanel6.setBounds(20, 30, 160, 540);

        //this.MainFrame.setSize(new Dimension(830,760));
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.MainFrame.setBounds((screenSize.width-871)/2, (screenSize.height-766)/2, 871, 766);
        this.MainFrame.add(jPanel3);
        this.MainFrame.add(jPanel4);
        this.MainFrame.add(jPanel5);
        this.MainFrame.add(jPanel6);
        this.MainFrame.add(picNetwork);
        this.MainFrame.add(picRadar);
        this.MainFrame.add(MainFramePanel);
        //java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        //setBounds((screenSize.width-871)/2, (screenSize.height-766)/2, 871, 766);
    }

    private void btnStart_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStart_Click
        // TODO add your handling code here:
        if (network != null) {
            if (network.tSimulation == null) {  // no simulation running - start a new simulation (by spawning a new thread)
                network.Reset(true);
                network.tSimulation = new Thread(network.new RunSimulationThread()); // How to run new Thread
                network.tSimulation.start();
                btnStart.setLabel("Stop Simulation");
           //     btnStart.Refresh();
                lblStatus.setText("Status: Operating");
           //     lblStatus.Refresh();
                }
            else {  // simulation running - tell the thread to stop running and relabel buttons
                network.bAbort = true;
                network.tSimulation = null;
                btnStart.setLabel("Start Simulation");
           //     btnStart.Refresh();
                lblStatus.setText("Status: Ready");
          //      lblStatus.Refresh();

            }
        picNetwork.paintComponent(picNetwork.getGraphics());
        }
    }//GEN-LAST:event_btnStart_Click

    private void btnDeploy_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeploy_Click
        // TODO add your handling code here:
        network = new WirelessSensorNetwork((int) trackNetworkSize.getValue(), (int) trackSensorRadius.getValue(), (int) trackSensorDelay.getValue(), (int) trackTransmissionRadius.getValue(), (int) trackTransmitterDelay.getValue(), (float) trackTransmissionCost.getValue()/ 100.0f, (int) trackReceiveCost.getValue(), (int) trackSensorCost.getValue(), radioDirected.getModel().getSelectedItem().equals("Directed"), trackEnergyCost.getValue(), trackResidualEnergy.getValue(), trackInitialEnergy.getValue(), 1, picNetwork.getWidth() - 5, picNetwork.getHeight() - 5, picNetwork.getWidth() - 45);
       // picNetwork.paintComponent(picNetwork.getGraphics());
        iSetupDisplay = 0;  // initiate the "deploying network" display
    }//GEN-LAST:event_btnDeploy_Click

    private void btnReplay_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplay_Click
        // TODO add your handling code here:
        if (network != null) {
            if (network.tSimulation != null)  // immediately stop simulation if it's running, so that we can start a new one
                network.tSimulation.interrupt(); // Terminate a thread (I think, it must be checked again)
            else {
                btnStart.setLabel("Stop Simulation");
                //btnStart.Refresh();
                lblStatus.setText("Status: Operating");
                //lblStatus.Refresh();
                }
            network.Reset(false);  // "false" indicates that we're restarting without picking a new seed (i.e., use the one from the last run)
            network.tSimulation = new Thread(network.new RunSimulationThread()); // How to run new Thread
            network.tSimulation.start();
        }
    }//GEN-LAST:event_btnReplay_Click

    private void bMeanLifetimeTest_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMeanLifetimeTest_Click
        // TODO add your handling code here:
        if (network != null) {
            if (network.tSimulation != null) {  // abort any running simulation
                network.tSimulation.interrupt();
                network.tSimulation = null;
                btnStart.setLabel("Start Simulation");
                //btnStart.Refresh();
                lblStatus.setText("Status: Ready");
                //lblStatus.Refresh();
            }
            // start a new simulation and display the tester window
            Thread thread = new Thread(network.new RunTestThread());
            thread.start();
           // WirelessSensorNetworkTest test = new WirelessSensorNetworkTest(network);
           // test.setModal(true);
           // test.setVisible(true); // Equalenet to test.ShowDialog() in C#; http://www.dreamincode.net/forums/topic/66100-equivalent-to-showdialog/
        }
    }//GEN-LAST:event_bMeanLifetimeTest_Click

    private void picNetwork_Paint(Graphics e) {
        // note that we're painting, so that the timer thread doesn't send another Paint message
        if (network != null) {
            network.bPainting = true;
            network.bPaint = false;
        }
        // create drawing tools
        Font font = new Font("Times New Roman", 10, 7);
        //Format format = new Format();
        //format.Alignment = StringAlignment.Center;
        Graphics2D g = (Graphics2D) e;
        //g.SmoothingMode = System.Drawing.Drawing2D.SmoothingMode.AntiAlias;
        // draw background
        //g.FillRectangle(System.Drawing.Brushes.BlanchedAlmond, e.ClipRectangle);
        // draw network objects (if network has been deployed)
        if (network != null) {
            // draw sensor background
            if (iSetupDisplay == -1) {
                ArrayList activatedSensors = new ArrayList();
                for (int i_temp = 0; i_temp < network.aSensors.size(); i_temp++) {
                    WirelessSensor sensor = (WirelessSensor)network.aSensors.get(i_temp);
                    if (sensor.iSensorDelay <= 0){
                            g.setPaint(Color.getHSBColor(196,196,196));
                            g.draw(new Ellipse2D.Double(sensor.x - sensor.iSensorRadius, sensor.y - sensor.iSensorRadius, sensor.iSensorRadius * 2, sensor.iSensorRadius * 2));
                    }
        		//g.FillEllipse(new SolidBrush(Color.FromArgb(196, 196, 196)), sensor.x - sensor.iSensorRadius, sensor.y - sensor.iSensorRadius, sensor.iSensorRadius * 2, sensor.iSensorRadius * 2);
                    else
                        activatedSensors.add(sensor);
                    }
                for (int i_temp = 0; i_temp < activatedSensors.size(); i_temp++) {
                    WirelessSensor sensor = (WirelessSensor) activatedSensors.get(i_temp);
                    //g.FillEllipse(new SolidBrush(Color.FromArgb(196, 196, 196 + 48 * sensor.iSensorDelay / network.iSensorDelay)), sensor.x - sensor.iSensorRadius, sensor.y - sensor.iSensorRadius, sensor.iSensorRadius * 2, sensor.iSensorRadius * 2);
                    g.setPaint(Color.getHSBColor(196, 196, 196 + 48 * sensor.iSensorDelay / network.iSensorDelay));
                    g.draw(new Ellipse2D.Double(sensor.x - sensor.iSensorRadius, sensor.y - sensor.iSensorRadius, sensor.iSensorRadius * 2, sensor.iSensorRadius * 2));

                    //g.fillRect(sensor.x - sensor.iSensorRadius, sensor.y - sensor.iSensorRadius, sensor.iSensorRadius * 2, sensor.iSensorRadius * 2);
                }
            }
            // draw end zone

            g.setPaint(Color.black);
            g.drawLine(picNetwork.getWidth() - 44, 0, picNetwork.getWidth() - 44, picNetwork.getHeight());
            for (int i = 0; i < picNetwork.getHeight(); i += 20)
                g.drawLine(picNetwork.getWidth() - 44, i + 20, picNetwork.getWidth(), i);
            // draw connections
            for (int i_temp = 0; i_temp < network.aSensors.size(); i_temp++) {
                WirelessSensor sensor = (WirelessSensor) network.aSensors.get(i_temp);
                for (int j_temp = 0; j_temp < sensor.aConnections.size(); j_temp++){
                    WirelessSensorConnection connection = (WirelessSensorConnection) sensor.aConnections.get(j_temp);
                    if ((connection.sReceiver != null) && ((iSetupDisplay == -1) ||  (iSetupDisplay > connection.sReceiver.x)) && (connection.sSender.iResidualEnergy > 0) && (connection.sReceiver.iResidualEnergy > 0)){
                        g.setPaint(connection.iTransmitting >0 ? Color.red : connection==sensor.connectionCurrent ? Color.blue : Color.black);
                        g.drawLine(connection.sSender.x, connection.sSender.y, connection.sReceiver.x, connection.sReceiver.y);
                    }
                }
            }

            // draw sensors
            //Brush sensorBrush = Brushes.DarkGray;
            //Pen sensorPen = Pens.Red;
            for (int i_temp=0; i_temp < network.aSensors.size(); i_temp++){
                WirelessSensor sensor = (WirelessSensor) network.aSensors.get(i_temp);
                if ((iSetupDisplay == -1) || (iSetupDisplay > sensor.x)) {
                    int color = sensor.iResidualEnergy <= 0 ? 0 : (int) (255 * sensor.iResidualEnergy / WirelessSensorNetwork.iMaxEnergy);
                    //g.setColor(Color.getHSBColor(color, color, color));
                    g.setPaint(Color.getHSBColor(color, color, color));
                    g.draw(new Ellipse2D.Double(sensor.x - 4, sensor.y - 4, 9, 9));
                    if (sensor.iResidualEnergy <= 0) {
                        if (sensor.iSensorRadius > 0)
                            sensor.iSensorRadius--;
                        }
                    g.setPaint(sensor.iResidualEnergy <= 0 ? Color.black : Color.red);
                    g.draw (new Ellipse2D.Double(sensor.x - 4, sensor.y - 4, 9, 9));
                    }
            }
            // draw vectors
            if ((network.bRunningSimulation == true) && (network.vectors != null)) {
               // network.vectors.mutexVector.WaitOne();
                for (int i_temp = 0;i_temp < network.vectors.aVectors.size(); i_temp++){
                    Vector vector = (Vector) network.vectors.aVectors.get(i_temp);
                    g.setPaint(Color.green);
                    g.fillRect(vector.x - 1, vector.y - 1, 3, 3);
                }
              //  network.vectors.mutexVector.ReleaseMutex();

            }
            // draw setup line, if network is being deployed
            if (iSetupDisplay != -1){
                g.setPaint(Color.black);
                g.drawLine(iSetupDisplay, 0, iSetupDisplay, picNetwork.getHeight());
            }

        }
        // finish painting
        if (network != null)
            network.bPainting = false;
    }
    private void picRadar_Paint(Graphics e){
        
    }

/*    private void picRadar_Paint(Graphics e) {
        // create drawing tools
        Font font = new Font("Times New Roman", 7.0f);
        StringFormat format = new StringFormat();
        format.Alignment = StringAlignment.Center;
        Graphics g = e.Graphics;
        g.SmoothingMode = System.Drawing.Drawing2D.SmoothingMode.AntiAlias;
        // draw background
        g.FillRectangle(System.Drawing.Brushes.Black, e.ClipRectangle);
        // draw network radar objects
        if ((network != null) && (network.vectors != null)) {
            // draw sensors
            int iRadius = network.iSensorRadius * picRadar.Width / picNetwork.Width;
            foreach (WirelessSensor sensor in network.aSensors) {
                if (sensor.iResidualEnergy > 0)
                    g.DrawEllipse(Pens.Green, sensor.x * picRadar.Width / picNetwork.Width - iRadius, sensor.y * picRadar.Height / picNetwork.Height - iRadius, iRadius * 2, iRadius * 2);
            }
            // draw received packets
            for (int i = 0; i < network.aRadar.Count;) {
                if ((++((Packet) network.aRadar[i]).timestamp) >= ((Packet) network.aRadar[i]).lifespan)
                    network.aRadar.RemoveAt(i);
                else {
                    int green = 255 - 191 * ((Packet) network.aRadar[i]).timestamp / (((Packet) network.aRadar[i]).lifespan + 1);
                    g.FillEllipse(new SolidBrush(Color.FromArgb(0, green, 0)), ((Packet) network.aRadar[i]).x * picRadar.Width / picNetwork.Width - iRadius, ((Packet) network.aRadar[i]).y * picRadar.Height / picNetwork.Height - iRadius, iRadius * 2, iRadius * 2);
                    i++;

                }

            }
            // draw vectors
            network.vectors.mutexVector.WaitOne();
            foreach (Vector vector in network.vectors.aVectors)
                    g.DrawRectangle(Pens.White, vector.x * picRadar.Width  / picNetwork.Width, vector.y * picRadar.Height / picNetwork.Height, 2, 2);
            network.vectors.mutexVector.ReleaseMutex();
            // draw radar line
            int xRadarLine = picRadar.Width - Math.Abs((int) (System.DateTime.Now.Ticks / 500000) % picRadar.Width);
            for (int i = 0; i < 6; i++)
                g.DrawLine(new Pen(Color.FromArgb(0, 255 - (255 * i / 7), 0)), xRadarLine - i, 0, xRadarLine - i, picRadar.Height);

        }
    }
*/
    private void timerUpdate_Elapsed(java.awt.event.ActionEvent e) {
        // check to see if the network is being deployed
        if (iSetupDisplay != -1) {
            iSetupDisplay += 10;
            if (iSetupDisplay >= picNetwork.getWidth())
                iSetupDisplay = -1;
            picNetwork.update(picNetwork.getGraphics()); //.paintComponent(picNetwork.getGraphics());   // picNetwork.Refresh();
        }
        // check to see if network simulation is running
        else if ((network != null) && (network.tSimulation != null) && (network.bPaint == true) && (network.bPainting == false)) {
            // refresh objects
            picNetwork.update(picNetwork.getGraphics()); //picNetwork.Refresh();
            picRadar.update(picRadar.getGraphics()); //picRadar.Refresh();
            // display information in textboxes
            if (network.bRunningSimulation == true) {

                TimeSpan counter = new TimeSpan(network.timeStart, (int) System.currentTimeMillis());
                lblTime.setText("Time: " + counter.Minutes + ":" + counter.Seconds + "." + counter.Milliseconds);
                //lblTime.Refresh();
                lblRecdPackets.setText("Rec'd Packets: " + network.iPacketsDelivered);
                //lblRecdPackets.Refresh();
                int iPower = 0;int iSensors = 0;
                int iLivePackets = 0;
                for (int i_temp = 0;i_temp < network.aSensors.size(); i_temp++){
                    WirelessSensor sensor = (WirelessSensor) network.aSensors.get(i_temp);
                    iPower += sensor.iResidualEnergy;
                    if (sensor.iResidualEnergy > 0) {
                        iSensors++;
                        iLivePackets += sensor.aPackets.size();
                    }
                }

                lblSensors.setText("Sensors: " + iSensors + "/" + network.aSensors.size());
                //lblSensors.Refresh();
                lblPower.setText("Power: " + iPower);
                //lblPower.Refresh();
                lblLivePackets.setText("Live Packets: " + iLivePackets);
                //lblLivePackets.Refresh();

            }
            else {   // network has stopped running - throw away the completed thread and relabel buttons
                network.tSimulation = null;
                btnStart.setLabel("Start Simulation");
                //btnStart.Refresh();
                lblStatus.setText("Status: Ready");
                //lblStatus.Refresh();

            }

        }

    }



    class PicNetworkDrawing extends javax.swing.JPanel{
        @Override public void paintComponent(Graphics g) {
        super.paintComponent(g);  // Ask parent to paint background.
        picNetwork_Paint(g);
        //iSetupDisplay = 0;
        }
    }

    class PicRadarDrawing extends javax.swing.JPanel{
        @Override public void paintComponent(Graphics g) {
        super.paintComponent(g);  // Ask parent to paint background.
        picRadar_Paint(g);
        //iSetupDisplay = 0;
        }
    }

 
        public static void main(String[] args) {
            Main MainProg = new Main();
          //  NetworkShow p = new NetworkShow();
            
  //      Label lbl = new Label("Please fill this blank:");
  //      MainProg.MainFrame.add(lbl);
  //      MainProg.MainFrame.setSize(350,200);
  //      MainProg.MainFrame.setVisible(true);
            MainProg.MainFrame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {System.exit(0);}
                public void windowDeiconified(WindowEvent e) {  }
                public void windowIconified(WindowEvent e) {  }
            });
            MainProg.RefreshTimer.start();
//            MainProg.MainFrame.p
  //      MainProg.MainFrame.getContentPane().add("Center", p);
        //f.pack();
  //      MainProg.MainFrame.setSize(new Dimension(800,800));
  //      MainProg.MainFrame.setLocation(100,100);

            //MainProg.picNetwork.add(p);//.MainFrame.getContentPane().add(p);
           // MainProg.MainFrame.getContentPane().add(p);
            MainProg.MainFrame.show();
//            MainProg.picNetwork.show();
            //Graphics e=MainProg.picNetwork.getGraphics();
            //e.drawLine(100,100,220,200);

           // MainProg.MainFrame.show();

        // TODO code application logic here
    }

}
