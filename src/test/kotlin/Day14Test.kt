import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day14Test {
    private val exampleInput = Day14.parseInput(
        """
            NNCB
            
            CH -> B
            HH -> N
            CB -> H
            NH -> C
            HB -> C
            HC -> B
            HN -> C
            NN -> C
            BH -> H
            NC -> B
            NB -> B
            BN -> B
            BB -> N
            BC -> B
            CC -> N
            CN -> C
        """.trimIndent()
    )

    @Test
    fun `part one example works`() {
        assertEquals(1588, Day14.partOne(exampleInput))
    }

    @Test
    fun `part two example works`() {
        assertEquals(2188189693529, Day14.partTwo(exampleInput))
    }
}