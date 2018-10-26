package structures;

public class SimpleNode<T> {

    SimpleNode<T> next;
    SimpleNode<T> previous;
    T value;
    int priority;

    public SimpleNode(SimpleNode<T> next, T value, SimpleNode<T> previous, int priority) {
        this.next = next;
        this.value = value;
        this.previous = previous;
        this.priority = priority;
    }

    public SimpleNode(T value, int priority) {
        this.value = value;
        this.priority = priority;
    }
    
    public SimpleNode(SimpleNode<T> next, T value){
        this.next = next;
        this.value = value;
    }
   
    public SimpleNode() {
    }

    public SimpleNode<T> getNext() {
        return next;
    }

    public void setNext(SimpleNode<T> next) {
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public SimpleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(SimpleNode<T> previous) {
        this.previous = previous;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "SimpleNode{" + "value=" + value + ", priority=" + priority + '}';
    }
    
    
}