import org.junit.jupiter.api.Test

internal class Day3Test {
    private val sampleInput = mutableListOf(
        "00100",
        "11110",
        "10110",
        "10111",
        "10101",
        "01111",
        "00111",
        "11100",
        "10000",
        "11001",
        "00010",
        "01010",
    ).map { it.split(("")).filter { bit -> bit == "0" || bit == "1" } }

    @Test
    fun `part one example works`() {
        assert(Day3.partOne(sampleInput) == 198)
    }

    @Test
    fun `part two example works`() {
        assert(Day3.partTwo(sampleInput) == 230)
    }
}