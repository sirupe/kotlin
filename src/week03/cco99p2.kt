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

    // 1) 단어별 빈도수 세기 (첫 등장 순서 유지)
    val counts = LinkedHashMap<String, Int>()
    for (w in words) counts[w] = (counts[w] ?: 0) + 1

    // 2) frequency -> 해당 frequency 가진 단어 수
    val freqCount = HashMap<Int, Int>()
    for (c in counts.values) freqCount[c] = (freqCount[c] ?: 0) + 1

    // 3) 각 frequency f에 대해 "더 높은 frequency 가진 단어 개수"
    val greaterCount = HashMap<Int, Int>()
    var cumulativeHigher = 0
    for (f in freqCount.keys.sortedDescending()) {
        greaterCount[f] = cumulativeHigher
        cumulativeHigher += freqCount[f]!!
    }

    // 4) 순위 판정: (#더 큰 단어 개수 == k-1)인 단어들을 입력 순서대로 출력
    val targetHigher = ordinalNumber - 1
    for ((word, cnt) in counts) {
        if (greaterCount[cnt] == targetHigher) {
            println(word)
        }
    }

    println()
}

fun main() {
    // test()
    solve()
}