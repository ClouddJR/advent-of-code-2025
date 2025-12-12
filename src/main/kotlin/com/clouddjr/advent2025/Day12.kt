package com.clouddjr.advent2025

class Day12(private val input: String) {
    fun solvePart1() =
        input.substringAfterLast("\n\n").lines().count { region ->
            val (dims, counts) = region.split(": ")
            val (w, h) = dims.split("x").map { it.toInt() }
            val total = counts.split(" ").sumOf { it.toInt() }
            (w / 3) * (h / 3) >= total
        }
}
