fun main() {
    outerLoop@ while (true) {
        println("Outer loop")
        while (true) {
            println("Inner loop")
            // Use the labeled break to exit the outer loop
            if (conditionToExitOuterLoop()) {
                break@outerLoop
            }
        }
    }
    println("After the loops")
}

fun conditionToExitOuterLoop(): Boolean {
    // Replace this condition with your own logic
    return true
}