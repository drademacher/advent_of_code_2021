import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day1Test {
    private val exampleInput = Day1.parseInput(
        """
            199
            200
            208
            210
            200
            207
            240
            269
            260
            263
        """.trimIndent()
    )

    @Test
    fun `part one example works`() {
        assertEquals(7, Day1.partOne(exampleInput))
    }

    @Test
    fun `part two example works`() {
        assertEquals(5, Day1.partTwo(exampleInput))
    }
}