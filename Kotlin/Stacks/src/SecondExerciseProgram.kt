import Stack.NoElementStackedException
import com.sun.swing.internal.plaf.synth.resources.synth_zh_CN
import java.util.Scanner

class SecondExerciseProgram {

    fun exec(){
        val scan: Scanner = Scanner(System.`in`)
        val pair: Stack<Int> = Stack<Int>(10)
        val odd: Stack<Int> = Stack<Int>(10)

        for(i: Int in 0..9){
            print("Enter a number: ")
            val num: Int = scan.nextInt()

            if(num % 2 == 0){
                pair.push(num)
            }

            if(num % 2 != 0){
                odd.push(num)
            }

            if(num == 0){
                try{
                    pair.removeTop()
                    odd.removeTop()
                }catch (exception: NoElementStackedException){
                    println("Stack is empty")
                }finally {
                    continue
                }
            }
        }

        if(!pair.isEmpty() && !odd.isEmpty()){
            println("Pairs")
            println(pair.toString())
            println("------------------------------------")
            println("Odds")
            println(odd.toString())
        }
    }
}