package exercise1

class Document(val name: String, val pages: Int) : Comparable<Document> {


    override fun compareTo(other: Document): Int {
        return if(this.pages < other.pages){
            1
        } else if(this.pages == other.pages){
            return 0
        }else{
            return -1
        }


    }
}