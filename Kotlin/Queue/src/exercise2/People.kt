package exercise2

class People(val name: String, val age: Int) : Comparable<People>{

    override fun compareTo(other: People): Int {
        return if(other.age >= 60){
            1
        }else if(other.age < 18){
            1
        }else{
            0
        }
    }
}