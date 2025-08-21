import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun solve() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val n = reader.readLine().trim().toInt()
    repeat(n) {
        // read "m k" with robust tokenization
        var line: String
        do {
            line = reader.readLine() ?: ""
        } while (line.isBlank())
        val st = StringTokenizer(line)
        val m = st.nextToken().toInt()
        val k = st.nextToken().toInt()

        // read m words
        val words = MutableList(m) { reader.readLine().trim() }

        // solve one dataset
        cco99p2(words, k)
    }
}

fun toOrdinal(number: Int): String {
    val suffix = when {
        number % 100 in 11..13 -> "th"
        number % 10 == 1 -> "st"
        number % 10 == 2 -> "nd"
        number % 10 == 3 -> "rd"
        else -> "th"
    }
    return "$number$suffix"
}

fun test() {
    // 서수 test
    check(toOrdinal(1) == "1st")
    check(toOrdinal(2) == "2nd")
    check(toOrdinal(3) == "3rd")
    check(toOrdinal(4) == "4th")
    check(toOrdinal(11) == "11th")
    check(toOrdinal(12) == "12th")
    // 문제 test
    val ordinalNumber = 2
    val words = mutableListOf("the", "brown", "the", "fox", "red", "the", "red")
    val result = cco99p2(words, ordinalNumber)
    val ordinalNumber2 = 3
    val words2 = mutableListOf("the")
    val result2 = cco99p2(words2, ordinalNumber2)
    val ordinalNumber3 = 1
    val words3 = mutableListOf("the", "wash")
    val result3 = cco99p2(words3, ordinalNumber3)
    println("test passed")
}

fun cco99p2(words: MutableList<String>, ordinalNumber: Int) {
    println("${toOrdinal(ordinalNumber)} most common word(s):")
    val counts = LinkedHashMap<String, Int>()
    for (w in words) counts[w] = (counts[w] ?: 0) + 1
    val sorted = counts.entries.toList().sortedByDescending { it.value }
    val distinctFreqs = sorted.map { it.value }.distinct()
    val target = distinctFreqs.getOrNull(ordinalNumber - 1)

    if (target != null) {
        sorted.filter { it.value == target }
              .forEach { println(it.key) }
    }
    println()

    // 재 제출 필요
}

fun main() {
    // test()
    solve()
}