package com.clouddjr.advent2025.utils

data class Point2D(val x: Int, val y: Int) {
    fun allNeighbours() =
        listOf(
            Point2D(x - 1, y),
            Point2D(x + 1, y),
            Point2D(x, y - 1),
            Point2D(x, y + 1),
            Point2D(x - 1, y - 1),
            Point2D(x + 1, y - 1),
            Point2D(x - 1, y + 1),
            Point2D(x + 1, y + 1),
        )

    fun neighbours() =
        listOf(
            Point2D(x - 1, y),
            Point2D(x + 1, y),
            Point2D(x, y - 1),
            Point2D(x, y + 1),
        )
}
