import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author DKroell
 * @version 2015-10-08 The List class implementation uses a Node class to hold
 *          individual elements in the list.(TestCases for LListo)
 */
public class LListoTest {

    /**
     * Tests a situation with the Illegal Argument Exception.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testIAE() {
        LListo<Integer> list = new LListo<Integer>();
        list.delete();
        assertEquals(null, list.element());
    }
    
    /**
     * This problem arose because of a problem with the retreat function in
     * WebCat.
     */
    @Test
    public void testRetreatProblem() {
        LListo<Integer> list = new LListo<Integer>();
        for (int i = 0; i < 6; i++) {
            list.add(i);
            if (i % 2 == 0) {
                assertTrue(list.retreat());
            }
        }
        assertTrue(list.advance());
        assertTrue(list.advance());
    }

    /**
     * This tests the delete function.
     */
    @Test
    public void testExtensiveDeletion() {
        LListo<Integer> list = new LListo<Integer>();
        list.add(33);
        list.add(52);
        list.add(32);
        list.delete();
        assertEquals("< 33 | 32 >", list.asString());
        list.goToHead();
        list.delete();
    }

    /**
     * this tests the use of both constructors.
     */
    @Test
    public void testConstructor() {
        LListo<Integer> list = new LListo<Integer>(3);
        LListo<Integer> listo = new LListo<Integer>();
        listo = list;
        list = listo;
        assertEquals(list, listo);
    }

    /**
     * This tests the use of the isEmpty function.
     */
    @Test
    public void testIsEmpty() {
        LListo<String> list = new LListo<String>();
        boolean actual = list.isEmpty();
        assertTrue("The list that was implemented is Empty.", actual);
    }

    /**
     * This tests the isEmpty method on a non empty list.
     */
    @Test
    public void testIsNotEmpty() {
        LListo<Integer> list = new LListo<Integer>();
        list.add(22);
        boolean actual = list.isEmpty();
        assertFalse("The list has an added Node, and is not empty.", actual);
    }

    /**
     * This tests the advance function when pointer is at the end of the list.
     */
    @Test
    public void advanceAtEnd() {
        LListo<Integer> list = new LListo<Integer>();
        list.add(54);
        list.add(18);
        list.add(47);
        list.add(88);
        boolean f = list.advance();
        assertFalse(f);
    }

    /**
     * tests the erase method.
     */
    @Test
    public void testErase() {
        LListo<Integer> list = new LListo<Integer>();
        list.add(13);
        list.add(25);
        list.add(18);
        list.advance();
        list.advance();
        list.erase();
        assertTrue("The List should be empty after erasing", list.isEmpty());
    }

    /**
     * Tests a combination of Add and erase calls.
     */
    @Test
    public void testEraseThenAddWithNumberOfElements() {
        LListo<Character> list = new LListo<Character>();
        list.add('a');
        list.add('b');
        list.erase();
        list.add('c');
        list.add('d');
        list.add('a');

        int numOfNodes = list.numberOfElements();

        assertEquals("There are supposed to be three.", 3, numOfNodes);
    }

    /**
     * Tests a combination of methods.
     */
    @Test
    public void testEraseThenAddWithContentCheckWithAsString() {
        LListo<Character> list = new LListo<Character>();
        list.add('a');
        list.add('b');
        list.erase();
        list.add('c');
        list.add('d');
        list.advance();
        list.add('a');

        String result = list.asString();

        assertEquals("The two list asStrings are not equal", "< c d | a >",
                result);
    }

    /**
     * tests adding
     */
    @Test
    public void testAdding() {
        LListo<Character> list = new LListo<Character>();
        list.add('a');
        list.add('b');
        list.add('c');
        String actual = list.asString();

        assertEquals("The list strings don't match.", "< a b | c >", actual);
    }

    /**
     * tries to delete an empty list.
     */
    @Test
    public void testDeletingEmptyList() {
        LListo<Integer> list = new LListo<Integer>();
        list.delete();

        assertEquals("The list should have two elements.", "< | >",
                list.asString());
    }

    /**
     * tries to add and delete with one case
     */
    @Test
    public void testAddingThenDeleting1() {
        LListo<Integer> list = new LListo<Integer>();
        list.add(13);
        list.add(15);
        list.delete();
        assertEquals("There should be one element in the list.", "< | 15 >",
                list.asString());
    }

    /**
     * tries to add and delete with second case.
     */
    @Test
    public void testAddingThenDeleting2() {
        LListo<Integer> list = new LListo<Integer>();
        list.add(13);
        list.add(15);
        list.add(22);
        list.delete();
        list.add(47);
        list.add(88);
        list.retreat();
        list.delete();

        assertEquals("There should be two elements.", "< 13 | 47 88 >",
                list.asString());
    }

