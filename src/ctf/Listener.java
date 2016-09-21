
package ctf;

import java.awt.Color;
import simplegui.GUIListener;
import simplegui.KeyboardListener;
import simplegui.SGMouseListener;

/**
 *
 * @author Elizabeth
 */
public class Listener implements GUIListener, KeyboardListener, SGMouseListener {
    boolean gameOver;
    
    
    public Listener() {
        gameOver = false;
        Main.sg.registerToGUI(this);
        Main.sg.registerToMouse(this);
    }

    @Override
    public void reactToMouseClick(int x, int y) {
        //if clicked on correct flag, erase that flag
        if(!gameOver) {
            if(Main.area.remaining>0 && x >= Main.area.uncapturedStart.data.x && x <= Main.area.uncapturedStart.data.x + 20  && y >= Main.area.uncapturedStart.data.y - 20 && y <= Main.area.uncapturedStart.data.y) {
                Main.area.remaining--;
                if(Main.area.remaining == 0) {
                    Main.area.uncapturedStart = null;
                    Main.area.redraw(Main.sg);
                    Main.sg.setBackgroundColor(new Color(0, 100, 18));
                    Main.sg.drawText("Game over: You Win!", 600, 30, Color.white, 1, "flag");
                    gameOver = true;
                }
                else {
                    Main.area.uncapturedStart = Main.area.uncapturedStart.next;
                    Main.area.redraw(Main.sg);
                }
            } else {
                Node current = Main.area.uncapturedStart;
                while(current.next != null) {
                    if(x >= current.next.data.x && x <= current.next.data.x + 20  && y >= current.next.data.y - 20 && y <= current.next.data.y) {
                        Main.sg.setBackgroundColor(new Color(160, 0, 0));
                        Main.sg.drawText("Clicked wrong number! Click Restart button to try again.", 300, 30, Color.white, 1, "flag");
                        gameOver = true;
                        break;
                    }
                    current = current.next;
                }
            }
        }
    }

    @Override
    public void reactToButton1() {
        System.out.println("New Game!");
        Main.area.makeNewField(Main.area.total);
        Main.area.redraw(Main.sg);
        gameOver = false;
    }

    @Override
    public void reactToButton2() {
        System.out.println("Game restarted");
        Main.area.reset();
        Main.area.redraw(Main.sg);
        gameOver = false;
    }

    @Override
    public void reactToSwitch(boolean bln) {
    }

    @Override
    public void reactToSlider(int i) {
         if(i/5 == 0) {
            Main.area.makeNewField(1);
            Main.area.redraw(Main.sg);
         }
        else if(i/5 != Main.area.total) {
            Main.area.makeNewField(i / 5);
            Main.area.redraw(Main.sg);
        }
        gameOver = false;
    }

    @Override
    public void reactToKeyboardEntry(String s) {
    }

    @Override
    public void reactToKeyboardSingleKey(String s) {
        switch (s) {
        //go up
            case "w":
                break;
        //go right
            case "a":
                break;
        //go down
            case "s":
                break;
        //go left
            case "d":
                break;
            default:
                break;
        }
    }



    
}
