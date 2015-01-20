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
import java.util.Random;
import java.lang.Thread;

public class VectorList {
    // This class represents (and manages) a list of vectors.

    public ArrayList<Vector> aVectors;			// the array of vectors
//    public Mutex mutexVector;		        // a mutex to control access to the vector list
    private int iMaxX, iMaxY;			// the maximum X and Y coordinates of a vector
    private Random r;				// a random number generator (the same one used by the WirelessSensorNetwork object that houses this object)

    public VectorList(int iMaxX, int iMaxY, Random r) {
        this.iMaxX = iMaxX;
        this.iMaxY = iMaxY;
        aVectors = new ArrayList<Vector>();
//        mutexVector = new Mutex();
        this.r = r;

    }
    public void AddVector() {
        // this function creates a new vector and adds it to the vector list
        int iBorder = r.nextInt(4);
        if (iBorder == 0)  // add to left border, traveling right and up or down
            aVectors.add(new Vector(-5, r.nextInt(iMaxY), r.nextInt(3) + 1, r.nextInt(7) - 3));
        else if (iBorder == 1)  // add to top border, traveling down and left or right
            aVectors.add(new Vector(r.nextInt(iMaxX), -5, r.nextInt(7) - 3, r.nextInt(3) + 1));
        else if (iBorder == 2)  // add to right border, traveling left and up or down
            aVectors.add(new Vector(iMaxX + 5, r.nextInt(iMaxY), r.nextInt(3) - 3, r.nextInt(7) - 3));
        else if (iBorder == 3)  // add to bottom border, traveling up and left or right
            aVectors.add(new Vector(r.nextInt(iMaxX), iMaxY + 5, r.nextInt(7) - 3, r.nextInt(3) - 3));
        
    }
    public void Update() {
        // this function moves the vectors around, and removes those that have traveled out of bounds
        ArrayList<Vector> aRemoveVectors = new ArrayList<Vector>();
        for (Vector vector : aVectors) {
            vector.x += vector.dx;
            vector.y += vector.dy;
            if ((vector.x < -5) || (vector.y < -5) || (vector.x > iMaxX + 5) || (vector.y > iMaxY + 5))
                aRemoveVectors.add(vector);
        }
        for (Vector vector : aRemoveVectors)
            aVectors.remove(vector);

    }
}
