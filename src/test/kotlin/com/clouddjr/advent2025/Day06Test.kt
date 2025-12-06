package com.clouddjr.advent2025

import com.clouddjr.advent2025.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 6")
class Day06Test {
    private val input = """
        123 328  51 64 
         45 64  387 23 
          6 98  215 314
        *   +   *   +  
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day06(input).solvePart1()

            assertEquals(4_277_556, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day06(resourceAsListOfString("day06.txt")).solvePart1()

            assertEquals(8_108_520_669_952, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day06(input).solvePart2()

            assertEquals(3_263_827, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day06(resourceAsListOfString("day06.txt")).solvePart2()

            assertEquals(11_708_563_470_209, answer)
        }
    }
}
