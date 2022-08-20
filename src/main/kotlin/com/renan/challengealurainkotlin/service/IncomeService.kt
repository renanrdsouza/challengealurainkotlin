package com.renan.challengealurainkotlin.service

import com.renan.challengealurainkotlin.exception.AlreadyExistsException
import com.renan.challengealurainkotlin.model.Income
import com.renan.challengealurainkotlin.repository.IncomeRepository
import org.springframework.stereotype.Service

@Service
class IncomeService(
    private val incomeRepository: IncomeRepository
) {

    fun insert(incomeToSave: Income): Income {
        val incomes = incomeRepository.findByDescriptionIgnoreCase(incomeToSave.description)

        if (incomes.isEmpty) {
            return save(incomeToSave)
        } else {
            throw AlreadyExistsException("Income already exists in database.")
        }
    }

    fun save(income: Income) = incomeRepository.save(income)
}
