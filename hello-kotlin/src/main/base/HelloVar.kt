package main.base

// 变量测试

// init
var var_a = 1.3
var var_b: Int = -1
// init 修饰还不是常量，它只能是一个不能修改的变量
val val_a = -1.3
val val_b: Double = 1.736840
//init nullable
var var_c: String? = null
// late init
//使用lateinit关键字
//  必须是可读且可写的变量，即用var声明的变量
//  不能声明于可空变量。
//  不能声明于基本数据类型变量。例：Int、Float、Double等，注意：String类型是可以的。
//  声明后，在使用该变量前必须赋值，不然会抛出UninitializedPropertyAccessException异常。
lateinit var princess: Princess
// lazy init
//使用lazy{}高阶函数，不能用于类型推断。且该函数在变量的数据类型后面，用by链接。
//必须是只读变量，即用val声明的变量。
val peko: Princess by lazy(::Princess)
// 常量const，const≠final,only primitives
const val const_a: Double = 114514.0

//const在顶层声明——常量，object类，伴生
//在object修饰的类中声明，在kotlin中称为对象声明，它相当于Java中一种形式的单例类
//在伴生对象中声明
object Megumi {
    const val name = "惠惠"
    val mona: Princess by lazy(::Princess)
}
class WangCai{
    companion object {
        const val name = "旺财"
    }
}

fun main() {
    println("var_a=$var_a \t var_b=$var_b")
    println("val_a=$val_a")
    println("var_c=$var_c")
    princess = Princess()
    princess.hp = 31109
    println(princess.tp)
    println("peko.hp=${peko.tp}")
    println("const_a=$const_a")
    println("megumi=${Megumi.name}")
    println("wangcai=${WangCai.name}")

}