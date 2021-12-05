import org.junit.jupiter.api.Test
import java.awt.Point
import java.io.File
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

internal class Day5Test {
    private val sampleInput = Day5.parse(
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
        assertEquals(Day5.partOne(sampleInput), 5)
    }

    @Test
    fun `part two example works`() {
        assertEquals(Day5.partTwo(sampleInput), 12)
    }

    @Test
    fun `points of a diagonal can be determined`() {
        assertContentEquals(
            Day5.Line(Point(1, 1), Point(3,3 )).points,
            listOf(Point(1,1), Point(2,2), Point(3,3))
        )

        assertContentEquals(
            Day5.Line(Point(9, 7), Point(7,9 )).points,
            listOf(Point(9,7), Point(8,8), Point(7,9))
        )
    }

    @Test
    fun `my input is solved correctly`() {
        val input = Day5.parse(File("src/main/resources/day5.txt").readText())

        assertEquals(Day5.partOne(input), 7297)
        assertEquals(Day5.partTwo(input), 21038)
    }
}