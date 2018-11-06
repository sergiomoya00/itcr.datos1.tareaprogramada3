/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testCola;

import tareaprogramada2.datos1.register.*;
import tareaprograma2.datos1.collections.PriorityQueue;
import static tareaprogramada2.datos1.register.ColorPatientCondition.*;
import static tareaprogramada2.datos1.register.IncidentPatientCondition.*;

public class testCola {
    
    public static void main(String [] args){
    
    Ticket uno = new Ticket(Rojo, I, 89);
    Ticket dos = new Ticket(Amarillo, P, 9);
    Ticket tres = new Ticket(Verde, Q, 90);
    Ticket cuatro = new Ticket(Rojo, H, 1);
    Ticket cinco = new Ticket(Verde, I, 99);
    Ticket seis = new Ticket(Amarillo, P, 38);
    
    PriorityQueue<Ticket> cola = new PriorityQueue<Ticket>();
    
    cola.insert(uno);
    cola.insert(uno);
    cola.insert(uno);
    
    cola.insert(uno);
    cola.insert(uno);
    cola.insert(uno);
    
    cola.toString();
    
    cola.remove();
    cola.remove();
    
    cola.toString();
            
}
}