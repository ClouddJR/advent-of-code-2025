package com.clouddjr.advent2025

import java.util.BitSet

class Day10(input: List<String>) {
    private val machines = input.map { Machine.from(it) }

    private val options = machines.associateWith { machine ->
        machine.buttons.powerSet().map { buttons ->
            val current = BitSet(machine.diagram.size())
            buttons.flatten().forEach { current.flip(it) }
            current to buttons
        }.groupBy({ it.first }, { it.second })
    }

    fun solvePart1() =
        machines.sumOf { machine ->
            options.getValue(machine).getValue(machine.diagram).minOf { it.size }
        }

    fun solvePart2() =
        machines.sumOf { machine ->
            machine.fewestPresses(machine.joltages)
        }

    private fun Machine.fewestPresses(
        joltages: List<Int>,
        cache: MutableMap<List<Int>, Int> = mutableMapOf()
    ): Int =
        when {
            joltages.all { it == 0 } -> 0
            joltages.any { it < 0 } -> 10_000_000
            else -> cache.getOrPut(joltages) {
                val target = BitSet().apply {
                    joltages.forEachIndexed { i, j -> set(i, j % 2 == 1) }
                }

                val candidates = options.getValue(this)[target] ?: return@getOrPut 10_000_000

                candidates.minOf { buttons ->
                    val newJoltages = IntArray(joltages.size) { joltages[it] }
                    buttons.flatten().forEach { newJoltages[it]-- }
                    2 * this.fewestPresses(newJoltages.map { it / 2 }, cache) + buttons.size
                }
            }
        }

    private fun <T> List<T>.powerSet(): List<List<T>> =
        (0 until (1 shl size)).map { state ->
            filterIndexed { i, _ -> state shr i and 1 == 1 }
        }

    private data class Machine(
        val diagram: BitSet,
        val buttons: List<List<Int>>,
        val joltages: List<Int>
    ) {
        companion object {
            fun from(line: String): Machine {
                val diagram = BitSet().apply {
                    line.substringAfter("[").substringBefore("]").forEachIndexed { i, c -> set(i, c == '#') }
                }
                val buttons = line.substringAfter("] ").substringBefore(" {").split(" ").map { button ->
                    button.trim('(', ')').split(",").map { it.toInt() }
                }
                val joltages = line.substringAfter("{").substringBefore("}").split(",").map { it.toInt() }

                return Machine(diagram, buttons, joltages)
            }
        }
    }
}
