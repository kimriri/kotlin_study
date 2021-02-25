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