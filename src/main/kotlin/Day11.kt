import java.io.File

private typealias Day11Input = MutableList<MutableList<Int>>

fun Day11Input.print() = this.forEach { println(it.joinToString("")) }
fun Day11Input.getPoint(point: Point): Int? = this.getOrNull(point.y)?.getOrNull(point.x)
fun Day11Input.getAllPoints() = this.indices.flatMap { y -> this[y].indices.map { x -> Point(y, x) } }
fun Day11Input.clone(): Day11Input = this.map { it.toMutableList() }.toMutableList()

object Day11 {
    fun solve() {
        val input = parseInput(
            File("src/main/resources/day11.txt")
                .readText()
        )

        println("Part 1: ${partOne(input.clone())}")
        println("Part 2: ${partTwo(input.clone())}")
    }

    fun parseInput(x: String) = x
        .split("\n")
        .filter { it != "" }
        .map { it.split("").filter { it != "" }.map { it.toInt() }.toMutableList() }
        .toMutableList()

    fun partOne(input: Day11Input): Int {
        var totalFlashes = 0
        repeat(100) {
            input.getAllPoints().forEach {
                input[it.y][it.x] += 1
            }

            val hasFlashed = mutableSetOf<Point>()
            val flashingNeighbors = input.getAllPoints()
                .filter { input.getPoint(it)!! == 10 }
                .toMutableList()


            while (flashingNeighbors.isNotEmpty()) {
                val next = flashingNeighbors.removeFirst()
                if (hasFlashed.contains(next)) {
                    continue
                }
                hasFlashed.add(next)
                incrementNeighbors(input, next)
                flashingNeighbors.addAll(getFlashingNeighbors(input, next))
            }

            totalFlashes += hasFlashed.size
            hasFlashed.forEach {
                input[it.y][it.x] = 0
            }
        }

        return totalFlashes
    }

    fun partTwo(input: Day11Input): Int {
        for (day in 1..Int.MAX_VALUE) {
            for (y in input.indices) {
                for (x in input[y].indices) {
                    input[y][x] += 1
                }
            }

            val hasFlashed = mutableSetOf<Point>()
            val flashingNeighbors = input.indices.flatMap { y -> input[y].indices.map { Point(y, it) } }
                .filter { input.getPoint(it)!! == 10 }
                .toMutableList()


            while (flashingNeighbors.isNotEmpty()) {
                val next = flashingNeighbors.removeFirst()
                if (hasFlashed.contains(next)) {
                    continue
                }
                hasFlashed.add(next)
                incrementNeighbors(input, next)
                flashingNeighbors.addAll(getFlashingNeighbors(input, next))
            }

            hasFlashed.forEach {
                input[it.y][it.x] = 0
            }

            if (hasFlashed.size == input.size * input[0].size) {
                return day
            }
        }

        return -1
    }

    private fun getNeighbors(input: Day11Input, point: Point): List<Point> = (-1..+1).flatMap { x -> (-1..+1).map { y -> Point(x, y) } }
        .filter { it != Point(0, 0) }
        .map { it.add(point) }
        .filter { input.getOrNull(it.y)?.getOrNull(it.x) != null }

    private fun getFlashingNeighbors(input: Day11Input, point: Point) = getNeighbors(input, point)
        .filter { input.getPoint(it) == 10 }

    private fun incrementNeighbors(input: Day11Input, point: Point) {
        getNeighbors(input, point)
            .forEach {
                input[it.y][it.x] += 1
            }
    }
}

fun main() {
    Day11.solve()
}