package main.base

import com.sun.org.apache.xpath.internal.operations.Bool

typealias Predicate<T> = (T) -> Boolean

fun test1(p: Predicate<Int>) = p(2)

fun test2(p: Predicate<String>) = p("hello")

val gtZero: Predicate<Int> = { it > 0 }

val equalsHomo: Predicate<String> = { it == "homo" }

typealias MutListData = MutableList<MutableList<Int>>

val item1 = mutableListOf(1, 3, 5, 7)

val item2 = mutableListOf(2, 4, 6, 8)

val data: MutListData = mutableListOf()

/**
 * 在开发中，处理Json字符串转换成实体类的时候，会出现属性名和关键字冲突的问题。下面实现Java与kotlin的解决方案。
 */
data class TestBean(
    val id: Int,
    val name: String,
    val `package`: String,
)

/**
 * sam接口
 */

fun interface IntPredicate {
    fun accept(i: Int): Boolean
}


fun main() {
    println(test1(gtZero))
    println(test2(equalsHomo))

    data.add(item1)
    data.add(item2)
    data.asSequence().flatMap { it.asSequence() }.forEach { print("value:$it  ") }

    val isEven = IntPredicate { it % 2 == 0 }
    println(isEven.accept(10))


}



