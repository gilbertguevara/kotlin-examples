class SafeCalls {
    class Head(val name: String)
    class Department(val name: String, val head: Head?)
    class Employee(val name: String, val age: Int, val department: Department?)
}

fun main() {
    val head = SafeCalls.Head("The IT Boss")
    val department = SafeCalls.Department("IT", head)
    val employee = SafeCalls.Employee("Juan Valdez", 45, department)

    println(employee.department?.head?.name)
    val employee2 = SafeCalls.Employee("John Connor", 45, null)
    println(employee2.department?.head?.name)

    employee.department?.head?.name?.let { println(it) }
    employee2.department?.head?.name?.let { println(it) }
}