package com.globant.pilmobilebasics.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.globant.pilmobilebasics.mvp.model.MainModel
import com.globant.pilmobilebasics.mvp.presenter.MainPresenter
import com.globant.pilmobilebasics.mvp.view.MainView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainPresenter(MainModel(), MainView(this))
    }
}
