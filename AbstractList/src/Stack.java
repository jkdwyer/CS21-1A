/**
 * Stack subclass
 * - implements insertNode (push) from parent class.
 * - implements its own deleteNode (pop)
 *
 * @author Jan Dwyer
 * @version 1.0     10/3/2017.
 */
public class Stack extends AbstractLinkedList {
    /**
     * Constructor 1.
     * - no-args constructor
     */
    public Stack() {
    }   // end Constructor 1.


    /**
     * Constructor 2.
     * @param node
     */
    public Stack(Node node) {
        insertNode(node);
    }   // end Constructor 2.


    /**
     * insertNode method implemented from parent class
     * - push onto head (LIFO)
     * @param node
     */
    public void insertNode(Node node) {
        if (nodeCounter == 0) {
            head = node;
            tail = node;
        } else {
            node.setNext(head);
            head = node;
        }
        nodeCounter++;
    }   // end insertNode;


    /**
     * deleteNode method
     * - pop off of head (LIFO)
     * @return
     */
    public Node deleteNode() {
        Node currentHead = new Node();
        currentHead = head;
        head = currentHead.getNext();
        nodeCounter--;
        // return value is the node that was the previous head.
        return currentHead;
    }   // end deleteNode.
}   // end Stack subclass
