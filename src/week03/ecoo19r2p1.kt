import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun solve() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    for (i in 1..10) {
        val n = reader.readLine().toInt()
        val emails = Array(n) { reader.readLine() }
        val result = ecoo19r2p1(emails)
        writer.write("$result\n")
    }
    writer.flush()
}

fun test() {
    val emails = arrayOf(
        "foo@bar.com",
        "fO.o+baz123@bAR.com",
        "foo@bar..com"
    )
    val result = ecoo19r2p1(emails)
    println(result)
    check(result == 2)
    val emails2 = arrayOf(
        "c++@foo.com",
        "c...@Foo.com",
        ".c+c@FOO.COM"
    )
    val result2 = ecoo19r2p1(emails2)
    println(result2)
    check(result2 == 1)
    println("test passed")
}

fun ecoo19r2p1(emails: Array<String>): Int {
    val result = 0
    // set 준비
    val email_set = mutableSetOf<String>()
    for (email in emails) {
        // 소문자 변환
        val lower_case_email = email.lowercase()
        val (local_part, domain_part) = lower_case_email.split("@")
        val converted_local_part = local_part.replace(".", "").split("+")[0]
        val result_email = "$converted_local_part@$domain_part"
        email_set.add(result_email)
    }
    // email_count 가 가장 큰 값 찾기
    return email_set.size
}

fun main() {
    // test()
    solve()
}