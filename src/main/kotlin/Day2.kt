import java.io.File

object Day2 {
    sealed class Movement {
        data class Forward(val number: Int) : Movement()
        data class Up(val number: Int) : Movement()
        data class Down(val number: Int) : Movement()

        companion object {
            fun fromString(string: String): Movement {
                val parts = string.split(" ")

                return when (parts[0]) {
                    "forward" -> Forward(parts[1].toInt())
                    "up" -> Up(parts[1].toInt())
                    "down" -> Down(parts[1].toInt())
                    else -> throw RuntimeException("should not happen: '${string}'")
                }
            }
        }
    }

    fun solve() {
        val input = File("src/main/resources/day2.txt")
            .readText()
            .split("\n")
            .filter { it != "" }
            .map { Movement.fromString(it) }
        println("Part 1: ${partOne(input)}")
        println("Part 2: ${partTwo(input)}")
    }

    fun partOne(input: List<Movement>): Int {
        var horizontal = 0
        var depth = 0
        for (movement in input) {
            when (movement) {
                is Movement.Forward -> horizontal += movement.number
                is Movement.Up -> depth -= movement.number
                is Movement.Down -> depth += movement.number
            }
        }
        return horizontal * depth
    }

    fun partTwo(input: List<Movement>): Int {
        var horizontal = 0
        var aim = 0
        var depth = 0
        for (movement in input) {
            when (movement) {
                is Movement.Forward -> {
                    horizontal += movement.number
                    depth += aim * movement.number
                }
                is Movement.Up -> aim -= movement.number
                is Movement.Down -> aim += movement.number
            }
        }
        return horizontal * depth
    }
}

fun main() {
    Day2.solve()
}