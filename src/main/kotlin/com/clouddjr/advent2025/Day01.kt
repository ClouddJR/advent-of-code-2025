package com.clouddjr.advent2025


class Day01(private val input: List<String>) {
    fun solvePart1(): Int {
        var dial = 50
        var zeros = 0

        for (rotation in input) {
            val dir = rotation[0]
            val distance = rotation.drop(1).toInt()

            val sign = if (dir == 'R') 1 else -1

            dial = (dial + distance * sign).mod(100)

            if (dial == 0) {
                zeros++
            }
        }

        return zeros
    }

    fun solvePart2(): Int {
        var dial = 50
        var zeros = 0

        for (rotation in input) {
            val dir = rotation[0]
            val distance = rotation.drop(1).toInt()

            if (dir == 'R') {
                dial += distance
                zeros += dial / 100
                dial = dial.mod(100)
            } else {
                zeros += distance / 100
                if (dial != 0 && distance % 100 >= dial) {
                    zeros++
                }
                dial = (dial - distance).mod(100)
            }
        }

        return zeros
    }
}
