package com.globant.pilmobilebasics.mvp.presenter

import com.globant.pilmobilebasics.mvp.contract.MainContract
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class MainPresenterTest {

    private lateinit var presenter: MainContract.Presenter
    private lateinit var view: MainContract.View
    private lateinit var model: MainContract.Model

    @Before
    fun setUp() {
        view = mockk(relaxed = true)
        model = mockk(relaxed = true)
        presenter = MainPresenter(model, view)
    }

    @Test
    fun `when increment button is pressed and input is valid, model is called and view is updated`() {
        // Given
        val input = "2"
        every { view.checkNumber() } returns true
        every { view.getNumber() } returns input

        // When
        presenter.onIncrementButtonPressed()

        // Then
        verify { view.checkNumber() }
        verify { view.getNumber() }
        verify { model.increment(input) }
        verify { view.setCount(any()) }
    }

    @Test
    fun `when decrement button is pressed and input is valid, model is called and view is updated`() {
        // Given
        val input = "2"
        every { view.checkNumber() } returns true
        every { view.getNumber() } returns input

        // When
        presenter.onDecrementButtonPressed()

        // Then
        verify { view.checkNumber() }
        verify { view.getNumber() }
        verify { model.decrement(input) }
        verify { view.setCount(any()) }
    }

    @Test
    fun `when reset button is pressed, model is called and view is updated`() {
        // When
        presenter.onResetButtonPressed()

        // Then
        verify { model.reset() }
        verify { view.setCount(any()) }
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
        verify(exactly = 0) { model.increment(any()) }
        verify(exactly = 0) { view.setCount(any()) }
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
        verify(exactly = 0) { model.decrement(any()) }
        verify(exactly = 0) { view.setCount(any()) }
    }
}
