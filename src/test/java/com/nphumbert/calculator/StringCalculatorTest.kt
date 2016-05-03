package com.nphumbert.calculator

import com.pholser.junit.quickcheck.Property
import com.pholser.junit.quickcheck.generator.InRange
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Math.abs

@RunWith(JUnitQuickcheck::class)
class StringCalculatorTest {

    @Test
    fun should_compute_zero_for_empty_string() {
        assertThat(add("")).isEqualTo(0)
    }

    @Property(shrink = false)
    fun should_compute_sum_for_one_number(@InRange(minInt = 0, maxInt = 1000) number: Int) {
        assertThat(add(number.toString())).isEqualTo(number)
    }

    @Property(shrink = false)
    fun should_compute_sum_for_any_amount_of_numbers_separated_by_a_comma(rawNumbers: List<Int>) {
        val numbers = rawNumbers.sanitize(1000)
        assertThat(add(numbers.joinToString(","))).isEqualTo(numbers.sum())
    }

    @Property(shrink = false)
    fun should_compute_sum_for_any_amount_of_numbers_separated_by_any_separator(rawNumbers: List<Int>, separator: Char) {
        val numbers = rawNumbers.sanitize(1000)
        assertThat(add(numbers.joinToString(separator.toString()), separator)).isEqualTo(numbers.sum())
    }

    @Property(shrink = false)
    fun should_compute_sum_ignoring_numbers_greater_than_1000(rawNumbers: List<Int>) {
        val numbers = rawNumbers.sanitize(100000)
        assertThat(add(numbers.joinToString(","))).isEqualTo(numbers.filter{ it <= 1000 }.sum())
    }

    private fun List<Int>.sanitize(max: Int): List<Int> = map { abs(it).mod(max) }

}