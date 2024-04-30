fun main() {
    var humid = true
    var raining = true
    var shorts = false
    var sunny = false

// true AND true
    println(humid && raining) //  true

// true AND false
    println(humid && shorts) //  false

// false AND true
    println(sunny && raining) //  false

// false AND false
    println(shorts && sunny) // false


}