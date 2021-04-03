------------------------------------------
#[함수 기본]
```java
int max(int a, int b) {
    return if(a>b) a else b
}
```

```kotlin
fun max(a:Int, b:Int):Int {
    return if(a>b) a else b
}
```

자바와 다르게 코틀린은 fun 키워드를 통해 함수를 선언한다.

fun 다음에는 함수 이름이 온다. (return 타입은 파라미터의 뒤에 오게 된다.)

```kotlin
fun max(a:Int, b:Int):Int = if(a>b) a else b
```

자바와는 다르게 식이 본문인 함수도 만들 수 있다.

```kotlin
fun max(a:Int, b:Int) = if(a>b) a else b
```

식이 본문인 함수의 경우는 반환 타입을 적지 않아도 컴파일러가 분석하여 반환 타입을 정한다.

```java
int max(int a, int b) {
    return if(a>b) a else b
}

max(1, 2)
```

```kotlin
fun max(a:Int, b:Int):Int {
    return if(a>b) a else b
}

max(b=2, a=1) == max(1, 2)
```

코틀린은 파라미터 이름을 명시하여 전달할 수 있다.

```kotlin
fun max(a:Int, b:Int = 2):Int {
    return if(a>b) a else b
}

max(1)
```

코틀린은 디폴트 파라미터 값을 지정할 수 있다.

----------------

코틀린의 소스파일에 타겟 패키지에 넣을 함수를 선언하면

자바 컴파일러는 이를 코틀린의 소스 파일 이름을 클래스로 생성하고

해당 소스 파일의 함수를 클래스의 정적인 메소드로 만들어 준다.

즉 코틀린 파일의 모든 최상위 함수는 해당 클래스의 정적 메소드가 된다.

---------------------

함수와 마찬가지로 프로퍼티도 파일의 최상위 수준에 놓을 수 있다.

이런 프로퍼티의 값은 정적 필드에 저장된다.

이를 활용해서 코드에 상수를 추가할 수 있다.

하지만 접근자 메소드를 통해 노출되므로 겉으로만 상수처럼 보인다.

그렇기 때문에 상수로 만들고 싶으면 const 변경자를 사용하면 된다.

------------------------

#[확장 함수]
```kotlin
fun String.lastChar():Char = this.get(this.length-1)
```

코틀린은 확장이라는 개념을 통해 메소드를 다른 클래스에 추가할 수 있다.

확장 함수는 어떤 클래스의 멤버 메소드처럼 호출할 수 있지만

그 클래스의 밖에서 선언된 함수이다.

확장 함수를 만드려면 추가하려는 함수 이름 앞에 함수가 확장할 클래스 이름을 붙이면 된다.

그러한 클래스 이름을 수신 객체 타입이라 부르며
(위의 예시에서는 String)

확장 함수가 호출되는 대상이 되는 값을 수신 객체라고 부른다.
(위의 예시에서는 this / 생략 가능하다)

호출 구문은 다른 일반 클래스 멤버를 호출하는 구문과 똑같다.
(위의 예시라면 "Kotlin".lastChar())

즉 기존의 클래스에 새로운 메소드를 추가하는 것과 같다.


```kotlin
inline fun String.trim(): String = (this as CharSequence).trim().toString()
```

확장 함수(데코레이터 = 어떤 객체를 꾸며주는 추가 기능) => 데코레이터 패턴을 대체

원래는 외부로 감싸면서 기능들을 추가하지만, 코틀린의 확장 함수는 바로바로 주입가능

receiver(수신자)에 원하는 함수이름을 쓰면 됨 = 수신함수라고도 함

this가 성립하게 됨(클래스 내부에 정의된 메서드 처럼 사용가능)

CharSequence가 많은 기능 가짐(String이 상속받음)

첫번째 인자로 객체를 받는 함수로 치환됨(String의 인스턴스를 받겠죠?)

---------


확장 함수는 캡슐화를 깰 수 없다.

클래스 안에서 정의한 메소드와는 다르게 클래스 내부에서만 사용할 수 있는

private, protected 멤버를 사용할 수 없다.

확장 함수를 사용하기 위해서는 그 함수를 임포트해야 한다.

임포트 시에 as 키워드를 사용하면 클래스나 함수를 다른 이름으로도 부를 수 있다.

(import strings.lastChar as last로 임포트하면 "Kotlin".last()로 사용 가능)

확장 함수는 오버라이드 할 수 없다. (정적으로 결정하기 때문)

파일이나 문의 위치로 컴파일하고 관리하던 때와 다름(클래스에 메소드 추가하려면?)

=> 상속 확장해야되는데... 그럼 타입이 바뀌잖아...

