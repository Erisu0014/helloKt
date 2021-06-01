package main.base

/**
 * 所谓受限的类继承结构，即当类中的一个值只能是有限的几种类型，而不能是其他的任何类型。
这种受限的类继承结构从某种意义上讲，它相当于是枚举类的扩展。但是，我们知道Kotlin的枚举类中的枚举常量是受限的，因为每一个枚举常量只能存在一个实例。
但是其和枚举类不同的地方在于，密封类的一个子类可以有可包含状态的多个实例。
也可以说成，密封类是包含了一组受限的类集合，因为里面的类都是继承自这个密封类的。但是其和其他继承类（open）的区别在，密封类可以不被此文件外被继承，有效保护代码。但是，其密封类的子类的扩展是是可以在程序中任何位置的，即可以不在同一文件下。


好处：有效的保护代码
在使用when表达式 的时候，如果能够验证语句覆盖了所有情况，就不需要为该语句再添加一个else子句了。
 */
sealed class SealedExpr {
    data class Kyaru(val id: String = "10043", override var hp: Long?, override var tp: Int?) : PrincessA(hp, tp) {
        init {
            println("こちみなん～")
        }

        fun ub() {
            println("じろじろみるんじゃいわよ～")
        }
    }

    object NeRu : SealedExpr() // 寝る
    object oKiRu : SealedExpr()  // 起きる
}

object MiZuKyaRu : SealedExpr()

fun SealedExpr.NeRu.neru() {
    println("スヤスヤ")
}

fun SealedExpr.NeRu.neru(user: String) {
    println("一緒に寝ませんか？$user")
}


fun main() {
    SealedExpr.Kyaru(hp = 31109L, tp = 100).ub()
    SealedExpr.NeRu.neru()
    SealedExpr.NeRu.neru("Erisu")
}