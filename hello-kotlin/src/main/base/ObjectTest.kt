package main.base

import java.util.*

open class A1(val x: Int) {
    public open val y: Int = 0
}

interface B1 {}

val a_b: A1 = object : A1(1), B1 {
    override val y: Int
        get() = 2
}

/**
 * 请注意，匿名对象可以用作只在本地和私有作用域中声明的类型。如果你使用匿名对象作为公有函数的返回类型或者用作公有属性的类型，那么该函数或属性的实际类型会是匿名对象声明的超类型，如果你没有声明任何超类型，就会是 Any。在匿名对象中添加的成员将无法访问。
 */
class C {
    // 私有函数，所以其返回类型是匿名对象类型
    private fun foo() = object {
        val x: String = "x"
    }

    // 公有函数，所以其返回类型是 Any
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x        // 没问题
//        val x2 = publicFoo().x  // 错误：未能解析的引用“x”
    }
}

/**对象声明不是一个表达式，不能用在赋值语句的右边。
 *
 * 注意：对象声明不能在局部作用域（即直接嵌套在函数内部），但是它们可以嵌套到其他对象声明或非内部类中。
 **/
object DateUtil {

    fun getDate(date: Date): String {
        return "2021-06-01"
    }

    fun getTime(date: Date): String {
        return "15:04"
    }
}

class D {
    companion object {
        val a = "123"
    }
}


fun main() {
    println(a_b.y)
    val x = object {
        var a: Int = 0
        lateinit var b: Battle
    }
    x.b = Battle()
    println(x.b.characters.asSequence().joinToString { it })
    println(DateUtil.getDate(Date()))
    println(D.Companion.a)

}
