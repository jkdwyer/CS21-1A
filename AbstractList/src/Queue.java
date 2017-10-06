/**
 * Queue subclass
 * - implements insertNode (enqueue) from parent class.
 * - implements its own deleteNode (dequeue)
 *
 * @author Jan Dwyer
 * @version 1.0     10/3/2017.
 */
public class Queue extends AbstractLinkedList {
    /**
     * Constructor 1.
     * - no-args constructor.
     */
    public Queue () {
    }   // end Constructor 1.


    /**
     * Constructor 2.
     * @param node
     */
    public Queue (Node node) {
        insertNode(node);
    }   // end Constructor 2.


    /**
     * insertNode method implemented from parent class
     * - enqueue onto tail (FIFO)
     * @param node
     */
    public void insertNode(Node node) {
        if (nodeCounter == 0) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        nodeCounter++;
    }   // end insertNode.


    /**
     * deleteNode method
     * - dequeue off of head (FIFO)
     * @return Node
     */
    public Node deleteNode() {
        Node lastHead = head;
        head = head.getNext();
        nodeCounter--;
        return lastHead;
    }   // end deleteNode.
}   // end Queue subclass.
