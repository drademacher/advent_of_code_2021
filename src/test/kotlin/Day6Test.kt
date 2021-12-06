import org.junit.jupiter.api.Test

internal class Day6Test {
    @Test
    fun `part one example works`() {
        kotlin.test.assertEquals(Day6.partOne(mutableListOf(3, 4, 3, 1, 2)), 5934)
    }

    @Test
    fun `part two example works`() {
        kotlin.test.assertEquals(Day6.partTwo(mutableListOf(3, 4, 3, 1, 2)), 26984457539)
    }
}