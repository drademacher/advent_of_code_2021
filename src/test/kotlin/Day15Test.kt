import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day15Test {
    private val exampleInput = Day15.parseInput(
        """
            1163751742
            1381373672
            2136511328
            3694931569
            7463417111
            1319128137
            1359912421
            3125421639
            1293138521
            2311944581
        """.trimIndent()
    )

    @Test
    fun `part one example works`() {
        assertEquals(40, Day15.partOne(exampleInput))
    }

    @Test
    fun `part two example works`() {
        assertEquals(315, Day15.partTwo(exampleInput))
    }
}