import java.sql.Array;
import java.util.Arrays;

public class Queue<T> {

    private T[] queue;
    private int capacity;
    private int length = 0;

    public Queue(int capacity) {
        this.queue = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public Queue() {
        this(10);
    }

    public String toString() {
        return Arrays.toString(this.queue);
    }

    public int length(){
        return this.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    private void increaseCapacity(int newCapacity) {
        if (this.length == this.capacity) {
            final T[] newQueue = (T[]) new Object[this.capacity + newCapacity];
            for (int i = 0; i <= this.length - 1; i++) {
                newQueue[i] = this.queue[i];
            }
            this.queue = newQueue;
        }
    }

    public void showNext() {
        System.out.println(this.queue[0]);
    }

    public void add(T item) {
        if (this.length == this.capacity) {
            this.increaseCapacity(10);
        }

        this.queue[this.length] = item;
        this.length++;
    }

    public T getNext() throws EmptyQueueException{
        if(this.queue[0] == null || this.length == 0){
            throw new EmptyQueueException("Queue is empty");
        }

        T getElement = this.queue[0];
        for (int i = 0; i <= this.length - 1; i++) {
            this.queue[i] = this.queue[i + 1];
        }
        return getElement;
    }

    public void resetQueue(){
        this.length = 0;
        this.queue = (T[]) new Object[this.capacity];
    }


}

class EmptyQueueException extends Exception{

    public EmptyQueueException(String message){
        super(message);
    }

}

