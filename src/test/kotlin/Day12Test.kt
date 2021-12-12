import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day12Test {
    private val sampleInput = Day12.parse(
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
        assertEquals(10, Day12.partOne(sampleInput))
    }

    @Test
    fun `part two example works`() {
        assertEquals(36, Day12.partTwo(sampleInput))
    }
}