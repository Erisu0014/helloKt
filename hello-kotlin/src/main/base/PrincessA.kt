package main.base

/**
 * 类型别名的定义必须在顶层声明
 */
typealias   PrincessB = PrincessA

open class PrincessA constructor(open var hp: Long? = 31109L, open var tp: Int? = 100) {

}
