import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day11Test {
    private val sampleInput = Day11.parse(
        """
        5483143223
        2745854711
        5264556173
        6141336146
        6357385478
        4167524645
        2176841721
        6882881134
        4846848554
        5283751526
    """.trimIndent()
    )

    @Test
    fun neighbors() {
        println((-1..+1).flatMap { x -> (-1..+1).map { y -> Point(x, y) } })
        print(Day11.getNeighbors(sampleInput, Point(2, 5)))
        assertEquals(8, Day11.getNeighbors(sampleInput, Point(2, 5)).size)
    }

    @Test
    fun `part one example works`() {
        assertEquals(1656, Day11.partOne(sampleInput))
    }

    @Test
    fun `part two example works`() {
        assertEquals(195, Day11.partTwo(sampleInput))
    }
}