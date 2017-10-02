import java.io.*;
import java.text.*;
import java.util.*;

/**
 * MakeListApp class
 * - Contains main method.
 * - Contains methods:
 *      readDoublesFromConsole, readDoublesFromFile, writeDoublesToFile
 * - Currently used only for testing.
 * @author Jan Dwyer
 * @version 1.0     10/1/2017
 */
public class MakeListApp {
    public static void main(String args[]) {
        // Block 1 - test output of call:
        LinkedList doubleList = new LinkedList();
        doubleList = readDoublesFromConsole();
        doubleList.printList();

        // Block 2 - test output of call:
        LinkedList dblList = new LinkedList();
        String readFromFile = "fileOfDoubles.txt";
        dblList = readDoublesFromFile(readFromFile);
        dblList.printList();

        // Block 3 - test output of call:
        String filename = "listOfDoubles.txt";
        writeDoublesToFile(doubleList, filename);
        // writeDoublesToFile(dblList, filename);
        // need to verify existence and contents of file created.
        // this will tell you the default file location.
    }   // end main.


    /**
     * readDoublesFromConsole() method
     * - Creates a list object from doubles entered at the console
     * @return LinkedList
     */
    public static LinkedList readDoublesFromConsole() {
        System.out.println("in readDoublesFromConsole()");
        LinkedList list = new LinkedList();
        Scanner ds = new Scanner(System.in);
        int wct = 0;

        while (ds.hasNextDouble()) {
            Node newNode = new Node();
            Node otherNode = new Node();
            double ndbl = ds.nextDouble();
            if (wct == 0) {
                newNode.setPayload(ndbl);
                list.insertNode(newNode, otherNode, "after");
            } else {
                newNode.setPayload(ndbl);
                otherNode = list.getHead();
                list.insertNode(newNode, otherNode, "before");
            }
            wct++;
        }
        ds.close();

        return list;
    }   // end readDoublesFromConsole.


    /**
     * readDoublesFromFile() method
     * - Reads doubles from a file and creates a list object.
     * @param filename      - String containing the file name to be read
     *                          (and absolute path if needed.)
     * @return LinkedList
     */
    public static LinkedList readDoublesFromFile(String filename) {
        System.out.println("in readDoublesFromFile()");
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
                // TODO:  remove this output.
                System.out.println("Name: " + dblFile.getName());
                System.out.println("Readable: " + dblFile.canRead());
            }
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
                    list.insertNode(nextNode, otherNode, after);
                } else {
                    otherNode = list.getHead();
                    list.insertNode(nextNode, otherNode, before);
                }
                wct++;
            }
        } catch (Exception e) {
            System.out.println("Error encountered in read");
            e.printStackTrace();
        }

        return list;
    }   // end readDoublesFromFile.


    /**
     * writeDoublesToFile() method
     * - Accepts a list and a filename, writes the doubles from
     *      the nodes in the list to a text file of the name given.
     * @param list
     * @param filename
     */
    public static void writeDoublesToFile(LinkedList list, String filename) {
        System.out.println("in writeDoublesToFile()");
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
            String strPayload;

            // loop over list and add each payload to output file.
            nct = list.getNodeCounter();
            dNode = list.getHead();
            for (int j = 0; j < nct; j++) {
                dPayload = dNode.getPayload();
                strPayload = nf.format(dPayload);
                // TODO:  remove this output.
                System.out.println(strPayload);
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
}   // end MakeListApp class.
