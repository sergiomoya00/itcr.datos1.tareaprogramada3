/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada2.datos1.register;

import tareaprogramada2.datos1.register.Patient;

/**
 *
 * @author samoy
 */
public interface PriorityAdapter {
    
    void push(Patient patient);
    
    Patient pop();
}
