public class LinkedList<T> {


    private Cell<T> init;
    private int size = 0;
    private Cell<T> last;

    public LinkedList(){
    }

    public void add(T element){
        Cell<T> cell = new Cell<>(element);

        if(this.init == null && this.last == null || this.size == 0) {
            this.init = cell;

        }else {
            this.last.setNext(cell);

        }

        this.last = cell;
        this.size++;
    }

    public void addIn(int position, T element) {
        if( position < 0 || position > this.size){
            throw new IllegalArgumentException("Invalid position");
        }

        if(position == 0 || this.init == null){
            Cell<T> newCell = new Cell<>(element);
            newCell.setNext(this.init);
            this.init = newCell;
            this.last = newCell;
            this.size++;

        } else if(position == this.size) {
            this.add(element);
            this.size++;

        } else {
            Cell<T> beforeCell = this.searchCell(position - 1);
            Cell<T> nextCell = beforeCell.getNext();
            Cell<T> newCell = new Cell<>(element, nextCell);
            beforeCell.setNext(newCell);
            this.size++;

        }
    }

    public T popFirst(){
        if(this.init == null || this.size == 0){
            throw new RuntimeException("The first element must be initialized OR list is empty");
        }
        T element = this.init.getElement();
        this.init = init.getNext();
        this.size--;

        if(this.size == 0){
            this.last = null;
        }
        System.out.println("Removed: " + element);
        return element;
    }

    public T popLast() {
        if(this.init == null || this.size == 0){
            throw new RuntimeException("The first element must be initialized OR list is empty");
        }

        T element = this.last.getElement();
        this.last = null;
        this.size--;

        System.out.println("Removed: " + element);
        return element;
    }

    public T popFrom(int position) {
        Cell<T> actual = this.init;
        int i = 0;

        if(position < 0 || this.init == null) {
            throw new IllegalArgumentException("Invalid position");
        }

        while (i < position){
            actual = actual.getNext();
            i++;
        }

        Cell<T> beforeCell = this.searchCell(i - 1);
        beforeCell.setNext(this.searchCell(i + 1));

        T element = actual.getElement();
        actual = null;
        this.size--;
        System.out.println("Removed: " + element);
        return element;
    }



    public int getSize(){
        return this.size;
    }

    /*public void clear(){ Alexssander
        while (this.size > 0){
            this.last.setElement(null);
            this.last.setNext(null);
            this.size--;
        }

        if(this.size == 0){
            this.init = null;
            this.last = null;
        }
    }*/

    public void clear(){ // Loiane Groner
        for(Cell<T> actual = init; actual != null;){
            Cell<T> next = actual.getNext();
            actual.setNext(null);
            actual.setElement(null);
            actual = next;
        }

        this.init = null;
        this.last = null;
        this.size = 0;
    }

    public Cell<T> searchCell(int position) {
        if(!(position > 0) && !(position <= this.size)){
            throw new IllegalArgumentException("Invalid position");
        }

        Cell<T> actual = this.init;

        for(int i = 0; i < position; i++){
            if(i == position){
                break;
            }else{
                if(actual == null){
                    throw new IndexOutOfBoundsException("This element doesn't exist in the list, Null returned");
                }
                actual = actual.getNext();
            }
        }

        return actual;
    }

    public T search(int position) {
        if(!(position > 0) && !(position <= this.size)){
            throw new IllegalArgumentException("Invalid position");
        }

        Cell<T> actual = this.init;

        for(int i = 0; i < position; i++){
            if(i == position){
                break;
            }else{
                if(actual == null){
                    throw new IndexOutOfBoundsException("This element doesn't exist in the list, Null returned");
                }
                actual = actual.getNext();
            }
        }

        return actual.getElement();
    }

    public int indexOf(T element) {
        Cell<T> actual = this.init;
        int position = 0;

        while (actual != null) {
            if(actual.getElement() == element){
                return position;
            }else{
                actual = actual.getNext();
                position++;
            }

            if(actual == null){
                break;
            }
        }

        return position;
    }

    @Override
    public String toString(){
        if(this.size == 0){
            return "[]";
        } else{
            StringBuilder builder = new StringBuilder("[");
            Cell<T> actual = this.init;

            builder.append(actual.getElement()).append(",");

            while(actual.getNext() != null){
                actual = actual.getNext();
                if(actual.getNext() != null){
                    builder.append(actual.getElement()).append(",");
                }else {
                    builder.append(actual.getElement()).append("]");
                }
            }
            return builder.toString();
        }
    }
}
