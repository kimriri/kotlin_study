fun main() {

}

fun sampleCodeForDefaultDataClassFunction() {
    val user = User(name = "rams", age = 29)

    // Get property 확인
    println("----Get property 확인----")
    println(user.age) // 29
    println(user.name) // rams

    // Set property 확인
    println("----Set property 확인----")
    user.age = 30 // val 로 선언된 property 에서는 Compile error ( var / val 차이 )
    println(user) // User(name=rams, age=30)
    user.age = 29
    println(user) // User(name=rams, age=29)


    // toString 함수 확인
    println("----toString 함수 확인----")
    println(user) // User(name=rams, age=29)
    println(user.toString()) // User(name=rams, age=29)

    // equals 함수 확인
    println("----equals 함수 확인----")
    val sameUser = User(age = 29, name = "rams")
    val otherUser = User(age = 20, name = "rams")
    println(user == sameUser) // true
    println(user == otherUser) // false
    println(user === sameUser) // false

    // hashCode 확인
    println("----hashCode 확인----")
    val hashSet = mutableSetOf<User>()
    hashSet.add(user)
    println(user.hashCode() == sameUser.hashCode()) // true
    println(hashSet.contains(sameUser)) // true

    // ComponentN 확인
    println("----ComponentN 확인----")
    println(user.component1()) // rams
    println(user.component2()) // 29

    // destructuring declarations 확인
    println("----destructuring declarations 확인----")
    val (name, age) = user
    println(name) // rams
    println(age) // 29

    val (ageTest) = user
    println(ageTest) // rams

    // Compile error
    // val (name, age, error) = user

    // copy 확인
    println("----copy 확인----")
    val copiedUser = user.copy(name = "RAMS")
    val sameCopiedUser = user.copy()
    println(copiedUser) // User(name=RAMS, age=29)
    println(user == copiedUser) // false
    println(user == sameCopiedUser) // true
    println(user.hashCode() == sameCopiedUser.hashCode()) // true
    println(user === sameCopiedUser) // false
}