import java.io.File

private typealias Day9Input = List<List<Int>>

typealias Point = Pair<Int, Int>
val Point.x: Int
    get() = this.first
val Point.y: Int
    get() = this.second

object Day9 {
    fun solve() {
        val input = parse(File("src/main/resources/day9.txt").readText())

        println("Part 1: ${partOne(input)}")
        println("Part 2: ${partTwo(input)}")
    }

    fun parse(readText: String): Day9Input = readText
        .split("\n")
        .filter { it != "" }
        .map { line -> line.split("").filter { it != "" }.map { it.toInt() } }

    fun partOne(input: Day9Input): Int {
        return determineLowPoints(input).sumOf { input[it.y][it.x] + 1 }
    }

    private fun determineLowPoints(input: Day9Input): Set<Point> {
        val lowPoints = mutableSetOf<Point>()
        for (y in input.indices) {
            for (x in input[y].indices) {
                if (getOrthogonalNeighbors(input, Point(x, y)).all { input[it.y][it.x] > input[y][x] }) {
                    lowPoints.add(Point(x, y))
                }
            }
        }
        return lowPoints
    }

    private fun getOrthogonalNeighbors(input: Day9Input, point: Point): Set<Point> {
        val result = mutableSetOf<Point>()

        if (point.x > 0) result.add(Point(point.x - 1, point.y))
        if (point.x < input[point.y].size - 1) result.add(Point(point.x + 1, point.y))
        if (point.y > 0) result.add(Point(point.x, point.y - 1))
        if (point.y < input.size - 1) result.add(Point(point.x, point.y + 1))

        return result
    }

    fun partTwo(input: Day9Input): Int {
        return determineLowPoints(input)
            .map { lowPoint -> findBasin(input, lowPoint) }
            .map { it.size }
            .sorted()
            .reversed()
            .take(3)
            .reduce { a, b -> a * b }
    }

    private fun findBasin(input: Day9Input, start: Point): Set<Point> {
        val frontier = mutableListOf(start)
        val visited = mutableSetOf<Point>()

        while (frontier.size > 0) {
            val next = frontier.removeFirst()
            if (visited.contains(next) || input[next.y][next.x] == 9) {
                continue
            }

            visited.add(next)
            val neighbors = getOrthogonalNeighbors(input, next)
            frontier.addAll(neighbors)
        }

        return visited
    }
}

fun main() {
    Day9.solve()
}