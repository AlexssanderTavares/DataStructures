class Cell<T>(private var element: T, private var constNext: Cell<T>?) {
    private var next: Cell<T>? = constNext

    constructor(element: T): this(element, constNext = null)



    fun getElement(): T {
        return this.element
    }

    fun setElement(element: T?){
        this.element = null as T
    }

    fun setNext(next: Cell<T>?) {
        this.next = next
    }

    fun getNext() : Cell<T>? {
        return this.next
    }

    override fun toString(): String {
        return "Element: ${this.element} | Next: ${this.next}"
    }


}