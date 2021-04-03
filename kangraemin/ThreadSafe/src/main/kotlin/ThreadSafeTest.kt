/*
 * Copyright 2016-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

// This file was automatically generated from shared-mutable-state-and-concurrency.md by Knit tool. Do not edit.
import kotlinx.coroutines.*
import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.*

suspend fun massiveRun(action: suspend () -> Unit) {
    val n = 10  // number of coroutines to launch
    val k = 1000 // times an action is repeated by each coroutine
    val time = measureTimeMillis {
        coroutineScope { // scope for coroutines
            repeat(n) {
                launch {
                    repeat(k) { action() }
                }
            }
        }
    }
    println("Completed ${n * k} actions in $time ms")
}

//var counter = 0
var counter: AtomicInteger = AtomicInteger(0)
//val list: MutableList<Int> = mutableListOf()
val list: MutableList<Int> = Collections.synchronizedList(mutableListOf<Int>())
val expectedList = (0..9999).toList()

fun main() = runBlocking {
    withContext(Dispatchers.Default) {
        massiveRun {
//            list.add(counter++)
            list.add(counter.getAndIncrement())
        }
    }
    println(list)
    println(expectedList)
    println("Counter = $counter")
    println("actual list size = ${list.size}")
    println("expectedList size ${expectedList.size}")
    println("difference of list = ${expectedList - list}")
}