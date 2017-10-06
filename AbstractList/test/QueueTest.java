import junit.framework.TestCase;

public class QueueTest extends TestCase {
    public void testInsertNode() throws Exception {
        Node n1 = new Node();
        Node n2 = new Node();
        Queue q = new Queue();
        q.insertNode(n1);
        assertEquals(q.nodeCounter, 1);
        assertEquals(q.head, n1);
        assertEquals(q.tail, n1);
        q.insertNode(n2);
        assertEquals(q.nodeCounter, 2);
        assertEquals(q.head, n1);
        assertEquals(q.tail, n2);
    }

    public void testDeleteNode() throws Exception {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Node n4;
        Queue q = new Queue();
        q.insertNode(n1);   // 1 - head
        q.insertNode(n2);   // 2
        q.insertNode(n3);   // 3 - tail
        assertEquals(q.nodeCounter, 3);
        assertEquals(q.head, n1);
        assertEquals(q.tail, n3);
        n4 = q.deleteNode();
        assertEquals(q.nodeCounter, 2);
        assertTrue(n4.equals(n1));
        assertEquals(q.head, n2);
        assertEquals(q.tail, n3);
    }

    public void testIsEmptyTrue() throws Exception {
        Queue q = new Queue();
        assertEquals(q.isEmpty(), true);
    }

    public void testIsEmptyFalse() throws Exception {
        Node n = new Node();
        Queue q = new Queue();
        q.insertNode(n);
        assertEquals(q.isEmpty(), false);
    }

    public void testGetNodeCounter() throws Exception {
        Node n1 = new Node();
        Node n2 = new Node();
        Queue q = new Queue();
        q.insertNode(n1);
        assertEquals(q.getNodeCounter(), 1);
        q.insertNode(n2);
        assertEquals(q.getNodeCounter(), 2);
        assertEquals(q.getNodeCounter(), q.nodeCounter);
    }

    public void testGetHead() throws Exception {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Queue q = new Queue();
        q.insertNode(n1);
        q.insertNode(n2);
        q.insertNode(n3);
        assertEquals(q.head, n3);
        assertEquals(q.getHead(), n3);
    }

    public void testGetTail() throws Exception {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        Queue q = new Queue();
        q.insertNode(n1);
        q.insertNode(n2);
        q.insertNode(n3);
        assertEquals(q.tail, n1);
        assertEquals(q.getTail(), n1);
    }

    public void testSearchByNode() throws Exception {
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        Queue q = new Queue();
        int pos = 0;
        q.insertNode(n1);   // 1 (head)
        q.insertNode(n2);   // 2
        q.insertNode(n3);   // 3
        q.insertNode(n4);   // 4
        q.insertNode(n5);   // 5
        q.insertNode(n6);   // 6 (tail)
        pos = q.searchByNode(n4);
        assertEquals(pos, 4);
        pos = q.searchByNode(n1);
        assertEquals(pos, 1);
    }

    public void testSearchByPosition() throws Exception {
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        Queue q = new Queue();
        Node n7;
        q.insertNode(n1);   // 1 (head)
        q.insertNode(n2);   // 2
        q.insertNode(n3);   // 3
        q.insertNode(n4);   // 4
        q.insertNode(n5);   // 5
        q.insertNode(n6);   // 6 (tail)
        n7 = q.searchByPosition(5);
        assertEquals(n7, n5);
        n7 = q.searchByPosition(2);
        assertEquals(n7, n2);
    }

    public void testCreatePrintList() throws Exception {
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        Queue q = new Queue();

        q.insertNode(n1);   // 1 (head)
        q.insertNode(n2);   // 2
        q.insertNode(n3);   // 3
        q.insertNode(n4);   // 4
        q.insertNode(n5);   // 5
        q.insertNode(n6);   // 6 (tail)

        StringBuffer ps = new StringBuffer();
        ps.append("\n");
        ps.append("ct: 1 - payload: 144.0 (head)");
        ps.append("\n");
        ps.append("ct: 2 - payload: 12.22");
        ps.append("\n");
        ps.append("ct: 3 - payload: 3333.88999");
        ps.append("\n");
        ps.append("ct: 4 - payload: 150.0123");
        ps.append("\n");
        ps.append("ct: 5 - payload: 0.0847");
        ps.append("\n");
        ps.append("ct: 6 - payload: 16.9 (tail)");
        ps.append("\n");
        ps.append("\n");

        StringBuffer returnedList = q.createPrintList();
        String pl = returnedList.toString();
        String tl = ps.toString();
        assertEquals(pl, tl);
        assertTrue(returnedList.toString().equals(ps.toString()));
    }

    public void testCreateChain() throws Exception {
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        Queue q = new Queue();

        q.insertNode(n1);   // 1 (head)
        q.insertNode(n2);   // 2
        q.insertNode(n3);   // 3
        q.insertNode(n4);   // 4
        q.insertNode(n5);   // 5
        q.insertNode(n6);   // 6 (tail)

        StringBuffer pc = new StringBuffer();
        pc.append("\n");
        pc.append("ct: 1 - payload: 144.000 (head)");
        pc.append("\n");
        pc.append("ct: 2 - payload: 12.220");
        pc.append("\n");
        pc.append("ct: 3 - payload: 3333.890");
        pc.append("\n");
        pc.append("ct: 4 - payload: 150.012");
        pc.append("\n");
        pc.append("ct: 5 - payload: 0.085");
        pc.append("\n");
        pc.append("ct: 6 - payload: 16.900 (tail)");
        pc.append("\n");
        pc.append("\n");

        StringBuffer returnedChain = q.createChain();
        String cc = returnedChain.toString();
        String tc = pc.toString();
        assertEquals(cc, tc);
        assertTrue(returnedChain.toString().equals(pc.toString()));
    }
}