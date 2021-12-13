import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Test
import java.awt.Point
import java.io.File

internal class Day5Test {
    private val exampleInput = Day5.parseInput(
        """
            0,9 -> 5,9
            8,0 -> 0,8
            9,4 -> 3,4
            2,2 -> 2,1
            7,0 -> 7,4
            6,4 -> 2,0
            0,9 -> 2,9
            3,4 -> 1,4
            0,0 -> 8,8
            5,5 -> 8,2
    """.trimIndent()
    )

    @Test
    fun `part one example works`() {
        assertEquals(5, Day5.partOne(exampleInput))
    }

    @Test
    fun `part two example works`() {
        assertEquals(12, Day5.partTwo(exampleInput))
    }

    @Test
    fun `points of a diagonal can be determined`() {
        assertIterableEquals(
            listOf(Point(1, 1), Point(2, 2), Point(3, 3)),
            Day5.Line(Point(1, 1), Point(3, 3)).points
        )

        assertIterableEquals(
            listOf(Point(9, 7), Point(8, 8), Point(7, 9)),
            Day5.Line(Point(9, 7), Point(7, 9)).points
        )
    }

    @Test
    fun `my input works`() {
        val input = Day5.parseInput(File("src/main/resources/day5.txt").readText())

        assertEquals(7297, Day5.partOne(input))
        assertEquals(21038, Day5.partTwo(input))
    }
}