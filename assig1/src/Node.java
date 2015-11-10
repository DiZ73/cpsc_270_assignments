/**
 * 
 * @author DKroell
 *
 * @value:Nodes are used as Components of the Linked List.
 * @param <T>
 *            Generic Data Type used for item in Node.
 * @version 2015-10-08
 */
public class Node<T> {

    /**
     * holds the current item element in the node.
     */
    T item;

    /**
     * Hold the reference to the next node after this one.
     */
    Node<T> next;

    /**
     * @param t
     *            Constructs a Node with the current element equaling t in the
     *            object.
     */
    @SuppressWarnings("unchecked")
    public Node(Object t) {
        this.item = (T) t;
    }

    /**
     * Constructs a null node.
     */
    public Node() {
        // To create a null node.
    }
}