결국 추가적으로 추가하는 방법은 이런 확장 함수 뿐이다! (라이브러리에 따라 다르게 가능 / 컴파일 시에만 확정된다!)

---------
#[인라인 함수]

인라인 함수 (함수호출을 줄여줌)

함수를 많이 호출하면 연산이 많아짐

연산을 줄이고 메모리 할당을 많이 가져감 (메모리와 연산을 교환)

코틀린은 이러한 인라인 함수를 적극적으료 사용하는 언어(스칼라, C, GO 보다도 더)

다른 언어와 가장 큰 차이점이라고 볼 수도 있음(코틀린의 함수 철학에서 중요한 부분 차지)


[인라인 화 이전]
```kotlin
fun pass(v:Int, block:(Int)->Int) = block(v)

println("${pass(3){it*2}}")
```

```javascript
function main$lamda(it) {
    return it*2|0;
}
function pass(v, block) {
    return block(v);
}
println(pass(3, main$lamda).toString());
```

코틀린에서 인라인 함수가 될 수 있는 조건 = 함수의 인자에 람다가 와야 함(람다 부분이 인라인 화)



[인라인 화 이후]
```kotlin
inline fun pass(v:Int, block:(Int)->Int) = block(v)

println("${pass(3){it*2}}")
```

```javascript
println((3*2|0).toString());
```

inline fun () 으로 하면 컴파일 줄어든다 (콜에 대한 부하가 사라짐) => 여러 번 호출해도 부담X

가장 최적화된 형태의 문이 되어버리기 때문에 걱정 없음

```kotlin
inline fun ifTrue(v:Boolean, block:()->Unit) {if(v) block()}

ifTrue(true){
    println("true")
}
```

```javascript
if(true){
    println('true');
}
```

=> 함수를 만들어서 쌩 난리를 쳐도 가장 최적화된 제어문으로 나타남

---------
#[코틀린 인라인 함수]

코틀린 인라인 함수(코틀린 스펙/표준 함수) => 기본패키지
외우는 것이 좋다(문법처럼 알도록)

[코틀린 기본 패키지의 인라인 함수]
```kotlin
inline fun TODO(): Nothing
inline fun TODO(reason: String): Nothing
inline fun <R> run(block: () -> R): R
inline fun <T, R> T.run(block: T.() -> R): R
inline fun <T, R> with(receiver: T, block: T.() -> R): R
inline fun <T> T.apply(block: T.() -> Unit): T
inline fun <T> T.also(block: (T) -> R): T
inline fun <T, R> T.let(block: (T) -> R): R
inline fun <T> T.takeIf(predicate: (T) -> Boolean): T?
inline fun <T> T.takeUnless(predicate: (T) -> Boolean): T?
inline fun repeat(times: Int, action: (Int) -> Unit)
```

[순수 함수 계열]
```kotlin
inline fun TODO(): Nothing
inline fun TODO(reason: String): Nothing
inline fun <R> run(block: () -> R): R
inline fun <T, R> with(receiver: T, block: T.() -> R): R
inline fun repeat(times: Int, action: (Int) -> Unit)
```

[수신 함수 계열]
```kotlin
inline fun <T, R> T.run(block: T.() -> R): R
inline fun <T> T.apply(block: T.() -> Unit): T
inline fun <T> T.also(block: (T) -> R): T
inline fun <T, R> T.let(block: (T) -> R): R
inline fun <T> T.takeIf(predicate: (T) -> Boolean): T?
inline fun <T> T.takeUnless(predicate: (T) -> Boolean): T?
```
T형에 대한 수신함수 (T는 제네릭이니까 모든 타입 가능)
(어떠한 객체/형 모두 가능)
어떤 객체를 작성하든 붙일 수 있다!
코틀린의 제네릭은 Nullable이므로 정말 다 붙일 수 있음




[인라인 함수의 람다(블록)에서 리턴한 값이 함수의 리턴값인 경우]
```kotlin
inline fun <R> run(block: () -> R): R
inline fun <T, R> T.run(block: T.() -> R): R
inline fun <T, R> with(receiver: T, block: T.() -> R): R
inline fun <T, R> T.let(block: (T) -> R): R
```

[원래 수신했던 객체를 그대로 리턴하는 경우]
```kotlin
inline fun <T> T.apply(block: T.() -> Unit): T
inline fun <T> T.also(block: (T) -> R): T
inline fun <T> T.takeIf(predicate: (T) -> Boolean): T?
inline fun <T> T.takeUnless(predicate: (T) -> Boolean): T?
```
메서드 체이닝 같음(본인 자신을 그대로 리턴해줌)

