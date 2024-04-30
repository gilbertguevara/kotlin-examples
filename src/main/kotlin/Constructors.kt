class Constructors {
    class Person(val name: String, val surname: String, private var age: Int) {

        init {
            findJob()
        }

        private fun findJob() {}

        constructor(name: String, parent: Person) : this(name, parent.surname, 0)
    }
}

fun main() {
    val parent = Constructors.Person("Juan", "Valdez", 45)
    val child = Constructors.Person("John", parent)
}