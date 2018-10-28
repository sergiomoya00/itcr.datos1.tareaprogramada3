/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprograma2.datos1.collections;

/**
 *
 * @author samoy
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import tareaprogramada2.datos1.register.Patient;

public class PriorityQueue<T extends Comparable<T>> {

    private List<T> heap;

    public PriorityQueue() {
        heap = new LPriorityQueue<T>();
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public T top() {
        return heap.size() > 0 ? heap.get(0) : null;
    }

    public T remove() {
        if (heap.isEmpty()) {
            return null;
        }
        T result = heap.get(0);
        heap.remove(0);
        return result;
    }

    public void insert(T e) {
        heap.add(e);
        Collections.sort(heap);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        
        for (T value : heap){
            if (first){
                first = false;
            }
            else{
                sb.append(",");         
            }
            
            sb.append(String.valueOf(value));
        }
        
        return sb.toString();
    }
    
    
    
}