    /**
     * tries to add and delete with third case.
     */
    @Test
    public void testAddingThenDeleting3() {
        LListo<Integer> list = new LListo<Integer>();
        list.add(45);
        list.add(51);
        list.delete();
        list.delete();

        assertEquals("List should be empty at this point", "< | >",
                list.asString());

        list.add(18);
        list.add(78);
        list.add(88);
        list.retreat();
        list.retreat();
        list.delete();

        assertEquals("The list should have 78, and 88 with p at 78.",
                "< | 78 88 >", list.asString());
    }

    /**
     * tests advance and retreat.
     */
    @Test
    public void testAdvanceAndRetreat1() {
        LListo<Character> list = new LListo<Character>();
        list.add(32);
        list.add(42);
        list.add(99);
        assertEquals("< 32 42 | 99 >", list.asString());
        list.retreat();
        list.retreat();
        assertEquals("< | 32 42 99 >", list.asString());
        list.advance();
        assertEquals("< 32 | 42 99 >", list.asString());
    }

    /**
     * tests advance and retreat again
     */
    @Test
    public void testAdvanceAndRetreat2() {
        LListo<Character> list = new LListo<Character>();
        list.add(38);
        list.add(44);
        list.add(59);
        list.advance();
        assertEquals("< 38 44 | 59 >", list.asString());
        list.retreat();
        assertEquals("< 38 | 44 59 >", list.asString());
        list.delete();
        list.advance();
        assertEquals("< 44 | 59 >", list.asString());
    }

    /**
     * tests advance and retreat again.
     */
    @Test
    public void testRetreatAndAdvance1() {
        LListo<Character> list = new LListo<Character>();
        list.add(38);
        list.add(44);
        list.add(59);
        list.retreat();
        assertEquals("< 38 | 44 59 >", list.asString());
        list.retreat();
        assertEquals("< | 38 44 59 >", list.asString());
        list.delete();
        list.advance();
        assertEquals("< 44 | 59 >", list.asString());
    }

    /**
     * tests retreat and advance again.
     */
    @Test
    public void testRetreatAndAdvance2() {
        LListo<Character> list = new LListo<Character>();
        for (int i = 0; i < 9; i++) {
            list.add(i);
            if (i % 2 == 0) {
                list.retreat();
            }
        }
        assertEquals("< 1 3 5 | 7 8 6 4 2 0 >", list.asString());
    }

    /**
     * tries to find the number of elements
     */
    @Test
    public void testNumberOfElementsWithContent() {
        LListo<Character> list = new LListo<Character>();
        for (int i = 0; i < 9; i++) {
            list.add(i);
            if (i % 3 == 0) {
                list.retreat();
            }
        }
        assertEquals("< 1 2 4 5 7 | 8 6 3 0 >", list.asString());
        assertEquals(9, list.numberOfElements());
    }

    /**
     * tries to find the number of elements in an empty list.
     */
    @Test
    public void testNumberOfElementsEmptyList() {
        LListo<Character> list = new LListo<Character>();
        assertEquals(0, list.numberOfElements());
    }

    /**
     * returns an element with a go to head statement, which should return null
     */
    @Test
    public void testReturnElementWithGoToHead() {
        LListo<Character> list = new LListo<Character>();
        for (int i = 0; i < 9; i++) {
            list.add(i);
            if (i % 2 == 0) {
                list.retreat();
            }
        }
        assertEquals("< 1 3 5 | 7 8 6 4 2 0 >", list.asString());
        assertEquals(7, list.element());
        list.advance();
        assertEquals(8, list.element());
        list.retreat();
        list.retreat();
        assertEquals(5, list.element());
        list.goToHead();
        assertEquals(null, list.element());
    }

    /**
     * tests a combination of add, advance, retreat, and returning and element.
     */
    @Test
    public void testAddAdvanceRetreatReturnElement() {
        LListo<Character> list = new LListo<Character>();
        list.add('c');
        list.add('q');
        assertEquals('q', list.element());
        list.retreat();
        assertEquals('c', list.element());
    }

    /**
     * test the asString function.
     */
    @Test
    public void testAsString() {
        LListo<Integer> list = new LListo<Integer>();
        list.add(13);
        list.add(14);
        assertEquals("< 13 | 14 >", list.asString());
    }

    /**
     * test as string with a go to head, where the pointer is non existant.
     */
    @Test
    public void testAsStringWithGoToHead() {
        LListo<Integer> list = new LListo<Integer>();
        for (int i = 1; i <= 20; i++) {
            list.add(i);
            if (i % 5 == 0) {
                list.retreat();
            }
        }
        list.delete();
        assertEquals("< 1 2 3 4 6 7 8 9 11 12 13 14 16"
                + " 17 | 19 20 15 10 5 >", list.asString());
    }

    /**
     * test advance and retreat in an empty list.
     */
    @Test
    public void testAdvanceandRetreatInEmptyList() {
        LListo<Integer> list = new LListo<Integer>();
        boolean b = list.advance();
        assertFalse(b);
        b = list.retreat();
        assertFalse(b);
    }
}
