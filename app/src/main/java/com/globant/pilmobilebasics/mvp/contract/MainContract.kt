package com.globant.pilmobilebasics.mvp.contract

interface MainContract {

    interface Model {
        var counter: Int
        fun reset()
        fun increment(n: Int)
        fun decrement(n: Int)
    }

    interface View {
        fun setCount(count: String)
        fun getNumber(): String
        fun showNumberError()
        fun clear()
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
