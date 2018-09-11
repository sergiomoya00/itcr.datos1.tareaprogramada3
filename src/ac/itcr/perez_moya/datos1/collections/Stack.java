/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.itcr.perez_moya.datos1.collections;

import java.util.Iterator;


public class Stack<T> extends SimpleLinkeList<T> {

   
    public void push(T e) {
        add(0, e);
    }

    public T pop() {
        return remove(0);
    }
    
    public T peek() {
        return isEmpty()?null: head.getValue();
    }
    
}
