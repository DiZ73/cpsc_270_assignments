/**
 * @author DKroell
 * @param <T>
 *            T is a generic data type.
 * 
 *            The List class implementation uses a Node class to hold individual
 *            elements in the list.
 * 
 * @version 2015-10-08
 */
public class LListo<T> implements Listo {

    // The head of the list
    private Node<T> head;
    // The pointer that points to the current element
    private Node<T> pointer;

    /**
     * Constructor that initializes the
     */
    public LListo() {
        this.head = new Node<T>();
        this.pointer = head;
    }

    /**
     * @param size
     *            this is the option we ignore.
     */
    public LListo(int size) {
        this.head = new Node<T>();
        this.pointer = head;
    }

    /**
     * @return Is the list empty?
     */
    public boolean isEmpty() {
        return (head.next == null);
    }

    /**
     * erase everything in the list.
     */
    public void erase() {
        pointer = head;
        head = new Node<T>();
    }

    /**
     * @param element
     *            to add to the node after the pointer
     */
    public void add(Object element) {
        Node<T> toAdd = new Node<T>(element);
        if (this.isEmpty()) {
            head.next = toAdd;
            pointer = head.next;
        }
        else {
            toAdd.next = this.pointer.next;
            this.pointer.next = toAdd;
            this.pointer = toAdd;
        }
    }

    /**
     * delete the element before the pointer node or the head node.
     */
    public void delete() {
        if (!this.isEmpty()) {
            if ((pointer.equals(head.next))) {
                head.next = head.next.next;
                pointer = head.next;
            }
            else if (pointer.equals(head)) {
                return;
            }
            else {
                Node<T> curr = head;
                while (curr.next.next != pointer) {
                    curr = curr.next;
                }
                curr.next = pointer;
            }
        }
    }

    /**
     * move the pointer to the head node.
     */
    public void goToHead() {
        pointer = head;
    }

    /**
     * @return did the pointer retreat properly?
     */
    public boolean retreat() {
        if (pointer == head) {
            return false;
        }

        Node<T> curr = head;
        while (curr.next != pointer) {
            curr = curr.next;
        }
        pointer = curr;
        return true;
    }

    /**
     * @return Did the pointer advance properly?
     */
    public boolean advance() {
        if (this.isEmpty()) {
            return false;
        }
        if (pointer.next == null) {
            return false;
        }
        else {
            pointer = pointer.next;
        }
        return true;
    }

    /**
     * @return the number of elements.
     */
    public int numberOfElements() {
        int i = 0;
        Node<T> curr = head.next;
        while (curr != null) {
            curr = curr.next;
            i++;
        }
        return i;
    }

    /**
     * @return the element at the pointer node.
     */
    public Object element() {
        if (head.next == null) {
            throw new IllegalArgumentException();
        }
        return pointer.item;
    }

    /**
     * @return the list in the format: < | (Pointer) num1 num2 num3 ... >
     */
    public String asString() {
        String result = "< ";
        Node<T> curr = head.next;
        while (curr != null) {
            if (this.pointer.equals(curr)) {
                result += "| ";
            }
            result += curr.item + " ";
            curr = curr.next;
        }
        result += ">";
        if (this.isEmpty()) {
            return "< | >";
        }
        return result;
    }
}