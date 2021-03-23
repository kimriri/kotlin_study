fun main() {

}

fun sampleCodeForInterface() {
    val duck = Duck("Donald", 123)
    duck.cry()

    val dog = Dog("Snoopy", 3000)
    dog.cry()

    val penguin = Penguin("Peng", 13)
    penguin.eat()
    penguin.somethingNormal
}

abstract class AbstractAnimal {
    abstract fun cry()
}

interface Animal {
    fun cry()
}

open class AnimalClass {
    val somethingNormal = "somethingNormal"

    fun eat() {
        println("Nyam")
    }
}

data class Duck(val name: String, val age: Int): AbstractAnimal() {
    override fun cry() {
        println("Quack")
    }
}

data class Dog(val name: String, val age: Int): Animal {
    override fun cry() {
        println("Bow")
    }
}

data class Penguin(val name: String, val age: Int): AnimalClass() {

}

// 데이터 클래스 끼리의 상속은 안됨 ( open keyword 가 안붙음 )
data class ParentAnimal(val name: String, val age: Int)

// Function 'component1' generated for the data class conflicts with member of supertype 'ParentAnimal'
//data class Dog(val firstElement: String): ParentAnimal()