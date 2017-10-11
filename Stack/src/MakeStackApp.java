/**
 * MakeStackApp class
 * - Dependent on AbstractList module.
 * - Uses only AbstractList module's Node, Stack and StackHelper classes.
 *
 * @author Jan Dwyer
 * @version 1.0     10/8/2017.
 */
public class MakeStackApp {
    public static void main (String args[]) {
        System.out.println("in MakeStackApp");

        Node n1 = new Node(447.3);
        Node n2 = new Node(7776.481);
        Node n3 = new Node(889.00019);
        Node n4 = new Node(15);
        Node n5 = new Node(56.2034);
        Node n6 = new Node(0.115);
        Node n7 = new Node(4.25);
        Node n8 = new Node();
        n8.setPayload(111);
        Stack st = new Stack();
        st.insertNode(n1);   // 8 (tail)
        st.insertNode(n2);   // 7
        st.insertNode(n3);   // 6
        st.insertNode(n4);   // 5
        st.insertNode(n5);   // 4
        st.insertNode(n6);   // 3
        st.insertNode(n7);   // 2
        st.insertNode(n8);   // 1 (head)
        System.out.println("nodeCounter: " + st.getNodeCounter());
        st.printChain();

        String filename = "outputStack.txt";
        StackHelper.writeDoublesToFile(st, filename);

    }   // end main.
}       // end MakeStackApp class.
