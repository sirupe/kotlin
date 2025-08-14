import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.PI

fun swap(arr: Array<Int>, code: Char) {
    when (code) {
        'A' -> arr[0] = arr[1].also { arr[1] = arr[0] }
        'B' -> arr[1] = arr[2].also { arr[2] = arr[1] }
        'C' -> arr[0] = arr[2].also { arr[2] = arr[0] }
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val input = reader.readLine()
    val arr = arrayOf(1, 0, 0)
    for (s in input) {
        swap(arr, s)
    }
    val result = arr.indexOf(1) + 1
    writer.write(result.toString())
    writer.flush()
}