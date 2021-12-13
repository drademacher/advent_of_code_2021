import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day4Test {
    private fun exampleInput() = Day4.parseInput(
        """
            7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1
            
            22 13 17 11  0
             8  2 23  4 24
            21  9 14 16  7
             6 10  3 18  5
             1 12 20 15 19
            
             3 15  0  2 22
             9 18 13 17  5
            19  8  7 25 23
            20 11 10 24  4
            14 21 16 12  6
            
            14 21 17 24  4
            10 16 15  9 19
            18  8 23 26 20
            22 11 13  6  5
             2  0 12  3  7
        """.trimIndent()
    )

    @Test
    fun `part one example works`() {
        assertEquals(4512, Day4.partOne(exampleInput().first, exampleInput().second))
    }

    @Test
    fun `part two example works`() {
        assertEquals(1924, Day4.partTwo(exampleInput().first, exampleInput().second))
    }

    @Test
    fun `my input works`() {
        val parsedInput = Day4.parseInput(File("src/main/resources/day4.txt").readText())

        assertEquals(8580, Day4.partOne(parsedInput.first, parsedInput.second))
        assertEquals(9576, Day4.partTwo(parsedInput.first, parsedInput.second))
    }
}