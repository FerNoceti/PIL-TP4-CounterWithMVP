package com.globant.pilmobilebasics.mvp.view

import android.app.Activity
import android.widget.Toast
import com.globant.pilmobilebasics.mvp.view.base.ActivityView
import com.globant.pilmobilebasics.databinding.ActivityMainBinding
import com.globant.pilmobilebasics.mvp.contract.MainContract
import com.globant.pilmobilebasics.util.Constants.MessageInputError

class MainView(activity: Activity) : ActivityView(activity), MainContract.View {

    private var binding: ActivityMainBinding = ActivityMainBinding.inflate(activity.layoutInflater)

    init {
        activity.setContentView(binding.root)
    }

    override fun setCount(count: String) {
        binding.countLabel.text = count
    }

    override fun getNumber(): String {
        return binding.editText.text.toString()
    }

    override fun checkNumber(): Boolean {
        return getNumber().isNotEmpty()
    }

    override fun showNumberError() {
        Toast.makeText(activity, MessageInputError, Toast.LENGTH_SHORT).show()
    }

    override fun onIncrementButtonPressed(onClick: () -> Unit) {
        binding.incrementButton.setOnClickListener { onClick() }
    }

    override fun onDecrementButtonPressed(onClick: () -> Unit) {
        binding.decrementButton.setOnClickListener { onClick() }
    }

    override fun onResetButtonPressed(onClick: () -> Unit) {
        binding.resetButton.setOnClickListener { onClick() }
    }
}
