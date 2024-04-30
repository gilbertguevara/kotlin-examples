class DataClasses {

    data class User(val name: String, val age: Int)

    fun test() {
        val user = User("Juan Valdez", 45)
        val (name, age) = user

        println(user == User("Juan Valdez", 45))
        println(user === User("Juan Valdez", 45))
        println(user.hashCode())
        println(user)
        println(name)
        println(age)
        println(user.copy(age = 50))
    }
}

fun main() {
    DataClasses().test()
}