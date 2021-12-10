import java.io.File

object Day10 {
    fun solve() {
        val input = File("src/main/resources/day10.txt")
            .readText()
            .split("\n")
            .filter { it != "" }

        println("Part 1: ${partOne(input)}")
        println("Part 2: ${partTwo(input)}")
    }

    fun partOne(input: List<String>): Int {
        val evaluateError = hashMapOf(")" to 3, "]" to 57, "}" to 1197, ">" to 25137)
        var result = 0

        for (line in input) {
            val chars = line.split("").filter { it != "" }
            val stack = mutableListOf<String>()
            for (char in chars) {
                if (isChunkOpening(char)) {
                    stack.add(char)
                    continue
                }

                if (stack.isEmpty()) {
                    print("Input invalid, too many closing chunks")
                    break
                }

                val previous = stack.removeLast()
                if (!isCorresponding(previous, char)) {
                    result += evaluateError[char]!!
                }
            }
        }

        return result
    }

    fun partTwo(input: List<String>): Long {
        val evaluateError = hashMapOf("(" to 1, "[" to 2, "{" to 3, "<" to 4)

        val lineScores = mutableListOf<Long>()
        for (line in input) {
            val chars = line.split("").filter { it != "" }
            val stack = mutableListOf<String>()
            for (char in chars) {
                if (isChunkOpening(char)) {
                    stack.add(char)
                    continue
                }

                if (stack.isEmpty()) {
                    print("Input invalid, too many closing chunks")
                    break
                }

                val previous = stack.removeLast()
                if (!isCorresponding(previous, char)) {
                    stack.clear()
                    break
                }
            }

            if (stack.isNotEmpty()) {
                val lineScore = stack.foldRight(0L) { char, acc -> acc * 5 + evaluateError[char]!! }
                lineScores.add(lineScore)
            }
        }

        return lineScores.sorted()[lineScores.size / 2]
    }

    private fun isChunkOpening(c: String): Boolean = setOf("(", "[", "{", "<").contains(c)
    private fun isCorresponding(start: String, end: String) = listOf("(", "[", "{", "<").indexOf(start) == listOf(")", "]", "}", ">").indexOf(end)
}

fun main() {
    Day10.solve()
}