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
import java.util.Iterator;
import java.util.List;
import tareaprograma2.datos1.collections.LPriorityQueue;

public class PriorityQueue<T extends Comparable<T>> {

    private List<T> priorityQueue;

    public PriorityQueue() {
        priorityQueue = new LPriorityQueue<T>();
    }

    public int size() {
        return priorityQueue.size();
    }

    public boolean isEmpty() {
        return priorityQueue.isEmpty();
    }

    public T top() {
        return priorityQueue.size() > 0 ? priorityQueue.get(0) : null;
    }

    public T remove() {
        if (priorityQueue.isEmpty()) {
            return null;
        }
        T result = priorityQueue.get(0);
        priorityQueue.remove(0);
        return result;
    }

    public void insert(T e) {
        priorityQueue.add(e);
        Collections.sort(priorityQueue);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (T value : priorityQueue){
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

    public Iterator<T> iterator() {
        return priorityQueue.iterator(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
