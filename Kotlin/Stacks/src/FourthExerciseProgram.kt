import java.math.BigInteger
import kotlin.math.roundToInt
import java.util.Arrays

class FourthExerciseProgram {
    private val binary = Stack<Int>(10)

    private fun exec(num: Number) : Array<Any> {
        val castedNum = num.toInt()

        binary.push(castedNum % 2)
        //breakpoint
        if(castedNum == 1 || castedNum == 0){
            return binary.invert()
        }

        return exec(num.toInt() / 2)
    }

    fun getBinaryOf(num: Double) : String {
        var bin: String = ""
        exec(num).forEach {
            if(it !is Unit){
                bin += it.toString()
            }
        }

        return bin
    }

}