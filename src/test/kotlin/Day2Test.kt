import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day2Test {
    private val exampleInput = mutableListOf(
        Day2.Movement.Forward(5),
        Day2.Movement.Down(5),
        Day2.Movement.Forward(8),
        Day2.Movement.Up(3),
        Day2.Movement.Down(8),
        Day2.Movement.Forward(2),
    )

    @Test
    fun `part one example works`() {
        assertEquals(150, Day2.partOne(exampleInput))
    }

    @Test
    fun `part two example works`() {
        assertEquals(900, Day2.partTwo(exampleInput))
    }
}