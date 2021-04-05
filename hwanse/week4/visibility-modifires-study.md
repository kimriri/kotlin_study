## 가시성 변경자 (Visibility Modifiers)    
class, object, interface, constructor, function, property 과 property 의     
setter 는 가시성 변경자를 가질 수 있으며, getter 는 항상 property 의 동일한 가시성을 가진다

<br>

종류
- private
- protected
- internal
- public (default)

자바와는 다르게 코틀린에서는 `internal` 이 있으며 자바에는 없는 키워드이다.     
internal은 모듈을 기준으로 하기 때문에 모듈은 보통 여러 패키지들로 이루어져 있다.    
따라서 바이트코드에서는 internal 은 public이 된다.

<br>

|변경자|클래스 멤버|최상위 선언|
|---|---|---|
|public|모든 곳에서 볼 수 있다|모든 곳에서 볼 수 있다|
|internal|같은 모듈 안에서만 볼 수 있다|같은 모듈 안에서만 볼 수 있다|
|protected|하위 클래스 안에서만 볼 수 있다|최상위 선언에 적용 할 수 없다|
|private|같은 클래스 안에서만 볼 수 있다|같은 파일 안에서만 볼 수 있다|

예외적으로 `protected`는 클래스, 함수, 인터페이스 등에서는 `protected` 로     
선언이 불가하여 사용하려 하면 컴파일 오류를 낸다.

```kotlin
// 아래와 같은 방식으로 protected 로 선언이 불가함 (컴파일 에러)
protected class Person

protected fun foo() {}

protected var test = ""

// 아래와 같은 클래스 멤버 안에서는 protected 사용이 가능
class Factory {
    protected var item = ""
    
    protected fun make() {
        print("make..")
    }
}
```

<br>









