// ref : https://kotlinlang.org/docs/collection-parts.html#windowed
fun main() {

}

fun sliceCollectionSampleCode() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.slice(1..3))
    println(numbers.slice(0..4 step 2))
    println(numbers.slice(setOf(3, 5, 0)))
}

fun takeDropSampleCode() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.take(3))
    println(numbers.takeLast(3))
    println(numbers.drop(1))
    println(numbers.dropLast(5))
}

fun takeDropSampleCodeWithPredicates() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.takeWhile { !it.startsWith('f') })
    println(numbers.takeLastWhile { it != "three" })
    println(numbers.dropWhile { it.length == 3 })
    println(numbers.dropLastWhile { it.contains('i') })
}

fun chunkSampleCode() {
    val numbers = (0..13).toList()
    println(numbers.chunked(3))
}

fun chunkWithTransformSampleCode() {
    val numbers = (0..13).toList()
    println(numbers.chunked(3) { it.sum() })  // `it` is a chunk of the original collection
}

fun windowedSampleCode() {
    val numbers = listOf("one", "two", "three", "four", "five")
    println(numbers.windowed(3))
}

fun windowedWithParamsSampleCode() {
    val numbers = (1..10).toList()
    println(numbers.windowed(3, step = 2, partialWindows = false))
    println(numbers.windowed(3, step = 2, partialWindows = true))
    println(numbers.windowed(3) { it.sum() })
}

fun zipWithNextSampleCode() {
    val numbers = listOf("one", "two", "three", "four", "five")
    println(numbers.zipWithNext())
    println(numbers.zipWithNext() { s1, s2 -> s1.length > s2.length})
}