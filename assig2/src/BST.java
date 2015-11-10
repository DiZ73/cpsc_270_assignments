/**
 * This is the class which controls the Binary Search Tree.
 * @author DavidKroell
 * @version - 11/04/2015
 */
public class BST {
    
    /**
     * Denoted the root Object
     */
    public Tnode<Object> root;
    
    /**
     * Creates a new Node
     */
    public BST() {
        root = null;
    }
    
    /**
     * Searches for an album.
     * @param a - Denotes an album to find.
     * @return Is the album in the Tree?
     */
    public boolean find(Album a) {
        if (this.isEmpty()) {
            return false;
        }
        return finder(a, root);
    }
    
    /**
     * 
     * @param a - Album to find
     * @param rt - root of this project
     * @return Is the album in the tree?
     */
    private boolean finder(Album a, Tnode<Object> rt) {
        if (a.compareTo(rt.getAlbum()) == 0) {
            return true;
        }
        else if (a.compareTo(rt.getAlbum()) > 0) {
            if (rt.left() == null) {
                return false;
            }
            else {
                return finder(a, rt.left());
            }
        }
        else {
            if (rt.right() == null) {
                return false;
            }
            else {
                return finder(a, rt.right());
            }
        }
    }
    
    /**
     * Global Variable for Inorder Traversal
     */
    private String s;
    
    /**
     * Conducts an in-order traversal of this tree.
     * @return The in-order traversal of albums in the list.
     */
    public String inOrder() {
        if (this.isEmpty()) {
            return "";
        }
        s = ""; // Change to make here?
        return inOrderHelper(root);
    }
    /**
     * 
     * @param rt - root to reference in each recurrence of the method call
     * @return - The string of the InOrder traversal of this tree.
     */
    private String inOrderHelper(Tnode<Object> rt) {
        if (rt == null) {
            return null;
        }
        
        inOrderHelper(rt.right());
        s += ("|" + rt.getAlbum().key() + "|");
        inOrderHelper(rt.left());
        
        return s;
    }
    
    /**
     * Inserts an album a in the list.
     * @param a - The album to insert.
     */
    public void insert(Album a) {
        if (this.isEmpty()) {
            root = new Tnode<Object>(a, null, null);
        }
        else {
            inserter(a, root);
        }
    } 
    
    /**
     * Inserts element into the tree.
     * @param a - Album to insert
     * @param rt - root reference of the tree.
     */
    private void inserter(Album a, Tnode<Object> rt) {
        
        if (a.compareTo(rt.getAlbum()) == 0) {
            return;
        }
        else if (a.compareTo(rt.getAlbum()) < 0) {
            if (rt.right() == null) {
                rt.setRight(new Tnode<Object>(a, null, null));
            }
            else {
                inserter(a, rt.right());
            }
        }
        else {
            if (rt.left() == null) {
                rt.setLeft(new Tnode<Object>(a, null, null));
            }
            else {
                inserter(a, rt.left());
            }
        }
    }
    
    /**
     * Returns whether the tree is empty of not.
     * @return is the tree empty?
     */
    public boolean isEmpty() {
        return root == null;
    }
    
    /**
     * Removes the given album from the tree after finding it.
     * @param a - The album to remove
     */
    public void remove(Album a) {
        if (this.isEmpty()) {
            return;
        }
        root = remover(a, root);
    }
    /**
     * 
     * @param a - Album to find
     * @param rt - root reference for each node's sub tree
     * @return - the Tnode containing the removed object.
     */
    private Tnode<Object> remover(Album a, Tnode<Object> rt) {
        if (rt == null) {
            return null;
        }
        
        if (a.compareTo(rt.getAlbum()) > 0) {
            rt.setLeft(remover(a, rt.left()));
        }
        else if (a.compareTo(rt.getAlbum()) < 0) {
            rt.setRight(remover(a, rt.right()));
        }
        else { // Found the Value
            if (rt.left() == null) {
                return rt.right();
            }
            else if (rt.right() == null) {
                return rt.left();
            }
            else {
                Tnode<Object> temp = getMax(rt.left());
                rt.setAlbum(temp.getAlbum());
                rt.setLeft(deleteMax(rt.left()));
            }
        }
        return rt;
    }
    /**
     * 
     * @param rootref - root reference
     * @return - the node deleted
     */
    private Tnode<Object> deleteMax(Tnode<Object> rootref) {
        if (rootref.right() == null) {
            return rootref.left();
        }
        rootref.setRight(rootref.left());
        return rootref;
    }
    
    /**
     * 
     * @param rootref - the root reference for  this tree.
     * @return - is the maximum node in the sub tree
     */
    private Tnode<Object> getMax(Tnode<Object> rootref) {
        if (rootref.right() == null) {
            return rootref;
        }
        return getMax(rootref.right());
    }
    
    
    /**
     * Searches for and returns the Album in the list.
     * @param artist - Contains the artist
     * @param title - Contains the title
     * @return The album object held in the list.
     */
    public Album retrieve(String artist, String title) {
        if (this.isEmpty()) {
            return null;
        }
        Album a = new Album(artist, title, new String[]{});
        return retriever(a, root);
    }
    /**
     * 
     * @param a - album to retrieve
     * @param rt - root reference for each sub tree in the helper
     * @return - the Album retrieved
     */
    private Album retriever(Album a, Tnode<Object> rt) {
        if (a.compareTo(rt.getAlbum()) == 0) {
            return rt.getAlbum();
        }
        else if (a.compareTo(rt.getAlbum()) > 0) {
            if (rt.left() == null) {
                return null;
            }
            else {
                return retriever(a, rt.left());
            }
        }
        else {
            if (rt.right() == null) {
                return null;
            }
            else {
                return retriever(a, rt.right());
            }
        }
    }
}
