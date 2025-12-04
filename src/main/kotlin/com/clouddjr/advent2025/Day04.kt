package com.clouddjr.advent2025

import com.clouddjr.advent2025.utils.Point2D

class Day04(input: List<String>) {
    private val rolls = input.flatMapIndexed { y, row ->
        row.mapIndexedNotNull { x, char ->
            if (char == '@') Point2D(x, y) else null
        }
    }.toSet()

    fun solvePart1() = rolls.removable().size

    fun solvePart2(): Int {
        val remaining = generateSequence(rolls) { current ->
            (current - current.removable()).takeIf { it.size < current.size }
        }.last()

        return rolls.size - remaining.size
    }

    private fun Set<Point2D>.removable() =
        filter { roll -> roll.allNeighbours().count { it in this } < 4 }.toSet()
}
