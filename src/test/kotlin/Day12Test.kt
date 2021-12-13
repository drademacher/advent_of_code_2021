import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day12Test {
    private val exampleInput = Day12.parseInput(
        """
            start-A
            start-b
            A-c
            A-b
            b-d
            A-end
            b-end
        """.trimIndent()
    )

    @Test
    fun `part one example works`() {
        assertEquals(10, Day12.partOne(exampleInput))
    }

    @Test
    fun `part two example works`() {
        assertEquals(36, Day12.partTwo(exampleInput))
    }
}