import java.lang.reflect.Array;
import java.util.Arrays;

import static java.util.Arrays.stream;

public class Vector<T> {

    public int length = 0;
    private T[] elements;


    public Vector(int capacity){
        this.elements = (T[]) new Object[capacity] ;
        //Empty string arrays in Java has null values as default
    }

    public String toString(){
        return Arrays.toString(elements);
    }


    public void add(T element) throws IndexOutOfBoundsException{
        if(this.length == this.elements.length){
            this.increaseCapacity(1);
        }
        if(this.length > this.elements.length){
            throw new IndexOutOfBoundsException();
        }
        this.elements[this.length] = element;
        this.length++;
    }

    public T get(int index) throws IllegalArgumentException{
        this.checkIndex(index);

        if(elements[index] == null){
            return null;
        }else{
            return elements[index];
        }
    }

    public T last(){
        T lastElement = (T) new Object();
        for(int i = 0; i < this.length - 1; i++){
            if(this.elements[i].getClass() != Void.class){
                lastElement = this.elements[i];
            }
        }
        return lastElement;
    }

    public void show(){
        for(int i = 0; i < this.elements.length - 1 ; i++){
            System.out.println(this.elements[i]);
        }
    }

    public void clear(){
        this.elements = (T[]) new Object[10];
        this.length = 0;
    }

    public Boolean search(T element){
        for(int i = 0; i < this.elements.length - 1; i++){
            if(this.elements[i] != null && this.elements[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    public int findIndex(T element){
        for(int i = 0; i < this.length - 1; i++){
            if(elements[i].equals(element)){
                return i;
            }
        }
        return - 1;
    }

    public void remove(int position){
        checkIndex(position);
        for(int i = position; i < elements.length-1; i++){
            elements[i] = elements[i + 1];
        }
        length--;
    }

    public void remove(T element){
        if(this.search(element)){
            this.remove(this.findIndex(element));
        }
    }

    public void increaseCapacity(int newCapacity){
        T[] newElements = (T[]) new Object[this.length + newCapacity];
        for(int i = 0; i <= this.length; i++){
            newElements[i] = this.elements[i];
        }
        this.elements = newElements;
    }

    public void insertInIndex(int index, T element) throws IllegalArgumentException{
        if(this.length == this.elements.length){
            this.increaseCapacity(1);
        }

        if(index > this.elements.length || index < 0){
            throw new IllegalArgumentException("Invalid index");
        }

        for(int i = this.length - 1; i >= index; i--){
            this.elements[i + 1] = this.elements[i];
        }

        this.elements[index] = element;
        length++;
    }

    private void checkIndex(int index){
        if(index > elements.length || index < 0){
            throw new IllegalArgumentException("Parameter value above Array size");
        }
    }

    public int size(){
        return this.elements.length;
    }
}
