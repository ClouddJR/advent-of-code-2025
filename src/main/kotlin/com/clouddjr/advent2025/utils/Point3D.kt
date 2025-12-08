package com.clouddjr.advent2025.utils

import kotlin.math.pow
import kotlin.math.sqrt

data class Point3D(val x: Int, val y: Int, val z: Int) {
    infix fun euclideanDistance(other: Point3D): Double {
        return sqrt(
            (x - other.x).toDouble().pow(2) + (y - other.y).toDouble().pow(2) + (z - other.z).toDouble().pow(2)
        )
    }
}
