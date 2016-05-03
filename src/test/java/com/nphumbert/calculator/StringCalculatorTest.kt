package com.nphumbert.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class StringCalculatorTest {

    @Test
    fun should_compute_zero_for_empty_string() {
        assertThat(add("")).isEqualTo(0)
    }

}