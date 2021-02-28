// ref : https://kotlinlang.org/docs/collection-transformations.html
fun main() {

}

fun checkDefaultMapOperator() {
    val numbers = setOf(1, 2, 3)
    println(numbers.map { it * 3 })
    println(numbers.mapIndexed { idx, value -> value * idx })

    val numbersNullCheck = setOf(1, 2, 3)
    println(numbersNullCheck.mapNotNull { if ( it == 2) null else it * 3 })
    println(numbersNullCheck.mapIndexedNotNull { idx, value -> if (idx == 0) null else value * idx })
}

fun makeMapCollectionUsingMapOperator() {
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    println(numbersMap.mapKeys { it.key.toUpperCase() })
    println(numbersMap.mapValues { it.value + it.key.length })
}

fun checkDefaultZipOperator() {
    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    println(colors zip animals)

    val twoAnimals = listOf("fox", "bear")
    println(colors.zip(twoAnimals))
}

fun checkZipUsingTransformFunction() {
    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")

    println(colors.zip(animals) { color, animal -> "The ${animal.capitalize()} is $color"})
}

fun checkUnzipFunction() {
    val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    println(numberPairs.unzip())
}

fun checkAssociateWithOperator() {
    val numbers = listOf("one", "two", "three", "four")
    println(numbers.associateWith { it.length })
}

fun checkAssociateByOperator() {
    val numbers = listOf("one", "two", "three", "four")

    println(numbers.associateBy { it.first().toUpperCase() })
    println(numbers.associateBy(keySelector = { it.first().toUpperCase() }, valueTransform = { it.length }))
}

fun associateOperator() {
    val names = listOf("Alice Adams", "Brian Brown", "Clara Campbell")
    println(names.associate { name -> parseFullName(name).let { it.lastName to it.firstName } })
}

fun parseFullName(name: String): FullName {
    return FullName(name.split(" ")[0], name.split(" ")[1])
}

data class FullName(val lastName: String, val firstName: String)

fun flattenOperator() {
    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    println(numberSets.flatten())
}

fun flatMapOperator() {
    val containers = listOf(
            StringContainer(listOf("one", "two", "three")),
            StringContainer(listOf("four", "five", "six")),
            StringContainer(listOf("seven", "eight"))
    )
    println(containers.flatMap { it.values })
}

data class StringContainer(val values: List<String>)

fun checkJoinToOperator() {
    val numbers = listOf("one", "two", "three", "four")

    println(numbers)
    println(numbers.joinToString())

    val listString = StringBuffer("The list of numbers: ")
    numbers.joinTo(listString)
    println(listString)
}

fun checkJoinToOperatorWithParams() {
    val numbers = listOf("one", "two", "three", "four")
    println(numbers.joinToString(separator = " | ", prefix = "start: ", postfix = ": end"))

    val numbersToCheckLimit = (1..100).toList()
    println(numbersToCheckLimit.joinToString(limit = 10, truncated = "<...>"))

    val numbersToCheckTransform = listOf("one", "two", "three", "four")
    println(numbersToCheckTransform.joinToString { "Element: ${it.toUpperCase()}"})
}