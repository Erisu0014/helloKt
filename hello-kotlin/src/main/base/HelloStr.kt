package main.base

fun main() {
    var str: String? = null
    println("str[0]=${str?.firstOrNull()}")
    str = "nmsl wdnmd"
}