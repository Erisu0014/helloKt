package main.base

enum class BattleType(var battleName: String) {
    /**
     * 每个枚举常量都包含两个属性：name（枚举常量名）和ordinal（枚举常量位置）
     */
    JJC("竞技场") {
        // 匿名类
        override fun toString(): String {
            return "battleType:${JJC.battleName}"
        }
    },
    PJJC("公主竞技场") {
        override fun toString(): String {
            return "battleType:${PJJC.battleName}"
        }
    },
    GURANBATORU("公会战") {
        override fun toString(): String {
            return "battleType:${GURANBATORU.battleName}"
        }
    }
}

fun main() {
    println(BattleType.JJC.toString())

    println(BattleType.JJC.name)
    println(BattleType.JJC.ordinal)
    println(BattleType.JJC.battleName)
    println(enumValues<BattleType>().joinToString { it.battleName.plus("..") })
    /**
     * 若使用Color.valueOf("不存在的枚举常量")，则会抛出IllegalArgumentException 异常，即枚举变量不存在。若使用Color.values()[大于枚举常量位置]，则会抛出下标越界异常。
     */
    println(enumValueOf<BattleType>("JJC"))
    println(BattleType.valueOf("PJJC"))
    println(BattleType.values()[0])
    println(BattleType.values()[2])


}