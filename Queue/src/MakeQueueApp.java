/**
 * MakeQueueApp class
 * - Queue module is dependent upon AbstractList module.
 * - This class will use only the AbstractList classes for
 *      Node, Queue and QueueHelper.
 *
 * @author  Jan Dwyer
 * @version 1.0     10/8/2017.
 */
public class MakeQueueApp {
    public static void main (String args[]) {
        System.out.println("in MakeQueueApp");

        Node n1 = new Node(222);
        Node n2 = new Node(3.1415);
        Node n3 = new Node(4400.01);
        Node n4 = new Node(151.55);
        Node n5 = new Node(0.1677);
        Node n6 = new Node();
        n6.setPayload(7.8);
        Queue q = new Queue();

        q.insertNode(n1);   // 1 (head)
        q.insertNode(n2);   // 2
        q.insertNode(n3);   // 3
        q.insertNode(n4);   // 4
        q.insertNode(n5);   // 5
        q.insertNode(n6);   // 6 (tail)
        System.out.println("nodeCounter: " + q.getNodeCounter());
        q.printChain();

        String filename = "outputQueue.txt";
        QueueHelper.writeDoublesToFile(q, filename);

    }   // end main.
}       // end MakeQueueApp class.
