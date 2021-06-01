package main.base

/**
 * data为声明数据类的关键字，必须书写在class关键字之前。
在没有结构体的时候，大括号{}可省略。
构造函数中必须存在至少一个参数，并且必须使用val或var修饰。

数据类不能是抽象、开放、密封或者内部的

Koltin要修改数据类的属性，若属性使用val修饰，则只能使用其独有的copy()函数。其作用就是：修改部分属性，但是保持其他不变，若用var修饰，也可以用Setter()函数修改，这一点和Java一样
 */
data class ResponsePo constructor(val code: Int, val msg: String) {
}

fun main() {
    val responsePo = ResponsePo(0, "success")
    println(responsePo.toString())
    val responsePo2 = responsePo.copy(msg = "やった")
    println(responsePo2.toString())
    /*  解构声明  */
    val (code, msg) = responsePo
    println("code=$code,msg=$msg")
}