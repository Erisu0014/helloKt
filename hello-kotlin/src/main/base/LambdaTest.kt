package main.base

class LambdaTest {
    fun <T, R> Collection<T>.fold(
        initial: R,
        combine: (acc: R, nextElement: T) -> R,
    ): R {
        var accumulator: R = initial
        for (element: T in this) {
            accumulator = combine(accumulator, element)
        }
        return accumulator
    }
}

/**
 * 带与不带接收者的函数类型非字面值可以互换，其中接收者可以替代第一个参数，反之亦然。例如，(A, B) -> C 类型的值可以传给或赋值给期待 A.(B) -> C 的地方，反之亦然：

- 所有函数类型都有一个圆括号括起来的参数类型列表以及一个返回类型：(A, B) -> C 表示接受类型分别为 A 与 B 两个参数并返回一个 C 类型值的函数类型。 参数类型列表可以为空，如 () -> A。Unit 返回类型不可省略。

- 函数类型可以有一个额外的接收者类型，它在表示法中的点之前指定： 类型 A.(B) -> C 表示可以在 A 的接收者对象上以一个 B 类型参数来调用并返回一个 C 类型值的函数。 带有接收者的函数字面值通常与这些类型一起使用。

- 挂起函数属于特殊种类的函数类型，它的表示法中有一个 suspend 修饰符 ，例如 suspend () -> Unit 或者 suspend A.(B) -> C。
 */
val repeatFun: String.(Int) -> String = { t -> this.repeat(t) }
val twoParameters: (String, Int) -> String = repeatFun
fun runTransformation(f: (String, Int) -> String): String {
    return f("hello", 3)
}

fun main() {
    val items = listOf(2, 4, 6, 8, 10)
    items.fold(0) { acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        result
    }
    val joinedToString = items.fold("Element") { acc, i -> "$acc $i" }
    println(joinedToString)
    // 函数引用也可以用于高阶函数调用：
    val product = items.fold(1, Int::times)
    println(product)
    println(runTransformation(repeatFun))
}