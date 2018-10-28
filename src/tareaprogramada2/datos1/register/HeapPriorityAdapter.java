/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada2.datos1.register;

import java.util.Iterator;
import tareaprograma2.datos1.collections.MyHeap;
import tareaprogramada2.datos1.register.Patient;
/**
 *
 * @author samoy
 */
public class HeapPriorityAdapter implements PriorityAdapter {

    private MyHeap<Patient> adapterH = new MyHeap();

    @Override
    public void push(Patient patient) {
        adapterH.insert(patient);; //To change body of generated methods, choose Tools | Templates.
    }

    public Patient pop() {
        return adapterH.remove(); //To change body of generated methods, choose Tools | Templates.
    }

    public Iterator<Patient> iterator() {
        return adapterH.iterator(); //To change body of generated methods, choose Tools | Templates.
    }

}
