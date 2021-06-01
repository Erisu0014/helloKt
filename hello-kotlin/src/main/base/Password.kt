package main.base

/**
 * 有时候，业务逻辑需要围绕某种类型创建包装器。然而，由于额外的堆内存分配问题，它会引入运行时的性能开销。此外，如果被包装的类型是原生类型，性能的损失是很糟糕的，因为原生类型通常在运行时就进行了大量优化，然而他们的包装器却没有得到任何特殊的处理。
 */
interface I
inline class Password(val value: String) : I {
    val length: Int
        get() = value.length

    fun clear() {
        println("password is cleared now")
    }

    fun asInline(f: Password) {}
    fun <T> asGeneric(x: T) {}
    fun asInterface(i: I) {}
    fun asNullable(i: Password?) {}

    fun <T> id(x: T): T = x
}

fun main() {
    val password = Password("sadahkfka")
    println(password.toString())
    password.clear()
    println(password.length)
}