package sealedclass

fun main() {

}

fun sampleCodeForHandlingThrowable() {
    handleError(InternalServerError)
}

fun handleError(sealedThrowable: SealedThrowable) = when (sealedThrowable) {
    is IOException -> println("IOException")
    is InvalidParameter -> println("InvalidParameter")
    is Forbidden -> println("Forbidden")
    InternalServerError -> println("InternalServerError")
    is DataClassThrowable -> {
        println(sealedThrowable.responseCode)
        sealedThrowable.throwable.printStackTrace()
    }
}

sealed class SealedThrowable : Throwable()
open class IOException : SealedThrowable()
class InvalidParameter : SealedThrowable()
class Forbidden : SealedThrowable()
object InternalServerError : SealedThrowable()
data class DataClassThrowable(val throwable: Throwable, val responseCode: Int) : SealedThrowable()

fun sampleCodeForAnimalSealedClass() {
    handleAnimal(Animal.Dog("Puppy"))
}

fun handleAnimal(animal: Animal) = when (animal) {
    is Animal.Duck -> println("Duck")
    is Animal.Dog -> println(animal.name)
    Animal.Penguin -> println("PENGUIN")
}

sealed class Animal {
    class Duck : Animal()
    data class Dog(val name: String) : Animal()
    object Penguin : Animal()
}