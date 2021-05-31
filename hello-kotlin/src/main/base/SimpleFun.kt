package main.base

// 函数不是一等公民
// 在Kotlin中，函数的返回值类型可以分为：
//
// Unit类型：该类型即无返回值的情况，可以省略。
// 其他类型： 显示返回类型的情况
fun unitFun(): Unit {

}

// 对于默认参数，即使指一个函数中的参数具有默认值，这样在使用该函数的时候，可以省略一部分参数，可以减少函数的重载
fun intFun(name: String, flag: Int = 0): Int {
    return 1
}

//当该函数是一个成员函数时,并且该函数时复写继承类中的方法时，则该成员函数必须从签名中省略该函数的默认值。
open class A {
    open fun foo(i: Int = 10) {}
}

class B : A() {
    override fun foo(i: Int) {
        println(i)
    }
}

// 可变数量参数
//当一个函数中的参数是不定数量的个数并且是同一个类型，则可是使用vararg修饰符去修饰这个变量，则被vararg修饰的参数相当于一个固定类型的数组。
//声明格式：fun 函数名(vararg 参数名 ： 类型，…) ：返回值{}
fun varargFun(vararg gust: String) {

}

//单表达式函数：即函数具备返回值的时候，可以省略花括号并且在`=`赋值符号之后指定代码体，而函数的返回值是有编辑器自动推断的。
fun test1(num: Int) = num * 2


fun main() {
    intFun("erisu")
    intFun("megumi", 2)
    // 命名参数:即在使用函数时显示使用参数名 = 参数值这种方式传递参数
    intFun(name = "erisu", flag = 3)
    // 在传递参数值时，我们可以一个一个参数的传递，或者可以直接传递一个当前定义类型的数组。不过在传递数组时，请使用伸展操作符( * )
    varargFun("001", "002")
    var arr = arrayOf("001", "002")
    varargFun(*arr)


}