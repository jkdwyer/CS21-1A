import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * QueueHelper class
 * - Contains the read / write data methods needed to satisfy
 *      the Queue subclass in assignment 1.
 * @author Jan Dwyer
 * @version 1.0     10/8/2017.
 */
public class QueueHelper {
    /**
     * readDoublesFromConsole() method
     * - Creates a Queue object from doubles entered at the console
     * @return Queue
     */
    public static Queue readDoublesFromConsole() {
        // System.out.println("in readDoublesFromConsole()");
        // System.out.println("\nPlease type in a list of double values, " +
        //        "one per line,\n and then finish by typing Command-D: ");
        Queue newQueue = new Queue();
        Scanner ds = new Scanner(System.in);
        
        while (ds.hasNextDouble()) {
            Node newNode = new Node();
            double newDbl = ds.nextDouble();
            newNode.setPayload(newDbl);
            newQueue.insertNode(newNode);
        }
        ds.close();
        return newQueue;
    }   // end readDoublesFromConsole.


    /**
     * readDoublesFromFile() method
     * - Reads doubles from a file and creates a Queue object.
     * @param filename      - String containing the file name to be read
     *                          (and absolute path if needed.)
     * @return Queue
     */
    public static Queue readDoublesFromFile(String filename) {
        // System.out.println("in readDoublesFromFile()");
        Queue newQueue = new Queue();
        double dbl = 0.0;

        Scanner fileIn;
        File dblFile;
        FileReader frInput;
        BufferedReader bufInput;

        try {
            dblFile = new File(filename);
            if (dblFile.exists()) {
                // System.out.println("Name: " + dblFile.getName());
                // System.out.println("Readable: " + dblFile.canRead());

                frInput = new FileReader(dblFile);
                bufInput = new BufferedReader(frInput);
                fileIn = new Scanner(bufInput);
                // read double values from input text file.
                while (fileIn.hasNextDouble()) {
                    Node nextNode = new Node();
                    dbl = fileIn.nextDouble();
                    nextNode.setPayload(dbl);
                    newQueue.insertNode(nextNode);
                }
            }
        } catch (Exception e) {
            System.out.println("Error encountered in read");
            e.printStackTrace();
        }
        return newQueue;
    }   // end readDoublesFromFile.


    /**
     * writeDoublesToConsole() method
     * - Accepts a Queue and writes formatted doubles from
     *      the nodes in the LinkedList to the console.
     * @param q
     */
    public static void writeDoublesToConsole(Queue q) {
        // System.out.println("in writeDoublesToConsole()");
        int nct = 0;
        Node dNode;
        double dPayload = 0.0;
        String strPayload;
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(3);
        nf.setMinimumFractionDigits(3);
        DecimalFormat df = (DecimalFormat) nf;

        // loop over list and add each payload to output file.
        System.out.println("\n");
        nct = q.getNodeCounter();
        dNode = q.getHead();
        for (int j = 0; j < nct; j++) {
            dPayload = dNode.getPayload();
            df.setGroupingUsed(false);
            strPayload = df.format(dPayload);
            System.out.println(strPayload);
            dNode = dNode.getNext();
        }
        System.out.println("\n");
    }   // end writeDoublesToConsole.


    /**
     * writeDoublesToFile() method
     * - Accepts a Stack and a filename, writes the doubles from
     *      the nodes in the Stack to a text file of the name given.
     * @param q
     * @param filename
     */
    public static void writeDoublesToFile(Queue q, String filename) {
        // System.out.println("in writeDoublesToFile()");
        int nct = 0;
        Node dNode;
        double dPayload = 0.0;

        File outputFile;
        FileWriter fwOutput;
        BufferedWriter bufOutput;
        PrintWriter dblOut;

        try {
            outputFile = new File(filename);
            fwOutput = new FileWriter(outputFile, true);
            bufOutput = new BufferedWriter(fwOutput);
            dblOut = new PrintWriter(bufOutput);
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(3);
            nf.setMinimumFractionDigits(3);
            DecimalFormat df = (DecimalFormat) nf;
            df.setGroupingUsed(false);
            String strPayload;

            // loop over list and add each payload to output file.
            nct = q.getNodeCounter();
            dNode = q.getHead();
            for (int j = 0; j < nct; j++) {
                dPayload = dNode.getPayload();
                strPayload = df.format(dPayload);
                dblOut.println(strPayload);
                dNode = dNode.getNext();
            }
            dblOut.println("\n");
            dblOut.close();
        } catch (Exception e) {
            System.out.println("Error encountered in write");
            e.printStackTrace();
        }
    }   // end writeDoublesToFile.
}   // end QueueHelper class.
