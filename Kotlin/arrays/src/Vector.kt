import java.util.Arrays

class Vector<T>(var size: Int) {
    constructor() : this(size = 10)

    private var elements: Array<Any> = Array<Any>(size, {})
    var length: Int = 0

    override fun toString(): String {
        return Arrays.toString(this.elements)
    }

    fun add(element: T) { // O(n)
        if (this.length == this.elements.size) {
            this.increaseCapacity()
        } else if (this.length < this.elements.size) {
            this.increaseCapacity(1)
        }
        elements[this.length] = element ?: ""
        length++
    }

    fun get(index: Int): T {
        this.checkIndex(index)
        val gapValue = this.elements[index].toString()
        if (gapValue == "") {
            return "" as T
        } else {
            return this.elements[index] as T
        }
    }

    fun last(): T { // O(n)
        var lastElement: Any = -1
        for (i: Int in 0..this.length - 1) {
            if (this.elements[i] !is Unit) {
                lastElement = this.elements[i]
            }
        }

        return lastElement as T
    }

    fun show() { // O(n)
        this.elements.forEach {
            if (it != "") {
                println(it)
            }
        }
    }


    fun clear() { // O(n)
        this.elements = Array<Any>(this.size, {})
        this.length = 0

    }

    fun search(element: T): Boolean { // O(n)
        for (e in elements) {
            if (e == element) {
                return true
            }
        }
        return false
    }

    fun findIndex(element: T): Int { // O(n)
        var index: Int = 0
        while (index < this.length - 1) {
            if (elements[index] == element) {
                return index
            }
            index++
        }
        return -1
    }

    fun remove(position: Int) { // O(n)
        this.checkIndex(position)
        for (i: Int in position..this.length - 1) {
            elements[i] = elements[i + 1]
        }
        length--
    }

    fun remove(element: T) { // O(n)”
        if (this.search(element)) {
            this.remove(this.findIndex(element))
        } else {

        }
    }

    fun contains(element: T): Boolean { // O(n)
        var index: Int = 0
        while (index < this.length - 1) {
            if (elements[index] == element || elements[index] is Unit) {
                return true
            }
            index++
        }
        return false
    }


    fun increaseCapacity(newCapacity: Int = 10) { // O(n)
        var newElements = Array<Any>(newCapacity + this.size, {})
        for (i: Int in 0..this.length - 1) {
            newElements[i] = this.elements[i]
        }
        this.elements = newElements
    }
    ;
    fun insertInIndex(index: Int, element: String) { // O(n log n)
        this.checkIndex(index)
        if (this.length == this.elements.size) {
            this.increaseCapacity() // O(n)
        } else if (this.length < this.elements.size) {
            this.increaseCapacity(1) // O(n)
        }

        var i: Int = this.length - 1
        while (i >= index) { // O(log n)
            this.elements[i + 1] = this.elements[i]
            i--
        }
        this.elements[index] = element
        length++

    }

    private fun checkIndex(index: Int) {
        if (index > this.length || index < 0) {
            throw IllegalArgumentException("Invalid array index")
        }
    }

    fun pickSize(): Int { // O(1)
        return this.elements.size
    }

    class ItemNotExistInVectorException() : Exception("Element won't exist inside vector.")


}