import junit.framework.TestCase;
import java.io.File;

public class AbstractLinkedListTest extends TestCase {

    class ConcreteLinkedList extends AbstractLinkedList {
        // Now this is a concrete class, so I can instantiate one.
        // Bill says, probably in each method of this test class.
        public void insertNode(Node node) {
            if (nodeCounter == 0) {
                head = node;
                tail = node;
            } else {
                // set incoming node next-ref to existing head.
                node.setNext(head);
                // set existing head last-ref to incoming node.
                head.setLast(node);
                // set new head to incoming node.
                // tail is not affected by insert.
                head = node;
            }
            nodeCounter++;
        }
    }

    public void testIsEmptyTrue() throws Exception {
        ConcreteLinkedList cl = new ConcreteLinkedList();
        assertEquals(cl.isEmpty(), true);
    }

    public void testIsEmptyFalse() throws Exception {
        ConcreteLinkedList cl = new ConcreteLinkedList();
        Node n = new Node();
        cl.insertNode(n);
        assertEquals(cl.isEmpty(), false);
    }

    public void testGetNodeCounter() throws Exception {
        ConcreteLinkedList cl = new ConcreteLinkedList();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3;
        cl.insertNode(n1);
        assertEquals(cl.getNodeCounter(), 1);
        cl.insertNode(n2);
        assertEquals(cl.getNodeCounter(), 2);
        assertEquals(cl.getNodeCounter(), cl.nodeCounter);
    }

    public void testGetHead() throws Exception {
        ConcreteLinkedList cl = new ConcreteLinkedList();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        cl.insertNode(n1);
        cl.insertNode(n2);
        cl.insertNode(n3);
        assertEquals(cl.getHead(), n3);
        assertEquals(cl.head, n3);
        assertEquals(cl.head, cl.getHead());
    }

    public void testGetTail() throws Exception {
        ConcreteLinkedList cl = new ConcreteLinkedList();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        cl.insertNode(n1);
        cl.insertNode(n2);
        cl.insertNode(n3);
        assertEquals(cl.getTail(), n1);
        assertEquals(cl.tail, n1);
        assertEquals(cl.tail, cl.getTail());
    }

    public void testSearchByNode() throws Exception {
        ConcreteLinkedList cl = new ConcreteLinkedList();
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        int pos = 0;
        cl.insertNode(n1);   // 6 (tail)
        cl.insertNode(n2);   // 5
        cl.insertNode(n3);   // 4
        cl.insertNode(n4);   // 3
        cl.insertNode(n5);   // 2
        cl.insertNode(n6);   // 1 (head)
        pos = cl.searchByNode(n4);
        assertEquals(pos, 3);
        pos = cl.searchByNode(n1);
        assertEquals(pos, 6);
    }

    public void testSearchByPosition() throws Exception {
        ConcreteLinkedList cl = new ConcreteLinkedList();
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        Node testNode;
        cl.insertNode(n1);   // 6 (tail)
        cl.insertNode(n2);   // 5
        cl.insertNode(n3);   // 4
        cl.insertNode(n4);   // 3
        cl.insertNode(n5);   // 2
        cl.insertNode(n6);   // 1 (head)
        testNode = cl.searchByPosition(2);
        assertEquals(testNode, n5);
        testNode = cl.searchByPosition(4);
        assertEquals(testNode, n3);
    }

    public void testCreatePrintList() throws Exception {
        ConcreteLinkedList cl = new ConcreteLinkedList();
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        cl.insertNode(n1);   // 6 (tail)
        cl.insertNode(n2);   // 5
        cl.insertNode(n3);   // 4
        cl.insertNode(n4);   // 3
        cl.insertNode(n5);   // 2
        cl.insertNode(n6);   // 1 (head)

        StringBuffer ps = new StringBuffer();
        ps.append("\n");
        ps.append("ct: 1 - payload: 16.9 (head)");
        ps.append("\n");
        ps.append("ct: 2 - payload: 0.0847");
        ps.append("\n");
        ps.append("ct: 3 - payload: 150.0123");
        ps.append("\n");
        ps.append("ct: 4 - payload: 3333.88999");
        ps.append("\n");
        ps.append("ct: 5 - payload: 12.22");
        ps.append("\n");
        ps.append("ct: 6 - payload: 144.0 (tail)");
        ps.append("\n");
        ps.append("\n");

        StringBuffer returnedList = cl.createPrintList();
        String pl = returnedList.toString();
        String tl = ps.toString();
        assertEquals(pl, tl);
        assertTrue(returnedList.toString().equals(ps.toString()));
    }

    public void testCreateChain() throws Exception {
        ConcreteLinkedList cl = new ConcreteLinkedList();
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        cl.insertNode(n1);   // 6 (tail)
        cl.insertNode(n2);   // 5
        cl.insertNode(n3);   // 4
        cl.insertNode(n4);   // 3
        cl.insertNode(n5);   // 2
        cl.insertNode(n6);   // 1 (head)

        StringBuffer pc = new StringBuffer();
        pc.append("\n");
        pc.append("ct: 1 - payload: 16.900 (head)");
        pc.append("\n");
        pc.append("ct: 2 - payload: 0.085");
        pc.append("\n");
        pc.append("ct: 3 - payload: 150.012");
        pc.append("\n");
        pc.append("ct: 4 - payload: 3333.890");
        pc.append("\n");
        pc.append("ct: 5 - payload: 12.220");
        pc.append("\n");
        pc.append("ct: 6 - payload: 144.000 (tail)");
        pc.append("\n");
        pc.append("\n");

        StringBuffer returnedChain = cl.createChain();
        String cc = returnedChain.toString();
        String tc = pc.toString();
        assertEquals(cc, tc);
        assertTrue(returnedChain.toString().equals(pc.toString()));
    }

    public void testInsertNode() throws Exception {
        ConcreteLinkedList cl = new ConcreteLinkedList();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        cl.insertNode(n1);
        assertEquals(cl.getHead(), n1);
        assertEquals(cl.getTail(), n1);
        assertEquals(cl.getNodeCounter(), 1);
        cl.insertNode(n2);
        cl.insertNode(n3);
        assertEquals(cl.getHead(), n3);
        assertEquals(cl.getTail(), n1);
        assertEquals(cl.getNodeCounter(), 3);
    }
}