package com.example.usercenter.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.baselibrary.ui.activity.BaseMvpActivity
import com.example.usercenter.R
import com.example.usercenter.ui.di.module.component.DaggerUserComponent
import com.example.usercenter.ui.presenter.RegisterPresenter
import com.example.usercenter.ui.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register);
        injection()
        mPresenter.mView=this
        mRegisterBtn.setOnClickListener {
            mPresenter.register(mMobileEt.text.toString(),
                mVerifyCodeBtn.text.toString(),mPwdEt.text.toString())
        }
    }

    override fun onRegisterResult(result: Boolean) {
        toast("注册成功")
    }


    fun injection(){
        DaggerUserComponent.builder().activityComponent(activityComponent).build().inject(this)
    }

}