package com.globant.pilmobilebasics.mvp.contract

interface MainContract {

    interface Model {
        fun getCount(): String
        fun reset()
        fun increment(n: String)
        fun decrement(n: String)
    }

    interface View {
        fun setCount(count: String)
        fun getNumber(): String
        fun checkNumber(): Boolean
        fun showNumberError()
        fun onIncrementButtonPressed(onClick: () -> Unit)
        fun onDecrementButtonPressed(onClick: () -> Unit)
        fun onResetButtonPressed(onClick: () -> Unit)
    }

    interface Presenter {
        fun onIncrementButtonPressed()
        fun onDecrementButtonPressed()
        fun onResetButtonPressed()
    }
}
