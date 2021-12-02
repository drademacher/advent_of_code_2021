import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day2Test {
    private val sampleInput = mutableListOf(
        Day2.Movement.Forward(5),
        Day2.Movement.Down(5),
        Day2.Movement.Forward(8),
        Day2.Movement.Up(3),
        Day2.Movement.Down(8),
        Day2.Movement.Forward(2),
    )

    @Test
    fun `part one example works`() {
        assert(Day2.partOne(sampleInput) == 150)
    }

    @Test
    fun `part two example works`() {
        assert(Day2.partTwo(sampleInput) == 900)
    }
}