/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.itcr.perez_moya.datos1.collections;


public class NodeSimpleLinkedList<T> {
    NodeSimpleLinkedList <T> next;
    T value;

    public NodeSimpleLinkedList(NodeSimpleLinkedList<T> next, T value) {
        this.next = next;
        this.value = value;
    }

    public NodeSimpleLinkedList() {
    }

    public NodeSimpleLinkedList<T> getNext() {
        return next;
    }

    public void setNext(NodeSimpleLinkedList<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    
    
    
}
