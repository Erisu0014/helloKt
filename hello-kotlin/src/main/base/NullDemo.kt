package main.base

class Builder {
    private var name: String? = "erisu"
    private var age: Int? = 12
    private var kira: Boolean = true
    fun setName(name: String): Builder? {
        this.name = name
        return this
    }

    fun setAge(age: Int): Builder? {
        this.age = age
        return this
    }

    fun setKira(kira: Boolean): Builder? {
        this.kira = kira
        return this
    }

    override fun toString(): String {
        return "Builder(name=$name, age=$age, kira=$kira)"
    }


}

fun main() {
    val a: Int?
    a = 10
    println("a为可空变量，a被赋值为$a")
    // 判空
    var b: Int?
    b = null
    println("b==null?${b == null}")
    // 使用符号?.判断
    val kokkoro: PrincessA?
    kokkoro = null
    println("kokkoro.hp=${kokkoro?.hp}")
    // 链式调用
    val builder: Builder? = Builder()
    println("builder=${builder.toString()}")
    val testStr: String? = null
    val result = testStr?.length?.plus(5)?.minus(10)
    println(result)
    // 当一个函数/方法有返回值时，如果方法中的代码使用?.去返回一个值，那么方法的返回值的类型后面也要加上?符号
    println("testStr的长度为${testStr?.length}")
    // let操作符
    // let操作符的作用：当时用符号?.验证的时候忽略掉null
    // let的用法：变量?.let{ … }
    val arrTest: Array<Int?> = arrayOf(1, 2, null, 3, 4, null, null, 5)


    arrTest.forEach { it?.let { print("$it\t") } }
    println()
    // Elvis操作符
    // ?: 这个操作符表示在判断一个可空类型时，会返回一个我们自己设定好的默认值.
    // !! 这个操作符表示在判断一个可空类型时，会显示的抛出空引用异常（NullPointException）.
    // as? 这个操作符表示为安全的类型转换.
    val test: String? = null
    var length = if (test != null) test.length else -1
    println("length=$length")
    length = test?.length ?: -1
    println("length=$length")
    // 分析：此操作符一般和?.操作符连用。当且仅当?:左边的表达式为null时，才会执行?:右边的表达式。
    // !!操作符可谓是给爱好空引用异常（NullPointException）的开发者使用，因为在使用一个可空类型变量时，在该变量后面加上!!操作符，会显示的抛出NullPointException异常
//    println("length=${test!!.length}")
    // 其实这里是指as操作符，表示类型转换，如果不能正常转换的情况下使用as?操作符。
    // 当使用as操作符的使用不能正常的转换的情况下会抛出类型转换（ClassCastException）异常，而使用as?操作符则会返回null,但是不会抛出异常
//    val num1: Int? = "0" as Int
//    println("num1=$num1")
    val num1: Int? = "0" as? Int
    println("num1=$num1")
    //
    //项目中会抛出空引用异常（NullPointerException）的情况
    //
    //
    //
    //  在可空类型变量的使用时，用了!!操作符
    //  显式抛出空引用异常 throw NullPointerException()
    //  外部Java代码导致的
    //  对于初始化，有一些数据不一致(如一个未初始化的this用于构造函数的某个地方)
    //
    //
    //
    //项目中会抛出类型转换异常（ClassCastException）的情况
    //
    //
    //
    //  在类型转换中使用了as操作符
    //  使用了toXXX()方法不能转换的情况下
    //  外部Java代码导致的
    //
    //
    //
    //尽量避免使用的操作符
    //
    //
    //
    //  尽可能的不要使用!!操作符，多使用?:、?.操作符，以及let{}函数
    //  尽可能的使用as?操作符去替换掉as,在不确定是否可以安全转换的情况下不使用toXXX()方法
    //


}