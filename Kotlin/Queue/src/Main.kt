import exercise1.Printer
import exercise2.People
import exercise2.QueueManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
suspend fun main() {
    runBlocking {
        val printer = Printer()
        val queueManager = QueueManager()

        /*val document1: Document = Document("Medical Herbs", 5)
        val document2: Document = Document("Modern Operational Systems", 5)
        val document3: Document = Document("Computers Networks", 5)
        val document4: Document = Document("Cake Recipes", 5)

        printer.addToQueue(document1, document2, document3, document4)

            if (printer.printDocument()) {
                println("Everything goes correctly")
            }*/

        val ppl1 = People("Tonho", 55)
        val ppl2 = People("Linda-Li", 24)
        val ppl3 = People("Paulo", 78)
        val ppl4 = People("Vó Neuza", 84)
        val ppl5 = People("Raul", 6)
        val ppl6 = People("Robert", 5)

        queueManager.exec(ppl1, ppl2, ppl3, ppl4, ppl5, ppl6)
    }
}

/*
class PersonalQueue : jQueue<Int> {
    override fun add(e: Int?): Boolean {
        TODO("Not yet implemented")
    }

    override fun offer(e: Int?): Boolean {
        TODO("Not yet implemented")
    }

    override fun remove(): Int? {
        TODO("Not yet implemented")
    }

    override fun poll(): Int? {
        TODO("Not yet implemented")
    }

    override fun element(): Int? {
        TODO("Not yet implemented")
    }

    override fun peek(): Int? {
        TODO("Not yet implemented")
    }

    override fun addAll(elements: Collection<Int?>): Boolean {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun iterator(): MutableIterator<Int?> {
        TODO("Not yet implemented")
    }

    override fun remove(element: Int?): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeAll(elements: Collection<Int?>): Boolean {
        TODO("Not yet implemented")
    }

    override fun retainAll(elements: Collection<Int?>): Boolean {
        TODO("Not yet implemented")
    }

    override val size: Int
        get() = TODO("Not yet implemented")

    override fun contains(element: Int?): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<Int?>): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

}*/
