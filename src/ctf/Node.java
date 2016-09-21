
package ctf;

/**
 *
 * @author Munz
 */
public class Node {
    
    public Node next;
    public Flag data;
    
    public Node(Flag f) {
        this.data = f;
        this.next = null;
    }
    
}
