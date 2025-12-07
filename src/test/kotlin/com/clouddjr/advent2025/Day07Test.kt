package com.clouddjr.advent2025

import com.clouddjr.advent2025.Resources.resourceAsListOfString
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 7")
class Day07Test {
    private val input = """
        .......S.......
        ...............
        .......^.......
        ...............
        ......^.^......
        ...............
        .....^.^.^.....
        ...............
        ....^.^...^....
        ...............
        ...^.^...^.^...
        ...............
        ..^...^.....^..
        ...............
        .^.^.^.^.^...^.
        ...............
    """.trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day07(input).solvePart1()

            assertEquals(21, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day07(resourceAsListOfString("day07.txt")).solvePart1()

            assertEquals(1698, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day07(input).solvePart2()

            assertEquals(40, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day07(resourceAsListOfString("day07.txt")).solvePart2()

            assertEquals(95_408_386_769_474, answer)
        }
    }
}
