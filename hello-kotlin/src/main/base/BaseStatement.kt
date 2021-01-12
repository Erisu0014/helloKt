package main.base

// kt基本语句学习
fun main() {
    // if
    val a = 123
    val b = 123
    //在Kotlin中其实是不存在三元运算符(condition ? then : else)这种操作的。
    //那是因为if语句的特性(if表达式会返回一个值)故而不需要三元运算符。
    println(if (a == b) "a==b" else "a!=b")
    // if作为一个块元素
    val num = if (a > b) {
        a
    } else if (a < b) {
        b
    } else {
        a + b
    }
    println("num=>$num")
    //Kotlin废除了Java中的for(初始值;条件；增减步长)这个规则。但是Kotlin中对于for循环语句新增了其他的规则，来满足刚提到的规则。
    //  for循环提供迭代器用来遍历任何东西
    //  for循环数组被编译为一个基于索引的循环，它不会创建一个迭代器对象
    //
    // 递增
    for (i in 0 until 5) {
        print("i=>$i\t")
    }
    println()
    // 递减
    for (i in 15 downTo 10) {
        print("i=>$i\t")
    }
    println()
    // 符号（' .. '） 表示递增的循环的另外一种操作
    for (i in 20..25) { // 包括25
        print("i=>$i\t")
    }
    println()
    for (i in 20 until 25) { // 不包括25
        print("i=>$i\t")
    }
    println()
    // 设置步长
    for (i in 20..30 step 3) {
        print("i=>$i\t")
    }
    println()
    // 遍历字符串
    for (i in "abcdefg") {
        print("i=>$i\t")
    }
    println()
    // 遍历数组
    for (i in arrayOf("1", 2, "3", 4.78f)) {
        print("i=>$i\t")
    }
    println()
    // 使用数组的indices属性遍历
    val arr = arrayOf("1", 2, "3", 4.78f)
    for (i in arr.indices) {
        print("arr[$i]=>${arr[i]}")
    }
    println()
    // 使用数组的withIndex()方法遍历
    for ((i, v) in arr.withIndex()) {
        print("index=$i,v=$v\t")
    }
    println()
    // 迭代器遍历
    val iterator: Iterator<Any> = arr.iterator()
    while (iterator.hasNext()) {
        print(iterator.next())
    }
    //foreach
    arr.forEach { println(it) }


    // when语句
    when (5) {
        1, 2, 3 -> println("condition=1|2|3")
        5 -> println("condition=5")
        else -> {
            println("default error")
        }
    }
    val num_a = 5
    when (num_a > 5) {
        true -> print("num_a>5")
        false -> print("num_a<=5")
        else -> {
            println("default error")
        }
    }
    println()
    // 检查值是否在集合或数组中
    when (123) {
        in arr -> print("123 存在于arr中")
        in 0..10 -> print("123存在0-10")
        !in 0..10 -> print("123不存在0-10中")
    }
    // 检查值是否为指定类型的值
    when (arr[1]) {
        is String -> print("abc type is double")
        !is String -> print("abc type is not double")
    }
    // 不使用when的表达式 表示为最简单的布尔表达式
    when {
        true -> {
            arr.forEach { print(it) }
        }
        false -> {
        }
    }
    // while其同Java中的while循环一样。在此不做累述。
    // do while其同Java中的do...while循环一样。在此不做累述。
    // return语句 默认情况下，从最近的封闭函数或匿名函数返回。
    // break continue同java
}