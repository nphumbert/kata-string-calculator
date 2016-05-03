package com.nphumbert.calculator

fun add(numbers: String): Int {
    return numbers.split(",").map { it.toIntHandlingEmpty() }.sum()
}

private fun String.toIntHandlingEmpty(): Int =
        if (isEmpty()) {
            0
        } else {
            toInt()
        }