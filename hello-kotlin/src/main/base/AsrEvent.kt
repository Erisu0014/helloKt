//在构造函数不具有注解符或者默认的可见性修饰符时，constructor关键字可以省略。
//默认的可见性修饰符时public。可以省略不写。
class AsrEvent constructor(var userList: List<String>, val code: Int = 0, val msg: String?) {
    // 构造函数中不能出现其他的代码，只能包含初始化代码。包含在初始化代码块中。
    init {
        userList.forEach {
            print("$it\t")
            println()
        }
    }

    constructor(userList: List<String>, code: Int) : this(userList, code, null) {
        println("其他构造函数")
    }


}

//使用了val修饰的属性，不能有setter().
//  不管是val还是var修饰的属性，只要存在getter(),其值再也不会变化
//  使用var修饰的属性，可以省略掉getter(),不然setter()毫无意义。当然get() = field除外。而get() = field是Koltin默认的实现，是可以省略这句代码的。
//

fun main() {
    val asrEvent = AsrEvent(arrayListOf("123", "456"), msg = "123")
    asrEvent.userList = arrayListOf("456")
    println("msg info=${asrEvent.msg}")
            asrEvent.userList.forEach {
                print("$it\t")
                println()
            }
}