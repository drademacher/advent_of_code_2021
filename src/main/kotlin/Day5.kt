import java.awt.Point
import java.io.File

object Day5 {
    private const val coordsSize = 1000

    class Line(private val start: Point, private val end: Point) {
        val isHorizontalOrVertical: Boolean = start.x == end.x || start.y == end.y
        val points: List<Point>
            get() {
                val xs = if (start.x < end.x) {
                    (start.x..end.x)
                } else {
                    (start.x downTo end.x)
                }
                val ys = if (start.y < end.y) {
                    (start.y..end.y)
                } else {
                    (start.y downTo end.y)
                }

                if (start.x == end.x) {
                    return ys.map { Point(start.x, it) }
                }

                if (start.y == end.y) {
                    return xs.map { Point(it, start.y) }
                }

                return xs.zip(ys).map { Point(it.first, it.second) }
            }
    }

    fun solve() {
        val lines = parse(File("src/main/resources/day5.txt").readText())

        println("Part 1: ${partOne(lines)}")
        println("Part 2: ${partTwo(lines)}")
    }

    fun parse(file: String): List<Line> {
        return file
            .replace(" -> ", ",")
            .split("\n")
            .filter { it != "" }
            .map { it.split(",").map { it.toInt() } }
            .map { Line(Point(it[0], it[1]), Point(it[2], it[3])) }
    }

    fun partOne(lines: List<Line>): Int {
        val coords = Array(coordsSize) { IntArray(coordsSize) { 0 } }

        lines
            .filter { it.isHorizontalOrVertical }
            .flatMap { it.points }
            .forEach { point -> coords[point.y][point.x] += 1 }

        return coords.sumOf { col -> col.filter { it >= 2 }.size }
    }

    fun partTwo(lines: List<Line>): Int {
        val coords = Array(coordsSize) { IntArray(coordsSize) { 0 } }

        lines
            .flatMap { it.points }
            .forEach { point -> coords[point.y][point.x] += 1 }

        return coords.sumOf { col -> col.filter { it >= 2 }.size }
    }
}

fun main() {
    Day5.solve()
}