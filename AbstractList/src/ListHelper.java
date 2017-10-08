import java.io.*;
import java.text.*;
import java.util.Scanner;

/**
 * ListHelper class
 * - Contains the read / write data methods needed to satisfy
 *      the LinkedList class in assignment 1.
 * @author Jan Dwyer
 * @version 1.0     10/4/2017.
 */
public class ListHelper {
    /**
     * readDoublesFromConsole() method
     * - Creates a LinkedList object from doubles entered at the console
     * @return LinkedList
     */
    public static LinkedList readDoublesFromConsole() {
        // System.out.println("in readDoublesFromConsole()");
        // System.out.println("\nPlease type in a list of double values, " +
        //        "one per line,\n and then finish by typing Command-D: ");
        LinkedList list = new LinkedList();
        Scanner ds = new Scanner(System.in);
        int wct = 0;
        
        while (ds.hasNextDouble()) {
            Node newNode = new Node();
            Node otherNode = new Node();
            double newDbl = ds.nextDouble();
            if (wct == 0) {
                newNode.setPayload(newDbl);
                list.insertListNode(newNode, otherNode, "after");
            } else {
                newNode.setPayload(newDbl);
                otherNode = list.getHead();
                list.insertListNode(newNode, otherNode, "before");
            }
            wct++;
        }
        ds.close();

        return list;
    }   // end readDoublesFromConsole.


    /**
     * readDoublesFromFile() method
     * - Reads doubles from a file and creates a LinkedList object.
     * @param filename      - String containing the file name to be read
     *                          (and absolute path if needed.)
     * @return LinkedList
     */
    public static LinkedList readDoublesFromFile(String filename) {
        // System.out.println("in readDoublesFromFile()");
        LinkedList list = new LinkedList();
        double dbl = 0.0;
        int wct = 0;
        String after = "after";
        String before = "before";

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
                    Node otherNode = new Node();
                    dbl = fileIn.nextDouble();
                    nextNode.setPayload(dbl);
                    if (wct == 0) {
                        list.insertListNode(nextNode, otherNode, after);
                    } else {
                        otherNode = list.getHead();
                        list.insertListNode(nextNode, otherNode, before);
                    }
                    wct++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error encountered in read");
            e.printStackTrace();
        }

        return list;
    }   // end readDoublesFromFile.


    /**
     * writeDoublesToConsole() method
     * - Accepts a LinkedList and writes formatted doubles from
     *      the nodes in the LinkedList to the console.
     * @param list
     */
    public static void writeDoublesToConsole(LinkedList list) {
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
        nct = list.getNodeCounter();
        dNode = list.getHead();
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
     * - Accepts a LinkedList and a filename, writes the doubles from
     *      the nodes in the LinkedList to a text file of the name given.
     * @param list
     * @param filename
     */
    public static void writeDoublesToFile(LinkedList list, String filename) {
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
            nct = list.getNodeCounter();
            dNode = list.getHead();
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
}   // end ListHelper class.
