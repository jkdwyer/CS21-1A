import junit.framework.TestCase;
import java.io.File;

public class ListHelperTest extends TestCase {
    public void testReadDoublesFromConsole() throws Exception {
    }

    public void testReadDoublesFromFileWhenNoFileExists() throws Exception {
        String readFromFile = "noSuchFile.txt";
        LinkedList dblList = ListHelper.readDoublesFromFile(readFromFile);
        dblList.printList();
        // this only displays console message:  "Chain is empty"
        // can I do better?
    }

    public void testReadDoublesFromFileWhenFileExists() throws Exception {
        String readFromFile = "inputDoubles.txt";
        LinkedList dblList = ListHelper.readDoublesFromFile(readFromFile);
        dblList.printList();
        // this displays console output of list created.
        // StringBuffer sb = dblList.createChain();
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
        ListHelper.writeDoublesToConsole(newList);
        // this displays console output of list created.
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