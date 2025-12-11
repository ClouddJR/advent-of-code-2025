package com.clouddjr.advent2025

import com.clouddjr.advent2025.Day09.CellType.BORDER
import com.clouddjr.advent2025.Day09.CellType.INSIDE
import com.clouddjr.advent2025.Day09.CellType.OUTSIDE
import com.clouddjr.advent2025.utils.Point2D
import kotlin.math.abs

class Day09(input: List<String>) {
    private val points = input.map {
        Point2D(it.substringBefore(",").toInt(), it.substringAfter(",").toInt())
    }

    private val pointsPairs = points.flatMapIndexed { i, p1 ->
        points.drop(i + 1).map { p2 -> p1 to p2 }
    }

    fun solvePart1() = pointsPairs.maxOf { (p1, p2) -> rectangleArea(p1, p2) }

    fun solvePart2(): Long {
        val uniqueX = listOf(Int.MIN_VALUE) + points.map { it.x }.distinct().sorted().withGaps() + Int.MAX_VALUE
        val uniqueY = listOf(Int.MIN_VALUE) + points.map { it.y }.distinct().sorted().withGaps() + Int.MAX_VALUE

        val indexedX = uniqueX.withIndex().associate { it.value to it.index }
        val indexedY = uniqueY.withIndex().associate { it.value to it.index }

        val grid = Array(uniqueY.size) { Array(uniqueX.size) { INSIDE } }

        (points + points.first()).zipWithNext { p1, p2 ->
            val yRange = indexedY.getValue(minOf(p1.y, p2.y))..indexedY.getValue(maxOf(p1.y, p2.y))
            val xRange = indexedX.getValue(minOf(p1.x, p2.x))..indexedX.getValue(maxOf(p1.x, p2.x))

            yRange.forEach { y ->
                xRange.forEach { x ->
                    grid[y][x] = BORDER
                }
            }
        }

        val queue = ArrayDeque(listOf(Point2D(0, 0)))
        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            if (grid[current.y][current.x] != INSIDE) continue
            grid[current.y][current.x] = OUTSIDE
            queue += current.neighbours().filter { it.y in grid.indices && it.x in grid[it.y].indices }
        }

        val prefixSum = Array(uniqueY.size + 1) { IntArray(uniqueX.size + 1) }
        for (y in 1..prefixSum.lastIndex) {
            for (x in 1..prefixSum[y].lastIndex) {
                val isOutside = if (grid[y - 1][x - 1] == OUTSIDE) 1 else 0
                prefixSum[y][x] = isOutside + prefixSum[y][x - 1] + prefixSum[y - 1][x] - prefixSum[y - 1][x - 1]
            }
        }

        return pointsPairs.maxOf { (p1, p2) ->
            val x1 = indexedX.getValue(minOf(p1.x, p2.x))
            val x2 = indexedX.getValue(maxOf(p1.x, p2.x))
            val y1 = indexedY.getValue(minOf(p1.y, p2.y))
            val y2 = indexedY.getValue(maxOf(p1.y, p2.y))

            val outside = prefixSum[y2 + 1][x2 + 1] - prefixSum[y2 + 1][x1] - prefixSum[y1][x2 + 1] + prefixSum[y1][x1]

            if (outside > 0) 0 else rectangleArea(p1, p2)
        }
    }

    private fun List<Int>.withGaps(): List<Int> = buildList {
        add(this@withGaps.first())
        this@withGaps.zipWithNext { current, next ->
            if (next - current > 1) add(current + 1)
            add(next)
        }
    }

    private fun rectangleArea(p1: Point2D, p2: Point2D) =
        (abs(p1.x - p2.x) + 1L) * (abs(p1.y - p2.y) + 1L)

    private enum class CellType { INSIDE, BORDER, OUTSIDE }
}
