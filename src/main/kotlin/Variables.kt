const val GAME_PREFIX: String = "GAME_";

fun main() {
    val a: Int = 1	// immediate assignment

    var b = 2		// 'Int' type is inferred
    b = a 			// Reassigning to 'var' is okay

    val c: Int		// Type required when no initializer is provided
    c = 3			// Deferred assignment
//        a = 4			// Error: Val cannot be reassigned

    // cannot be calculated at compile-time
    val gamePrefixLowerCase =  GAME_PREFIX.lowercase();
}