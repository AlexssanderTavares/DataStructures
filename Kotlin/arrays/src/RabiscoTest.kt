import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test

class RabiscoTest {

    companion object{
        var rabisco = Rabisco<Int>(10)
    }

    @Before
    fun setup(){
        println("----------------------SETUP-----------------------------")
        for(num in 0..rabisco.capacity - 1){
            rabisco.add(num)
        }
        rabisco.show()
        println("Initial length: ${rabisco.length}")
        println("--------------------END SETUP---------------------------")
    }

    @After
    fun report(){
        println("---------------------REPORT-----------------------------")
        rabisco.show()
        println("Last length: ${rabisco.length}")
        rabisco.clear()
        println("-------------------END REPORT---------------------------")
    }

    @Test
    fun `should clear all elements`(){
        println("Testing clear() method")
        rabisco.clear()
        for(index in 0..rabisco.length - 1){
            assertEquals("" , rabisco.get(index))
        }
        assertEquals(0, rabisco.length)
    }

    @Test
    fun `should increase capacity without losing any element`(){
        println("Testing increaseCapacity() method")
        rabisco.increaseCapacity(5)
        assertEquals(15, rabisco.capacity)
    }

    @Test
    fun `should pop desired element from array and move elements to it place`(){
        println("Testing pop() method")
        rabisco.pop(5)
        assertEquals(6, rabisco.get(5))
        assertEquals(9, rabisco.getLast())
    }

    @Test
    fun `should get the last element`(){
        println("Testing getLast() method")
        assertEquals(9, rabisco.getLast())
    }

    @Test
    fun `should get an value by index`(){
        println("Testing get() method")
        assertEquals(7, rabisco.get(7))
    }

}