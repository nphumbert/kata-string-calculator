package com.nphumbert.calculator

import com.pholser.junit.quickcheck.Property
import com.pholser.junit.quickcheck.generator.InRange
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitQuickcheck::class)
class StringCalculatorTest {

    @Test
    fun should_compute_zero_for_empty_string() {
        assertThat(add("")).isEqualTo(0)
    }

    @Property(shrink = false)
    fun should_compute_sum_for_one_number(@InRange(minInt = 0) number: Int) {
        assertThat(add(number.toString())).isEqualTo(number)
    }

    @Property(shrink = false)
    fun should_compute_sum_for_any_amount_of_numbers_separated_by_a_comma(numbers: List<@InRange(minInt = 0, maxInt = 10000) Int>) {
        assertThat(add(numbers.joinToString(","))).isEqualTo(numbers.sum())
    }
}