package main.base

interface BaseAction {
    /**
     * 在接口中申明属性。接口中的属性要么是抽象的，要么提供访问器的实现。接口属性不可以有后备字段。而且访问器不可以引用它们。
     */
    val uid: Int

    var date: String

    fun doAction()
    fun getResult(): String

}