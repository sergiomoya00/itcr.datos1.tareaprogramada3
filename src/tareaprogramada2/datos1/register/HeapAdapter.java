/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada2.datos1.register;

import tareaprograma2.datos1.collections.MyHeap;

/**
 *
 * @author samoy
 */
public class HeapAdapter implements PriorityAdapter {

    private MyHeap adapter = new MyHeap();

    @Override
    public void push(Patient patient) {
        adapter.insert(patient); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pop(Patient patient) {
        adapter.remove(); //To change body of generated methods, choose Tools | Templates.
    }

}
