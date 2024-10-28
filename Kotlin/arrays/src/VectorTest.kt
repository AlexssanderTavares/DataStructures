import Vector
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.After
import org.junit.Before


@RunWith(JUnit4::class)
class VectorTest {
    companion object{
        private val vector = Vector<String>(10)
    }

    @Before
    fun setUp(){
        println("-------------------------------------------------")
        for(i: Int in 0..8){
            vector.add("test${i}")
        }
        vector.show()
        println("Vector length: ${vector.length}")
        println("Vector initial capacity: ${vector.pickSize()}")
        println("-------------------------------------------------")
    }

    @After
    fun report(){
        println(vector.toString())
        println("Last Vector length: ${vector.length}")
        println("Last Vector capacity: ${vector.pickSize()}")
        vector.clear()
        println("-------------------------------------------------")
    }

    @Test
    fun `should length increase when function add is called`() {
        println("Testing Add function")
        vector.add("testAdd")
        assertEquals(10, vector.length)
    }

    @Test
    fun `should make all values blank`(){
        println("Testing clear() method")
        vector.clear()
        for(i: Int in 0..vector.length-1){
            assertEquals(Unit, vector.get(i))
        }
        assertEquals(0, vector.length)
    }

    @Test
    fun `should function add insert one value next the another`(){
        println("Testing add() method")
        vector.add("testAdd")
        assertEquals("testAdd", vector.get(9))
    }

    @Test
    fun `should pop remove the element from array`(){
        println("Testing pop() method to remove ${vector.get(7)}")
        try{
            println("Removing it...")
            vector.remove(6)
            vector.show()
            assertEquals("test7", vector.get(6))
            assertEquals(8, vector.length)
        }catch (e: Vector.ItemNotExistInVectorException){
            println("Item not found or won't exist")
            fail()
        }

    }

    @Test
    fun `should search for an element and return true`(){
        println("Testing search() method to find test6 value")
        assertEquals(true, vector.search("test6"))
    }

    @Test
    fun `should search for an element and return false`(){
        println("Testing search() method to not find value test12")
        assertEquals(false, vector.search("test12"))
    }

    @Test
    fun `should search and get element index`(){
        println("Testing findIndex() method")
        println("Trying find test2 index")
        assertEquals(2, vector.findIndex("test2"))
    }

    @Test
    fun `should search an element and return boolean`(){
        println("Testing contains() method")
        assertEquals(true, vector.contains("test4"))
        assertEquals(false, vector.contains("test9"))
    }

    @Test
    fun `should always returns the last element`(){
        println("Testing if last() method will always show the last element")
        assertEquals("test8", vector.last())
        vector.insertInIndex(9, "testDummy")
        assertEquals("testDummy", vector.last())
        vector.insertInIndex(9,"test9")
        assertEquals("testDummy", vector.last())
        assertEquals(false, vector.contains(Unit.toString()))
    }

    @Test
    fun `should insert element in any deserved index`(){
        println("Testing insertInIndex function")
        vector.insertInIndex(3,"TestDoll")
        vector.show()
        assertEquals("TestDoll", vector.get(3))
    }

    @Test
    fun `should remove an element and rearrange the next itens to the new positions`(){
        println("Testing remove() method")
        vector.remove("test3")
        vector.show()
        assertEquals("test4", vector.get(3))
    }

    @Test
    fun `should increaseCapacity() increase elemets capacity without losing it values`(){
        println("Testing increaseCapacity() method")
        println("Increasing by 4")
        vector.increaseCapacity(newCapacity = 4)
        println("Showing it values")
        vector.show()
        assertEquals(14, vector.pickSize())
    }



}