fun main() {

    val person: Person = Person("test", 20, "010-1234-1234")

    println("Name : ${person.name}")
    println("Age : ${person.age}")
    println("Phone : ${person.phone}")

    val Food = Food("육류")

}


class Person(var name: String) {
    var age: Int = 0
    var phone: String = ""

    constructor(name: String, age: Int) : this(name) {
        println("Call Name, Age Constructor")
        this.age = age
    }

    constructor(name:String, age: Int, phone: String) : this(name, age) {
        println("Call Name, Age, Phone Constructor")
        this.age = age
        this.phone = phone
    }
}

class Food(type: String) {
    var name = "firstName"
    var count = 0
    var length = type.length

    init {
        println("첫번째 초기화 $type")
        name = "Name2"
        count = 100
    }

    init {
        println("두번째 초기화 $type")
        name = "Name3"
        count = 500
    }

}

class Outer {
    val name: String = "test"

    class Inner {
        fun foo() : String {
            //return name  - 외부 참조를 가지고 있지 않아서 컴파일 에러
            return "testName"
        }
    }

    inner class InnerClass {
        fun foo() : String {
            return name
        }
    }

}

interface OuterInterface {
    class InnerClass(var name: String)

    interface InnerInterface
}

class OuterClass {
    class InnerClass

    interface InnerInterface
}

