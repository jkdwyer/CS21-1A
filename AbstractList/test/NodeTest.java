import junit.framework.TestCase;

public class NodeTest extends TestCase {
    public void testSetPayload() throws Exception {
        Node n = new Node();
        n.setPayload(42);
        assertEquals(n.getPayload(), 42.0);
    }

    public void testGetPayload() throws Exception {
        Node n = new Node(16.9);
        double d = n.getPayload();
        assertEquals(d, 16.9);
    }

    public void testSetNext() throws Exception {
        Node n1 = new Node();
        Node n2 = new Node();
        n1.setNext(n2);
        assertEquals(n1.getNext(), n2);
    }

    public void testGetNext() throws Exception {
        Node n1 = new Node();
        Node n2 = new Node();
        n1.setNext(n2);
        assertEquals(n1.getNext(), n2);
    }

    public void testSetLast() throws Exception {
        Node n1 = new Node();
        Node n2 = new Node();
        n1.setLast(n2);
        assertEquals(n1.getLast(), n2);
    }

    public void testGetLast() throws Exception {
        Node n1 = new Node();
        Node n2 = new Node();
        n1.setLast(n2);
        assertEquals(n1.getLast(), n2);
    }
}