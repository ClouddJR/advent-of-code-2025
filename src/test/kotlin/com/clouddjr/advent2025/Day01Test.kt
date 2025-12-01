package com.clouddjr.advent2025

import com.clouddjr.advent2025.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 1")
class Day01Test {
    private val input = """
        L68
        L30
        R48
        L5
        R60
        L55
        L1
        L99
        R14
        L82
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day01(input).solvePart1()

            assertEquals(3, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day01(resourceAsListOfString("day01.txt")).solvePart1()

            assertEquals(1029, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day01(input).solvePart2()

            assertEquals(6, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day01(resourceAsListOfString("day01.txt")).solvePart2()

            assertEquals(5892, answer)
        }
    }
}
