package com.clouddjr.advent2025

import com.clouddjr.advent2025.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 8")
class Day08Test {
    private val input = """
        162,817,812
        57,618,57
        906,360,560
        592,479,940
        352,342,300
        466,668,158
        542,29,236
        431,825,988
        739,650,466
        52,470,668
        216,146,977
        819,987,18
        117,168,530
        805,96,715
        346,949,466
        970,615,88
        941,993,340
        862,61,35
        984,92,344
        425,690,689
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day08(input).solvePart1(pairsToConsider = 10)

            assertEquals(40, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day08(resourceAsListOfString("day08.txt")).solvePart1(pairsToConsider = 1000)

            assertEquals(80_446, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day08(input).solvePart2()

            assertEquals(25_272, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day08(resourceAsListOfString("day08.txt")).solvePart2()

            assertEquals(51_294_528, answer)
        }
    }
}
