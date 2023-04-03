package com.globant.pilmobilebasics.mvp.presenter

import com.globant.pilmobilebasics.mvp.contract.MainContract

class MainPresenter(private val model: MainContract.Model, private val view: MainContract.View) :
    MainContract.Presenter {

    init {
        view.onIncrementButtonPressed { onIncrementButtonPressed() }
        view.onDecrementButtonPressed { onDecrementButtonPressed() }
        view.onResetButtonPressed { onResetButtonPressed() }
    }

    override fun onIncrementButtonPressed() {
        if (view.checkNumber()) {
            model.increment(view.getNumber())
            view.setCount(model.getCount())
        } else {
            view.showNumberError()
        }
    }

    override fun onDecrementButtonPressed() {
        if (view.checkNumber()) {
            model.decrement(view.getNumber())
            view.setCount(model.getCount())
        } else {
            view.showNumberError()
        }
    }

    override fun onResetButtonPressed() {
        model.reset()
        view.setCount(model.getCount())
    }
}
