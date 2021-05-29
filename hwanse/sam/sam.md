
### SAM 이란?
추상 메서드가 하나만 있는 인터페이스를 함수형 인터페이스 또는 SAM(Single Abstract Method) 인터페이스라고 부른다.     
함수형 인터페이스는 비 추상적(non-abstract) 메버를 가질 수 있지만 오직 하나의 추상 멤버를 가질 수 있다.    

```kotlin
fun interface KRunnable {
    fun invoke()
}
```

<br><br>

### SAM Conversion 
SAM Conversion은 자바로 작성된 함수형 인터페이스에서만 동작하게 된다. 자바와의 상호 운영성 측면에서 나오게 되었으며,     
코틀린에서는 자바처럼 함수형 인터페이스를 사용하는 것이 아닌 함수 타입으로 선언이 가능하다.     
함수형 인터페이스의 경우에는 람다 식을 활용하면 코드를 더 간결하고 읽기 쉽게 사용할 수 있다.

함수형 인터페이스의 구현체를 만드는 대신에 람다 식으로 대체가 가능하고, SAM Conversion을 통해서 Kotlin은 인터페이스의    
단일 추상 메서드와 일치하는 모든 람다 식을 변환하여 인터페이스 구현을 동적으로 인스턴스화할 수 있다.    

```kotlin
fun interface IntPredicate {
    fun accept(i: Int): Boolean
}
```

```kotlin
// 객체식을 활용한 구현체 인스턴스 생성
var isEven = object: IntPredicated {
    override fun accept(i: Int): Boolean {
        return i % 2 == 0
    }
}
```

```kotlin
// 람다를 활용한 인스턴스 생성
val isEven = IntPredicate { it % 2 == 0 }
```

<br>

**람다식과 익명 객체 사이에 차이**    
객체를 명시적으로 선언(객체 식 홯용)하는 경우엔 메서드를 호출할 때마다 새로운 객체가 생성되는 반면에,     
람다식은 호출할 때마다 반복 재사용한다,

<br><br>
