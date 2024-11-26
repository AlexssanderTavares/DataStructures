import com.sun.org.apache.xpath.internal.operations.Bool
import java.util.Arrays

open class Queue<T>(private var capacity: Int) {

    constructor() : this(10)

    private var queue: Array<Any> = Array<Any>(this.capacity, {})
    private var length: Int = 0

    override fun toString(): String {
        return Arrays.toString(this.queue)
    }

    fun isEmpty(): Boolean {
        return length == 0
    }

    fun length(): Int {
        return this.length
    }

    private fun increaseCapacity(newCapacity: Int = 10) {
        lateinit var newQueue: Array<Any>
        if (this.length == this.capacity) {
        newQueue = Array<Any>(this.capacity + newCapacity, {})
            for (i: Int in 0..this.length - 1) {
                newQueue[i] = this.queue[i]
            }
        }
        this.queue = newQueue
    }

    fun showNext() {
        if(this.isEmpty()){
            println("Queue is empty")
        }

        println("Next value: ${this.queue[0]}")
    }


    fun add(item: T) {
        if (this.length == this.capacity) {
            this.increaseCapacity(1)
        }

        this.queue[length] = item as Any
        length++
    }

    fun getNext(): T {
        if(this.queue[0] is Unit || this.length() == 0){
            throw EmptyQueueException()
        }

        val getElement: T = this.queue[0] as T
        for (i: Int in 0..this.length - 1) {
            this.queue[i] = this.queue[i + 1]
        }
        this.length--
        return getElement
    }

    fun resetQueue(){
        this.length = 0
        this.queue = Array<Any>(this.capacity, {})
    }

    class EmptyQueueException() : Exception("Queue is empty")
}