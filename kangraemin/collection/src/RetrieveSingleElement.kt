// ref : https://kotlinlang.org/docs/collection-elements.html
fun main() {

}

fun getElementFromSetSampleCode() {
    val numbers = linkedSetOf("one", "two", "three", "four", "five")
    println(numbers.elementAt(3))

    val numbersSortedSet = sortedSetOf("one", "two", "three", "four")
    println(numbersSortedSet.elementAt(0)) // elements are stored in the ascending order
}

fun getElementFromListSampleCode() {
    val numbers = listOf("one", "two", "three", "four", "five")
    println(numbers[0])
    println(numbers.get(0))
    println(numbers.elementAt(0))

    println(numbers.first())
    println(numbers.last())

    println(numbers.elementAt(20)) // runtime error
    println(numbers.elementAtOrNull(20))
    println(numbers.elementAtOrElse(20, { index -> "The value for index $index is undefined"}))
}

fun firstLastSampleCode() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.first { it.length > 3 })
    println(numbers.last { it.startsWith("f") })
}

fun firstLastNullCheckSampleCode() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.firstOrNull { it.length > 6 })
}

fun findSampleCode() {
    val numbers = listOf(1, 2, 3, 4)
    println(numbers.find { it % 2 == 0 }) // ( == firstOrNull )
    println(numbers.findLast { it % 2 == 0 }) // ( == lastOrNull )
}

fun checkRandomOperatorCode() {
    val numbers = listOf(1, 2, 3, 4)
    println(numbers.random())
    println(numbers.randomOrNull())
}

fun checkExistenceSampleCode() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.contains("four"))
    println("zero" in numbers)

    println(numbers.containsAll(listOf("four", "two")))
    println(numbers.containsAll(listOf("one", "zero")))
}

fun isEmptySampleCode() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.isEmpty())
    println(numbers.isNotEmpty())

    val empty = emptyList<String>()
    println(empty.isEmpty())
    println(empty.isNotEmpty())
}