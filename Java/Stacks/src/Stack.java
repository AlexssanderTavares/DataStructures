import java.lang.reflect.Array;
import java.util.Arrays;

public class Stack<T> {

    private T[] items;
    private int top = 0;
    private int length = 0;
    private int capacity;

    public Stack(int capacity) {
        this.items = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

    public String toString() {
        return Arrays.toString(this.items);
    }

    public T[] toArray() {
        return this.items;
    }

    public T[] invert(){
        T[] inverted = (T[]) new Object[this.capacity];
        int counter1 = 0;
        int counter2 = this.length;

        while(counter1 <= this.length - 1){
            inverted[counter2] = this.items[counter1];
            counter1++;
            counter2--;

            if(this.items[counter1] == null || counter2 == - 1){
                break;
            }
        }
        this.items = inverted;
        return this.items;
    }

    public void push(T element) {
        if (this.length == this.capacity - 1) {
            this.increaseCapacity(10);
        }

        if (this.items[this.top] == null) {
            this.items[this.top] = element;
            this.top++;
            this.length++;
        }
    }

    public void increaseCapacity(int newCapacity) throws IllegalArgumentException {
        if (newCapacity != 0) {
            T[] newItems = (T[]) new Object[this.length + newCapacity];
            for (int i = 0; i <= this.length; i++) {
                newItems[i] = this.items[i];
            }
            this.items = newItems;
        } else {
            throw new IllegalArgumentException("New capacity must be different and above 0");
        }
    }

    /*public boolean isEmpty() {
        boolean check = true;
        for (int i = 0; i <= this.length - 1; i++) {
            if (this.items[i] != null) {
                check = false;
            }
        }
        return check;
    }
*/
    public boolean isEmpty() {
        return this.length == 0;
    }

    public void showTop() {
        System.out.println("Top: " + this.items[top - 1]);
    }

    public T getTop() throws NoElementStackedException{
        if(this.isEmpty()){
            throw new NoElementStackedException("Stack is empty");
        }else {
            T element = this.items[top - 1];
            this.items[top - 1] = null;
            top --;
            length--;
            return element;
        }
    }

    public void removeTop() throws NoElementStackedException {
        if(this.isEmpty()){
            throw new NoElementStackedException("No items to be removed");
        }

        if (this.top >= 0) {
            this.items[this.top - 1] = null;
            this.top--;
            this.length--;
        }
    }

    public int length() {
        return this.length;
    }


}

class NoElementStackedException extends Exception{

    public NoElementStackedException(String message){
        super(message);
    }
}


