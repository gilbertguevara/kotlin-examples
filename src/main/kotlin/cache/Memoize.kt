package cache

import java.io.Serializable

inline fun <Any, R> GenericCache<Any, R>.getOrPut(prefixKey: String = "", key: Any, defaultValue: () -> R): R {
    val fullKey = (prefixKey to key) as Any
    val value = this[fullKey]
    return if (value == null) {
        val answer = defaultValue()
        this[fullKey] = answer
        answer
    } else {
        println("Returning value from cache")
        value
    }
}

inline fun <Any, R> GenericCache<Any, R>.getOrPut(key: String, defaultValue: () -> R): R {
    val value = this[key as Any]
    return if (value == null) {
        val answer = defaultValue()
        this[key] = answer
        answer
    } else {
        value
    }
}

fun <R> (() -> R).memoize(
    cache: GenericCache<in Unit, R>,
    key: String
): () -> R = {
    cache.getOrPut(key) { this() }
}

fun <A, R> ((A) -> R).memoize(
    cache: GenericCache<in A, R>,
    prefixKey: String
): (A) -> R = { a: A ->
    cache.getOrPut(prefixKey, a) { this(a) }
}

fun <A, B, R> ((A, B) -> R).memoize(
    cache: GenericCache<in Pair<A, B>, R>,
    prefixKey: String
): (A, B) -> R = { a: A, b: B ->
    cache.getOrPut(prefixKey, a to b) { this(a, b) }
}

fun <A, B, C, R> ((A, B, C) -> R).memoize(
    cache: GenericCache<in Triple<A, B, C>, R>,
    prefixKey: String
): (A, B, C) -> R = { a: A, b: B, c: C ->
    cache.getOrPut(prefixKey, Triple(a, b, c)) { this(a, b, c) }
}

data class Quadruple<out A, out B, out C, out D>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D
) : Serializable {
    companion object {
        private const val serialVersionUID = -24530L
    }

    override fun toString(): String = "($first, $second, $third, $fourth)"
}

fun <A, B, C, D, R> ((A, B, C, D) -> R).memoize(
    cache: GenericCache<in Quadruple<A, B, C, D>, R>,
    prefixKey: String
): (A, B, C, D) -> R = { a: A, b: B, c: C, d: D ->
    cache.getOrPut(prefixKey, Quadruple(a, b, c, d)) { this(a, b, c, d) }
}
