package com.globant.pilmobilebasics.mvp.presenter

import com.globant.pilmobilebasics.mvp.contract.MainContract
import com.globant.pilmobilebasics.mvp.model.MainModel
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class MainPresenterTest {

    private var view: MainContract.View = mockk(relaxed = true)

    private lateinit var presenter: MainContract.Presenter

    @Before
    fun setUp() {
        presenter = MainPresenter(MainModel(), view)

        verify { view.onIncrementButtonPressed(any()) }
        verify { view.onDecrementButtonPressed(any()) }
        verify { view.onResetButtonPressed(any()) }
    }

    @Test
    fun `when increment button is pressed and input is valid, model is called and view is updated`() {
        // Given
        every { view.getNumber() } returns testInputString

        // When
        presenter.onIncrementButtonPressed()

        // Then
        verify { view.getNumber() }
        verify { view.setCount(testInput.toString()) }
    }

    @Test
    fun `when decrement button is pressed and input is valid, model is called and view is updated`() {
        // Given
        every { view.getNumber() } returns testInputString

        // When
        presenter.onDecrementButtonPressed()

        // Then
        verify { view.getNumber() }
        verify { view.setCount(minusTestInput.toString()) }
    }

    @Test
    fun `when reset button is pressed, model is called and view is updated`() {
        // When
        presenter.onResetButtonPressed()

        // Then
        verify { view.setCount(ZERO.toString()) }
        verify { view.clear() }
    }

    @Test
    fun `when increment button is pressed and input is invalid, view shows error`() {
        // When
        presenter.onIncrementButtonPressed()

        // Then
        verify { view.showNumberError() }
    }

    @Test
    fun `when decrement button is pressed and input is invalid, view shows error`() {
        // When
        presenter.onDecrementButtonPressed()

        // Then}
        verify { view.showNumberError() }
    }
    companion object {
        private const val ZERO = 0
        private const val testInputString = "5"
        private const val testInput = 5
        private const val minusTestInput = -5
    }
}
