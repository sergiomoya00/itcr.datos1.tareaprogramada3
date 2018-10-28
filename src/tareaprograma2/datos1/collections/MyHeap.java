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
import java.util.Arrays;

import tareaprogramada2.datos1.register.Patient;

public class MyHeap<T> {

    private Patient[] heap;
    private int capacity;
    private int size;

    public MyHeap() {
        capacity = 8;
        heap = new Patient[capacity];
        size = 0;
    }

    private void increaseCapacity() {
        capacity += 1;
        heap = Arrays.copyOf(heap, capacity);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Patient top() {
        return size > 0 ? heap[0] : null;
    }

    public Patient remove() {
        if (size == 0) {
            return null;
        }
        size--;
        Patient res = heap[0];
        Patient te = heap[size];
        int curr = 0, son = 1;
        while (son < size) {
            int ficha = heap[son].getpriority();
            int ficha2 = heap[son + 1].getpriority();
            int ficha3 = te.getphone();
            if (son + 1 < size && ficha2 < ficha) {
                son++;
            }
            if (ficha3 <= ficha) {
                break;
            }
            heap[curr] = heap[son];
            curr = son;
            son = 2 * curr + 1;
        }
        heap[curr] = te;
        return res;
    }

    public void insert(Patient e) {
        if (size == capacity) { // auto scaling
            increaseCapacity();
        }
        int curr = size;
        int parent;
        heap[size] = e;
        size++;
        while (curr > 0) {
            parent = (curr - 1) / 2;
            int ficha = e.getpriority();
            int ficha2 = heap[parent].getpriority();
            if (ficha2 <= ficha) {
                break;
            }
            heap[curr] = heap[parent];
            curr = parent;
        }
        heap[curr] = e;
    }
}
