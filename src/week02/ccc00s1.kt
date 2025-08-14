import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.PI

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val machine_count = 3
    val coin_count = reader.readLine().trim().toInt()
    val reward_counts = intArrayOf(35, 100, 10)
    val bonus_coins = intArrayOf(30, 60, 9)

    val now_counters = IntArray(3) { reader.readLine().trim().toInt() }
    var leave_coin_count = coin_count
    var earn_coin_count = 0
    var l = 0
    while (leave_coin_count > 0) {
        if (leave_coin_count >= 3) {
            // reward_counts, bonus_coins 로깅
            val lotation_count = leave_coin_count / machine_count
            leave_coin_count = leave_coin_count % machine_count
            for (i in 0..2) {
                now_counters[i] += lotation_count
                val earn_coin = (now_counters[i] / reward_counts[i]) * bonus_coins[i]
                if (earn_coin > 0) {
                    now_counters[i] %= reward_counts[i]
                }
                leave_coin_count += earn_coin
                earn_coin_count += earn_coin
            }
        } else {
            val c = leave_coin_count
            for (i in 1..c) {
                leave_coin_count -= 1
                if (now_counters[i - 1] == 1) {
                    leave_coin_count += bonus_coins[i]
                    now_counters[i - 1] = 0
                }
            }
        }
    }

    val result = earn_coin_count + coin_count
    writer.write("Martha plays $result times before going broke.")
    writer.flush()
}