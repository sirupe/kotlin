import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.PI

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val n = reader.readLine().toInt()
    val yesterday = reader.readLine()
    val today = reader.readLine()
    val count = yesterday.zip(today).count {
        (t, y) -> t == 'C' && t == y
    }
    writer.write(count.toString())
    writer.flush()
}