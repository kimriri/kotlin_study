package sealedclass

object OtherThrowable: IOException()
// Compile error !
// object AnotherThrowable: SealedThrowable()