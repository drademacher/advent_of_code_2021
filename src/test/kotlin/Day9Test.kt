import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day9Test {
    private val sampleInput = Day9.parse(
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
        assertEquals(15, Day9.partOne(sampleInput))
    }

    @Test
    fun `part two example works`() {
        assertEquals(1134, Day9.partTwo(sampleInput))
    }
}