package com.renan.challengealurainkotlin.service


import com.renan.challengealurainkotlin.exception.AlreadyExistsException
import com.renan.challengealurainkotlin.repository.IncomeRepository
import com.renan.challengealurainkotlin.testutils.TestUtils
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

@ExtendWith(MockKExtension::class)
class IncomeServiceTest {

    @MockK
    private lateinit var repository: IncomeRepository

    @InjectMockKs
    private lateinit var service: IncomeService

    @BeforeEach
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    @DisplayName("given a income, should save it if there's no income with same description in database")
    fun shouldSaveIncome() {
        val income = TestUtils().createIncome()

        every { repository.findByDescriptionIgnoreCase(any()) } returns Optional.empty()
        every { repository.save(income) } returns income

        val incomeSaved = service.insert(income)

        verify { repository.findByDescriptionIgnoreCase(any()) }
        assertEquals(income, incomeSaved)
    }

    @Test
    @DisplayName("given a income, should throw an exception if there's a income with same description in database")
    fun shouldTrhowAnException() {
        val income = TestUtils().createIncome()

        every { repository.findByDescriptionIgnoreCase(income.description) } returns Optional.of(income)
        every { repository.save(income) } returns income

        Assertions.assertThrows(AlreadyExistsException::class.java) {
            service.insert(income)
        }
    }
}