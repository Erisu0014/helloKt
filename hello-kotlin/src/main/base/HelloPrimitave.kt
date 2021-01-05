package main.base


// Byte=> 字节 => 8位
// Short => 短整型 => 16位
// Int => 整型 => 32位
// Long => 长整型 => 64位
// Float => 浮点型 => 32位
// Double => 双精度浮点型 => 64位
const val a: Byte = 65536.toByte()
const val b: Short = 10000
const val c: Int = 100000
const val d: Long = -100L
const val e: Float = 1.23444343F
const val f: Double = 1000000.0
// 进制
const val g = 0x1f
const val h = 0b1000000
const val k = 123
// 数字类型字面常量的下划线:分割数字进行分组，使数字常量更易读
const val homo_num = 11_4514
val homo by lazy { homo_num }
// 在Kotlin中，存在数字的装箱，但是不存在拆箱。
// 因为Kotlin是没有基本数据类型的，Kotlin是万般皆对象的原则。
// 故不存在和`Java`中的类似`int`是数据类型，`Integer`是整型的引用类型。
const val num: Double = 123.0
val num_2: Double? = num  // cant do const val
// 判断两个数值是否相等（==）,判断两个数值在内存中的地址是否相等（===）
// 经典常量缓存池 [-128,127]
const val num_128: Int = 128
val num_128_2: Int? = num_128
const val num_127: Int = 127
val num_127_2: Int? = num_127
// 较小的类型不会被隐式转换为更大的类型，故而系统提供了显式转换。
const val num_x = 120.toByte().toShort().toInt().toFloat().toDouble().toChar().toString()
// 隐式转换
val num_p = Math.cos(Math.PI / 1.0)
// 位运算
// shl(bits) => 有符号向左移 (类似Java的<<)
// shr(bits) => 有符号向右移 (类似Java的>>)
// ushr(bits) => 无符号向右移 (类似Java的>>>)
// and(bits) => 位运算符 and (同Java中的按位与)
// or(bits) => 位运算符 or (同Java中的按位或)
// xor(bits) => 位运算符 xor (同Java中的按位异或)
// inv() => 位运算符 按位取反 (同Java中的按位取反)
const val operaNum = 4
// boolean
const val isNum: Boolean = false
// 逻辑运算符
// || && !
// 字符型Char 不仅可以转换为数字，同时也可转换为其他类型，但也是拿的ASCII码的key
// 转义 same as java
// 字符串 常量不可变 所以字符串的元素可以通过索引操作的字符
// 字符串字面量
// 在Kotlin中， 字符串字面量有两种类型：
//
// 包含转义字符的字符串 转义包括（\t、\n等）,不包含转义字符串的也同属此类型
// 包含任意字符的字符串 由三重引号（""" …. """）表示
val str = "hello\tworld"
const val str2 = """\t\n\b任意字符func{}但是\不行"""
// 数组型
val arr = arrayOf(1, 2, "hello", isNum)
// nullable arr,需指定类型
val null_arr = arrayOfNulls<Boolean>(100)
// 工厂函数arr
// 使用一个工厂函数Array()，它使用数组大小和返回给定其索引的每个数组元素的初始值的函数。
// Array() => 第一个参数表示数组元素的个数，第二个参数则为使用其元素下标组成的表达式
val good_arr = Array(10) { i -> ((2 + Math.random()) * i).toString() }
// 原始数组类型
// ByteArray => 表示字节型数组
// ShortArray => 表示短整型数组
// IntArray => 表示整型数组
// LongArray => 表示长整型数组
// BooleanArray => 表示布尔型数组
// CharArray => 表示字符型数组
// FloatArray => 表示浮点型数组
// DoubleArray => 表示双精度浮点型数组
// Kotlin中不支持字符串类型这种原始类型数组，
// 可以看源码Arrays.kt这个类中并没有字符串数组的声明。而源码中StringArray这个类并不是声明字符串型数组的。

fun main() {
    println(" a => $a \n b => $b \n c => $c \n d => $d \n e => $e \n f => $f")
    println(" g => $g \n h => $h \n k => $k")
    println("homo_num => $homo")
    println("num_2 =>$num_2")
    println("num==num2=>${num == num_2}")
    println("num===num2=>${num === num_2}")
    println("num_128==num_128_2=>${num_128 == num_128_2}")
    println("num_128===num_128_2=>${num_128 === num_128_2}")
    println("num_127==num_127_2=>${num_127 == num_127_2}")
    println("num_127===num_127_2=>${num_127 === num_127_2}")
    println("num_x => $num_x") // result = x [ASCII]
    println("num_p => $num_p")
    println("shl oper => ${operaNum shl 2}")
    println("shr oper => ${operaNum shr 2}")
    println("ushr oper => ${operaNum ushr 2}")
    println("isNum =>$isNum")
//    println("\t\n\r\b\uFF00")
    println(str2)
    arr.forEach { print("$it\t") }
    println()
    good_arr.forEach { print("$it\t") }
//    null_arr.forEach { print("$it\t") }


}
