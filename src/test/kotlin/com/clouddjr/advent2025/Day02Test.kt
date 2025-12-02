package com.clouddjr.advent2025

import com.clouddjr.advent2025.Resources.resourceAsText
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 2")
class Day02Test {
    private val input = """
       11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124 
    """.trimIndent()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            val answer = Day02(input).solvePart1()

            assertEquals(1_227_775_554, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day02(resourceAsText("day02.txt")).solvePart1()

            assertEquals(24_043_483_400, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            val answer = Day02(input).solvePart2()

            assertEquals(4_174_379_265, answer)
        }

        @Test
        fun `Matches actual`() {
            val answer = Day02(resourceAsText("day02.txt")).solvePart2()

            assertEquals(38_262_920_235, answer)
        }
    }
}
