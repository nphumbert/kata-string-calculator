package com.nphumbert.calculator

fun add(numbers: String, separator: Char = ','): Int {
    return numbers.split(separator).map { it.toIntHandlingEmpty() }.sum()
}

private fun String.toIntHandlingEmpty(): Int =
        if (isEmpty()) {
            0
        } else {
            toInt()
        }