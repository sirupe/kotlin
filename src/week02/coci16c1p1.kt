import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.PI

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val mb_X = reader.readLine().toInt()
    val months = reader.readLine().toInt()
    var used = 0
    for (i in 1..months) {
        used += reader.readLine().toInt()
    }
    val result = mb_X * (months + 1) - used
    writer.write(result.toString())
    writer.flush()
}