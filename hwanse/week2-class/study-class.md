 
## Class
<br>

#### **클래스 선언 방법**

- `class` 키워드 를 사용하여 선언
- 클래스명, 클래스 헤더(매개변수, 주 생성자), 중괄호로 둘러싸인 Body 로 구성된다
- 클래스에 헤더, Body 는 선택사항으로 없으면 생략이 가능하다

```kotlin
class Sample(name: String) {
   /* ... */
}

class Foo
```
<br>


**클래스 구성**
1. 생성자, 초기화 블록
2. 함수
3. 속성
4. 중첩, 내부 클래스
5. Object


<br>
<br>
<br>

#### **주 생성자**    

- 생성자는 `construct` 키워드를 사용
- kotlin 클래스에는 `주 생성자` 및 하나 이상의 `보조 생성자`가 있을 수 있다
- 주 생성자는 클래스 헤더의 일부로 클래스명 뒤에 위치한다
- 그러나 주 생성자에 주석이나 가시성 변경자가 없으면 `construct` 키워드 생략이 가능하다 

```kotlin
class Car constructor(name: String) {
    /* ... */
}

class Wheel private constructor(var count: Int = 4) {
    /* ... */
}


class Sample(name: String) {
    
    init {
        name = "newName"
    }
}

// 주 생성자에서 var, val 사용시 속성 선언 및 동시에 초기화 가능
class Person(
    val fistName: String,
    val lastName: String,
    val age: Int,
)
```

<br>
<br>
<br>

#### **초기화 블록**

- 초기화 블록은 `init` 키워드를 사용한다
- 인스턴스 초기화 과정중에 클래스 속성 값 초기화 및 초기화 블록은 본문의 순서대로 진행된다.

```kotlin
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
```

<br>
<br>
<br>

#### **보조 생성자**

- 보조 생성자 또한 `constructor` 키워드를 사용한다
- 주 생성자와 달리 보조 생성자에서는 `constructor` 키워드를 생략할 수 없다.
- 주 생성자가 있을 경우 반드시 각 보조 생성자를 통해 직접 또는 간접적으로 주 생성자에 생성을 위임해야한다.
- 동일한 클래스에서 다른 생성자에 대한 위임은 `this` 키워드를 사용하여 수행한다
- 초기화 블록과 속성 초기화는 보조 생성자의 본문보다 먼저 실행된다 

```kotlin
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
```

<br>
<br>
<br>

#### **중첩 및 내부 클래스**

자바에서의 내부 클래스와 코틀린에서의 내부 클래스는 다소 다른 내용이 있다.    
자바에서는 클래스 안에 새로운 클래스를 정의하면 자동으로 내부 클래스이지만         
코틀린에서는 이를 중첩 클래스라 부르고, 내부 클래스로 만들고 싶다면 `inner` 키워드로 선언해야한다

<br>

**중첩 클래스(Nested Classes)**

- 클래스는 다른 클래스에 중첩 될 수 있다
- 인터페이스와 클래스를 조합하여 중첩 구조를 만들 수 있다

<br>

자바 예시
```java
class Outer {
    
    // 내부 클래스
    class InnerClazz{
    
    }   

    // 자바에서 중첩 클래스 처럼 사용하려면 static 키워드를 붙인다
    static class Inner {
    
    }

}
```

<br>

코틀린 예시
```kotlin
class Outer {
    val name: String = "test"

    class Inner {
        fun foo() : Int {
          return 1
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
```

<br>
<br>

**내부 클래스(Inner Classes)**
- `inner` 키워드를 사용하여 내부 클래스임을 명시할 수 있다
- `inner` 키워드를 사용하여 만든 중첩 클래스는 외부 클래스 멤버에 접근이 가능하다
- 내부 클래스는 외부 클래스를 항상 참조하고 있다. (메모리 누수의 원인)

```kotlin
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
```

<br>

#### 내부 클래스와 메모리 누수의 관계성
객체가 삭제되는 시점은 객체가 더 이상 사용되지 않을 때 삭제된다. 그러나 내부 클래스를 사용하게 될 경우     
항상 외부 클래스의 메모리를 참조하고 있기 때문에 내부 클래스 객체가 적절한 시점에 삭제되지 못한다.     
따라서 내부 클래스의 사용은 메모리 누수에 원인을 제공하고, 컴파일 시점에 확인할 수 없다.

만약 내부 클래스가 외부 클래스 멤버를 접근해서 사용하고 있지 않다면 더더욱 `inner` 키워드를 사용할 필요가 없으며         
내부 클래스를 사용해야하는 명확한 이유가 없다면 내부 클래스 사용하지 않는 것을 권장.