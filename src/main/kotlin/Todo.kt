class Todo {
    class Item {}

    fun findItemOrNull(id: String): Item? = TODO("Find item $id")

    // Does not compile at all
//    fun findItemOrNull(id: String): Item? = { }
}