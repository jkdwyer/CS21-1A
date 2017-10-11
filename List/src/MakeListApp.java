import java.io.*;
import java.text.*;
import java.util.*;

/**
 * MakeListApp class
 * - Contains main method.
 * - Currently used only for testing.
 * @author Jan Dwyer
 * @version 1.0     10/8/2017
 */
public class MakeListApp {
    public static void main(String args[]) {
        System.out.println("in MakeListApp");

        // Block 1 - test output of call:
        LinkedList doubleList = new LinkedList();
        doubleList = ListHelper.readDoublesFromConsole();
        doubleList.printList();

        // Block 2 - test output of call:
        LinkedList dblList = new LinkedList();
        String readFromFile = "fileOfDoubles.txt";
        dblList = ListHelper.readDoublesFromFile(readFromFile);
        dblList.printList();

        // Block 3 - test output of call:
        String filename = "listOfDoubles.txt";
        ListHelper.writeDoublesToFile(doubleList, filename);
        // writeDoublesToFile(dblList, filename);
        // need to verify existence and contents of file created.
        // this will tell you the default file location.

    }   // end main.
}   // end MakeListApp class.
