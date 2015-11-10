/**
 * Node to be used as the datatype for holding albums.
 * @author DavidKroell
 * @param <T>
 * @version - 11/06/2015
 */
public class Tnode<T> {
    private Album album;
    private Tnode<T> right;
    private Tnode<T> left;
    
    /**
     * Basic constructor for Tnode
     */
    public Tnode() {
        this.album = null;
        this.right = null;
        this.left = null;
    }
    
    /**
     * More complex constructor for Tnode
     * @param a - album to add to the node being constructed
     * @param r - right node link reference to add.
     * @param l - left node link reference to all
     */
    public Tnode(Album a, Tnode<T> r, Tnode<T> l) {
        this.album = a;
        this.right = r;
        this.left = l;
    }
    
    /**
     * Accesor for the album.
     * @return this Node's album Object
     */
    public Album getAlbum() {
        return this.album;
    }
    
    /**
     * Modifier for the Album in Node.
     * @param a - Album to set this album to
     */
    public void setAlbum(Album a) {
        this.album = a;
    }
    
    /**
     * Function for accessing the right link node.
     * @return the right link node
     */
    public Tnode<T> right() {
        return this.right;
    }
    
    /**
     * Modifier for the function.
     * @param r - the right node to modify to
     */
    public void setRight(Tnode<T> r) {
        this.right = r; 
    }
    
    /**
     * Method to access the left node link
     * @return - left node link to this node.
     */
    public Tnode<T> left() {
        return this.left;
    }
    
    /**
     * Setter for the left node link
     * @param l - node to set to the left node link for this node.
     */
    public void setLeft(Tnode<T> l) {
        this.left = l;
    }
}
