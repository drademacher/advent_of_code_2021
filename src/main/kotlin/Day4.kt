import java.io.File

object Day4 {
    class Board(val numbers: List<List<Int>>) {
        var marked: MutableList<MutableList<Boolean>> = mutableListOf()

        init {
            for (i in numbers.indices) {
                marked.add(Array(5) { false }.toMutableList())
            }
        }

        fun mark(number: Int) {
            for (i in marked.indices) {
                for (j in marked.indices) {
                    if (numbers[i][j] == number) {
                        marked[i][j] = true
                    }
                }
            }
        }

        fun hasBingo(): Boolean {
            for (i in marked.indices) {
                val lineMatch = marked.indices.all { j -> marked[i][j] }
                val rowMatch = marked.indices.all { j -> marked[j][i] }
                val firstDiagonal = marked.indices.map { marked.size - 1 - it }.all { j -> marked[i][j] }
                val secondDiagonal = marked.indices.map { marked.size - 1 - it }.all { j -> marked[j][i] }

                if (lineMatch || rowMatch || firstDiagonal || secondDiagonal) {
                    return true
                }
            }

            return false
        }

        fun sumOfUnmarkedNumbers(): Int {
            var result = 0
            for (i in marked.indices) {
                for (j in marked.indices) {
                    if (!marked[i][j]) {
                        result += numbers[i][j]
                    }
                }
            }
            return result
        }
    }

    fun solve() {
        val (numbers, boards) = parseInput(File("src/main/resources/day4.txt").readText())

        println("Part 1: ${partOne(numbers, boards)}")
        println("Part 2: ${partTwo(numbers, boards)}")
    }

    fun parseInput(file: String): Pair<List<Int>, List<Board>> {
        val rawInput = file
            .split("\n")
            .filter { it != "" }
        val numbers = rawInput[0].split(",").map { it.toInt() }
        val boards = (1 until rawInput.size step 5)
            .map { lineIndex ->
                Board(
                    rawInput
                        .slice(lineIndex..lineIndex + 4)
                        .map { line -> line.split(" ").filter { it != "" }.map { it.toInt() } }
                )
            }
        return Pair(numbers, boards)
    }

    fun partOne(numbers: List<Int>, boards: List<Board>): Int {
        for (number in numbers) {
            boards.forEach { it.mark(number) }

            if (boards.any { it.hasBingo() }) {
                val board = boards.first { it.hasBingo() }
                return board.sumOfUnmarkedNumbers() * number
            }
        }

        return -1
    }

    fun partTwo(numbers: List<Int>, boards: List<Board>): Int {
        var lastBoard = Board(mutableListOf())
        for (number in numbers) {
            boards.forEach { it.mark(number) }

            if (boards.filter { !it.hasBingo() }.size == 1) {
                lastBoard = boards.first { !it.hasBingo() }
                break
            }
        }

        // solve the last board
        for (number in numbers) {
            lastBoard.mark(number)

            if (lastBoard.hasBingo()) {
                return lastBoard.sumOfUnmarkedNumbers() * number
            }
        }

        return -1
    }
}

fun main() {
    Day4.solve()
}