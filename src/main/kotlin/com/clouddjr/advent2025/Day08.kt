package com.clouddjr.advent2025

import com.clouddjr.advent2025.utils.Point3D
import org.jgrapht.alg.util.UnionFind

class Day08(input: List<String>) {
    private val points = input.map {
        val (x, y, z) = it.split(",")
        Point3D(x.toInt(), y.toInt(), z.toInt())
    }

    private val sortedPairs = points.flatMapIndexed { i, p1 ->
        points.drop(i + 1).map { p2 -> p1 to p2 }
    }.sortedBy { (p1, p2) -> p1 euclideanDistance p2 }

    fun solvePart1(pairsToConsider: Int): Int {
        val uf = UnionFind(points.toSet())

        sortedPairs.take(pairsToConsider).forEach { (p1, p2) -> uf.union(p1, p2) }

        return points.groupingBy { uf.find(it) }.eachCount().values
            .sortedDescending()
            .take(3)
            .reduce(Int::times)
    }

    fun solvePart2(): Int {
        val uf = UnionFind(points.toSet())

        sortedPairs.forEach { (p1, p2) ->
            uf.union(p1, p2)
            if (uf.numberOfSets() == 1) {
                return p1.x * p2.x
            }
        }

        error("No solution found")
    }
}
