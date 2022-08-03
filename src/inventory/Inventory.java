package inventory;

import clock.Clock;
import java.util.Set;
import java.util.TreeSet;

public class Inventory
{
    private Inventory instance;
    private final Set<Clock> clocks;

    private Inventory()
    {
        this.clocks = new TreeSet();
    }
    
    public Inventory getInstance(){
        if(instance == null){
            instance = new Inventory();
        }
        
        return instance;
    }
    
    public void addClock(Clock c){
        clocks.add(c);
    }
    
}
