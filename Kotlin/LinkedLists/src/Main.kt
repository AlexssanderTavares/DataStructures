//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val list = LinkedList<Int>()

    list.add(1)
    list.add(2)
    list.add(3)
    list.add(4)
    list.add(5)

   // list.clear()

    list.add(6)
    list.add(7)
    list.add(8)
    list.add(9)
    list.add(10)

    println(list.toString())

    list.addIn(4, 55)
    println(list.toString())
}