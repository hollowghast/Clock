package clock;

import java.time.LocalTime;
import javax.swing.JPanel;

public abstract class Clock extends JPanel implements Runnable
{
    protected int hour, minute, second;
    protected final int offset;

    public Clock(LocalTime t, int offset)
    {
        this.hour = t.getHour();
        this.minute = t.getMinute();
        this.second = t.getSecond();
        this.offset = offset;
    }
    
    public void adjust(LocalTime t){
        this.hour = t.getHour() + offset;
        this.minute = t.getMinute();
        this.second = t.getSecond();
    }

    @Override
    public void run(){
        while(true){
            adjust(LocalTime.now());
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }

    
}
