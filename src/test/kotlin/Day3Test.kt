import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day3Test {
    private val exampleInput = Day3.parseInput(
        """
            00100
            11110
            10110
            10111
            10101
            01111
            00111
            11100
            10000
            11001
            00010
            01010
        """.trimIndent()
    )

    @Test
    fun `part one example works`() {
        assertEquals(198, Day3.partOne(exampleInput))
    }

    @Test
    fun `part two example works`() {
        assertEquals(230, Day3.partTwo(exampleInput))
    }
}