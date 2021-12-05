package kotlinx.strings

import kotlin.math.abs

infix fun Int.toLastCharOf(string: String) = string.substring(this, string.length)

fun Int.lastChars(string: String) = string.substring(string.length - abs(this), string.length)

fun Int.firstChars(string: String) = string.substring(0, abs(this))

fun Int.last(string: String): Char = try {
    string[string.length - this]
} catch (e: Exception) {
    if (this > string.length)
        throw RuntimeException("Int::last Int($this) can't be greater than String.length(${string.length})")
    else
        throw RuntimeException("Int::last Int($this) can't be less than 1) ")
}
