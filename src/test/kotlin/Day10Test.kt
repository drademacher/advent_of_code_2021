import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day10Test {
    private val exampleInput = Day10.parseInput(
        """
            [({(<(())[]>[[{[]{<()<>>
            [(()[<>])]({[<{<<[]>>(
            {([(<{}[<>[]}>{[]{[(<()>
            (((({<>}<{<{<>}{[]{[]{}
            [[<[([]))<([[{}[[()]]]
            [{[{({}]{}}([{[{{{}}([]
            {<[[]]>}<{[{[{[]{()[[[]
            [<(<(<(<{}))><([]([]()
            <{([([[(<>()){}]>(<<{{
            <{([{{}}[<[[[<>{}]]]>[]]
        """.trimIndent()
    )

    @Test
    fun `part one example works`() {
        assertEquals(26397, Day10.partOne(exampleInput))
    }

    @Test
    fun `part two example works`() {
        assertEquals(288957, Day10.partTwo(exampleInput))
    }
}