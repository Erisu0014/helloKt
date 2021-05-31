package main.base

/**
 * kotlin接口支持多implement，我们用super<接口名>.方法名来区分
 */
class Fight(override val uid: Int, override var date: String) : BaseAction {
    init {
        println("uid=$uid,op date=$date")
    }

    override fun doAction() {
        println("ok here we go again")
    }

    override fun getResult(): String {
        return if (Math.random() > 0.5) "success" else "failure"
    }
}

fun main() {
    Fight(1269732086, "2021-05-31").doAction()
}