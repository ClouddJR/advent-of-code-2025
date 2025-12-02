package com.clouddjr.advent2025

class Day02(input: String) {
    private val ranges = input.trim().split(",").map {
        it.substringBefore("-").toLong()..it.substringAfter("-").toLong()
    }

    fun solvePart1() = ranges.sumOf { range ->
        range.filter { it.hasMatchingHalves() }.sum()
    }

    fun solvePart2() = ranges.sumOf { range ->
        range.filter { it.hasRepeatingPattern() }.sum()
    }

    private fun Long.hasMatchingHalves(): Boolean {
        val str = toString()
        val half = str.length / 2
        return str.take(half) == str.drop(half)
    }

    private fun Long.hasRepeatingPattern(): Boolean {
        val str = toString()
        return (1..<str.length).any { i ->
            str.take(i).repeat(str.length / i) == str
        }
    }
}
