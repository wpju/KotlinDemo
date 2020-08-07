package com.example.usercenter.ui.presenter.view

import com.example.baselibrary.presenter.view.BaseView

open interface RegisterView :BaseView {
    fun onRegisterResult(result:Boolean)
}