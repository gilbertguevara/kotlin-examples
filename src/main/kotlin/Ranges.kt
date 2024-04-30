fun main(args: Array<String>) {

    for (a in 1..5){
        print(a )
    }
    println()
    for(x in 'a'..'f'){
        print(x )
    }
    println()
    val range = 1.0..5.0
    println(range)
    println("3.14 in range is ${3.14 in range}")

    for (x in 9 downTo 0 step 3) {
        print("$x ")
    }

    println()
    for (i in 0..<8 step 2) print("$i ")
}  