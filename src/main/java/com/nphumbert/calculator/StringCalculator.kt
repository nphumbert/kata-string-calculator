package com.nphumbert.calculator

fun add(numbers: String): Int {
    return numbers.toIntHandlingEmpty()
}

private fun String.toIntHandlingEmpty(): Int = if (isEmpty()) { 0 } else { toInt() }