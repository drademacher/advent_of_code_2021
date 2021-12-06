import java.io.File

object Day6 {
    fun solve() {
        val input = File("src/main/resources/day6.txt")
            .readText()
            .replace("\n", "")
            .split(",")
            .filter { it != "" }
            .map { it.toInt() }

        println("Part 1: ${partOne(input)}")
        println("Part 2: ${partTwo(input)}")
    }

    fun partOne(inputs: List<Int>): Long {
        return lanternfish(inputs, 80)
    }

    fun partTwo(input: List<Int>): Long {
        return lanternfish(input, 256)
    }

    private fun lanternfish(inputs: List<Int>, days: Int): Long {
        var current = Array(9) { 0L }
        var next: Array<Long>

        for (input in inputs) {
            current[input] += 1L
        }

        for (i in 1..days) {
            next = Array(9) { if (it < 8) current[it + 1] else 0 }
            next[8] += current[0]
            next[6] += current[0]
            current = next
        }

        return current.sum()
    }

}

fun main() {
    Day6.solve()
}