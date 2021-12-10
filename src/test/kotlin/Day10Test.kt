import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day10Test {
    private val sampleInput = """
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
        .split("\n")
        .filter { it != "" }

    @Test
    fun `part one example works`() {
        assertEquals(26397, Day10.partOne(sampleInput))
    }

    @Test
    fun `part two example works`() {
        assertEquals(288957, Day10.partTwo(sampleInput))
    }
}