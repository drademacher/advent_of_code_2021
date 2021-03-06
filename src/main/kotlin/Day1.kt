import java.io.File

object Day1 {
    fun solve() {
        val input = parseInput(File("src/main/resources/day1.txt").readText())

        println("Part 1: ${partOne(input)}")
        println("Part 2: ${partTwo(input)}")
    }

    fun parseInput(readText: String) = readText
        .split("\n")
        .map { it.toInt() }

    fun partOne(input: List<Int>): Int {
        return (0..input.size - 2)
            .filter { input[it + 1] > input[it] }
            .size
    }

    fun partTwo(input: List<Int>): Int {
        val measurements = (0..input.size - 3)
            .map { input[it] + input[it + 1] + input[it + 2] }
        return partOne(measurements)
    }
}

fun main() {
    Day1.solve()
}