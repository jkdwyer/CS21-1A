import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

public class StackHelperTest extends TestCase {
    public void testReadDoublesFromConsole() throws Exception {
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

        ByteArrayInputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);

        Stack newStack = StackHelper.readDoublesFromConsole();

        Stack testStack = new Stack();
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        testStack.insertNode(n1);   // 6 (tail)
        testStack.insertNode(n2);   // 5
        testStack.insertNode(n3);   // 4
        testStack.insertNode(n4);   // 3
        testStack.insertNode(n5);   // 2
        testStack.insertNode(n6);   // 1 (head)
        StringBuffer nb = newStack.createChain();
        StringBuffer tb = testStack.createChain();
        String nl = nb.toString();
        String tl = tb.toString();
        // this .equals() only works on two String objects.
        assertTrue(nl.equals(tl));

        // this snippet is from StackOverflow
        // optionally, reset System.in to its original
        System.setIn(System.in);

        // show me.
        // newStack.printChain();
        // testStack.printChain();
    }

    public void testReadDoublesFromFileWhenNoFileExists() throws Exception {
        PrintStream oldStream = System.out;
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(myOut);
        System.setOut(ps);

        String readFromFile = "noSuchFile.txt";
        Stack newStack = StackHelper.readDoublesFromFile(readFromFile);
        newStack.printList();
        // this displays console message:  "Chain is empty"

        StringBuffer sb = newStack.createChain();
        assertEquals(sb.toString(), myOut.toString());

        System.out.flush();
        System.setOut(oldStream);
    }

    public void testReadDoublesFromFileWhenFileExists() throws Exception {
        PrintStream oldStream = System.out;
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        String readFromFile = "inputDoubles.txt";
        Stack newStack = StackHelper.readDoublesFromFile(readFromFile);
        newStack.printChain();

        // my comparison code:
        StringBuffer sb = newStack.createChain();
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
        Stack newStack = new Stack();
        newStack.insertNode(n1);   // 6 (tail)
        newStack.insertNode(n2);   // 5
        newStack.insertNode(n3);   // 4
        newStack.insertNode(n4);   // 3
        newStack.insertNode(n5);   // 2
        newStack.insertNode(n6);   // 1 (head)

        PrintStream oldStream = System.out;
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(myOut);
        System.setOut(ps);

        StackHelper.writeDoublesToConsole(newStack);
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
        Stack newStack = new Stack();
        File dFile;
        newStack.insertNode(n1);   // 6 (tail)
        newStack.insertNode(n2);   // 5
        newStack.insertNode(n3);   // 4
        newStack.insertNode(n4);   // 3
        newStack.insertNode(n5);   // 2
        newStack.insertNode(n6);   // 1 (head)
        String filename = "outputSHTest.txt";
        StackHelper.writeDoublesToFile(newStack, filename);
        dFile = new File(filename);
        assertTrue(dFile.exists());
        // this worked.  deleted the file so I can re-run it.
    }

}