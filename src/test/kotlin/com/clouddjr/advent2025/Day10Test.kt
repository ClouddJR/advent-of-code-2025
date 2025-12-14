package com.clouddjr.advent2025

import com.clouddjr.advent2025.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 10")
class Day10Test {
    private val input = """
        [.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}
        [...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}
        [.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day10(input).solvePart1()

            assertEquals(7, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day10(resourceAsListOfString("day10.txt")).solvePart1()

            assertEquals(396, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day10(input).solvePart2()

            assertEquals(33, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day10(resourceAsListOfString("day10.txt")).solvePart2()

            assertEquals(15_688, answer)
        }
    }
}
