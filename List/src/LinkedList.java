import java.io.*;
import java.util.*;
/**
 * LinkedList class
 * - This class will need to be abstract.
 * - Provides get methods for head, tail and nodeCounter.
 * - Provides methods:  listEmpty, createPrintList, printList,
 *      searchByPosition, searchByNode,
 *      deleteNode, insertNode and insertNewHead.
 *
 * @author Jan Dwyer
 * @version 1.0     10/1/2017.
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int nodeCounter;

    // no-args constructor.
    public LinkedList() {
    }

    /**
     * listEmpty() method
     * - true when list is empty.
     * @return boolean
     */
    public boolean listEmpty() {
        return (nodeCounter == 0);
    }   // end listEmpty.


    /**
     * getNodeCounter() method
     * @return int
     */
    public int getNodeCounter() {
        return nodeCounter;
    }   // end getNodeCounter.


    /**
     * getHead() method
     * @return Node
     */
    public Node getHead() {
        return head;
    }   // end getHead.


    /**
     * getTail() method
     * @return Node
     */
    public Node getTail() {
        return tail;
    }   // end getTail.


    /**
     * searchByNode() method
     * - Accepts a node and returns its integer position in the chain.
     * @param node
     * @return int
     */
    public int searchByNode(Node node){
        int position = -1;
        int compareCounter = 1;
        Node compareNode = head;
        boolean match = false;

        if (!listEmpty()) {
            while ((compareNode != tail) && (!match)) {
                if (compareNode == node) {
                    match = true;
                    position = compareCounter;
                } else {
                    Node nextNode = compareNode.getNext();
                    compareNode = nextNode;
                    compareCounter++;
                }
            }
            if (!match) {
                if (tail == node) {
                    position = compareCounter;
                }
            }
        }
        return position;
    }   // end searchByNode.


    /**
     * searchByPosition() method
     * - Accepts an integer position and returns the node
     *      at that position.
     * @param pos
     * @return int
     */
    public Node searchByPosition(int pos) {
        Node node = null;
        int counter = 1;
        boolean match = false;

        if (pos <= nodeCounter) {
            // then I can return a node.
            node = head;
            while ((counter <= nodeCounter) && (!match)) {
                if (pos == counter) {
                    match = true;
                } else {
                    Node nextNode = node.getNext();
                    node = nextNode;
                    counter++;
                }
            }
        }
        return node;
    }   // end searchByPosition.


    /**
     * createPrintList() method
     * - calls a searchByPosition method to create
     *      a StringBuffer object containing the list of node
     *      position and payload, one line per element.
     * @return StringBuffer
     */
    public StringBuffer createPrintList() {
        StringBuffer printString = new StringBuffer();
        int ct = 1;
        Node node;

        printString.append("\n");
        if (!listEmpty()) {
            while (ct <= nodeCounter) {
                node = searchByPosition(ct);
                printString.append("ct: " + ct + " - payload: " +
                    node.getPayload());
                if (node.equals(head)) {
                    printString.append(" (head)");
                } else if (node.equals(tail)) {
                    printString.append(" (tail)");
                }
                printString.append("\n");
                ct++;
            }
        } else {
            printString.append("List is empty");
        }
        printString.append("\n");

        return printString;
    }   // end createPrintList.


    /**
     * printList() method
     * - calls createPrintList method to obtain a StringBuffer object.
     * - displays the StringBuffer object.
     */
    public void printList() {
        StringBuffer list = createPrintList();
        System.out.println(list);
    }   // end printList.


    /**
     * deleteNode() method
     * - Accepts a node, searches for it, and changes
     *      the next and last references of adjoining nodes
     *      to remove it from the chain.
     * @param node
     */
    public void deleteNode(Node node) {
        Node neighbor;
        Node beforeNode;
        Node afterNode;

        if (!listEmpty()) {
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
        }
    }   // end deleteNode.


    /**
     * insertNode() method
     * - Accepts a node, its neighbor, and a before or after reference.
     * - Inserts the new node either before or after the neighbor.
     * - Handles empty list, replace head or replace tail scenarios.
     * @param node
     * @param neighbor
     * @param ba
     */
    public void insertNode(Node node, Node neighbor, String ba) {
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
    }   // end insertNode.


    /**
     * insertNewHead() method
     * - Accepts a node with no other args and adds it
     *      to the head of the chain.
     * @param node
     */
    public void insertNewHead(Node node){
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
    }   // end insertNewHead.
}   // end LinkedList class.
