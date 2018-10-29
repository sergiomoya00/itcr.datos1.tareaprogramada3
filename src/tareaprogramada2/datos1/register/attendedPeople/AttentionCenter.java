package tareaprogramada2.datos1.register.attendedPeople;

import java.util.logging.Level;
import java.util.logging.Logger;
import tareaprogramada2.datos1.register.DurationProvider;
import tareaprogramada2.datos1.register.Patient;
import tareaprogramada2.datos1.register.PriorityAdapter;

public class AttentionCenter implements Runnable {

    private final PriorityAdapter inputs;
    private final PriorityAdapter outputs;
    private final DurationProvider duration ;

    public AttentionCenter(PriorityAdapter inputs, PriorityAdapter outputs, DurationProvider duration) {
        this.inputs = inputs;
        this.outputs = outputs;
        this.duration = duration;
    }
    
    
    
    @Override
    public void run() {
        try {
        while (true){
            Patient patient = inputs.pop();
            if (patient == null){

                    Thread.sleep(100000L);
                
          
            }
            else{
                long duration = this.duration.getDuration();
                Thread.sleep(1000 * duration);
                this.outputs.push(patient);
                
            }
            
        }
        } catch (InterruptedException ex) {
                    Logger.getLogger(AttentionCenter.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
    
}