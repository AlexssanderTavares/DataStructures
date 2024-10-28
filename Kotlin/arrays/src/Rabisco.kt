import java.util.Arrays

class Rabisco<T>(var capacity: Int) {


    private var elements: Array<Any> = Array<Any>(this.capacity, { "" })
    var length: Int = 0
    private var pointer: Int = 0

    fun show(){
        this.elements.forEach {
            println(it)
        }
    }

    fun clear(){
        for(index in 0..this.length - 1){
            elements[index] = ""
            length--
        }
    }

    fun add(element: T){
        elements[pointer] = element as Any
        pointer++
        length++
    }

    fun pop(element: T){
        for(i in 0..this.length - 1){
            if(elements[i] == element){
                elements[i] == ""
                for(x in i..this.length - 1){
                    if(x + 1 > this.length - 1){
                        elements[x] = 0
                        break
                    }
                    elements[x] = elements[x + 1]
                }
            }
        }
        length--
    }

    fun popLast(){
        elements[pointer] = ""
        length--
        pointer--
    }

    fun get(index: Int): T{
        this.checkIndex(index)
        return elements[index] as T
    }

    fun getLast(): T{
        return this.elements[this.length - 1] as T
    }

    fun addInIndex(element: T, index: Int){
        this.checkIndex(index)
        for(i in index..this.length){
            elements[i + 1] = elements[i]
        }
        elements[index] = element as Any
    }

    override fun toString(): String {
        return Arrays.toString(this.elements)
    }

    fun checkIndex(index: Int){
        if(index > this.length || index < 0){
            throw IllegalArgumentException("Invalid Index")
        }
    }

    fun increaseCapacity(newCapacity: Int = 1) {
        this.capacity = this.capacity + newCapacity
        var newElements: Array<Any> = Array<Any>(this.capacity, { 0 })
        for(index in 0..this.length - 1){
            newElements[index] = elements[index]
        }
        this.elements = newElements
    }



}