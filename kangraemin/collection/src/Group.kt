fun main() {

}

fun groupBySampleCode() {
    val numbers = listOf("one", "two", "three", "four", "five")

    println(numbers.groupBy { it.first().toUpperCase() })
    println(numbers.groupBy(keySelector = { it.first() }, valueTransform = { it.toUpperCase() }))
}

fun groupingBySampleCode() {
    val numbers = listOf("one", "two", "three", "four", "five", "six", "fffive")
    val groupingResult = numbers.groupingBy { it.first() }
    println(groupingResult.eachCount())
    println(groupingResult.fold("one") { a, b ->
        println("----")
        println(a)
        println(b)
        println("----")
        a + b })
    println("@@@")
    println(groupingResult.reduce { a, b, c ->
        println("----")
        println(a)
        println(b)
        println(c)
        println("----")
        a + b + c
    })

    val numberAggregated = listOf(3, 4, 5, 6, 7, 8, 9)

    val aggregated = numberAggregated.groupingBy { it % 3 }.aggregate { key, accumulator: StringBuilder?, element, first ->
        if (first)
            StringBuilder().append(key).append(":").append(element)
        else
            accumulator!!.append("-").append(element)
    }
    println(aggregated)
    println(aggregated.values)
}