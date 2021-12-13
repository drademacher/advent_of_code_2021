import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day13Test {
    private val exampleInput = Day13.parseInput(
        """
            6,10
            0,14
            9,10
            0,3
            10,4
            4,11
            6,0
            6,12
            4,1
            0,13
            10,12
            3,4
            3,0
            8,4
            1,10
            2,14
            8,10
            9,0
            
            fold along y=7
            fold along x=5
        """.trimIndent()
    )

    @Test
    fun `part one example works`() {
        assertEquals(17, Day13.partOne(exampleInput))
    }

    @Test
    fun `part two example has proper ascii art (visual output in console)`() {
        val (width, height) = Day13.partTwo(exampleInput)
        exampleInput.paper.print(width, height)

        assertEquals(5, width)
        assertEquals(7, height)
    }
}