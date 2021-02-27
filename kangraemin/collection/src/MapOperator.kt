// ref : https://kotlinlang.org/docs/map-operations.html#plus-and-minus-operators
fun main() {

}

fun sampleCodeForMapOperator() {
    val numbersMap = mapOf("one" to 1, "two" to 2, "three" to 3)
    println(numbersMap.get("one"))
    println(numbersMap["one"])
    println(numbersMap.getOrElse("four", { getSomethingInt() }))
    println(numbersMap.getOrDefault("four", 10))
    println(numbersMap["five"])               // null
    //numbersMap.getValue("six")      // exception!
}

fun getSomethingInt(): Int {
    return 100
}

fun sampleCodeForFilterForMap() {
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filteredMap = numbersMap.filter { (key, value) -> key.endsWith("1") && value > 10}
    println(filteredMap)

    val numbersMapForOneProperty = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filteredKeysMap = numbersMapForOneProperty.filterKeys { it.endsWith("1") }
    val filteredValuesMap = numbersMapForOneProperty.filterValues { it < 10 }

    println(filteredKeysMap)
    println(filteredValuesMap)
}

fun sampleCodeForPlusMinusOperator() {
    val numbersMap = mapOf("one" to 1, "two" to 2, "three" to 3)
    println(numbersMap + Pair("four", 4))
    println(numbersMap + Pair("one", 10))
    println(numbersMap + mapOf("five" to 5, "one" to 11))

    val numbersMapMinus = mapOf("one" to 1, "two" to 2, "three" to 3)
    println(numbersMapMinus - "one")
    println(numbersMapMinus - listOf("two", "four"))
}

fun sampleCodeForAddOperator() {
    val numbersMap = mutableMapOf("one" to 1, "two" to 2)
    numbersMap.put("three", 3)
    println(numbersMap)

    val numbersMapPutAll = mutableMapOf("one" to 1, "two" to 2, "three" to 3)
    numbersMapPutAll.putAll(setOf("four" to 4, "five" to 5))
    println(numbersMapPutAll)

    val numbersMapChangeValue = mutableMapOf("one" to 1, "two" to 2)
    val previousValue = numbersMapChangeValue.put("one", 11)
    println("value associated with 'one', before: $previousValue, after: ${numbersMapChangeValue["one"]}")
    println(numbersMapChangeValue)

    val numbersMapShorthand = mutableMapOf("one" to 1, "two" to 2)
    numbersMapShorthand["three"] = 3     // calls numbersMapShorthand.put("three", 3)
    numbersMapShorthand += mapOf("four" to 4, "five" to 5)
    println(numbersMapShorthand)
}

fun sampleCodeForRemoveOperator() {
    val numbersMap = mutableMapOf("one" to 1, "two" to 2, "three" to 3)
    numbersMap.remove("one")
    println(numbersMap)
    numbersMap.remove("three", 4)            //doesn't remove anything
    println(numbersMap)

    val numbersMapRemoveElement = mutableMapOf("one" to 1, "two" to 2, "three" to 3, "threeAgain" to 3)
    numbersMapRemoveElement.keys.remove("one")
    println(numbersMapRemoveElement)
    numbersMapRemoveElement.values.remove(3)
    println(numbersMapRemoveElement)

    val numbersMapMinusOperator = mutableMapOf("one" to 1, "two" to 2, "three" to 3)
    numbersMapMinusOperator -= "two"
    println(numbersMapMinusOperator)
    numbersMapMinusOperator -= "five"             //doesn't remove anything
    println(numbersMapMinusOperator)
}