package com.nphumbert.calculator

fun add(numbers: String, separator: Char = ','): Int {
    return numbers.split(separator).map { it.toIntHandlingEmpty() }.filter { it <= 1000 }.sum()
}

private fun String.toIntHandlingEmpty(): Int =
        if (isEmpty()) {
            0
        } else {
            toInt()
        }