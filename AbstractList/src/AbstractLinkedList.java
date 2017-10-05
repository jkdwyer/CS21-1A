import java.text.NumberFormat;

/**
 * AbstractLinkedList class
 * - This class will need to be abstract.
 * - Provides get methods for head, tail and nodeCounter.
 * - Provides methods:  isEmpty, createPrintList, printList,
 *      searchByPosition, searchByNode, deleteNode, insertNode
 *      and insertNewHead.
 *
 * @author Jan Dwyer
 * @version 1.0     10/3/2017.
 */
public abstract class AbstractLinkedList {
    protected Node head;
    protected Node tail;
    protected int nodeCounter;

    // no-args constructor.
    public AbstractLinkedList() {
    }

    /**
     * isEmpty() method
     * - true when list is empty.
     * @return boolean
     */
    public boolean isEmpty() {
        return (nodeCounter == 0);
    }   // end isEmpty.


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

        if (!isEmpty()) {
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
        StringBuffer chainString = new StringBuffer();
        int ct = 1;
        Node node;

        chainString.append("\n");
        if (!isEmpty()) {
            while (ct <= nodeCounter) {
                node = searchByPosition(ct);
                chainString.append("ct: " + ct + " - payload: " + node.getPayload());
                if (node.equals(head)) {
                    chainString.append(" (head)");
                } else if (node.equals(tail)) {
                    chainString.append(" (tail)");
                }
                chainString.append("\n");
                ct++;
            }
        } else {
            chainString.append("Chain is empty");
        }
        chainString.append("\n");

        return chainString;
    }   // end createPrintList.


    /**
     * printList() method
     * - calls createChain method to obtain a StringBuffer object.
     * - displays the StringBuffer object.
     */
    public void printList() {
        StringBuffer chain = createPrintList();
        System.out.println(chain);
    }   // end printList.


    /**
     * createChain method
     * - walk through the chain without doing a numeric search.
     * @return
     */
    public StringBuffer createChain() {
        Node dNode;
        double dPayload;
        String strPayload;
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(3);
        nf.setMinimumFractionDigits(3);
        StringBuffer chainBuf = new StringBuffer();

        // loop over list and add each payload to output file.
        dNode = head;
        chainBuf.append("\n");
        if (!isEmpty()) {
            for (int j = 0; j < nodeCounter; j++) {
                dPayload = dNode.getPayload();
                strPayload = nf.format(dPayload);
                chainBuf.append("ct: " + (j + 1) + " - payload: " + strPayload);
                if (dNode.equals(head)) {
                    chainBuf.append(" (head)");
                } else if (dNode.equals(tail)) {
                    chainBuf.append(" (tail)");
                }
                chainBuf.append("\n");
                dNode = dNode.getNext();
            }
        } else {
            chainBuf.append("Chain is empty");
        }
        chainBuf.append("\n");

        return chainBuf;
    }   // end createChain.


    /**
     * printChain() method
     * - calls createChain method to obtain a StringBuffer object.
     * - displays the StringBuffer object.
     */
    public void printChain() {
        StringBuffer chain = createChain();
        System.out.println(chain);
    }   // end printChain.


    /**
     * insertNode() method
     * - This is the only abstract method.
     * - Abstract version must omit the body of the class.
     * - This method will behave differently based on who
     *      is inheriting from it.
     * @param node
     */
    abstract void insertNode(Node node);


    /**
     * deleteNode() method
     * - Cannot be abstract or non-abstract method in parent class.
     * - Stack and Queue need a version that takes no param and returns a node;
     *      List needs a version that takes a node param and returns void.
     * @param node
     */


    /**
     * insertListNode() method
     * - Cannot be abstract or non-abstract method in parent class,
     *      since neither stack nor queue can be allowed to use it.
     */
}   // end AbstractLinkedList class.
