package com.clouddjr.advent2025

class Day07(private val input: List<String>) {
    fun solvePart1() = analyzeManifold().splits

    fun solvePart2() = analyzeManifold().timelines

    private fun analyzeManifold(): ManifoldResult {
        var splits = 0
        val score = LongArray(input[0].length) { if (input[0][it] == 'S') 1 else 0 }

        for (y in 1..input.lastIndex) {
            for (x in input[y].indices) {
                if (input[y][x] == '^' && score[x] > 0) {
                    splits++
                    score[x - 1] += score[x]
                    score[x + 1] += score[x]
                    score[x] = 0
                }
            }
        }

        return ManifoldResult(splits = splits, timelines = score.sum())
    }

    data class ManifoldResult(val splits: Int, val timelines: Long)
}
