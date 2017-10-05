
/**
 * MakeAbstractListApp class
 * - Contains main method.
 * - Contains methods:
 *      readDoublesFromConsole, readDoublesFromFile, writeDoublesToFile
 * - Currently used only for testing.
 * @author Jan Dwyer
 * @version 1.0     10/3/2017
 */
public class MakeAbstractListApp {
    public static void main(String args[]) {
        System.out.println("in MakeAbstractListApp");

        /*
        Node node00;
        Node node01 = new Node();
        node01.setPayload(16.9);
        Node node02 = new Node(50);
        Node node03 = new Node(1.2227);
        */

        System.out.println("Stack tests:");
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
        System.out.println("printList output:");
        st.printList();
        System.out.println("printChain output:");
        st.printChain();


        /*
        Stack newStack = new Stack();
        if (newStack.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }
        System.out.println("nodeCounter:  " + newStack.getNodeCounter());
        newStack.insertNode(node01);
        System.out.println("nodeCounter:  " + newStack.getNodeCounter());
        if (newStack.isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack is not empty");
        }
        newStack.printList();
        newStack.insertNode(node02);
        System.out.println("nodeCounter:  " + newStack.getNodeCounter());
        newStack.insertNode(node03);
        System.out.println("nodeCounter:  " + newStack.getNodeCounter());
        node00 = newStack.deleteNode();
        System.out.println("nodeCounter:  " + newStack.getNodeCounter());
        System.out.println("node04.getPayload(): " + node00.getPayload());
        newStack.printList();

        System.out.println("Queue tests:");
        Queue newQueue = new Queue();
        if (newQueue.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue is not empty");
        }
        newQueue.insertNode(node01);
        if (newQueue.isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Queue is not empty");
        }
        newQueue.insertNode(node02);
        newQueue.insertNode(node03);
        node00 = newQueue.deleteNode();
        System.out.println("node04.getPayload(): " + node00.getPayload());
        newQueue.printList();

        System.out.println("LinkedList tests:");
        // Block 1 - test output of call:
        LinkedList doubleList;
        doubleList = ListHelper.readDoublesFromConsole();
        doubleList.printList();

        // Block 2 - test output of call:
        String readFromFile = "inputDoubles.txt";
        LinkedList dblList = ListHelper.readDoublesFromFile(readFromFile);
        dblList.printList();

        // Block 3 - test output of call:
        String filename = "outputDoubles.txt";
        // ListHelper.writeDoublesToFile(doubleList, filename);
        ListHelper.writeDoublesToFile(dblList, filename);
        // TODO:  need to verify existence and contents of file created.
        // this will tell you the default file location.
                */

    }   // end main.
}   // end MakeAbstractListApp class.
