import java.io.File

typealias Day12Input = HashMap<String, MutableList<String>>

object Day12 {
    var counter = 0

    fun solve() {
        val input = parseInput(File("src/main/resources/day12.txt").readText())

        println("Part 1: ${partOne(input)}")
        println("Part 2: ${partTwo(input)}")
    }

    fun parseInput(readText: String): Day12Input {
        val filter = readText
            .split("\n")
            .filter { it != "" }
            .map { line -> line.split("-") }
            .filter { it.size == 2 }
        return filter
            .fold(hashMapOf()) { acc, edge ->
                acc.putIfAbsent(edge[0], mutableListOf())
                acc[edge[0]]!!.add(edge[1])
                acc.putIfAbsent(edge[1], mutableListOf())
                acc[edge[1]]!!.add(edge[0])
                acc
            }
    }

    fun partOne(input: Day12Input): Int {
        counter = 0
        dfs(input, "start", mutableListOf("start"), false)
        return counter
    }

    fun partTwo(input: Day12Input): Int {
        counter = 0
        dfs(input, "start", mutableListOf("start"), true)
        return counter
    }


    private fun dfs(input: Day12Input, current: String, smallCavesVisited: MutableList<String>, canVisitSmallCaveTwice: Boolean) {
        for (cave in input[current]!!) {
            var canVisitSmallCaveTwice = canVisitSmallCaveTwice
            val isSmallCave = cave[0].isLowerCase()

            if (isSmallCave && smallCavesVisited.contains(cave)) {
                if (canVisitSmallCaveTwice && cave != "start") {
                    canVisitSmallCaveTwice = false
                } else {
                    continue
                }
            }

            if (cave == "end") {
                counter += 1
            } else {
                smallCavesVisited.add(cave)
                dfs(input, cave, smallCavesVisited, canVisitSmallCaveTwice)
                smallCavesVisited.remove(cave)
            }
        }
    }
}

fun main() {
    Day12.solve()
}