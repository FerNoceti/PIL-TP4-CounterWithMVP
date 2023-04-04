package com.globant.pilmobilebasics.mvp.presenter

import com.globant.pilmobilebasics.mvp.contract.MainContract

class MainPresenter(private val model: MainContract.Model, private val view: MainContract.View) :
    MainContract.Presenter {

    init {
        view.onIncrementButtonPressed { onIncrementButtonPressed() }
        view.onDecrementButtonPressed { onDecrementButtonPressed() }
        view.onResetButtonPressed { onResetButtonPressed() }

        view.setCount(model.counter.toString())
    }

    override fun onIncrementButtonPressed() {
        if (view.getNumber().isNotEmpty()) {
            model.increment(view.getNumber().toInt())
            view.setCount(model.counter.toString())
        } else {
            view.showNumberError()
        }
    }

    override fun onDecrementButtonPressed() {
        if (view.getNumber().isNotEmpty()) {
            model.decrement(view.getNumber().toInt())
            view.setCount(model.counter.toString())
        } else {
            view.showNumberError()
        }
    }

    override fun onResetButtonPressed() {
        model.reset()
        view.setCount(model.counter.toString())
        view.clear()
    }
}
