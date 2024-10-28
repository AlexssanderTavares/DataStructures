import Stack.NoElementStackedException
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Assert.*

@RunWith(JUnit4::class)
class StackTest {

    companion object{
        val stack = Stack<String>(10)
    }

    @Before
    fun setup(){
        println("-----------------------SETUP---------------------------------------")
        for(i: Int in 0..8){
            stack.push("test${i}")
        }
        println(stack.toString())
        println("Initial length: ${stack.length()}")
        stack.showTop()
        println("---------------------END SETUP-------------------------------------")
    }

    @After
    fun report(){
        println("-----------------------REPORT--------------------------------------")
        println(stack.toString())
        println("Final length: ${stack.length()}")
        stack.showTop()

        for(i: Int in 0..stack.length()){
            stack.removeTop()
        }
        println("---------------------END REPORT------------------------------------")
    }

    @Test
    fun `should invert the order of the stack`(){
        println("Testing invert() method")
        val sub1 = stack.toString()
        println(stack.toString())
        stack.invert()
        println(stack.toString())
        val sub2 = stack.toString()
        assertNotEquals(sub1, sub2)
    }

    @Test
    fun `should get the item on the top of the stack`(){
        println("Testing getTop() method")
        try{
            assertEquals("test8", stack.getTop())
        }catch(e: NoElementStackedException){
            fail()
        }
    }

    @Test
    fun `should add an item on the top of the stack`(){
        println("Testing push() method")
        stack.push("TestDummy")
        val res = stack.getTop()
        assertEquals("TestDummy", res)
    }

    @Test
    fun `should return false if stack has values`(){
        println("Testing isEmpty() method")

        assertEquals(false, stack.isEmpty())
    }


}