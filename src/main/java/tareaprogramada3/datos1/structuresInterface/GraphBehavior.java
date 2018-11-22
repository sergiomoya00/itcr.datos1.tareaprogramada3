/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.structuresInterface;

/**
 *
 * @author
 * @param <T>
 */
public interface GraphBehavior<T extends Comparable<T>> {
    public void add(T element);     
    public  T remove(T element);
    public  T search(T element);
    public int size();
    public  void clear();
    public boolean isEmpty();
    
}
