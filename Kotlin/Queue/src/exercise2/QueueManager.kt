package exercise2

import Queue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.awaitCancellation
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.PriorityQueue

class QueueManager {

    private val normalQueue: Queue<People> = Queue<People>(100)
    private val priorityQueue: PriorityQueue<People> = PriorityQueue<People>(20)

    suspend fun exec(vararg people: People){
        people.forEach {
            this.distribute(it)
        }
        println("Everyone added to the right queues")
        delay(3000)
        var priorities: Int = 0
        while(this.normalQueueSize() > 0 || this.priorityQueueSize() > 0){
            if(this.normalQueueSize() == 0 && this.priorityQueueSize() == 0){
                break
            }

            if (priorities == 3){
                this.attendNormalQueue()
                priorities = 0
            }

            if(this.priorityQueueSize() > 0){
                this.attendPriorityQueue()
                priorities++
            } else {
                this.attendNormalQueue()
            }
        }
    }

    fun priorityQueueSize(): Int {
        return priorityQueue.size
    }

    fun normalQueueSize(): Int {
        return normalQueue.length()
    }

    suspend fun distribute(people: People) {
        if (people.age >= 60) {
            println("Adding ${people.name} to the priority queue")
            priorityQueue.add(people)
        } else if (people.age < 18) {
            println("Adding ${people.name} to the priority queue")
            priorityQueue.add(people)
        } else {
            println("Adding ${people.name} to the queue")
            normalQueue.add(people)
        }
    }

    suspend fun distribute(vararg peoples: People) {
        peoples.forEach {
            if (it.age >= 60) {
                println("Adding ${it.name} to the priority queue")
                priorityQueue.add(it)
            } else if (it.age < 18) {
                println("Adding ${it.name} to the priority queue")
                priorityQueue.add(it)
            } else {
                println("Adding ${it.name} to the queue")
                normalQueue.add(it)
            }
        }
        println("Everyone added to the right queues")

    }

    suspend fun attendNormalQueue() {
        if (priorityQueue.isEmpty() || !normalQueue.isEmpty()) {
            println("Attending: ${normalQueue.getNext().name}")
            delay(5000)
        } else {
            println("Priority Queue is empty")
        }
    }

    suspend fun attendPriorityQueue() {
        if (!priorityQueue.isEmpty()) {
            if (priorityQueue.isEmpty()) {
                println("Finishing priority for a while")
            }
            println("Attending: ${priorityQueue.remove().name}")
            delay(5000)
        } else {
            println("Priority Queue is empty")
        }
    }
}