import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.fail
import org.junit.After
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class QueueTest {

    companion object{
        private val queue: Queue<Int> = Queue<Int>(10)
    }

    @Before
    fun setup(){
        println("---------------------SETUP----------------------------")
        for(i: Int in 0..8){
            queue.add(i)
        }
        println("Initial queue state: ${queue.toString()}")
        println("Initial queue length: ${queue.length()}")
        queue.showNext()

        println("---------------------SETUP----------------------------")
    }

    @After
    fun report(){
        println("--------------------REPORT----------------------------")
        println("Last queue state: ${queue.toString()}")
        println("Last queue length: ${queue.length()}")
        queue.showNext()

        queue.resetQueue()

        println("--------------------REPORT----------------------------")
    }

    @Test
    fun `should verify queue to assert if it is empty or not`(){
        println("Testing isEmpty() method...")
        assertNotEquals(true, queue.isEmpty())
    }

    @Test
    fun `should return the current length based on setup environment`(){
        println("Testing length() method...")
        assertNotEquals(-1 or 0, queue.length())
    }

    @Test
    fun `should insert a value inside the queue and it must be in the last position`(){
        println("Testing add() method...")
        println("Adding some value")
        queue.add(42)

        assertEquals(10, queue.length())
    }

    @Test
    fun `should assert that the capacity will be increased when queue is full`(){
        println("Testing increaseCapacity() method...")
        println("Adding some value")
        queue.add(54) //length 10
        println(queue.toString())
        println("Trying to add another value when queue is full")
        queue.add(85) //length 11
        assertEquals(11, queue.length())
    }

    @Test
    fun `should get the next item of the queue, return and remove from queue`(){
        println("Testing getNext() method...")
        try {
            assertEquals(0, queue.getNext())
        }catch (e: Queue.EmptyQueueException){
            fail()
        }
    }

    @Test
    fun `should reset all values of the queue`(){
        println("Testing resetQueue() method...")
        queue.resetQueue()
        assertNotEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, kotlin.Unit]", queue.toString())
    }

}