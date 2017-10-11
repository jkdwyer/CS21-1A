import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

public class QueueHelperTest extends TestCase {
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

        Queue newQueue = QueueHelper.readDoublesFromConsole();

        Queue testQueue = new Queue();
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        testQueue.insertNode(n1);   // 6 (tail)
        testQueue.insertNode(n2);   // 5
        testQueue.insertNode(n3);   // 4
        testQueue.insertNode(n4);   // 3
        testQueue.insertNode(n5);   // 2
        testQueue.insertNode(n6);   // 1 (head)
        StringBuffer nb = newQueue.createChain();
        StringBuffer tb = testQueue.createChain();
        String nl = nb.toString();
        String tl = tb.toString();
        // this .equals() only works on two String objects.
        assertTrue(nl.equals(tl));

        // this snippet is from StackOverflow
        // optionally, reset System.in to its original
        System.setIn(System.in);

        // show me.
        // newQueue.printChain();
        // testQueue.printChain();
    }

    public void testReadDoublesFromFileWhenNoFileExists() throws Exception {
        PrintStream oldStream = System.out;
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(myOut);
        System.setOut(ps);

        String readFromFile = "noSuchFile.txt";
        Queue newQueue = QueueHelper.readDoublesFromFile(readFromFile);
        newQueue.printList();
        // this displays console message:  "Chain is empty"

        StringBuffer sb = newQueue.createChain();
        assertEquals(sb.toString(), myOut.toString());

        System.out.flush();
        System.setOut(oldStream);
    }

    public void testReadDoublesFromFileWhenFileExists() throws Exception {
        PrintStream oldStream = System.out;
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(myOut));

        String readFromFile = "inputDoubles.txt";
        Queue newQueue = QueueHelper.readDoublesFromFile(readFromFile);
        newQueue.printChain();

        // my comparison code:
        StringBuffer sb = newQueue.createChain();
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
        Queue newQueue = new Queue();
        newQueue.insertNode(n1);   // 1 (head)
        newQueue.insertNode(n2);   // 2
        newQueue.insertNode(n3);   // 3
        newQueue.insertNode(n4);   // 4
        newQueue.insertNode(n5);   // 5
        newQueue.insertNode(n6);   // 6 (tail)

        PrintStream oldStream = System.out;
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(myOut);
        System.setOut(ps);

        QueueHelper.writeDoublesToConsole(newQueue);
        StringBuffer sb = new StringBuffer();
        sb.append("\n\n144.000");
        sb.append("\n12.220");
        sb.append("\n3333.890");
        sb.append("\n150.012");
        sb.append("\n0.085");
        sb.append("\n16.900\n\n\n");
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
        Queue newQueue = new Queue();
        File dFile;
        newQueue.insertNode(n1);   // 6 (tail)
        newQueue.insertNode(n2);   // 5
        newQueue.insertNode(n3);   // 4
        newQueue.insertNode(n4);   // 3
        newQueue.insertNode(n5);   // 2
        newQueue.insertNode(n6);   // 1 (head)
        String filename = "outputQHTest.txt";
        QueueHelper.writeDoublesToFile(newQueue, filename);
        dFile = new File(filename);
        assertTrue(dFile.exists());
        // this worked.  deleted the file so I can re-run it.
    }
}