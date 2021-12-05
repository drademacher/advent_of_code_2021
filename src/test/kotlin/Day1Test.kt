import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day1Test {
    private val sampleInput = mutableListOf(
        199,
        200,
        208,
        210,
        200,
        207,
        240,
        269,
        260,
        263
    )

    @Test
    fun `part one example works`() {
        assertEquals(Day1.partOne(sampleInput), 7)
    }

    @Test
    fun `part two example works`() {
        assertEquals(Day1.partTwo(sampleInput), 5)
    }
}