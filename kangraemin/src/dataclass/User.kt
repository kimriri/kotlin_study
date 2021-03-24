data class User(val name: String, var age: Int)

open class UserSuperClass {
    final override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    final override fun hashCode(): Int {
        return super.hashCode()
    }

    final override fun toString(): String {
        return super.toString()
    }
}
