import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day11Test {
    private val exampleInput = Day11.parseInput(
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
    fun `part one example works`() {
        assertEquals(1656, Day11.partOne(exampleInput))
    }

    @Test
    fun `part two example works`() {
        assertEquals(195, Day11.partTwo(exampleInput))
    }
}