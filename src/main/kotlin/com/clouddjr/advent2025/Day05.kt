package com.clouddjr.advent2025

class Day05(input: String) {
    private val ranges = input.substringBefore("\n\n").lines().map {
        it.substringBefore("-").toLong()..it.substringAfter("-").toLong()
    }

    private val ids = input.substringAfter("\n\n").lines().map { it.toLong() }

    fun solvePart1() = ids.count { id -> ranges.any { id in it } }

    fun solvePart2() =
        ranges.sortedBy { it.first }
            .fold(0L to 0L) { (sum, prevEnd), current ->
                val start = maxOf(prevEnd + 1, current.first)
                sum + maxOf(0, current.last - start + 1) to maxOf(prevEnd, current.last)
            }.first
}
