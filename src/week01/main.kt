fun q01() {
    val a = 5
    val b = 2.5
    println(a + b)
}

fun q02() {
    val s = "Kotlin"
    println("Hello $s!")
}

fun q03() {
    val isDone = false
    println(isDone::class)
}

fun q04() {
    val a = 'A'
    println("$a, " + a::class)
}

fun q05() {
    val x = 1.23
    println(x::class)
}

fun q06() {
    println(Int.MAX_VALUE)
}

fun q07() {
    val a = """
    abc
    cde
    123
    """
    println(a)
}

fun q08() {
    val x = 1
    println("Value is: ${x + 1}")
}

fun q09() {
    val score = 90
    println(if (score >= 90) "A" else if (score >= 80) "B" else "C")
}

fun q10() {
    for (i in 1..3) {
        println(i)
    }
}

fun q11() {
    var i = 0
    while (i < 4) {
        println(i)
        i++
    }
}

fun q12() {
    for (i in 2..10 step 2) {
        println(i)
    }
}

fun q13() {
    val text = "banana"
    val count = text.count { it == 'a' }
    println(count)
}

fun q14() {
    var num = 0
    for (i in 1..9 step 2) {
        num += i
        print("$num ")
    }
    println()
}

fun q15() {
    val n = 7
    val result = if (n % 2 == 0) "even" else "odd"
    println(result)
 }

fun q16() {
   println((1..10).sum())
}

fun q17() {
    for (i in 17 downTo 1) {
        println(i)
    }
}

fun main() {
    q01()  // 7.5
    q02()  // Hello Kotlin!
    q03()  // class kotlin.Boolean
    q04()  // A, class kotlin.Char
    q05()  // class kotlin.Double
    q06()  // 2147483647
    q07()
    q08()  // Value is: 2
    q09()  // a
    q10()  // 1  2  3
    q11()  // 0  1  2  3
    q12()  // 2  4  6  8  10
    q13()  // 3
    q14()  // 1 4 9 16 25
    q15()  // odd
    q16()  // 55
    q17()
}