package com.renan.challengealurainkotlin.testutils

import com.renan.challengealurainkotlin.model.Income
import java.math.BigDecimal
import java.time.LocalDate

class TestUtils {

    fun createIncome(
        id : Long? = null,
        description: String = "Any",
        amount: BigDecimal = BigDecimal("100"),
        date: LocalDate = LocalDate.now()
    ): Income {
        return Income(
            id = id,
            description = description,
            amount = amount,
            date = date
        )
    }
}