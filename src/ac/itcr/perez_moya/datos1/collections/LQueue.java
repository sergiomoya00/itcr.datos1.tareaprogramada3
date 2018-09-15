/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.itcr.perez_moya.datos1.collections;
 
public class LQueue<T> {

    private NodeSimpleLinkedList<T> front;
    private NodeSimpleLinkedList<T> rear;
    private int size;
    
 
    
    public LQueue(){
        this.front = new NodeSimpleLinkedList<>();
        this.rear = this.front;
        this.size = 0;
    }

    public void enqueue(T value){
        this.rear.setNext(new NodeSimpleLinkedList<>(null, value));
        this.rear = rear.getNext();
        this.size++;
    }

    public T dequeue(){
        if(this.size == 0){
            System.out.println("Queue is empty");
            return null;
        }
        T temp = this.front.getNext().getValue();
        NodeSimpleLinkedList<T> nTemp = this.front.getNext();
        this.front.setNext(nTemp.getNext());
        if (this.rear == nTemp){
            this.rear = this.front;
        }
        this.size--;
        return temp;
    }

    public Object first(){
        if(this.size == 0){
            System.out.println("Queue is empty");
            return null;
        }
        return this.front.getNext().getValue();
    }

    public int size(){
        return this.size;
    }

    public void clear(){
        this.front = new NodeSimpleLinkedList<>();
        this.rear = this.front;
        this.size = 0;
    }

    public String toString(){
        String result = "**LQueue**\n";
        NodeSimpleLinkedList<T> tFront = this.front;
        int tSize = this.size;
        while(tSize != 0){
            result+= tFront.getNext().getValue() + " ";
            tFront = tFront.getNext();
            tSize--;
        }
        return result;
    }

    public void rotate(){
        if (this.size == 0) {
            System.out.println("Queue is empty");
        } else {
            NodeSimpleLinkedList<T> current = this.front.getNext();
            NodeSimpleLinkedList<T> temp = null;
            NodeSimpleLinkedList<T> newRear = null;
            while (current != null) {
                if (current == this.front.getNext()){
                    temp = new NodeSimpleLinkedList<T>(null, current.getValue());
                    newRear = temp;
                } else if (current == this.rear) {
                    temp = new NodeSimpleLinkedList<T>(temp, current.getValue());
                    this.front.setNext(temp);
                } else {
                    temp = new NodeSimpleLinkedList<T>(temp,current.getValue());
                }
                current = current.getNext();
            }
            this.rear = newRear;
        }
    }

    public void rotate2(){
        if (this.size == 0) {
            System.out.println("Queue is empty");
        } else {
            NodeSimpleLinkedList<T> next = this.front.getNext();
            NodeSimpleLinkedList<T> afterNext = next.getNext();
            NodeSimpleLinkedList<T> temp = null;

            while (afterNext != null) {
                if (next == this.front.getNext()){
                    next.setNext(null);
                    this.front.setNext(this.rear);
                    this.rear = next;
                }
                temp =  afterNext.getNext();
                afterNext.setNext(next);
                next = afterNext;
                afterNext = temp;
            }

        }
    }
}
