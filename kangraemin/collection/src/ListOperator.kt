// ref : https://kotlinlang.org/docs/list-operations.html#retrieve-elements-by-index
fun main() {

}

fun sampleCodeForRetrieveListParts() {
    val numbers = (0..13).toList()
    println(numbers)
    println(numbers.subList(3, 6))
}

fun sampleCodeForLinearSearch() {
    val numbers = listOf(1, 2, 3, 4, 2, 5)
    println(numbers.indexOf(2))
    println(numbers.lastIndexOf(2))

    val numbersWithFunction = mutableListOf(1, 2, 3, 4)
    println(numbersWithFunction.indexOfFirst { it > 2})
    println(numbersWithFunction.indexOfLast { it % 2 == 1})
}

fun sampleCodeForBinarySearch() {
    val numbers = mutableListOf("one", "two", "three", "four")
    numbers.sort()
    println(numbers)
    println(numbers.binarySearch("two"))  // 3
    println(numbers.binarySearch("z")) // -5
    println(numbers.binarySearch("a")) // -1
    println(numbers.binarySearch("two", 0, 2))  // -3

    val numbersSecond = mutableListOf("one", "two", "three", "four", "aeae")
    numbersSecond.sort()
    println(numbersSecond)
    println(numbersSecond.binarySearch("two"))  // 4
    println(numbersSecond.binarySearch("z")) // -6
    println(numbersSecond.binarySearch("two", 0, 2))  // -3

    val numberNotSorted = mutableListOf("one", "two", "three", "four", "aeaze")
    println(numberNotSorted)
    println(numberNotSorted.binarySearch("two"))  // -6
    println(numberNotSorted.binarySearch("z")) // -6
    println(numberNotSorted.binarySearch("two", 0, 2))  // 1
}

fun sampleCodeForCustomOrderingBinarySearch() {
    val productList = listOf(
            Product("WebStorm", 49.0),
            Product("AppCode", 99.0),
            Product("DotTrace", 129.0),
            Product("ReSharper", 149.0))

    println(productList.binarySearch(
            // thenBy -> Product의 price를 기준으로 값 비교를 하는데, 만약 두 객체를 비교 할 때 첫번째 조건식에서 같다는 값이 나왔을 경우 새롭게 비교 할 두번째 조건을 제시 해 줌
            Product("AppCode", 99.0), compareBy<Product> { it.price }.thenBy { it.name }
    ))
}

data class Product(val name: String, val price: Double)

fun sampleCodeForCustomCondition() {
    val colors = listOf("Blue", "green", "ORANGE", "Red", "yellow")
    println(colors.binarySearch("RED", String.CASE_INSENSITIVE_ORDER)) // 3
}

fun sampleCodeForComparisonBinarySearch() {
    val productList = listOf(
            Product("WebStorm", 49.0),
            Product("AppCode", 99.0),
            Product("DotTrace", 129.0),
            Product("ReSharper", 149.0))

    println(productList.binarySearch { priceComparison(it, 49.0) }) // 0
    println(productList.binarySearch { priceComparison(it, 99.0) }) // 1
    println(productList.binarySearch { priceComparison(it, 419.0) }) // -5
}

fun priceComparison(product: Product, price: Double) = (product.price - price).toInt()

fun sampleCodeForUpdateListOperator() {
    val numbers = mutableListOf("one", "five", "three")
    numbers[1] =  "two"
    println(numbers)

    val filledNumbers = mutableListOf(1, 2, 3, 4)
    filledNumbers.fill(3)
    println(filledNumbers)
}

fun sampleCodeForSorting() {
    val numbers = mutableListOf("one", "two", "three", "four")

    numbers.sort()
    println("Sort into ascending: $numbers")
    numbers.sortDescending()
    println("Sort into descending: $numbers")

    numbers.sortBy { it.length }
    println("Sort into ascending by length: $numbers")
    numbers.sortByDescending { it.last() }
    println("Sort into descending by the last letter: $numbers")

    numbers.sortWith(compareBy<String> { it.length }.thenBy { it })
    println("Sort by Comparator: $numbers")

    numbers.shuffle()
    println("Shuffle: $numbers")

    numbers.reverse()
    println("Reverse: $numbers")
}