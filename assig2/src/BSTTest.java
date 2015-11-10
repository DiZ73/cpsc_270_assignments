import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author DKroell
 * @version - 11/04/2015
 */
public class BSTTest {

    /**
     * Test for insertion
     */
    @Test
    public void testInsertingFindingAndConstructors() {
        BST tree = new BST();
        String[] arr = { "Hi Calipso", "Whitewine and Beer",
            "Thank God I'm a Country Boy" };
        Album a = new Album("John Denver", "Thank God I'm a Country Boy", arr);
        tree.insert(a);

        arr = new String[] { "Killer Joe", "Down on Dolly" };
        Album b = new Album("Benny Goldstone", "6th Street Bar Jazz", arr);
        assertFalse(tree.find(b));
        tree.insert(b);

        assertTrue(tree.find(a));
        assertTrue(tree.find(b));

        Album c = new Album("Abra", "Connei", new String[] { "Singers Joy",
            "Hellalicious", "Fire Cabbon" });

        assertFalse(tree.find(c));

        tree.insert(c);

        assertTrue(tree.find(c));

    }

    /**
     * Test for a series of non existence
     */
    @Test
    public void testSeriesOfNonExistance() {
        BST tree = new BST();

        Album a = new Album("John Denver", "Thank God I'm a Country Boy",
                new String[] { "Hi Calipso", "Whitewine and Beer",
                    "Thank God I'm a Country Boy" });
        Album b = new Album("Benny Goldstone", "6th Street Bar Jazz",
                new String[] { "Killer Joe", "Down on Dolly" });
        assertFalse(tree.find(a));
        tree.insert(b);
        assertFalse(tree.find(a));
        tree.insert(a);
        tree.insert(a);
        assertTrue(tree.find(a));
        assertTrue(tree.find(b));
    }

    /**
     * Test for removal of albums
     */
    @Test
    public void testRemoveAlbum() {
        BST tree = new BST();

        Album a = new Album("John Denver", "Thank God I'm a Country Boy",
                new String[] { "Hi Calipso", "Whitewine and Beer",
                    "Thank God I'm a Country Boy" });
        Album b = new Album("Benny Goldstone", "6th Street Bar Jazz",
                new String[] { "Killer Joe", "Down on Dolly" });

        tree.insert(a);
        assertTrue(tree.find(a));
        tree.insert(b);
        tree.remove(a);
        assertFalse(tree.find(a));

    }

    /**
     * Test for the in order traversal of items.
     */
    @Test
    public void testInOrderTraversal() {
        BST tree = new BST();

        Album a = new Album("John Denver", "Thank God I'm a Country Boy",
                new String[] { "Hi Calipso", "Whitewine and Beer",
                    "Thank God I'm a Country Boy" });
        Album b = new Album("Benny Goldstone", "6th Street Bar Jazz",
                new String[] { "Killer Joe", "Down on Dolly" });

        tree.insert(a);
        tree.insert(b);

        assertEquals("|Benny Goldstone6th Street Bar Jazz|"
                + "|John DenverThank God I'm a Country" + " Boy|",
                tree.inOrder());

        Album c = new Album("Abra", "Connei", new String[] { "Singers Joy",
            "Hellalicious", "Fire Cabbon" });

        tree.insert(c);
        assertEquals("|AbraConnei||Benny Goldstone6th Street Bar"
                + " Jazz||John DenverThank G" + "od I'm a Country Boy|",
                tree.inOrder());
    }

    /**
     * Test for the in order traversal of an empty tree.
     */
    @Test
    public void testInOrderOfEmptyTree() {
        BST tree = new BST();
        assertEquals("", tree.inOrder());
    }

    /**
     * Test a combination of methods used.
     */
    @Test
    public void testHardCoreAsSRemovingAndInsertingFromTree() {
        BST tree = new BST();
        Album a = new Album("Joe", "Sierra", new String[] { "Indica" });
        Album b = new Album("Steven", "Helta", new String[] { "h3h3Pro" });
        Album c = new Album("NWA", "Straight Outta Compton",
                new String[] { "Express Yourself", "Straight Outta Compton",
                    "F_k tha Police" });
        Album d = new Album("Green Day", "September Flows",
                new String[] { "Boulevard of Broken Dreams" });
        Album e = new Album("Helvetica", "Done Away: " + "Sunlight Remix",
                new String[] { "Sunlit" });
        Album f = new Album("Ferris", "Oxide",
                new String[] { "Hell's Alight.." });
        Album g = new Album("Bueric", "Something", new String[] {});
        Album h = new Album("Aueric", "Something", new String[] {});

        // Validate for Empty Tree
        tree.remove(a);
        assertFalse(tree.find(a));

        // Validations of presence of objects in tree.
        tree.insert(a);
        tree.insert(b);
        tree.insert(c);
        tree.insert(d);
        assertTrue(tree.find(a));
        assertTrue(tree.find(b));
        assertTrue(tree.find(c));

        // Validate for Object that doesn't exist in tree
        tree.remove(e);

        // Mix and match removes and inserts
        assertTrue(tree.find(c));
        tree.insert(e);
        tree.insert(f);
        tree.insert(g);
        tree.insert(h);
        assertTrue(tree.find(c));
        assertTrue(tree.find(d));
        assertTrue(tree.find(e));

        // try removing in
        tree.remove(a);
        assertFalse(tree.find(a));
        tree.remove(b);
        assertFalse(tree.find(b));
        tree.remove(c);
        assertFalse(tree.find(c));
        tree.remove(g);
        tree.remove(d);
        assertFalse(tree.find(d));
        tree.remove(e);
        assertFalse(tree.find(e));
        assertTrue(tree.find(f));
        tree.remove(f);
        assertFalse(tree.find(f));
        tree.remove(g);
        tree.remove(h);

    }

    /**
     * Test remove functionality of the list.
     */
    @Test
    public void testRemoverFunctionalityForRightBeingNull() {
        Album e = new Album("Helvetica", "Done Away: Sunlight Remix",
                new String[] { "Sunlit" });
        Album f = new Album("Ferris", "Oxide",
                new String[] { "Hell's Alight.." });
        Album g = new Album("Bueric", "Something", new String[] {});
        Album h = new Album("Aueric", "Something", new String[] {});

        BST tree = new BST();

        tree.insert(f);
        tree.insert(h);
        tree.insert(g);
        tree.insert(e);

        tree.remove(h);
        assertFalse(tree.find(h));
    }

    /**
     * Test the retrieve functionality of the tree.
     */
    @Test
    public void testRetrieverFunctionWithEmptyTree() {
        Album e = new Album("Helvetica", "Done Away: Sunlight Remix",
                new String[] { "Sunlit" });
        Album f = new Album("Ferris", "Oxide",
                new String[] { "Hell's Alight.." });
        Album g = new Album("Bueric", "Something", new String[] {});
        Album h = new Album("Aueric", "Something", new String[] {});
        Album a = new Album("AA", "Something", new String[] { "HAHA" });

        // Because I have to
        Tnode<Object> forsomething = new Tnode<Object>();
        forsomething.right();
        // Because I have to

        BST tree = new BST();

        tree.retrieve("", "");

        tree.insert(f);
        tree.insert(h);
        tree.insert(e);
        tree.insert(g);
        tree.insert(a);

        tree.retrieve("Bueric", "Something");
        tree.retrieve("Aueric", "Something");
        tree.retrieve("Helvetica", "Done Away");
        tree.retrieve("Ferris", "Oxide");
        tree.retrieve("AA", "Something");
        tree.retrieve("Noop", "Something");
        assertTrue(tree.find(a));
    }
}
