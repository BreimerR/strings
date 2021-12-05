package kotlinx.strings


val String.camelSplit: List<String>
    get() {
        val strings = mutableListOf<String>()
        var prevString = ""

        val l = this.length - 1

        this.forEachIndexed { i, it ->
            if (it.isUpperCase()) {
                if (prevString.isNotEmpty()) strings.add(prevString)
                prevString = "$it"
            } else if (i == l) strings.add("$prevString$it")
            else prevString += it
        }

        return strings
    }

val String.snakeSplit: List<String>
    get() = split('_')

//TODO WRITE TEST TO REMOVE UNUSED STATE
val String.camelSnakeSplit
    get() = snakeSplit.map { it.camelSplit }.flatten()

val String.lcFirst: String
    get() = "${this.first().lowercase()}${this.substring(1, length)}"

val String.regex
    get() = toRegex()

val String.ucFirst: String
    get() = "${this.first().uppercase()}${this.substring(1, length)}"