/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada3.datos1.structuresInterface;


public interface StructuresInterface<T> {  //An interface to implement 
    
    public abstract void add(T value);     
    public abstract T remove(T object);
    public abstract T search(T object);
    public abstract int size();
    public abstract void clear();
    public abstract T set(T object, int index);
    public abstract T get(int index);

}
