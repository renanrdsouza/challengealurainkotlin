package com.renan.challengealurainkotlin.testutils

import com.renan.challengealurainkotlin.model.Income
import java.math.BigDecimal
import java.time.LocalDate

class TestUtils {

    fun createIncome(): Income {
        return Income(
            id = null,
            description = "Any",
            amount = BigDecimal("100"),
            date = LocalDate.now()
        )
    }
}