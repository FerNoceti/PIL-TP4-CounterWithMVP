package com.globant.pilmobilebasics.mvp.presenter

import com.globant.pilmobilebasics.mvp.contract.MainContract
import com.globant.pilmobilebasics.mvp.model.MainModel
import com.globant.pilmobilebasics.util.Constants.ZERO
import com.globant.pilmobilebasics.util.Constants.minusTestInput
import com.globant.pilmobilebasics.util.Constants.testInput
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class MainPresenterTest {

    private lateinit var model: MainContract.Model

    @MockK
    private lateinit var view: MainContract.View

    private lateinit var presenter: MainContract.Presenter

    @Before
    fun setUp() {
        MockKAnnotations.init(this, relaxed = true)
        model = MainModel()
        presenter = MainPresenter(model, view)
    }

    @Test
    fun `when increment button is pressed and input is valid, model is called and view is updated`() {
        // Given
        every { view.checkNumber() } returns true
        every { view.getNumber() } returns testInput

        // When
        presenter.onIncrementButtonPressed()

        // Then
        verify { view.checkNumber() }
        verify { view.getNumber() }
        verify { view.setCount(testInput) }
        assert(model.getCount() == testInput)
    }

    @Test
    fun `when decrement button is pressed and input is valid, model is called and view is updated`() {
        // Given
        every { view.checkNumber() } returns true
        every { view.getNumber() } returns testInput

        // When
        presenter.onDecrementButtonPressed()

        // Then
        verify { view.checkNumber() }
        verify { view.getNumber() }
        verify { view.setCount(minusTestInput) }
        assert(model.getCount() == minusTestInput)
    }

    @Test
    fun `when reset button is pressed, model is called and view is updated`() {
        // Given
        model.increment(testInput)

        // When
        presenter.onResetButtonPressed()

        // Then
        verify { view.setCount(ZERO.toString()) }
        assert(model.getCount() == ZERO.toString())
    }

    @Test
    fun `when increment button is pressed and input is invalid, view shows error`() {
        // Given
        every { view.checkNumber() } returns false

        // When
        presenter.onIncrementButtonPressed()

        // Then
        verify { view.checkNumber() }
        verify { view.showNumberError() }
    }

    @Test
    fun `when decrement button is pressed and input is invalid, view shows error`() {
        // Given
        every { view.checkNumber() } returns false

        // When
        presenter.onDecrementButtonPressed()

        // Then
        verify { view.checkNumber() }
        verify { view.showNumberError() }
    }
}
