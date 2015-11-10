
/**
 * <p>
 * List class ADT of Objects.
 * </p>
 * <p>
 * The purpose of this exercise is to give you practice with pointers and linked
 * lists. If you just google and copy/paste/modify, you might get it to work,
 * but you will not benefit from the exercise. You will likely not be able to
 * answer questions about this on the Final.
 * </p>
 * <p>
 * This list has a cursor that indicates the current element. When a Listo is
 * instantiated, it is empty (it contains no elements). It is somewhat similar
 * to the List interface of our book, but there are significant differences. You
 * will not be able to just copy and paste the book's implementation. Please
 * read the method descriptions carefully. Post questions on piazza as soon as
 * you think of them. Remember that you can ask concept questions but you may
 * not share or examine code that is not your own.
 * </p>
 * <p>
 * <em>
 * NOTE: This is DIFFERENT FROM THE BOOK.
 * </em>
 * </p>
 * <p>
 * The implementation of this interface is up to you and your creativity, as
 * long as you use linked lists. <br/>
 * <br/>
 * <em>Note however that your implementation MUST BE NAMED LListo.</em>
 * </p>
 * 
 * @author acsiochi (based upon cshaffer's List interface)
 * @version 092615 initial version
 * */
public interface Listo {

    /**
     * Determine if the list is empty.
     * 
     * @return true if the list contains no elements.
     */
    public boolean isEmpty();

    /**
     * Remove all elements from the list, so it is once again empty.
     */
    public void erase();

    /**
     * <p>
     * Add the given parameter to this list AFTER the current location.
     * </p>
     * <p>
     * <em>NOTE: This is DIFFERENT from the book.</em>
     * </p>
     * <p>
     * The newly added item becomes the current item shifting the elements after
     * the old current item towards the end of the list. This list will expand
     * dynamically as needed up to available memory.
     * </p>
     * <p>
     * Example:
     * 
     * <pre>
     * L = < 1 | 2 3 >; L.add(77); L = < 1 2 | 77 3 >
     * </pre>
     * 
     * </p>
     * <p>
     * To insert before the first item in the list, first call the goToHead()
     * method.
     * </p>
     * <p>
     * CRITICAL THINKING ITEM: is it possible to add after the last item in a
     * list? Why or why not?
     * </p>
     * *
     * 
     * @param element
     *            item to be added
     */
    public void add(Object element);

    /**
     * <p>
     * Delete the element BEFORE the current element from the list. The current
     * element is not changed. If this is not possible, then the current element
     * is deleted, and the element after the current element becomes the current
     * element. Nothing happens if the list is empty.
     * </p>
     * <p>
     * CRITICAL THINKING ITEM: is it possible to delete the last item in a list
     * with at least 2 items? Why or why not?
     * </p>
     * <p>
     * Example:
     * 
     * <pre>
     * L = < 1 | 2 3 >; L.delete(); L = < | 2 3 >
     * L = < | 2 3 >; L.delete(); L = < | 3 >
     * </pre>
     * 
     * </p>
     */
    public void delete();

    /**
     * Set the current position to the header of the list. This is used to add
     * an element before the first element. NOTE: this is NOT the same as the
     * book's moveToStart() method!
     */
    public void goToHead();

    /**
     * Move the current position one step nearer the beginning of this list. It
     * is possible to call this method if current is the first element in the
     * list. In that case, current moves to the beginning, that is "BEFORE" the
     * first element. There is no change if the cursor is already at the
     * beginning (before the first element).
     * 
     * @return true if the current position was actually moved, false else
     */
    public boolean retreat();

    /**
     * Move the current position one step nearer the end of this list. There is
     * no change if already at the last element. NOTE: this is NOT the same as
     * the book's next() method! It is not possible in this Listo interface to
     * advance the cursor past the last element (as is done in the book).
     * 
     * @return true if the current position was actually moved, false else
     */
    public boolean advance();

    /**
     * Return the number of elements in the list.
     * 
     * @return number of elements
     */
    public int numberOfElements();


    /**
     * Return the current element. Throw an IllegalArgumentException if the list
     * is empty.
     * 
     * @return object at current position
     */
    public Object element();

    /**
     * <p>
     * Produce a String representation of this list, following the book's
     * notation for lists. The empty list is "< | >".
     * </p>
     * <p>
     * This is an optional method. If you decide not to implement it, you must
     * type the following code in your implementation:
     * 
     * <pre>
     * public String asString() {
     *     return &quot; &quot;;
     * }
     * </pre>
     * 
     * </p>
     * 
     * @return String version of this list
     */
    public String asString();

}