import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.PI

fun writeAnswer(answer: String) {
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    writer.write(answer.toString())
    writer.flush()
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val num1 = reader.readLine().toInt()
    val num2 = reader.readLine().toInt()
    val num3 = reader.readLine().toInt()
    val num4 = reader.readLine().toInt()
    if (num1 != 8 && num1 != 9) {
        writeAnswer("answer")
        return
    }
    if (num4 != 8 && num4 != 9) {
        writeAnswer("answer")
        return
    }
    if (num2 != num3) {
        writeAnswer("answer")
        return
    }
    writeAnswer("ignore")

}