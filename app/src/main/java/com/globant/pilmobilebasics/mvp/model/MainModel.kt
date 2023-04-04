package com.globant.pilmobilebasics.mvp.model

import com.globant.pilmobilebasics.mvp.contract.MainContract

class MainModel : MainContract.Model {

    override var counter: Int = ZERO

    override fun reset() {
        counter = 0
    }

    override fun increment(n: Int) {
        counter += n
    }

    override fun decrement(n: Int) {
        counter -= n
    }

    companion object {
        private const val ZERO = 0
    }
}
