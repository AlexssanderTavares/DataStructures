import java.util.Arrays

class Stack<T>(private var capacity: Int) {

    private var items: Array<Any> = Array<Any>(capacity, { })
    private var top: Int = 0
    private var length: Int = 0

    override fun toString(): String {
        return Arrays.toString(this.items)
    }

    fun toArray() : Array<Any> {
        return this.items
    }

    fun invert() : Array<Any> {
        val inverted: Array<Any> = Array<Any>(this.capacity, {})
        var counter1: Int = 0
        var counter2: Int = this.length

        while(counter1 <= this.length-1) {
            inverted[counter2] = this.items[counter1]
            counter1++
            counter2--

            if(this.items[counter1] is Unit || counter2 == -1){
                break
            }
        }
        this.items = inverted
        return this.items
    }


    fun push(element: T) {
        if (this.length == this.capacity - 1) {
            this.increaseCapacity()
        }

        if (this.items[top] is Unit) {
            this.items[top] = element as Any
            this.length++
            this.top++
        }
    }


    fun increaseCapacity(newCapacity: Int = 10) {
        if (newCapacity != 0) {
            val newItems = Array<Any>(this.length + newCapacity, {})
            for (i: Int in 0..this.length - 1) {
                newItems[i] = this.items[i]
            }
            this.items = newItems
        } else {
            throw IllegalArgumentException("New Capacity must be different and above 0")
        }
    }

    /* autoral, O(n)
    fun isEmpty(): Boolean{
        var check: Boolean = true
        for(i: Int in 0..this.length - 1){
            if(this.items[i] !is Unit){
                check = false
                break
            }
        }
        return check
    }*/

    // professora Loiane, O(1)
    fun isEmpty(): Boolean {
        return this.length == 0
    }

    fun showTop() {
        println("Top: ${this.items[top - 1]}")
    }

    fun getTop(): T {
        if (this.isEmpty()) {
            throw NoElementStackedException()
        } else {
            val element: T = this.items[top - 1] as T
            this.items[top - 1] = Unit
            top--
            length--
            return element
        }
    }

    fun removeTop() {
        if (this.top > 0) {
            this.items[top - 1] = Unit
            this.top--
            this.length--
        }
    }

    fun length(): Int {
        return this.length
    }

    class NoElementStackedException : Exception("The stack is empty.")


}