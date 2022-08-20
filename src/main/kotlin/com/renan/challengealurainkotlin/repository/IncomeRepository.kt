package com.renan.challengealurainkotlin.repository

import com.renan.challengealurainkotlin.model.Income
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface IncomeRepository : JpaRepository<Income, Long>{

    fun findByDescriptionIgnoreCase(description: String): Optional<Income>
}
