package main.base

/**
 *
 * - 在Kotlin中的抽象类在顶层定义的时候只能使用public可见性修饰符修饰。
- 抽象类中可以定义内部抽象类。
- 只能继承一个抽象类。
- 若要实现抽象类的实例化，需要依靠子类采用向上转型的方式处理。
- 抽象类可以继承自一个继承类，即抽象类可以作为子类。不过，抽象类建议不用open修饰符修饰，因为可以覆写抽象类的父类的函数。

 */
open class Base {}

abstract class Language : Base() {
    val TAG = this.javaClass.simpleName

//    // 自身的函数
//    fun test(): Unit {
//        println("what it means")
//    }

    abstract var name: String    //  抽象属性
    abstract fun asdf()         //  抽象方法
    abstract class Country
}

class Chinese : Language() {
    override var name: String
        get() = "爱慕拆尼斯"
        set(value) {}

    override fun asdf() {
        println("tag=$TAG,name=$name")
    }
}

fun main() {
    println(Chinese().asdf())
}