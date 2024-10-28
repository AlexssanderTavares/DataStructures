class ThirdExerciseProgram {

    fun exec(word: String): Boolean {
        val midRange: Int = word.length / 2
        var high: Int = word.length - 1
        var counter: Int = 0

        while (counter < midRange) {
            if (word[counter] == word[high]) {
                counter++
                high--
            } else {
                break
            }
        }

        if (counter == midRange) {
            return true
        }else{
            return false
        }

    }
}