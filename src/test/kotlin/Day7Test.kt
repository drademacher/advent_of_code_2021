import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day7Test {
    private val exampleInput = Day7.parseInput("16,1,2,0,4,2,7,1,2,14")

    @Test
    fun `part one example works`() {
        assertEquals(37, Day7.partOne(exampleInput))
    }

    @Test
    fun `part two example works`() {
        assertEquals(168, Day7.partTwo(exampleInput))
    }
}