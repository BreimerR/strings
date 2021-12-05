package kotlinx.strings

import kotlin.reflect.KFunction1

infix fun String.replace(replacementAction: KFunction1<String, (String) -> String>) = replacementAction

infix fun String.replace(int: Int) = { replacement: String ->
    if (int > 0)
        replacement + substring(int, length)
    else
        substring(0, length + int) + replacement
}


infix fun String?.alt(string: String) = this?.let {
    if (it == "") string else it
} ?: string

infix fun String?.alternatively(string: String) = this alt string

fun String.titleCase(separator: String = ""): String = split(separator).joinToString(separator) { it.ucFirst }

fun String.titleCase(separator: Char = ' '): String = titleCase("$separator")


fun String.replace(from: Int, to: Int, with: String): String =
    substring(0, from) + with + substring(to, length)


infix operator fun <R> String.get(getter: (String) -> R) = getter(this)

operator fun String.get(fromTo: Pair<Int, Int>): String = substring(fromTo.first, fromTo.second)



infix fun String.test(string: String?): Boolean = string?.regex?.matches(string) ?: false

inline val String?.isEmpty
    get() = this == null || this.isEmpty()


inline val String?.isBlank
    get() = this == null || this.isBlank()

inline val String?.isNotBlank
    get() = !isBlank

inline val String?.isNotEmpty
    get() = !isEmpty

inline fun String.remove(vararg chars: Char): String {

    var s = this

    for (char in chars)
        s = s.replace("$char", "")

    return s

}



infix fun KFunction1<String, (String) -> String>.charsOf(actual: String) = { replacement: String ->
    this(actual)(replacement)
}


infix fun ((String) -> String).with(replacement: String) = this(replacement)


