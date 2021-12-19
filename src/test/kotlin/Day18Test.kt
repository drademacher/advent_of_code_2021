import Day18.Snailfish.Companion.add
import Day18.Snailfish.Companion.fromString
import Day18.Snailfish.Number
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class Day18Test {
    @Nested
    inner class BasicFunctionality {
        @Test
        fun `simple add works`() {
            assertEquals("[[1,2],[[3,4],5]]", add(fromString("[1,2]"), fromString("[[3,4],5]")).toString())
        }

        @Test
        fun `fromStrong and toString work`() {
            assertEquals("[[9,1],[1,9]]", fromString("[[9,1],[1,9]]").toString())
            assertEquals("[[1,2],[[3,4],5]]", fromString("[[1,2],[[3,4],5]]").toString())
            assertEquals("[[[[0,7],4],[[7,8],[6,0]]],[8,1]]", fromString("[[[[0,7],4],[[7,8],[6,0]]],[8,1]]").toString())
            assertEquals("[[[[1,1],[2,2]],[3,3]],[4,4]]", fromString("[[[[1,1],[2,2]],[3,3]],[4,4]]").toString())
            assertEquals("[[[[3,0],[5,3]],[4,4]],[5,5]]", fromString("[[[[3,0],[5,3]],[4,4]],[5,5]]").toString())
            assertEquals("[[[[5,0],[7,4]],[5,5]],[6,6]]", fromString("[[[[5,0],[7,4]],[5,5]],[6,6]]").toString())
            assertEquals("[[[[8,7],[7,7]],[[8,6],[7,7]]],[[[0,7],[6,6]],[8,7]]]", fromString("[[[[8,7],[7,7]],[[8,6],[7,7]]],[[[0,7],[6,6]],[8,7]]]").toString())
        }

        @Test
        fun `magnitude works`() {
            assertEquals(129, fromString("[[9,1],[1,9]]").magnitude)
            assertEquals(143, fromString("[[1,2],[[3,4],5]]").magnitude)
            assertEquals(1384, fromString("[[[[0,7],4],[[7,8],[6,0]]],[8,1]]").magnitude)
            assertEquals(445, fromString("[[[[1,1],[2,2]],[3,3]],[4,4]]").magnitude)
            assertEquals(791, fromString("[[[[3,0],[5,3]],[4,4]],[5,5]]").magnitude)
            assertEquals(1137, fromString("[[[[5,0],[7,4]],[5,5]],[6,6]]").magnitude)
            assertEquals(3488, fromString("[[[[8,7],[7,7]],[[8,6],[7,7]]],[[[0,7],[6,6]],[8,7]]]").magnitude)
        }

        @Test
        fun numberPair() {
            assertEquals(false, Number(5).isNumberPair)
            assertEquals(true, fromString("[9,1]").isNumberPair)
            assertEquals(false, fromString("[[9,1],[1,9]]").isNumberPair)
        }

        @Test
        fun containsNumberPair() {
            assertEquals(false, Number(5).containsNumberPair)
            assertEquals(true, fromString("[9,1]").containsNumberPair)
            assertEquals(true, fromString("[[9,1],[1,9]]").containsNumberPair)
        }

        @Nested
        inner class Exploding {
            @Test
            fun `simple explode example 1`() {
                val sut = fromString("[[[[[9,8],1],2],3],4]")

                sut.explode()

                assertEquals("[[[[0,9],2],3],4]", sut.toString())
            }

            @Test
            fun `simple explode example 2`() {
                val sut = fromString("[7,[6,[5,[4,[3,2]]]]]")

                sut.explode()

                assertEquals("[7,[6,[5,[7,0]]]]", sut.toString())
            }

            @Test
            fun `simple explode example 3`() {
                val sut = fromString("[[6,[5,[4,[3,2]]]],1]")

                sut.explode()

                assertEquals("[[6,[5,[7,0]]],3]", sut.toString())
            }

            @Test
            fun `simple explode example 4`() {
                val sut = fromString("[[3,[2,[1,[7,3]]]],[6,[5,[4,[3,2]]]]]")

                sut.explode()

                assertEquals("[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]", sut.toString())
            }

            @Test
            fun `simple explode example 5`() {
                val sut = fromString("[[3,[2,[8,0]]],[9,[5,[4,[3,2]]]]]")

                sut.explode()

                assertEquals("[[3,[2,[8,0]]],[9,[5,[7,0]]]]", sut.toString())
            }
        }

        @Test
        fun splitw() {
            val sut = fromString("[[[[0,7],4],[15,[0,13]]],[1,1]]")

            sut.split()
            sut.split()

            assertEquals("[[[[0,7],4],[[7,8],[0,[6,7]]]],[1,1]]", sut.toString())
        }
    }

    @Test
    fun `first example works`() {
        val exampleInput = Day18.parseInput(
            """
                [[[0,[4,5]],[0,0]],[[[4,5],[2,6]],[9,5]]]
                [7,[[[3,7],[4,3]],[[6,3],[8,8]]]]
                [[2,[[0,8],[3,4]]],[[[6,7],1],[7,[1,6]]]]
                [[[[2,4],7],[6,[0,5]]],[[[6,8],[2,8]],[[2,1],[4,5]]]]
                [7,[5,[[3,8],[1,4]]]]
                [[2,[2,2]],[8,[8,1]]]
                [2,9]
                [1,[[[9,3],9],[[9,0],[0,7]]]]
                [[[5,[7,4]],7],1]
                [[[[4,2],2],6],[8,7]]
            """.trimIndent()
        )

        assertEquals(3488, Day18.partOne(exampleInput))
    }

    @Test
    fun `part one example works`() {
        val exampleInput = Day18.parseInput(
            """
                [[[0,[5,8]],[[1,7],[9,6]]],[[4,[1,2]],[[1,4],2]]]
                [[[5,[2,8]],4],[5,[[9,9],0]]]
                [6,[[[6,2],[5,6]],[[7,6],[4,7]]]]
                [[[6,[0,7]],[0,9]],[4,[9,[9,0]]]]
                [[[7,[6,4]],[3,[1,3]]],[[[5,5],1],9]]
                [[6,[[7,3],[3,2]]],[[[3,8],[5,7]],4]]
                [[[[5,4],[7,7]],8],[[8,3],8]]
                [[9,3],[[9,9],[6,[4,9]]]]
                [[2,[[7,7],7]],[[5,8],[[9,3],[0,2]]]]
                [[[[5,2],5],[8,[3,7]]],[[5,[7,5]],[4,4]]]
            """.trimIndent()
        )

        assertEquals(4140, Day18.partOne(exampleInput))
    }

    @Test
    fun `part two example works`() {
        val exampleInput = Day18.parseInput(
            """
                [[[0,[5,8]],[[1,7],[9,6]]],[[4,[1,2]],[[1,4],2]]]
                [[[5,[2,8]],4],[5,[[9,9],0]]]
                [6,[[[6,2],[5,6]],[[7,6],[4,7]]]]
                [[[6,[0,7]],[0,9]],[4,[9,[9,0]]]]
                [[[7,[6,4]],[3,[1,3]]],[[[5,5],1],9]]
                [[6,[[7,3],[3,2]]],[[[3,8],[5,7]],4]]
                [[[[5,4],[7,7]],8],[[8,3],8]]
                [[9,3],[[9,9],[6,[4,9]]]]
                [[2,[[7,7],7]],[[5,8],[[9,3],[0,2]]]]
                [[[[5,2],5],[8,[3,7]]],[[5,[7,5]],[4,4]]]
            """.trimIndent()
        )

        assertEquals(3993, Day18.partTwo(exampleInput))
    }
}