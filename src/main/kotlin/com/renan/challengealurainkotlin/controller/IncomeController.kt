package com.renan.challengealurainkotlin.controller

import com.renan.challengealurainkotlin.controller.IncomeController.Companion.INCOME_PATH
import com.renan.challengealurainkotlin.model.Income
import com.renan.challengealurainkotlin.service.IncomeService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@Controller
@RequestMapping(INCOME_PATH)
class IncomeController(
    private val incomeService: IncomeService
) {

    companion object {
        const val INCOME_PATH = "/incomes"
    }

    @PostMapping
    fun insert(
        @RequestBody @Valid income: Income,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<Income> {
        incomeService.insert(income)
        val uri = uriBuilder.path("/incomes").build().toUri()

        return ResponseEntity.created(uri).build()
    }
}