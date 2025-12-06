package com.clouddjr.advent2025

class Day06(private val input: List<String>) {
    fun solvePart1(): Long {
        val numbers = input.dropLast(1).map { it.trim().split(REGEX_WHITESPACE).map(String::toLong) }
        val symbols = input.last().trim().split(REGEX_WHITESPACE)

        return symbols.indices.sumOf { col ->
            val values = numbers.map { it[col] }
            if (symbols[col] == "*") values.reduce(Long::times) else values.sum()
        }
    }

    fun solvePart2(): Long {
        val columns = input.first().indices.map { col ->
            input.dropLast(1).map { it[col] }.joinToString("").trim()
        }
        val symbols = input.last()

        return symbols.withIndex()
            .filter { !it.value.isWhitespace() }
            .sumOf { (col, symbol) ->
                val numbers = columns.drop(col).takeWhile { it.isNotEmpty() }.map { it.toLong() }
                if (symbol == '*') numbers.reduce(Long::times) else numbers.sum()
            }
    }


    companion object {
        val REGEX_WHITESPACE = """\s+""".toRegex()
    }
}
