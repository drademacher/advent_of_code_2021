import java.io.File
import java.util.Collections.max
import java.util.Collections.min
import kotlin.math.abs

object Day7 {
    fun solve() {
        val input = File("src/main/resources/day7.txt")
            .readText()
            .replace("\n", "")
            .split(",")
            .filter { it != "" }
            .map { it.toInt() }

        println("Part 1: ${partOne(input)}")
        println("Part 2: ${partTwo(input)}")
    }

    fun partOne(input: List<Int>): Int {
        return (min(input)..max(input))
            .map { goal -> Pair(goal, input.sumOf { abs(it - goal) }) }
            .minByOrNull { it.second }!!
            .second
    }

    fun partTwo(input: List<Int>): Int {
        return (min(input)..max(input))
            .map { goal -> Pair(goal, input.sumOf { gauss(abs(it - goal)) }) }
            .minByOrNull { it.second }!!
            .second
    }

    private fun gauss(n: Int): Int = n * (n + 1) / 2
}

fun main() {
    Day7.solve()
}