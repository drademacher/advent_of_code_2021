import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day9Test {
    private val exampleInput = Day9.parseInput(
        """
            2199943210
            3987894921
            9856789892
            8767896789
            9899965678
        """.trimIndent()
    )

    @Test
    fun `part one example works`() {
        assertEquals(15, Day9.partOne(exampleInput))
    }

    @Test
    fun `part two example works`() {
        assertEquals(1134, Day9.partTwo(exampleInput))
    }
}