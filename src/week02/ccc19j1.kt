import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun calcScore(reader: BufferedReader): Int {
    var totalScore = 0 
    for (i in 3 downTo 1) {
        totalScore += i * reader.readLine().toInt()
    }
    return totalScore
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val aScore = calcScore(reader)
    val bScore = calcScore(reader)
    val result = if (aScore == bScore) "T" else if (aScore > bScore) "A" else "B"
    writer.write(result)
    writer.flush()
}