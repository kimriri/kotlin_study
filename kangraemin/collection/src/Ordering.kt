// ref : https://kotlinlang.org/docs/collection-ordering.html
import kotlin.Comparator

fun main() {

}

fun sampleCodeForCustomCompareClass() {
    println(Version(1, 2) > Version(1, 3))
    println(Version(2, 0) > Version(1, 5))
    println(Version(2, 0) == Version(2, 0))
    println(Version(2, 0) > Version(2, 0))
}

data class Version(val major: Int, val minor: Int) : Comparable<Version> {
    // compareTo -> 앞 객체와 뒷 객체의 크기 비교 원칙을 서술
    // compareTo 함수의 결과 값이 음수 -> 뒷 객체가 더 큰것을 의미
    // compareTo 함수의 결과 값이 양수 -> 앞 객체가 더 큰것을 의미
    // compareTo 함수의 결과 값이 0 -> 두 객체의 값이 같음을 의미
    override fun compareTo(other: Version): Int {
        return when {
            this.major != other.major -> {
                this.major - other.major
            }
            this.minor != other.minor -> {
                this.minor - other.minor
            }
            else -> 0 // When version is same
        }
    }
}

fun sampleCodeForCustomComparator() {
    val lengthComparator = Comparator { str1: String, str2: String ->
        str1.length - str2.length
    }
    println(listOf("aaa", "bb", "c").sortedWith(lengthComparator))
    println(listOf("aaa", "bb", "c").sortedWith { x, y -> x.length - y.length })

    val lengthComparatorReverse = Comparator { str1: String, str2: String ->
        str2.length - str1.length
    }
    println(listOf("aaa", "bb", "c").sortedWith(lengthComparatorReverse))
    println(listOf("aaa", "bb", "c").sortedWith { x, y -> y.length - x.length })
}

fun sampleCodeForCompareBy() {
    println(listOf("aaa", "bb", "c").sortedWith(compareBy { it.length }))
}

fun sampleCodeForCustomOrderingUsingNaturalOrdering() {
    val numbers = listOf("one", "two", "three", "four")

    val sortedNumbers = numbers.sortedBy { it.length }
    println("Sorted by length ascending: $sortedNumbers")
    val sortedByLast = numbers.sortedByDescending { it.last() }
    println("Sorted by the last letter descending: $sortedByLast")

    val numbersCompareBy = listOf("one", "two", "three", "four")
    println("Sorted by length ascending: ${numbersCompareBy.sortedWith(compareBy { it.length })}")
}

fun sampleCodeForReverseOrder() {
    val numbers = listOf("one", "two", "three", "four")
    println(numbers.reversed())

    val mutableNumbers = mutableListOf("one", "two", "three", "four")
    println(mutableNumbers.reversed())
    mutableNumbers.add("five")
    println(mutableNumbers)

    val numbersAsReversed = listOf("one", "two", "three", "four")
    val reversedNumbers = numbersAsReversed.asReversed()
    println(reversedNumbers)

    val mutableNumbersAsReversed = mutableListOf("one", "two", "three", "four")
    val mutableReversedNumbers = mutableNumbersAsReversed.asReversed()
    println(mutableReversedNumbers)
    mutableNumbersAsReversed.add("five")
    println(mutableReversedNumbers)

    val set = setOf("one", "two")
    set.reversed()

    val map = mapOf("one" to 1, "two" to 2)
}

fun sampleCodeForRandomOrder() {
    val numbers = listOf("one", "two", "three", "four")
    println(numbers.shuffled())
}