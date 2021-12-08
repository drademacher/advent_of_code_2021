import java.io.File

object Day8 {
    private val zero: Display = setOf(1, 2, 3, 5, 6, 7)
    private val one: Display = setOf(3, 6)
    private val two: Display = setOf(1, 3, 4, 5, 7)
    private val three: Display = setOf(1, 3, 4, 6, 7)
    private val four: Display = setOf(2, 3, 4, 6)
    private val five: Display = setOf(1, 2, 4, 6, 7)
    private val six: Display = setOf(1, 2, 4, 5, 6, 7)
    private val seven: Display = setOf(1, 3, 6)
    private val eight: Display = setOf(1, 2, 3, 4, 5, 6, 7)
    private val nine: Display = setOf(1, 2, 3, 4, 6, 7)
    private val allDisplays = setOf(zero, one, two, three, four, five, six, seven, eight, nine)
    private val displayToIntMapping = hashMapOf(zero to 0, one to 1, two to 2, three to 3, four to 4, five to 5, six to 6, seven to 7, eight to 8, nine to 9)

    fun solve() {
        val input = parse(File("src/main/resources/day8.txt").readText())

        println("Part 1: ${partOne(input)}")
        println("Part 2: ${partTwo(input)}")
    }

    fun parse(readText: String) = readText
        .split("\n")
        .filter { it != "" }
        .map { it.replace(" | ", " ").split(" ").map { it.split("").sorted().joinToString("") } }

    fun partOne(input: List<List<String>>): Int {
        return input
            .map { it.slice((10..13)).map { it.length }.filter { listOf(2, 4, 3, 7).contains(it) } }
            .flatten()
            .size
    }

    fun partTwo(input: List<List<String>>): Int {
        return input.sumOf { decodeOneInputLine(it.slice((0..9)), it.slice((10..13))) }
    }

    private fun decodeOneInputLine(uniqueSignals: List<String>, output: List<String>): Int {
        for (a in 1..7) {
            for (b in 1..7) {
                if (b == a) continue
                for (c in 1..7) {
                    if (c == a || c == b) continue
                    for (d in 1..7) {
                        if (d == a || d == b || d == c) continue
                        for (e in 1..7) {
                            if (e == a || e == b || e == c || e == d) continue
                            for (f in 1..7) {
                                if (f == a || f == b || f == c || f == d || f == e) continue

                                val g = 28 - (a + b + c + d + e + f)

                                val translationMapping = hashMapOf("a" to a, "b" to b, "c" to c, "d" to d, "e" to e, "f" to f, "g" to g)

                                val resultOfMapping = uniqueSignals
                                    .map { signal -> toDisplay(signal, translationMapping) }
                                    .toSet()

                                if (resultOfMapping == allDisplays) {
                                    return output
                                        .map { signal -> toDisplay(signal, translationMapping) }
                                        .map { display -> displayToIntMapping[display]!! }
                                        .joinToString("")
                                        .toInt()
                                }
                            }
                        }
                    }
                }
            }
        }

        throw IllegalStateException("Could not solve $uniqueSignals, $output")
    }

    private fun toDisplay(signal: String, mapping: HashMap<String, Int>) = signal.split("").filter { it != "" }.map { mapping[it]!! }.toSet()
}

typealias Display = Set<Int>

fun main() {
    Day8.solve()
}