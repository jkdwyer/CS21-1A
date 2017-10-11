import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DoublyLinkedListTest extends TestCase {
    private String after = "after";
    private String before = "before";

    public void testDeleteListNodeListEmpty() throws Exception {
        PrintStream oldStream = System.out;
        ByteArrayOutputStream myOut = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(myOut);
        System.setOut(ps);

        DoublyLinkedList dl2 = new DoublyLinkedList();
        Node n1 = new Node();
        dl2.deleteListNode(n1);
        // This displays console output: "List is empty"

        String s = "List is empty" + "\n";
        assertEquals(s, myOut.toString());

        System.out.flush();
        System.setOut(oldStream);
    }

    public void testDeleteListNodeHead() throws Exception {
        DoublyLinkedList dl2 = new DoublyLinkedList();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        dl2.insertNode(n1);
        assertEquals(dl2.getHead(), n1);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 1);
        dl2.insertNode(n2);
        dl2.insertNode(n3);
        assertEquals(dl2.getHead(), n3);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 3);
        Node n4 = dl2.getHead();
        dl2.deleteListNode(n4);
        assertEquals(dl2.getHead(), n2);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 2);
    }

    public void testDeleteListNodeTail() throws Exception {
        DoublyLinkedList dl2 = new DoublyLinkedList();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        dl2.insertNode(n1);
        assertEquals(dl2.getHead(), n1);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 1);
        dl2.insertNode(n2);
        dl2.insertNode(n3);
        assertEquals(dl2.getHead(), n3);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 3);
        assertEquals(n2.getNext(), n1);
        assertEquals(n2.getLast(), n3);
        dl2.deleteListNode(n1);
        assertEquals(dl2.getHead(), n3);
        assertEquals(dl2.getTail(), n2);
        assertEquals(dl2.getNodeCounter(), 2);
    }

    public void testDeleteListNode() throws Exception {
        DoublyLinkedList dl2 = new DoublyLinkedList();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        dl2.insertNode(n1);
        assertEquals(dl2.getHead(), n1);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 1);
        dl2.insertNode(n2);
        dl2.insertNode(n3);
        assertEquals(dl2.getHead(), n3);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 3);
        assertEquals(n2.getNext(), n1);
        assertEquals(n2.getLast(), n3);
        dl2.deleteListNode(n2);
        assertEquals(dl2.getHead(), n3);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 2);
        assertEquals(n3.getNext(), n1);
        assertEquals(n1.getLast(), n3);
    }

    public void testInsertListNodeListEmpty() throws Exception {
        // needs to begin with an empty list.
        DoublyLinkedList dl2 = new DoublyLinkedList();
        Node n1 = new Node();
        Node n2 = new Node();
        dl2.insertListNode(n1, n2, after);
        assertEquals(dl2.getHead(), n1);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 1);
    }

    public void testInsertListNodeBeforeHead() throws Exception {
        DoublyLinkedList dl2 = new DoublyLinkedList();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        dl2.insertNode(n1);
        assertEquals(dl2.getHead(), n1);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 1);
        dl2.insertNode(n2);
        dl2.insertNode(n3);
        assertEquals(dl2.getHead(), n3);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 3);
        dl2.insertListNode(n4, n3, before);
        assertEquals(dl2.getHead(), n4);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 4);
        Node n5 = dl2.head.getNext();
        assertEquals(n5, n3);
        assertEquals(n4.getNext(), n3);
        assertEquals(n3.getLast(), n4);
    }

    public void testInsertListNodeBeforeNotHead() throws Exception {
        DoublyLinkedList dl2 = new DoublyLinkedList();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        dl2.insertNode(n1);
        assertEquals(dl2.getHead(), n1);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 1);
        dl2.insertNode(n2);
        dl2.insertNode(n3);
        assertEquals(dl2.getHead(), n3);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 3);
        dl2.insertListNode(n4, n2, before);
        assertEquals(dl2.getHead(), n3);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 4);
        assertEquals(n4.getNext(), n2);
        assertEquals(n4.getLast(), n3);
        assertEquals(n3.getNext(), n4);
        assertEquals(n2.getLast(), n4);
    }

    public void testInsertListNodeAfterTail() throws Exception {
        DoublyLinkedList dl2 = new DoublyLinkedList();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        dl2.insertNode(n1);
        assertEquals(dl2.getHead(), n1);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 1);
        dl2.insertNode(n2);
        dl2.insertNode(n3);
        assertEquals(dl2.getHead(), n3);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 3);
        dl2.insertListNode(n4, n1, after);
        assertEquals(dl2.getHead(), n3);
        assertEquals(dl2.getTail(), n4);
        assertEquals(dl2.getNodeCounter(), 4);
        assertEquals(n4.getLast(), n1);
        assertEquals(n1.getNext(), n4);
    }

    public void testInsertListNodeAfterNotTail() throws Exception {
        DoublyLinkedList dl2 = new DoublyLinkedList();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        dl2.insertNode(n1);
        assertEquals(dl2.getHead(), n1);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 1);
        dl2.insertNode(n2);
        dl2.insertNode(n3);
        assertEquals(dl2.getHead(), n3);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 3);
        dl2.insertListNode(n4, n2, after);
        assertEquals(dl2.getHead(), n3);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 4);
        assertEquals(n4.getNext(), n1);
        assertEquals(n4.getLast(), n2);
        assertEquals(n2.getNext(), n4);
        assertEquals(n1.getLast(), n4);
    }

    public void testInsertNode() throws Exception {
        DoublyLinkedList dl2 = new DoublyLinkedList();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4 = new Node();
        dl2.insertNode(n1);
        assertEquals(dl2.getHead(), n1);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 1);
        dl2.insertNode(n2);
        dl2.insertNode(n3);
        assertEquals(dl2.getHead(), n3);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.getNodeCounter(), 3);
    }

    public void testIsEmptyTrue() throws Exception {
        DoublyLinkedList dl2 = new DoublyLinkedList();
        assertEquals(dl2.isEmpty(), true);
    }

    public void testIsEmptyFalse() throws Exception {
        DoublyLinkedList dl2 = new DoublyLinkedList();
        Node n = new Node();
        dl2.insertNode(n);
        assertEquals(dl2.isEmpty(), false);
    }

    public void testGetNodeCounter() throws Exception {
        DoublyLinkedList dl2 = new DoublyLinkedList();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3;
        dl2.insertNode(n1);
        assertEquals(dl2.getNodeCounter(), 1);
        dl2.insertNode(n2);
        assertEquals(dl2.getNodeCounter(), 2);
        assertEquals(dl2.getNodeCounter(), dl2.nodeCounter);
    }

    public void testGetHead() throws Exception {
        DoublyLinkedList dl2 = new DoublyLinkedList();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        dl2.insertNode(n1);
        dl2.insertNode(n2);
        dl2.insertNode(n3);
        assertEquals(dl2.getHead(), n3);
        assertEquals(dl2.head, n3);
        assertEquals(dl2.head, dl2.getHead());
    }

    public void testGetTail() throws Exception {
        DoublyLinkedList dl2 = new DoublyLinkedList();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        dl2.insertNode(n1);
        dl2.insertNode(n2);
        dl2.insertNode(n3);
        assertEquals(dl2.getTail(), n1);
        assertEquals(dl2.tail, n1);
        assertEquals(dl2.tail, dl2.getTail());
    }

    public void testSearchByNode() throws Exception {
        DoublyLinkedList dl2 = new DoublyLinkedList();
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        int pos = 0;
        dl2.insertNode(n1);   // 6 (tail)
        dl2.insertNode(n2);   // 5
        dl2.insertNode(n3);   // 4
        dl2.insertNode(n4);   // 3
        dl2.insertNode(n5);   // 2
        dl2.insertNode(n6);   // 1 (head)
        pos = dl2.searchByNode(n4);
        assertEquals(pos, 3);
        pos = dl2.searchByNode(n1);
        assertEquals(pos, 6);
    }

    public void testSearchByPosition() throws Exception {
        DoublyLinkedList dl2 = new DoublyLinkedList();
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        Node testNode;
        dl2.insertNode(n1);   // 6 (tail)
        dl2.insertNode(n2);   // 5
        dl2.insertNode(n3);   // 4
        dl2.insertNode(n4);   // 3
        dl2.insertNode(n5);   // 2
        dl2.insertNode(n6);   // 1 (head)
        testNode = dl2.searchByPosition(2);
        assertEquals(testNode, n5);
        testNode = dl2.searchByPosition(4);
        assertEquals(testNode, n3);
    }

    public void testCreatePrintList() throws Exception {
        DoublyLinkedList dl2 = new DoublyLinkedList();
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        dl2.insertNode(n1);   // 6 (tail)
        dl2.insertNode(n2);   // 5
        dl2.insertNode(n3);   // 4
        dl2.insertNode(n4);   // 3
        dl2.insertNode(n5);   // 2
        dl2.insertNode(n6);   // 1 (head)

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

        StringBuffer returnedList = dl2.createPrintList();
        String pl = returnedList.toString();
        String tl = ps.toString();
        assertEquals(pl, tl);
        assertTrue(returnedList.toString().equals(ps.toString()));
    }

    public void testCreateChain() throws Exception {
        DoublyLinkedList dl2 = new DoublyLinkedList();
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        dl2.insertNode(n1);   // 6 (tail)
        dl2.insertNode(n2);   // 5
        dl2.insertNode(n3);   // 4
        dl2.insertNode(n4);   // 3
        dl2.insertNode(n5);   // 2
        dl2.insertNode(n6);   // 1 (head)

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

        StringBuffer returnedChain = dl2.createChain();
        String cc = returnedChain.toString();
        String tc = pc.toString();
        assertEquals(cc, tc);
        assertTrue(returnedChain.toString().equals(pc.toString()));
    }
}