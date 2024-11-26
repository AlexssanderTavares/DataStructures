public class Cell <T>{

    private T element;
    private Cell<T> next;

    @Override
    public String toString(){
        return "Element: " + this.element + " | " + "Next: " + this.next;
    }
    public Cell(T element){
        this.element = element;
        this.next = null;
    }

    public Cell(T element, Cell<T> next) {
        this.element = element;
        this.next = next;
    }

    public void setElement(T element){
        this.element = element;
    }

    public T getElement(){
        return this.element;
    }

    public void setNext(Cell<T> next){
        this.next = next;
    }

    public Cell<T> getNext() {
        return this.next;
    }
}
