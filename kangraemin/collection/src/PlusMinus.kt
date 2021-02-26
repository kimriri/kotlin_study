// ref : https://kotlinlang.org/docs/collection-plus-minus.html
fun main() {

}

fun plusMinus() {
    val numbers = listOf("one", "two", "three", "four")

    val plusList = numbers + "five"
    val minusList = numbers - listOf("three", "four")
    println(plusList)
    println(minusList)
}

fun augmentedAssignment() {
    val valNumberCollection = listOf("one", "two", "three", "four")
    // Compile error
//    valNumberCollection += "five"
//    valNumberCollection -= listOf("three", "four")
//    valNumberCollection -= "four"

    // mutableList로 바꿀 것을 권장, + / - operator 자체가 재할당 하는 형식이기 때문
    var varNumberCollection = listOf("one", "two", "three", "four")
    varNumberCollection += "five"
    varNumberCollection -= listOf("three", "four")
    varNumberCollection -= "four"

    val valNumberMutableCollection = mutableListOf("one", "two", "three", "four")
    valNumberMutableCollection += "five"
    valNumberMutableCollection -= listOf("three", "four")
    valNumberMutableCollection -= "four"
}

// region ref : https://kotlinlang.org/docs/collection-write.html#removing-elements
fun sampleCodeForAddingElements() {
    val numbers = mutableListOf(1, 2, 3, 4)
    numbers.add(5)
    println(numbers)

    val numbersAddAll = mutableListOf(1, 2, 5, 6)
    numbersAddAll.addAll(arrayOf(7, 8))
    println(numbersAddAll)
    numbersAddAll.addAll(2, setOf(3, 4))
    println(numbersAddAll)

    val numbersPlusOperator = mutableListOf("one", "two")
    numbersPlusOperator += "three"
    println(numbersPlusOperator)
    numbersPlusOperator += listOf("four", "five")
    println(numbersPlusOperator)
}

fun sampleCodeForRemovingElements() {
    val numbers = mutableListOf(1, 2, 3, 4)
    println(numbers)
    numbers.retainAll { it >= 3 }
    println(numbers)
    numbers.clear()
    println(numbers)

    val numbersSet = mutableSetOf("one", "two", "three", "four")
    numbersSet.removeAll(setOf("one", "two"))
    println(numbersSet)

    val numbersMinusOperator = mutableListOf("one", "two", "three", "three", "four")
    numbersMinusOperator -= "three"
    println(numbersMinusOperator)
    numbersMinusOperator -= listOf("four", "five")
//    numbersMinusOperator -= listOf("four")    // does the same as above
    println(numbersMinusOperator)
}
// endregion