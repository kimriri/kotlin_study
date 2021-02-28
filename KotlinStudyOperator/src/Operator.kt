fun main(args: Array<String>) {
    printAllCaps("abc")
    printAllCapsNull(null)
    println(ElvisOperator("abc"))
    println(ElvisOperator(null))
    println(asOperator("a", 1))
    println(NeverNullOperator("123"))
//  println(NeverNullOperator(null))

}
// 안전한 호츨 연산 ?.
fun printAllCaps(s: String?) {
    val allCaps: String? = s?.toUpperCase()
    println("printAllCaps $allCaps")
}
fun printAllCapsNull(s: String?) {
    val allCaps: String? = s?.toUpperCase()
    println("printAllCapsNull $allCaps")
}

// 엘비스 연산자
fun ElvisOperator(s: String?): Int = s?.length ?: 0

// 안전한 캐스트 as
fun asOperator(a: String, b: Int) {
    val otheras0 = a as? String ?: "123"
    val otheras1 = b as? String ?: "123"
    println("otheras $otheras0")
    println("otheras1 $otheras1")
}

// 절대 null 이 아님!!
fun NeverNullOperator(s: String) {
    val a: String = s!!
    println("a $a")
}