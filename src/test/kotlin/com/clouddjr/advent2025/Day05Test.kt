package com.clouddjr.advent2025

import com.clouddjr.advent2025.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 5")
class Day05Test {
    private val input = """
        3-5
        10-14
        16-20
        12-18

        1
        5
        8
        11
        17
        32
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day05(input).solvePart1()

            assertEquals(3, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day05(resourceAsText("day05.txt")).solvePart1()

            assertEquals(775, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day05(input).solvePart2()

            assertEquals(14, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day05(resourceAsText("day05.txt")).solvePart2()

            assertEquals(350_684_792_662_845, answer)
        }
    }
}
