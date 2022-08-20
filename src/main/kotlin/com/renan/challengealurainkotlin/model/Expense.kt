package com.renan.challengealurainkotlin.model

import com.fasterxml.jackson.annotation.JsonFormat
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "EXPENSE")
data class Expense(

    /* Id único da entidade EXPENSE*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @field:NotNull
    val description: String,

    @field:NotNull
    val amount: BigDecimal,

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    val date: LocalDate = LocalDate.now()
) {
}