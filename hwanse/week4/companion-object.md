## object 키워드를 주로 사용하는 상황
- 객체 선언(Object declaration) - 싱글턴 객체와 연관됨
- 동반 객체(companion object) - java의 static 한 필드와 메소드와 연관됨
- 객체 표현식(object expression)은 자바의 무명 클래스 대신 쓰인다

<br>

## Object Declaration (객체 선언)
자바에서는 싱글턴 패턴을 구현할 때 보통 해당 클래스의 생성자를 `private`으로 제한하고 정적인 필드에       
그 클래스의 유일한 객체 인스턴스를 저장하도록 구현한다.    

코틀린에서는 `object` 키워드를 사용해 객체 선언을 통해 싱글턴 구현을 기본 지원해준다. 객체 선언은 클래스 정의와 클래스의       
인스턴스를 생성해 변수에 저장하는 모든 작업을 한 문장으로 처리가 가능하다.     
클래스와 마찬가지로 객체 선언 안에도 속성, 함수, 초기화 블록 등 정의가 가능하고, 반면에 생성자는 사용 불가하다.     
일반 클래스의 인스턴스와 달리 싱글턴 객체이고 객체 선언문이 있는 위치에서 생성자 호출 없이 즉시 만들어지며,      
그렇기 때문에 객체 선언에는 생성자 정의가 필요가 없는 것이다.

```kotlin
object Payroll {
    val allEmployees = arrayListOf<Person>()
    
    fun calculateSalary() {
        // 로직
    }
}
```

<br>

## Object Expressions (객체 표현식)
특정 타입을 상속한 익명 클래스의 오브젝트를 생성하는 방법이다.      
예로 들어 자바의 익명 클래스를 정의하는 것과 유사하다고 볼 수 있다.

```kotlin
window.addMouseListener(object : MouseAdapter() {
    
    override fun mouseEntered(e: MouseEvent?) {
        super.mouseEntered(e)
    }

    override fun mouseClicked(e: MouseEvent?) {
        super.mouseClicked(e)
    }
    
})
```

상위 타입에 생성자가 있고 생성자 매개 변수 있다면 매개변수를 전달 해주어야 하며, 또한 후행에 `,`로 구분하고      
새로운 타입을 명시하면 상위 타입으로 다양한 타입 지정이 가능해진다.      

```kotlin
open class Apple(input: Int) {
    public open val count: Int = input
}

interface Fruit { /*...*/ }

val ab: Apple = object : Apple(1), Fruit {
    override val count = 15
}
```

단순한 오브젝트로써 사용한다면 아래와 같이 사용
```kotlin
class Points {
    val point = object {
        var x: Int = 0
        var y: Int = 0
    }
    
    fun printPoint() {
        print("#{po} ")
    }
}
```

단, 익명 오브젝트는 private 선언에서만 `타입`으로써 사용될 수 있으며, 익명 오브젝트를 public함수의     
리턴 타입으로 쓰거나 public property 의 타입으로 쓰면 둘의 실제 타입은 익명 객체에서 선언된 상위 타입(supertype)     
이 되거나 supertype 을 선언하지 않은 경우엔 `Any`타입이 된다.

```kotlin
class C {
    // private 함수: 리턴 타입은 익명 객체의 타입입니다.
    private fun foo() = object {
        val x: String = "x"
    }

    // public 함수: 리턴 타입은 Any입니다.
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x // 제대로 동작함.
        val x2 = publicFoo().x // 에러: Unresolved reference 'x'.
    }
}
```

<br>

object expression 과 object declaration 의 의미적 차이

- 객체 표현식은 사용되는 곳에서 즉시 초기화 된다.
- 객체 선언은 처음 엑세스 할 때 lazy 하게 초기화된다.
- companion object는 해당 클래스가 로드 될 때 초기화되며, java의 static initializer 의 의미와 동일



<br>

## Companion Object (동반자 객체)
자바와 C#과는 달리 코틀린에는 static 멤버 변수나 함수가 없다. 코틀린에서 클래스의 인스턴스화 없이 static 처럼      
클래스 내부에 접근하고 싶다면, `companion` 식별자를 붙이 object 를 선언하여 사용한다.

companion object 를 사용하면 static 멤버들을 호출하던 것 처럼 해당 객체를 사용 가능하다.
단, 클래스당 한 개만 가질 수 있다.
또한 companion object 의 이름은 생략이 가능하고, 이 경우엔 Companion 라는 식별자로 사용한다.

```kotlin
class MyClass {
    companion object {
        fun create(): MyClass = MyClass()
    }
}

var my = MyClass.Companion

fun main() {
    val instance = MyClass.create()
}
```

companion object 멤버가 static 으로 선언된 변수 처럼 보이긴 하지만 companion object 는 클래스 안에 정의된 일반 객체이다.     
따라서 companion object 에 이름을 붙이거나 인터페이스를 상속하여 구현하는 행위가 가능하다.      
단, @JvmStatic 애노테이션과 함께 사용되면 예외다.

```kotlin
interface Factory<T> {
    fun create(): T
}

class MyClass {
    companion object : Factory<MyClass> {
        override fun create(): MyClass = MyClass()
    }
}
```

<br>

## static 사용하는 방법
1) const val 사용
코틀린에서 const val 을 이용하여 변수를 만들면 자바의 public static final 같이 사용이 가능하다.
단, const 선언은 String타입과 Primitive타입에서만 사용이 가능하다.
   

2) 코틀린의 object + @JvmStatic 
코틀린의 object 키워드를 사용하는 것은 자바에서의 static 이랑 다른 부분이 존재하기 때문에 @JvmStatic 을 조합한다.     
이 애노테이션은 static 멤버를 컴파일러에게 getter,setter 함수를 자동으로 만들도록 힌트를 주는 역할과 비슷하다.          
이 애노테이션이 적용된 멤버들에 경우에는 컴파일러는 선언된 필드와 메소드를 바로 자바의 정적 메소드로 노출되게끔 만든다.     
(자바와의 상호 운용성과 관련되는 부분)
   

2) object  사용
object declaration 또는 companion object 를 활용하여 싱글턴 객체를 형성하고 static class 로 사용하는 방법이다.           
이 방법을 사용하면 java 에서 static 관련 멤버들을 집합시킨 클래스와 비슷한 형태로 코드를 구현이 가능하다
