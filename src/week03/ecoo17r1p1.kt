import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun test() {
    val cost = 4000
    val student_ratio = doubleArrayOf(0.5, 0.2, 0.1, 0.2)
    val student_count = 400
    val result = ecoo17r1p1(cost, student_ratio, student_count)
    println("TC1 : $result")
    check(result == "YES")
    val cost2 = 6000
    val student_ratio2 = doubleArrayOf(0.1, 0.1, 0.45, 0.35)
    val student_count2 = 2000
    val result2 = ecoo17r1p1(cost2, student_ratio2, student_count2)
    println("TC2 : $result2")
    check(result2 == "NO")
    val cost3 = 1815
    val student_ratio3 = doubleArrayOf(0.31, 0.30, 0.19, 0.20)
    val student_count3 = 401
    val result3 = ecoo17r1p1(cost3, student_ratio3, student_count3)
    println("TC3 : $result3")
    check(result3 == "NO")
    println("test passed")
}


val PRICE_GRADE = arrayOf(12, 10, 7, 5)

fun ecoo17r1p1(cost: Int, student_ratio: DoubleArray, student_count: Int): String {
    val grade_counts = IntArray(4)
    val price_counts = IntArray(4)
    var biggest_student_ratio_index = 0
    for (i in 0..3) {
        grade_counts[i] = (student_count * student_ratio[i]).toInt()
        price_counts[i] = PRICE_GRADE[i] * grade_counts[i]
        if (student_ratio[i] > student_ratio[biggest_student_ratio_index]) {
            biggest_student_ratio_index = i
        }
    }
    val sum = grade_counts.sum()
    if (student_count > sum) {
        val left = student_count - sum
        grade_counts[biggest_student_ratio_index] += left
        price_counts[biggest_student_ratio_index] = PRICE_GRADE[biggest_student_ratio_index] * grade_counts[biggest_student_ratio_index]
    }
    val total_price = price_counts.sum()
    val spenable_price = total_price / 2
    return if (spenable_price < cost) "YES" else "NO"
}

fun main() {
    // test()
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    for (i in 1..10) {
        val cost = reader.readLine().toInt()
        val student_ratio = reader.readLine().split(" ").map { it.toDouble() }.toDoubleArray()
        val student_count = reader.readLine().toInt()
        val result = ecoo17r1p1(cost, student_ratio, student_count)
        writer.write(result + "\n")
    }
    writer.flush()
}
