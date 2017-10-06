import junit.framework.TestCase;

public class StackTest extends TestCase {
    public void testInsertNode() throws Exception {
        Stack s = new Stack();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        s.insertNode(n1);
        assertEquals(s.nodeCounter, 1);
        assertEquals(s.head, n1);
        assertEquals(s.tail, n1);
        s.insertNode(n2);
        assertEquals(s.nodeCounter, 2);
        assertEquals(s.head, n2);
        assertEquals(s.tail, n1);
        s.insertNode(n3);
        assertEquals(s.nodeCounter, 3);
        assertEquals(s.head, n3);
        assertEquals(s.tail, n1);
    }

    public void testDeleteNode() throws Exception {
        Stack s = new Stack();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3;
        s.insertNode(n1);
        assertEquals(s.head, n1);
        assertEquals(s.tail, n1);
        s.insertNode(n2);
        assertEquals(s.nodeCounter, 2);
        assertEquals(s.head, n2);
        assertEquals(s.tail, n1);
        n3 = s.deleteNode();
        assertEquals(n3, n2);
        assertEquals(s.nodeCounter, 1);
        assertEquals(s.head, n1);
        assertEquals(s.tail, n1);
    }

    public void testIsEmptyTrue() throws Exception {
        Stack s = new Stack();
        Node n = new Node();
        assertEquals(s.isEmpty(), true);
    }

    public void testIsEmptyFalse() throws Exception {
        Stack s = new Stack();
        Node n = new Node();
        s.insertNode(n);
        assertEquals(s.isEmpty(), false);
    }

    public void testGetNodeCounter() throws Exception {
        Stack s = new Stack();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3;
        s.insertNode(n1);
        assertEquals(s.getNodeCounter(), 1);
        s.insertNode(n2);
        assertEquals(s.getNodeCounter(), 2);
    }

    public void testGetHead() throws Exception {
        Stack s = new Stack();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        s.insertNode(n1);
        s.insertNode(n2);
        s.insertNode(n3);
        assertEquals(s.getHead(), n3);
        assertEquals(s.head, n3);
        assertEquals(s.head, s.getHead());
    }

    public void testGetTail() throws Exception {
        Stack s = new Stack();
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        s.insertNode(n1);
        s.insertNode(n2);
        s.insertNode(n3);
        assertEquals(s.getTail(), n1);
        assertEquals(s.tail, n1);
        assertEquals(s.tail, s.getTail());
    }

    public void testSearchByNode() throws Exception {
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        Stack s = new Stack();
        int pos = 0;
        s.insertNode(n1);   // 6 (tail)
        s.insertNode(n2);   // 5
        s.insertNode(n3);   // 4
        s.insertNode(n4);   // 3
        s.insertNode(n5);   // 2
        s.insertNode(n6);   // 1 (head)
        pos = s.searchByNode(n4);
        assertEquals(pos, 3);
        pos = s.searchByNode(n1);
        assertEquals(pos, 6);
    }

    public void testSearchByPosition() throws Exception {
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        Stack s = new Stack();
        Node testNode;
        s.insertNode(n1);   // 6 (tail)
        s.insertNode(n2);   // 5
        s.insertNode(n3);   // 4
        s.insertNode(n4);   // 3
        s.insertNode(n5);   // 2
        s.insertNode(n6);   // 1 (head)
        testNode = s.searchByPosition(2);
        assertEquals(testNode, n5);
        testNode = s.searchByPosition(4);
        assertEquals(testNode, n3);
    }

    public void testCreatePrintList() throws Exception {
        Node n1 = new Node(144);
        Node n2 = new Node(12.22);
        Node n3 = new Node(3333.88999);
        Node n4 = new Node(150.0123);
        Node n5 = new Node(0.0847);
        Node n6 = new Node(16.9);
        Stack s = new Stack();

        s.insertNode(n1);   // 6 (tail)
        s.insertNode(n2);   // 5
        s.insertNode(n3);   // 4
        s.insertNode(n4);   // 3
        s.insertNode(n5);   // 2
        s.insertNode(n6);   // 1 (head)

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

        StringBuffer returnedList = s.createPrintList();
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
        Stack st = new Stack();
        st.insertNode(n1);   // 6 (tail)
        st.insertNode(n2);   // 5
        st.insertNode(n3);   // 4
        st.insertNode(n4);   // 3
        st.insertNode(n5);   // 2
        st.insertNode(n6);   // 1 (head)

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

        StringBuffer returnedChain = st.createChain();
        String cc = returnedChain.toString();
        String tc = pc.toString();
        assertEquals(cc, tc);
        assertTrue(returnedChain.toString().equals(pc.toString()));
    }
}   // end StackTest.