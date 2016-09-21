
package ctf;

import java.awt.Color;
import simplegui.SimpleGUI;

/**
 *
 * @author Elizabeth
 */
public class FlagField {
    int total;
    int remaining;
    Node start;
    Node uncapturedStart;
    
    public FlagField(int n) {
        total = n;
        remaining = total;
        int i = 0;
        do {
            this.addFlag(new Flag(i+1));
            i++;
        } while(i < n);
    }
    
    
    public void makeNewField(int n) {
        total = n;
        remaining = total;
        int i = 1;
        start = new Node(new Flag(i));
        uncapturedStart = start;
         while(i < n) {
            i++;
            this.addFlag(new Flag(i));
        }
    }
    
    public void addFlag(Flag f) {
         if (start == null) {
             start = new Node(f);
             uncapturedStart = start;
         }
         else {
            Node n = new Node(f);
            Node current = start;
            Node currentUncaptured = uncapturedStart;
            while (current.next != null) {
                current = current.next;
                currentUncaptured = currentUncaptured.next;
            }
            current.next = n;
            currentUncaptured.next = n;
         }
        
    }
    
    
    public void reset() {
        uncapturedStart = start;
        remaining = total;
    }
    
    public void redraw(SimpleGUI sg) {
        //draw all flags in uncaptured ll
        Node current = uncapturedStart;
        sg.setBackgroundColor(Color.black);
        sg.eraseAllDrawables("flag");
        sg.setFont("", "", 20);
        while(current != null) {
            sg.drawText(""+current.data.number, current.data.x, current.data.y, Color.white, 1, "flag");
            current = current.next;
        }
        sg.eraseAllDrawables("count");
        sg.drawText("Flags remaining: " + remaining, 5, 30, Color.white, 1, "count");
    }
    
    
    
}
