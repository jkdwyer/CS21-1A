import junit.framework.TestCase;
import java.io.*;

public class ListHelperTest extends TestCase {
    public void testReadDoublesFromConsole() throws Exception {
        // How do I give this one console input?
        StringBuffer sb = new StringBuffer();
        sb.append(144);
        sb.append("\n");
        sb.append(12.22);
        sb.append("\n");
        sb.append(3333.88999);
        sb.append("\n");
        sb.append(150.0123);
        sb.append("\n");
        sb.append(0.0847);
        sb.append("\n");
        sb.append(16.9);
        sb.append("\n");
        // No need for ctl-D here.
        String inputString = sb.toString();

        // this snippet is from StackOverflow
        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);

        // do your thing
        LinkedList newList = ListHelper.readDoublesFromConsole();

        LinkedList testList = new LinkedList();
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        testList.insertNode(n1);   // 6 (tail)
        testList.insertNode(n2);   // 5
        testList.insertNode(n3);   // 4
        testList.insertNode(n4);   // 3
        testList.insertNode(n5);   // 2
        testList.insertNode(n6);   // 1 (head)
        StringBuffer nb = newList.createChain();
        StringBuffer tb = testList.createChain();
        String nl = nb.toString();
        String tl = tb.toString();
        // this .equals() only works on two String objects.
        assertTrue(nl.equals(tl));

        // this snippet is from StackOverflow
        // optionally, reset System.in to its original
        System.setIn(System.in);

        // show me.
        // newList.printChain();
        // testList.printChain();
    }

    public void testReadDoublesFromFileWhenNoFileExists() throws Exception {
        PrintStream oldStream = System.out;
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(myOut);
        System.setOut(ps);

        String readFromFile = "noSuchFile.txt";
        LinkedList dblList = ListHelper.readDoublesFromFile(readFromFile);
        dblList.printList();
        // this displays console message:  "Chain is empty"

        StringBuffer sb = dblList.createChain();
        assertEquals(sb.toString(), myOut.toString());

        System.out.flush();
        System.setOut(oldStream);
    }

    public void testReadDoublesFromFileWhenFileExists() throws Exception {
        // addition from another StackOverflow post, to save and then reset System.out.
        PrintStream oldStream = System.out;

        // this solution is a snippet from StackOverflow, wrapped around my test output:
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        // my test output:
        // this displays console output of list created.
        String readFromFile = "inputDoubles.txt";
        LinkedList dblList = ListHelper.readDoublesFromFile(readFromFile);
        dblList.printChain();

        // my comparison code:
        StringBuffer sb = dblList.createChain();
        assertEquals(sb.toString(), myOut.toString());

        // finish reset of System.out.
        System.out.flush();
        System.setOut(oldStream);
    }

    public void testWriteDoublesToConsole() throws Exception {
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        LinkedList newList = new LinkedList();
        newList.insertNode(n1);   // 6 (tail)
        newList.insertNode(n2);   // 5
        newList.insertNode(n3);   // 4
        newList.insertNode(n4);   // 3
        newList.insertNode(n5);   // 2
        newList.insertNode(n6);   // 1 (head)

        PrintStream oldStream = System.out;
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(myOut);
        System.setOut(ps);

        ListHelper.writeDoublesToConsole(newList);
        StringBuffer sb = new StringBuffer();
        sb.append("\n\n16.900");
        sb.append("\n0.085");
        sb.append("\n150.012");
        sb.append("\n3333.890");
        sb.append("\n12.220");
        sb.append("\n144.000\n\n\n");
        assertEquals(sb.toString(), myOut.toString());

        System.out.flush();
        System.setOut(oldStream);
    }

    public void testWriteDoublesToFile() throws Exception {
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        LinkedList newList = new LinkedList();
        File dFile;
        newList.insertNode(n1);   // 6 (tail)
        newList.insertNode(n2);   // 5
        newList.insertNode(n3);   // 4
        newList.insertNode(n4);   // 3
        newList.insertNode(n5);   // 2
        newList.insertNode(n6);   // 1 (head)
        String filename = "outputLHTest.txt";
        ListHelper.writeDoublesToFile(newList, filename);
        dFile = new File(filename);
        assertTrue(dFile.exists());
        // this worked.  deleted the file so I can re-run it.
    }
}