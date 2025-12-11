package com.clouddjr.advent2025

class Day11(input: List<String>) {
    private val graph = input.associate { line ->
        val (device, output) = line.split(": ")
        device to output.split(" ")
    }

    fun solvePart1() =
        paths("you", "out")

    fun solvePart2() =
        paths("svr", "fft") * paths("fft", "dac") * paths("dac", "out") +
                paths("svr", "dac") * paths("dac", "fft") * paths("fft", "out")

    private fun paths(
        from: String,
        to: String,
        cache: MutableMap<String, Long> = mutableMapOf(),
    ): Long {
        if (from == to) return 1L

        return cache.getOrPut(from) {
            graph[from]?.sumOf { next -> paths(next, to, cache) } ?: 0L
        }
    }
}
