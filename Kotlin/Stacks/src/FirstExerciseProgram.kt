import java.util.Scanner

class FirstExerciseProgram {

    fun exec(){
        val scan = Scanner(System.`in`)
        val stack = Stack<Int>(10)

        for(i: Int in 0..9) {
            print("Enter a number: ")
            var num: Int = scan.nextInt()

            if(num % 2 == 0){
                stack.push(num)
            }

            if(num % 2 != 0){
                try {
                    stack.removeTop()
                }catch (e: IndexOutOfBoundsException){
                    println("No items to remove")
                }finally {
                    continue
                }
            }

            if(stack.isEmpty()){
                println("Stack is empty")
            }
        }

        if(!stack.isEmpty()){
            for(i: Int in 0..stack.length() - 1){
                println(stack.getTop())
            }
        }
    }
}