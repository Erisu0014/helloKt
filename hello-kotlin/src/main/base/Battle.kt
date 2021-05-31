package main.base

/**
因为是默认的可见性修饰符且不存在任何的注释符
故而主构造函数constructor关键字可以省略
var表示变量（可读写），val表示常量（只读）
在构造函数不具有注解符或者默认的可见性修饰符时，constructor关键字可以省略.默认的可见性修饰符时public。可以省略不写。

如果类主构造函数的所有参数都具有默认值，编译器将生成一个额外的无参数构造函数，它将使用默认值

- public修饰符表示 公有 。此修饰符的范围最大。当不声明任何修饰符时，系统会默认使用此修饰符。
- internal修饰符表示 模块 。对于模块的范围在下面会说明。
- protected修饰符表示 私有`+`子类。值得注意的是，此修饰符不能用于顶层声明，在下面可以看到。
- private修饰符表示 私有 。此修饰符的范围最小，即可见性范围最低。

open表示该类是继承类
 **/
open class Battle constructor(
    var time: Double = 90.0,
    var characters: Array<String> = arrayOf("kokkoro", "kyaru", "PEKO")
) {

    /**
    属性可以用val或者var修饰。

    用var定义的属性是可读写的，即能用能改
    用val定义的属性是只读的，即不能被修改，只可使用
    属性必须在init之前定义才不会被弃用
    用lateinit修饰的属性，不能为基本类型。String不是基本类型
     */
    open lateinit var character: String

    /**
     *当用var修饰时，必须为属性赋默认值(特指基本数据类型，因为自定义的类型可以使用后期初始化属性，见后续)
    即使在用getter()的情况下,不过这样写出来，不管我们怎么去改变其值，其值都为`123`
     */
    open val battle_character_max = 5
        get() = field   // 这句可以省略，kotlin默认实现的方式
    var battle_time: Double? = null
        get() = field
        //    get() = 12.3
        /** 所谓后备属性，其实是对后备字段的一个变种，它实际上也是隐式的对属性值的初始化声明，避免了空指针。*/
        set(value) {
            field = if (value!! > 90.0) 90.0 else value
        }

    private var battle_characters: Array<String>? = null
        get() = field
        set(value) {
            field = value
        }
    open val isCached: Boolean
        get() = battle_characters?.size == 5

    /**
     * 构造函数中不能出现其他的代码，只能包含初始化代码。包含在初始化代码块中。
    关键字：init{…}
    值得注意的是，init{…}中能使用构造函数中的参数
     */
    init {
        this.battle_time = time
        this.battle_characters = characters
        println("time=$time,Characters=$characters")
    }


    constructor(time: Double, characters: Array<String>, type: String?) : this(time, characters) {
        println("time=$time,Characters=$characters,type=$type")
    }

    companion object {
        /** 对象的顶层或成员，即顶层声明。 */
        const val CONST_NUM = 10
    }

    open fun helloWorld() {
        println("hello world")
    }


}

class GroupBattle constructor(time: Double = 60.0, characters: Array<String> = arrayOf("chocomint")) :
    Battle(time, characters) {
    /**
     * 那么当一个基类去继承另外一个基类时，第二个基类不想去覆盖掉第一个基类的方法时，第二个基类的该方法使用final修饰符修饰。
     * */
    final override fun helloWorld() {
        super.helloWorld()
        println("グラントバトルhello world")
    }

    /**重写属性即指：在基类中声明的属性，然后在其基类的实现类中重写该属性，
    该属性必须以override关键字修饰，并且其属性具有和基类中属性一样的类型。且可以重写该属性的值(Getter)
    重写属性的时候慎用super关键字。
    当基类中属性的变量修饰符为val的使用，其实现类可以用重写属性可以用var去修饰。反之则不能。*/
    override var battle_character_max = 4
    fun helloWorld(hello: String) {
        super.helloWorld()
        println("グラントバトル$hello")
    }
}

fun main() {
    val battle = Battle(90.0, arrayOf("kokkoro", "kyaru", "PEKO"))
    println(battle.toString())
    println(Battle().toString())
    val battle2 = Battle(90.0, arrayOf("kokkoro", "kyaru", "PEKO"), "jjc")
    println(battle2.isCached)
//    battle2.battle_time = null
    println(GroupBattle().helloWorld("asdf"))

}

