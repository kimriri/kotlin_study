package enumclass

import enumclass.Animal.*

fun main() {

}

fun sampleCodeForDefaultMethodInEnum() {
    // Return enum property's name
    println(CAT.name)

    // Return enum property's position in enum class
    println(CAT.ordinal)

    // Get enum property by name
    println(valueOf("DUCK"))
    // println(Animal.valueOf("DUCKY")) // throw IllegalArgumentException error ( no enum constants )

    // Return values to arrayList
    println(
        values()
            .map { "You are ${it.name} in position ${it.ordinal} !" }
            .toList()
    )

    // enum 에서 어떤 값이 분기처리가 되지 않았는지 확인 할 수 있음
    // 임의의 enum property 에 대한 예외처리를 하지않았을 때 아래의 warning 문구가 표출이 됨
    // 'when' expression on enum is recommended to be exhaustive, add 'PENGUIN' branch or 'else' branch instead
    when (values().random()) {
        DUCK -> {
            println("DUCK")
        }
        CAT -> {
            println("CAT")
        }
        DOG -> {
            println("DOG")
        }
    }
}

enum class Animal {
    DUCK, PENGUIN, CAT, DOG
}

fun sampleCodeForEnumWithConstructor() {
    println(AnimalWithName.CAT.age)
    println(AnimalWithName.CAT.cryingSound)
}

enum class AnimalWithName(val cryingSound: String, val age: Int) {
    DUCK("Quack", 123),
    PENGUIN("Peng", 12),
    CAT("Meow", 1),
    DOG("Bow", 31)
}

fun sampleCodeForEnumWithAbstractClass() {
    AnimalWithAbstractFunction.CAT.cry()
    println(AnimalWithAbstractFunction.DOG.age)
}

enum class AnimalWithAbstractFunction() {
    DUCK {
        override val age: Int
            get() = 123

        override fun cry() {
            println("Quack")
        }
    },
    PENGUIN {
        override val age: Int
            get() = 12

        override fun cry() {
            println("Peng")
        }
    },
    CAT {
        override val age: Int
            get() = 1

        override fun cry() {
            println("Meow")
        }
    },
    DOG {
        override val age: Int
            get() = 31

        override fun cry() {
            println("Bow")
        }
    };
    abstract fun cry()
    abstract val age: Int
}

fun sampleCodeWithInterface() {
    AnimalWithInterface.CAT.cry()
    println(AnimalWithAbstractFunction.CAT.age)
}

interface NormalAnimal {
    val age: Int
    fun cry()
}

enum class AnimalWithInterface: NormalAnimal {
    DUCK {
        override val age: Int
            get() = 123

        override fun cry() {
            println("Quack")
        }
    },
    PENGUIN {
        override val age: Int
            get() = 12

        override fun cry() {
            println("Peng")
        }
    },
    CAT {
        override val age: Int
            get() = 1

        override fun cry() {
            println("Meow")
        }
    },
    DOG {
        override val age: Int
            get() = 31

        override fun cry() {
            println("Bow")
        }
    },
}

fun sampleCodeForEnumWithNameAndCompanionObject() {
    println("oldest animal = ${AnimalWithNameAndCompanionObject.getOldestAnimalName()}")
}

enum class AnimalWithNameAndCompanionObject(val cryingSound: String, val age: Int) {
    DUCK("Quack", 123),
    PENGUIN("Peng", 12),
    CAT("Meow", 1),
    DOG("Bow", 31);

    companion object {
        fun getOldestAnimalName(): String {
            println(values().toList())
            return values().maxWithOrNull(compareBy { it.age })?.name ?: "none !"
        }
    }
}