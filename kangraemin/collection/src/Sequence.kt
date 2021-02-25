// ref : https://kotlinlang.org/docs/sequences.html
fun main() {
    
}

fun makeSequenceInstance() {
    // From elements
    val numbersSequenceFromElement = sequenceOf("four", "three", "two", "one")

    // From Iterable
    val numbers = listOf("one", "two", "three", "four")
    val numbersSequence = numbers.asSequence()

    // Using generateSequence function
    val oddNumbers = generateSequence(1) { it + 2 } // `it` is the previous element
//    println(oddNumbers.take(5))
//    println(oddNumbers.take(5).toList())
//    println(oddNumbers.count())     // error: the sequence is infinite

    val oddNumbersLessThan10 = generateSequence(1) {
        println("it = $it")
        if (it < 8) {
            it + 2
        } else null
    }
    println(oddNumbersLessThan10)
    println(oddNumbersLessThan10.count())

    // From chunks
    val oddNumbersSequence = sequence {
        yield(1)
        yieldAll(listOf(3, 5))
        yieldAll(generateSequence(7) { it + 2 })
    }
    println(oddNumbersSequence.take(5).toList())
}

fun checkFlowInIterable() {
    val words = "The quick brown fox jumps over the lazy dog".split(" ")
    val lengthsList = words.filter { println("filter: $it"); it.length > 3 }
            .map { println("length: ${it.length}"); it.length }
            .take(4)

    println("Lengths of first 4 words longer than 3 chars:")
    println(lengthsList)
}

fun checkFlowInSequence() {
    val words = "The quick brown fox jumps over the lazy dog".split(" ")
    //convert the List to a Sequence
    val wordsSequence = words.asSequence()

    val lengthsSequence = wordsSequence.filter { println("filter: $it"); it.length > 3 }
            .map { println("length: ${it.length}"); it.length }
            .take(4)

    println("Lengths of first 4 words longer than 3 chars")
    // terminal operation: obtaining the result as a List
    println(lengthsSequence.toList())
}