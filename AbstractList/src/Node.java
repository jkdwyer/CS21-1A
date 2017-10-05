/**
 * Node class
 * - Will be used by List, Stack and Queue in project CS21-1A.
 * - This class will not be abstract.
 *
 * @author Jan Dwyer
 * @version 1.0         10/3/2017.
 */
public class Node {
    private double payload;
    private Node next;
    private Node last;

    /**
     * default constructor, no args.
     */
    public Node() {
        payload = 0.0;
    }

    /**
     * constructor, takes double arg for payload.
     * @param data      double
     */
    public Node(double data) {
        payload = data;
    }

    /**
     * setPayload() method.
     * @param data
     */
    public void setPayload(double data) {
        payload = data;
    }

    /**
     * getPayload() method.
     * @return double
     */
    public double getPayload() {
        return payload;
    }

    /**
     * setNext() method
     * @param newNode
     */
    public void setNext(Node newNode) {
        next = newNode;
    }

    /**
     * getNext() method
     * @return Node
     */
    public Node getNext() {
        return next;
    }

    /**
     * setLast() method
     * @param newNode
     */
    public void setLast(Node newNode) {
        last = newNode;
    }

    /**
     * getLast() method
     * @return
     */
    public Node getLast() {
        return last;
    }
}
