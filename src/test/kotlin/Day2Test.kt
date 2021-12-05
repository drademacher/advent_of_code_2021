import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

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
        assertEquals(Day2.partOne(sampleInput), 150)
    }

    @Test
    fun `part two example works`() {
        assertEquals(Day2.partTwo(sampleInput), 900)
    }
}