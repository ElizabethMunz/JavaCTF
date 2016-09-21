
package ctf;

import java.awt.Color;
import simplegui.SimpleGUI;

/**
 *
 * @author Elizabeth
 */
public class Main {
    static SimpleGUI sg;
    static FlagField area;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        sg = new SimpleGUI(800,500);
        sg.setBackgroundColor(Color.black);
        sg.labelButton1("New Game"); // starts new randomly generated field
        sg.labelButton2("Restart"); // returns your flags remaining to total, makes all flags reappear
        //sg.drawText("Flags remaining: " + sg.getSliderValue()/5, 5, 30, Color.white, 1, "count");
        
        
        
        area = new FlagField(sg.getSliderValue()/5);
        area.redraw(sg);
        
        System.out.println("Capture the flag game!");
        System.out.println("To play, click each \"flag\" in sequential order, starting with 1.");
        System.out.println("Adjust the slider start a new game with a different number of flags.");
        System.out.println("Click \"New Game\" to start a new game with the same number of flags but a different layout.");
        System.out.println("Click \"Restart\" to begin the game again with the same layout.");
        
        
        Listener l = new Listener();
        
    }
}
