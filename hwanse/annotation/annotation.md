
### Annotation이란?
annotation은 코드에 대한 메타 데이터를 붙이는 수단이다.

- annotation 선언 방법
```kotlin
annotation class Foo 
```

annotation 클래스에 annotation에 대한 추가 속성을 지정할 수 있다.

- @Target : annotation을 붙일수 있는 요소의 가능한 종류를 지정한다 (예 : 클래스, 함수, property, 표현식과 같은)

- @Retention : annotation이 컴파일된 클래스 파일에 남아있게 저장에 대한 여부와 런타임 시 리플렉션을 통해 표시되는지     
여부를 지정한다. (default로 둘 다 true)
  
- @Repeatable : 단일 요소에 동일한 annotation을 여러 번 사용이 가능해진다

- @MustBeDocumented :annotation이 공용 API의 일부이며 생성된 API 문서에 표시된 클래스 또는 메소드 서명에      
포함되어야 하는지에 대한 여부를 지정한다.
  

```kotlin
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, 
        AnnotationTarget.PROPERTY, AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class Foo
```

<br>

**기본 생성자에 주석 사용 방법**
```kotlin
annotation class Foo

class Bar @Foo constructor (a: Int) 
```
기본 생성자에 annotation을 달고싶다면 주의 사항이 있다.
원래 기본생성자는 `constructor` 키워드가 생략이 가능하지만 annotation을 달기 위해서 `constructor` 키워드를  선언하고    
그 앞에다 annotation을 달아주어야 한다.


<br>

### 생성자
annotation은 매개변수를 사용하는 생성자를 가질 수 있다

```kotlin
annotation class Foo(val a: String)

@Foo("test") class Bar
```
파라미터로 받을 수 있는 타입들은 다음과 같다

- 자바의 primitive type에 해당되는 type (예 : int, long, char ..)
- String
- class (MyClass::class)
- enum
- 다른 annotaion 들
- 위에 나열된 타입들에 대한 배열 ( arrayOf("foo", "test") )

**주의점**
JVM이 annotation 속성의 값으로 `null` 을 저장하지 못한다. 따라서 annotation 파라미터에는 nullable 타입을 쓸수 없다.     
만일 annotation 파라미터에 타입으로 다른 annotation이 오게된다면, 해당 annotation 이름의 접두사로 `@` 를 붙이지 않아도 된다.    

```kotlin
annotation class ReplaceWith(val expression: String)

annotation class Deprecated(
    val message: String,
    val replaceWith: ReplaceWith = ReplaceWith(""))

@Deprecated("This function is deprecated, use === instead", ReplaceWith("this === other"))
```

<br>

### Annotation 대상 (use-site targets)
코틀린 소스코드에서 한 선언을 컴파일한 결과가 여러 자바 선언과 대응하는 경우가 자주 있다. 예로들어 코틀린의 property선언은         
기본적으로 자바 필드와 게터/세터 매소드 선언과 대응한다. 따라서 이런 요소들에 annotation을 붙일 때 어떤 요소에 붙일지에 대한     
**대상**을 표시할 필요가 있다. 이를 **사용 지점 대상**을 선언한다하며 다음과 같이 사용한다.

```kotlin
annotation class Foo

class Bar {
    @get:Foo
    var a: String
}
```

사용 지점 대상을 지정할 때 지원하는 목록은 다음과 같다

- property: 프로퍼티 전체에 지정하는 의미이며, 이 Target은 자바에서 선언된 annotation에는 사용할 수 없다.
- field
- get
- set
- receiver: 확장 함수나 프로퍼티의 수신 파라미터
- param: 생성자 파라미터
- setparam: 세터 파라미터
- delegate: 위임 프로퍼티의 위임 인스턴스를 담아둔 필드
- file: 파일 안에 선언된 최상위 함수와 프로퍼티를 담아두는 클래스

<br>

### 코틀린과 자바의 Annotation
자바에서 선언된 annotation은 코틀린과 100% 호환이 된다.

````kotlin
class Tests {
    // apply @Rule annotation to property getter
    @get:Rule val tempFolder = TemporaryFolder()

    @Test fun simple() {
        val f = tempFolder.newFile()
        assertEquals(42, getTheAnswer())
    }
}
````