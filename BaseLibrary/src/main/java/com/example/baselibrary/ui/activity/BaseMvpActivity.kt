package com.example.baselibrary.ui.activity

import android.os.Bundle
import com.example.baselibrary.common.BaseApplication
import com.example.baselibrary.di.component.ActivityComponent
import com.example.baselibrary.di.component.DaggerActivityComponent
import com.example.baselibrary.di.module.ActivityModule
import com.example.baselibrary.di.module.LifeCycleModule
import com.example.baselibrary.presenter.BasePresenter
import com.example.baselibrary.presenter.view.BaseView
import javax.inject.Inject

open class BaseMvpActivity<T : BasePresenter<*>> :BaseActivity(),BaseView{

     //Presenter泛型，Dagger注入
     @Inject
    lateinit var mPresenter: T

    lateinit var activityComponent: ActivityComponent


    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    override fun onError() {
        TODO("Not yet implemented")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityInJection()
    }

    private fun initActivityInJection() {
        activityComponent= DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent).
                lifeCycleModule(LifeCycleModule(this))
                .activityModule(ActivityModule(this)).build()
    }

}