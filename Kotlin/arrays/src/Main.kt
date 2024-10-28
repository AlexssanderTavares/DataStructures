

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    // Collection that store values aside of the last value stored
    // Arrays has fixed values and to add one new value will must iterate each element until reach the last one
    // Adding elements in array is O(n)
    // Reading elements is O(1)
    val arr1: Array<Int> = Array<Int>(10, { 0 })
    val arr2: Array<Int> = arrayOf<Int>(0,1,2,3,4,5,6,7,8,9,10)


    // Collection that store values where the value has the memory address pointing to the next
    // value stored
    // You can store values faster than arrays because lists give instant access to it values
    // Adding and removing items in lists is O(1)
    // Because of the needing of knowing each memory reference inside each element in the list, it must iterate over
    // elements to find those references and then reach the right element was ordered to read, then is O(n)
    val list1: List<Int> = List<Int>(10, { 0 })
    val list2: List<Int> = listOf<Int>(0,1,2,3,4,5,6,7,8,9,10)
    val list3: MutableList<Int> = mutableListOf<Int>()
    val list4: MutableList<Int> = MutableList<Int>(10, { 0 })

    for(num in 0..arr1.size){
        if(num == arr1.size){
            break
        }
        arr1[num] += num
    }

    arr1.forEach {
        println(it)
    }

    val vector = Vector<String>(11)
    println(vector)

    try{
        vector.add("World")
        vector.add("Hello")
        vector.show()
        //println(vector.exist("hello"))
    }catch (exception: IndexOutOfBoundsException){
        println("Vector is full")
    }



}