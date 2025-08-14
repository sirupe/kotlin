import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.PI

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val r = reader.readLine().toInt()
    val h = reader.readLine().toInt()
    val result = (PI * r * r * h) / 3.0
    writer.write(result.toString())
    writer.flush()
}