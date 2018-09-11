/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.itcr.perez_moya.datos1.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class SimpleLinkeList<T> implements List<T> {
    
    NodeSimpleLinkedList <T> head;
    private int size; 
    
    
    
    @Override
    public int size() {
       return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(T e) {
        this.add(0, e);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T e: c){
            add(e);
        
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
  
    }

    @Override
    public T get(int index) {
        NodeSimpleLinkedList <T> Current = head;
        while (index-- > 0){
            Current = Current.getNext();

        }
        return Current.getValue();
    }

    @Override
    public T set(int index, T element) {
        NodeSimpleLinkedList <T> Current = head;
        while (index-- > 0){
            Current = Current.getNext();

        }
        T previous = Current.getValue();
        Current.setValue(element);
        return previous;
    }

    @Override
    public void add(int index, T element) {
        NodeSimpleLinkedList <T> Current = this.head;
        NodeSimpleLinkedList <T>  newNode = new NodeSimpleLinkedList<T>(null, element);
        
        if (isEmpty()){
            this.head = newNode;
            
        }
        
        else{
            if (size == 0){
                this.head = newNode;
                newNode.setNext(Current);
            } 
            else{
                
                NodeSimpleLinkedList<T> previous = Current;
                Current = previous.getNext();
                
                while (--index >0){
                    previous = Current;  
                    Current = previous.getNext();
                    
                }
                
                previous.setNext(newNode);
                newNode.setNext(Current);
                
            }
        }
        size ++;
        
    }

    @Override
    public T remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
