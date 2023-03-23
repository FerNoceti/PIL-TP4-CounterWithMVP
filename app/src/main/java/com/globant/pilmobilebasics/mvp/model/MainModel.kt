package com.globant.pilmobilebasics.mvp.model

import com.globant.pilmobilebasics.mvp.contract.MainContract
import com.globant.pilmobilebasics.util.Constants.ZERO

class MainModel : MainContract.Model {

    private var count = ZERO

    override fun getCount(): String = count.toString()

    override fun reset() {
        count = 0
    }

    override fun increment(n: String) {
        count += n.toInt()
    }

    override fun decrement(n: String) {
        count -= n.toInt()
    }
}
