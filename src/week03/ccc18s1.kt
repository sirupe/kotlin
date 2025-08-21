import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

// 파라미터로 int 배열 (village) 받기
fun ccc18s1(villages: IntArray): Double {
    // viliages 배열 1번째 방부터 마지막 방 - 1 까지 반복
    villages.sort()
    var current_length = Double.MAX_VALUE
    for (i in 1..(villages.size - 2)) {
        val left = villages[i - 1].toDouble()
        val right = villages[i + 1].toDouble()
        val current = villages[i].toDouble()
        val calculated = ((current - left) / 2) + ((right - current) / 2)
        if (calculated < current_length) {
            current_length = calculated
        }
    }
    // 소수점 한자리까지만 표시
    return current_length
}

fun test() {
    val villages = intArrayOf(16, 0, 10, 4, 15)
    val result = ccc18s1(villages)
    println(result)
    check(result == 3.0)
    val villages2 = intArrayOf(2, 9, 15, 25)
    val result2 = ccc18s1(villages2)
    println(result2)
    check(result2 == 6.5)
    val villages3 = intArrayOf(0, 5, 10, 15)
    val result3 = ccc18s1(villages3)
    println(result3)
    check(result3 == 5.0)
    println("test passed")
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = reader.readLine().toInt()
    val viliages = IntArray(n)
    for (i in 0 until n) {
        viliages[i] = reader.readLine().toInt()
    }
    val result = ccc18s1(viliages)
    writer.write("%.1f".format(result))
    writer.flush()
    // test()
}