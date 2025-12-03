package com.clouddjr.advent2025

class Day03(private val banks: List<String>) {
    fun solvePart1() =
        calculateJoltage(digits = 2)

    fun solvePart2() =
        calculateJoltage(digits = 12)

    private fun calculateJoltage(digits: Int) =
        banks.sumOf { bank ->
            (digits downTo 1).fold("" to 0) { (joltage, start), remaining ->
                val (max, maxPos) = (start..bank.length - remaining)
                    .map { bank[it] to it }
                    .maxBy { it.first }
                joltage + max to maxPos + 1
            }.first.toLong()
        }
}
