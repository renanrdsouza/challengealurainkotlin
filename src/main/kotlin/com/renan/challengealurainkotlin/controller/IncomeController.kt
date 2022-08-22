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
        const val ID_PATH = "/{id}"
    }

    @PostMapping
    fun insert(
        @RequestBody @Valid income: Income,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<Income> {
        incomeService.insert(income)
        val uri = uriBuilder.path(INCOME_PATH).build().toUri()

        return ResponseEntity.created(uri).build()
    }

    @GetMapping(INCOME_PATH, ID_PATH)
    fun getIncome(@PathVariable id: Long): ResponseEntity<Income> {
        return ResponseEntity.ok().body(incomeService.getBy(id))
    }

    @DeleteMapping(INCOME_PATH, ID_PATH)
    fun deleteIncome(@PathVariable id: Long) {
        incomeService.delete(id)
    }
}