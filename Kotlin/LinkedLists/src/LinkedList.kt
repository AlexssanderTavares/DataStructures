import kotlin.math.acos

class LinkedList<T> {

    private var init : Cell<T>? = null
    private var last : Cell<T>? = null
    private var size: Int = 0

    fun add(element: T){
        val newCell: Cell<T> = Cell<T>(element)
        if(this.init == null || this.size == 0){
            this.init = newCell
            this.last = newCell
        }else {
            this.last?.setNext(newCell)
        }

        this.last = newCell
        this.size++
    }

    fun addIn(position: Int, element: T) {
        if(position < 0 || position > this.size){
            throw IllegalArgumentException("Invalid position")
        }

        if(position == 0 || this.init == null){
            val newCell: Cell<T>? = Cell<T>(element)
            newCell?.setNext(this.init)
            this.init = newCell
            this.last = newCell
            this.size++

        } else if(position == this.size){
            this.add(element)
            this.size++

        } else {
            val beforeCell: Cell<T>? = this.searchCell(position - 1)
            val nextCell: Cell<T>? = beforeCell?.getNext()
            val newCell: Cell<T>? = Cell<T>(element, nextCell)
            beforeCell?.setNext(newCell)
            this.size++
        }


    }

    fun searchCell(position: Int) : Cell<T>? {
        if(!(position > 0) && !(position <= this.size)){
            throw IllegalArgumentException("Invalid position")
        }

        var actual: Cell<T>? = this.init
        var i: Int = 0

        while(i < position){
            if(actual == null){
                throw IndexOutOfBoundsException("This element doesn't exist in the list. Null has been returned!")
            }
            actual = actual.getNext()
            i++
        }

        return actual
    }

    fun search(position: Int) : T {
        if(!(position > 0) && !(position <= this.size)){
            throw IllegalArgumentException("Invalid position")
        }

        var actual: Cell<T>? = this.init
        var i: Int = 0

        while(i < position){
            if(actual == null){
                throw IndexOutOfBoundsException("This element doesn't exist in the list. Null has been returned!")
            }
            actual = actual.getNext()
            i++
        }

        return actual?.getElement() as T
    }

    fun indexOf(element: T) : Int {
        var actual: Cell<T>? = this.init
        var position: Int = 0

        while(actual != null){
            if(actual.getElement() == element){
                return position
            }else{
                actual = actual.getNext()
                position++
            }

            if(actual == null){
                break
            }
        }

        return position
    }

    fun getSize() : Int {
        return this.size
    }

    /*fun clear() { Alexssander
        while(this.size > 0){
            this.last?.setNext(null)
            this.last?.setElement(null)
            this.size--
        }

        if(this.size == 0){
            this.init = null
            this.last = null
        }
    }*/

    fun clear(){ // Loiane Groner
        var actual: Cell<T>? = this.init

        while (actual != null) {
            var next: Cell<T>? = actual.getNext()
            actual.setElement(null)
            actual.setNext(null)
            actual = next
        }

        this.init = null
        this.last = null
        this.size = 0
    }

    override fun toString(): String {
        if(this.size == 0){
            return "[]"
        } else {
            val builder: StringBuilder = StringBuilder("[")
            var actual: Cell<T>? = this.init

            builder.append(actual?.getElement()).append(",")

            while(actual?.getNext() != null){
                actual = actual?.getNext()
                if(actual?.getNext() != null) {
                    builder.append(actual?.getElement()).append(",")
                }else {
                    builder.append(actual?.getElement()).append("]")
                }
            }
            return builder.toString()
        }


    }


}