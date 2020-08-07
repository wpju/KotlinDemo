package com.example.usercenter.ui.presenter

import androidx.annotation.MainThread
import com.example.baselibrary.ext.excute
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.rx.BaseSubscriber
import com.example.usercenter.ui.di.module.component.DaggerUserComponent
import com.example.usercenter.ui.presenter.view.RegisterView
import com.example.usercenter.ui.service.UserService
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class RegisterPresenter  @Inject constructor():BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserService

    fun register(mobile:String,verifyCode: String,pwd: String) {
        userService.register(mobile, verifyCode, pwd).excute(object : BaseSubscriber<Boolean>() {
                override fun onNext(t: Boolean) {
                    mView.onRegisterResult(t);
                }
            },lifecycleProvider)
    }

}