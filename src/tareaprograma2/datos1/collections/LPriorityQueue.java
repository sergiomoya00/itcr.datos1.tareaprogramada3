/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprograma2.datos1.collections;

import tareaprogramada2.datos1.register.Patient;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @param <T>
 */
public class LPriorityQueue<T extends Comparable<T>> extends SimpleLinkeList<T> implements List<T> {

    private SimpleNode<T> back;
    private int size;
    private SimpleNode<T> front;
    private int incomeCounter;
    private int outcomeCounter;

    public LPriorityQueue() {
        this.front = new SimpleNode<>();
        this.back = this.front;
        this.size = 0;
        this.incomeCounter = 0;
        this.outcomeCounter = 0;
    }

    LPriorityQueue(){
         //To change body of generated methods, choose Tools | Templates.
    }

    public int peopleWaiting(int incomeCounter, int outcomeCounter) {
        int result = incomeCounter - outcomeCounter;
        return result;
    }

    public T dequeque() {
        if (size == 0) {
            return null;
        } else {

            SimpleNode tempNode = this.front;
            T tempValue = (T) this.front.getValue();

            this.front = front.getNext();

            tempNode = null;

            if (this.back == tempNode) {
                this.back = this.front;
            }
            size--;
            outcomeCounter++;
            return tempValue;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    //Para  evaluar la condición médica de los pacientes
    @Override
    public boolean contains(Object o) {
        if (size == 0) {
            return false;
        }
        SimpleNode temp = this.front;

        while (!temp.getNext().equals(this.back)) {

            if (temp.getNext().getValue().equals(o)) {
                return true;
            }
            temp = temp.getNext();
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            SimpleNode<T> current = front;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T result = current.getValue();
                current = current.getNext();
                return result;
            }
        };
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
        //Se crea un nuevo nodo con el elemento a insertar
        SimpleNode<T> newNode = new SimpleNode(e);
        if (this.size == 0) {
            this.front = newNode;
            this.back = front;
        }
        int position = 0;
        int curr = size();
        back.setNext(new SimpleNode(null));
        back = back.getNext();
        SimpleNode<T> tempNode = back;  //Nodo tempNode para recorrer la cola

        while (curr > 0) {
            T ficha = e;
            T ficha2 = tempNode.getPrevious().getValue();
            if (ficha2.compareTo(ficha) <= 0) {
                break;
            }
            tempNode = tempNode.getPrevious();
            curr--;
            position++;
        }

        this.add(size() - position, e);
        this.size++;
        incomeCounter++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        SimpleNode current = this.front;

        if (this.front == null) {
            return false;
        }

        if (this.front.getValue().equals(o)) {
            size--;
            front = current.getNext();
            return true;
        }

        while (current.getNext() != null && !current.getNext().value.equals(o)) {
            current = current.getNext();
        }

        if (current.getNext() == null) {
            return false;
        }

        current.setNext(current.getNext().getNext());

        size--;

        return true;

    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        this.size = 0;
        front = null;

    }

    @Override
    public T get(int index) {

        SimpleNode current = this.front;
        if (size == 0) {
            return null;
        }
        int counter = index;

        while (counter - 1 > 0) {
            if (current.getNext().getValue() == null) {
                return null;
            }
            counter--;
            current = current.getNext();
        }

        return (T) current.getValue();
    }

    @Override
    public T set(int index, T element) {
        SimpleNode<T> current = front;
        while (index-- > 0) {
            current = current.getNext();

        }
        T previous = current.getValue();
        current.setValue(element);
        return previous;

    }

    @Override
    public void add(int index, T element) {
        SimpleNode<T> current = this.front;
        SimpleNode<T> newNode = new SimpleNode<T>(null, element);

        if (isEmpty()) {
            this.front = newNode;

        } else {
            if (size == 0) {
                this.front = newNode;
                newNode.setNext(current);
            } else {

                SimpleNode<T> previous = current;
                current = previous.getNext();

                while (--index > 0) {
                    previous = current;
                    current = previous.getNext();

                }

                previous.setNext(newNode);
                newNode.setNext(current);

            }
        }
        size++;
    }

    @Override
    public T remove(int index) {

        SimpleNode current = this.front;
        if (size == 0) {
            return null;
        }
        int counter = index;

        while (counter > 0) {
            if (current.getNext().getValue() == null) {
                return null;
            }
            counter--;
            current = current.getNext();
        }

        current.setNext(current.getNext().getNext());
        size--;

        T result = (T) current.getNext().getValue();
        return result;

    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        SimpleNode current = this.front;

        while (current.getValue() != null) {
            if (current.getValue().equals(o)) {
                return index;
            }
            current = current.getNext();
            index++;
        }

        return index;
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

    public String toString() {
        while (size > 0) {
            System.out.println(front.getValue());
            size--;
            front.getNext();
        }
        return "LPriorityQueue{" + "back=" + back + ", size=" + size + ", front=" + front + '}';
    }
}