----------
[TODO 함수]
```kotlin
inline fun TODO(): Nothing
inline fun TODO(reason: String): Nothing
```

TODO는 무조건 쓰로우함

```kotlin
fun mock() {
    TODO("....")
}

mock()
```

mock() 호출하는 순간 쓰로우하고 죽음 (컴파일은 됨 / 마킹을 위해서 사용)

인텔리제이가 코드제너레이팅 할때 본문을 투두로 박아줌

개인적인 사용성은 떨어짐

----------
[run 함수]
```kotlin
inline fun <R> run(block: () -> R): R
inline fun <T, R> T.run(block: T.() -> R): R
```

```kotlin
val run0 = run {
    val a = 3
    val b = 5
    a+b
}
```
람다가 리턴하는 값이 이 함수의 리턴값 (8)
람다는 마지막에 오는 값이 리턴값(함수에서 return을 반드시 해줘야하는 것과 다름)

```kotlin
val run1 = 15.run {
    this + 10
}
```
수신함수는 this 사용가능 (10)

나의 리턴 타입을 컴파일러가 확정하게 하기 위해 자주 사용 (return 기술 불필요)



--------
[with 함수]
```kotlin
inline fun <T, R> with(receiver: T, block: T.() -> R): R
```

with는 순수한 함수지만
수신할 인자를 받음(수신 람다를 사용 => 람다는 수신 함수)

```kotlin
val list1 = mutableListOf<String>()
val with1 = with(list1) {
    this.addAll("1,2,3,4,5,6,7".split(","))
    this[0]
}
```

-----------------
[apply 함수]
```kotlin
inline fun <T> T.apply(block: T.() -> Unit): T
```

apply는 자신에게 무엇인가를 막 하고 자기 자신을 리턴(함수 체이닝)
수신함수니까 this 사용가능
트랜잭션 효과를 가지게 됨

```kotlin
val apply1 = mutableListOf(1,2,3).apply{
    forEachIndexed { idx, v ->
        this[idx] = v * 2
    }
}
```
원래라면 apply1을 이용해서 변화를 줘야하는데
apply1을 확정하는 순간 이미 모든 작업이 끝남(간섭 불가)


----------
[also 함수]
```kotlin
inline fun <T> T.also(block: (T) -> R): T
```

also는 인자로 T가 들어옴, apply는 this로 받음

```kotlin
val also1 = mutableListOf(1,2,3).also{
    it.forEachIndexed { idx, v ->
        it[idx] = v * 2
    }
}
```

----------
[let 함수]

```kotlin
inline fun <T, R> T.let(block: (T) -> R): R
```

```kotlin
val v1:Int? = null
if(v1 != null) println("널아님")
```

```kotlin
val v1:Int? = null
v1?.let{ println("$it 널아님") }
```

let은 nullable과 밀접한 관련이있고 많이 사용됨
T가 null이면 안의 block이 실행되지 않고 곧장 null 리턴함
T가 null이 아니면 안의 block을 실행하고 그 리턴값을 리턴함

즉 if(a==null) 같은 코드가 사라지고 전부 let으로 바뀜

```kotlin
val v2 = v1?.let{double(it)} ?: 0
```

?:은 엘비스 오퍼레이터(엘비스 옆으로 누운거 같이 생김)
앞이 null일때 뒤가 작동함
0대신 throw 넣어도됨 (nothing이기 때문에 끝남)
즉 Int거나 nothing인게 되는게 아니라 Int

elvis 연산자때문에 null로 오는게 처리하기 편함

---------
[takeIf, takeUnless 함수]
```kotlin
inline fun <T> T.takeIf(predicate: (T) -> Boolean): T?
inline fun <T> T.takeUnless(predicate: (T) -> Boolean): T?
```

```kotlin
val takeList = mutableListOf(1,2,3)
val takeIf0 = if(takeList.size > 2) takeList else null
val takeIf1 = takeList.takeIf { it.size > 2 }
```

takeIf는 true라고 판단하면 T를 주고 false라고 판단하면 null줌
Unless는 위의 반대(루비 문법)


--------
[repeat 함수]
```kotlin
inline fun repeat(times: Int, action: (Int) -> Unit)
```

```kotlin
var i = 0
while(i<10){
    println(i)
    i++
}
```

(0~9까지 출력됨)

```kotlin
repeat(10){
    println(it)
}
```

repeat은 while이나 for문 같은것 대체(숫자 0 부터 그 숫자 전까지)



---------

위의 코틀린 인라인 함수들을 이용하면

builder 패턴도 더 간단하게 작성할 수 있게 된다.
