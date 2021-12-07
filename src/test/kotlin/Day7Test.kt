import org.junit.jupiter.api.Test

internal class Day7Test {
    @Test
    fun `part one example works`() {
        kotlin.test.assertEquals(Day7.partOne(mutableListOf(16, 1, 2, 0, 4, 2, 7, 1, 2, 14)), 37)
    }

    @Test
    fun `part two example works`() {
        kotlin.test.assertEquals(Day7.partTwo(mutableListOf(16, 1, 2, 0, 4, 2, 7, 1, 2, 14)), 168)
    }
}