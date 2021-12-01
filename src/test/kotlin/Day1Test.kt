import org.junit.jupiter.api.Test

internal class Day1Test {
    val sampleInput = mutableListOf(
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
        assert(Day1.partOne(sampleInput) == 7)
    }

    @Test
    fun `part two example works`() {
        assert(Day1.partTwo(sampleInput) == 5)
    }
}