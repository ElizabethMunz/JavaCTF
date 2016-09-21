
package ctf;

import java.util.Random;

/**
 *
 * @author Elizabeth
 */
public class Flag {
    int x,y;
    int number;
    
    //creates empty flag
    public Flag() {
    }
    
    public Flag(int n) {
        Random r = new Random();
        x = r.nextInt(700) + 50;
        y = r.nextInt(400) + 50; // MAKE THERE BE A 50 PIXEL BORDER WHERE FLAGS WONT BE SO THEY DONT GO OFF EDGE
        number = n;
    }
    
    
    
}
