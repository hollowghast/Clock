package clock;

import java.time.LocalTime;


public class DigitalClock extends Clock
{
    private int [] digits [];
    
    public DigitalClock(LocalTime t, int offset)
    {
        super(t, offset);
        
        init();
    }

    private void init(){
        //digits start
        digits = new int [10][];
        digits[0] = new int[] {1, 1, 1, 0, 1, 1, 1};
        digits[1] = new int[] {0, 0, 1, 0, 0, 1, 0};
        digits[2] = new int[] {1, 0, 1, 1, 1, 1, 0};
        digits[3] = new int[] {1, 0, 1, 1, 0, 1, 1};
        digits[4] = new int[] {0, 1, 1, 1, 0, 1, 0};
        digits[5] = new int[] {1, 1, 0, 1, 0, 1, 1};
        digits[6] = new int[] {1, 1, 0, 1, 1, 1, 1};
        digits[7] = new int[] {1, 0, 1, 0, 0, 1, 0};
        digits[8] = new int[] {1, 1, 1, 1, 1, 1, 1};
        digits[9] = new int[] {1, 1, 1, 1, 0, 1, 0};
        //digits end
        
    }
    
    
    
}
