/**
 * DoublyLinkedList class
 * - This class will inherit from AbstractList/src/AbstractLinkedList class.
 * - Inherits get methods for head, tail and nodeCounter.
 * - Inherits methods:  listEmpty, createPrintList, printList,
 *      searchByPosition, searchByNode,
 * - Implements abstract method:  insertNode
 * - Provides additional methods:  insertListNode, deleteListNode
 *
 * @author Jan Dwyer
 * @version 1.0     10/8/2017.
 */
public class DoublyLinkedList extends AbstractLinkedList {
    /**
     * insertNode() method
     * - Implements abstract method.
     * - Accepts a node with no other args and adds it
     *      to the head of the chain.  Increments nodeCounter.
     * @param node
     */
    public void insertNode(Node node){
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
    }   // end insertNode.


    /**
     * deleteListNode() method
     * - Accepts a node, searches for it, and changes
     *      the next and last references of adjoining nodes
     *      to remove it from the chain.  Decrements nodeCounter.
     * @param node
     */
    public void deleteListNode(Node node) {
        Node neighbor;
        Node beforeNode;
        Node afterNode;

        if (!isEmpty()) {
            if (node == head) {
                neighbor = node.getNext();
                // remove ref to current head.
                neighbor.setLast(null);
                // neighbor becomes new head.
                head = neighbor;
            } else if (node == tail) {
                neighbor = node.getLast();
                // remove ref to current tail.
                neighbor.setNext(null);
                // neighbor becomes the new tail.
                tail = neighbor;
            } else {
                beforeNode = node.getLast();
                afterNode = node.getNext();
                // remove node from the list.
                beforeNode.setNext(afterNode);
                afterNode.setLast(beforeNode);
            }
            // reduce the node count.
            nodeCounter--;
        } else {
            System.out.println("List is empty");
        }
    }   // end deleteListNode.


    /**
     * insertListNode() method
     * - Accepts a node, its neighbor, and a before or after reference.
     * - Inserts the new node either before or after the neighbor.
     * - Handles empty list, replace head or replace tail scenarios.
     * - Increments nodeCounter.
     * @param node
     * @param neighbor
     * @param ba
     */
    public void insertListNode(Node node, Node neighbor, String ba) {
        Node neighborLast;
        Node neighborNext;

        if (nodeCounter == 0) {
            head = node;
            tail = node;
        } else {
            if (ba == "before") {
                if (neighbor != head) {
                    node.setNext(neighbor);
                    neighborLast = neighbor.getLast();
                    node.setLast(neighborLast);
                    neighborLast.setNext(node);
                    neighbor.setLast(node);
                } else {
                    node.setNext(neighbor);
                    neighbor.setLast(node);
                    // node becomes new head.
                    head = node;
                }
            } else {    // after.
                if (neighbor != tail) {
                    node.setLast(neighbor);
                    neighborNext = neighbor.getNext();
                    node.setNext(neighborNext);
                    neighbor.setNext(node);
                    neighborNext.setLast(node);
                } else {
                    node.setLast(neighbor);
                    neighbor.setNext(node);
                    // node becomes new tail.
                    tail = node;
                }
            }
        }
        nodeCounter++;
    }   // end insertListNode.
}   // end DoublyLinkedList class.
