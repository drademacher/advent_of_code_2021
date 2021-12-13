import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day6Test {
    private val exampleInput = mutableListOf(3, 4, 3, 1, 2)

    @Test
    fun `part one example works`() {
        assertEquals(5934, Day6.partOne(exampleInput))
    }

    @Test
    fun `part two example works`() {
        assertEquals(26984457539, Day6.partTwo(exampleInput))
    }

    @Test
    fun `my input works`() {
        val parsedInput = Day6.parseInput(File("src/main/resources/day6.txt").readText())

        assertEquals(352872, Day6.partOne(parsedInput))
        assertEquals(1604361182149, Day6.partTwo(parsedInput))
    }
}