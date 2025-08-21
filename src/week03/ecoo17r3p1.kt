import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun solve() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    // 판매량 (문자열 배열)
    for (i in 1..10) {
        val (f, d) = reader.readLine().split(" ").map { it.toInt() }
        val sales = Array(d) { reader.readLine().split(" ").map { it.toInt() }.toIntArray() }
        val result = ecoo17r3p1(sales)
        writer.write("$result\n")
    }
    writer.flush()
}

fun ecoo17r3p1(sales: Array<IntArray>): Int {
    val dozen = 13
    var bonus = 0
    // sales [0] 번째 배열의 크기만큼 intarray 만들기
    val francise_sum = IntArray(sales[0].size)
    for (sale in sales) {
        val daily_sum = sale.sum()
        if (daily_sum % dozen == 0) {
            bonus += daily_sum / dozen
        }
        for (i in 0 until francise_sum.size) {
            francise_sum[i] += sale[i]
        }
    }
    for (i in 0 until francise_sum.size) {
        if (francise_sum[i] % dozen == 0) {
            bonus += francise_sum[i] / dozen
        }
    }
    return bonus
}

fun test() {
    val sales = arrayOf(
        intArrayOf(4, 3, 2, 4),
        intArrayOf(3, 3, 2, 1),
        intArrayOf(8, 2, 4, 1),
        intArrayOf(2, 2, 4, 3),
        intArrayOf(9, 3, 2, 3)
    )
    val result = ecoo17r3p1(sales)
    println(result)
    check(result == 4)
    val sales2 = arrayOf(
        intArrayOf(4, 4, 4, 1),
        intArrayOf(1, 1, 3, 4)
    )
    val result2 = ecoo17r3p1(sales2)
    println(result2)
    check(result2 == 1)
    println("test passed")
}

fun main() {
    // test()
    solve()
}