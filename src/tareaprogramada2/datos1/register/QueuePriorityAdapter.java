/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada2.datos1.register;

import java.util.Iterator;
import tareaprograma2.datos1.collections.PriorityQueue;

/**
 *
 * @author samoy
 */
public class QueuePriorityAdapter implements PriorityAdapter{
    
    private PriorityQueue<Patient> adapterQ = new PriorityQueue();

    @Override
    public void push(Patient patient) {
        adapterQ.insert(patient); //To change body of generated methods, choose Tools | Templates.
    }

    public Patient pop() {
        return adapterQ.remove(); //To change body of generated methods, choose Tools | Templates.
    }

    public Iterator<Patient> iterator() {
         return adapterQ.iterator(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
