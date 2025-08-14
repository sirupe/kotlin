import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.PI
import java.util.LinkedList

fun moveSong(song_list: LinkedList<String>, button_number: Int) {
    when (button_number) {
        1 -> song_list.addLast(song_list.removeFirst())
        2 -> song_list.addFirst(song_list.removeLast())
        3 -> song_list.add(1, song_list.removeAt(0))
        4 -> song_list
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val song_list = LinkedList(listOf("A", "B", "C", "D", "E"))
    var button_number = 0
    var click_count = 0
    while (button_number != 4) {
        button_number = reader.readLine().toInt()
        click_count = reader.readLine().toInt()

        // A, B, C, D, E 의 5개의 노래. 위치 변경 가능.
        // 버튼 1: 재생목록의 첫 곡을 맨 뒤로 보냄
        // 버튼 2: 재생목록의 마지막 곡을 맨 앞으로 보냄
        // 버튼 3: 재생목록의 첫 두 곡을 서로 교환
        // 버튼 4: 입력 종료 및 현재 재생목록을 출력
        for (i in 1..click_count) {
            moveSong(song_list, button_number)
        }
    }
    // A B C D E 형태로 출력
    writer.write(song_list.joinToString(" "))
    writer.flush()
}