package com.example.baselibrary.ext

import android.database.Observable
import com.example.baselibrary.data.protocal.BaseResponse
import com.example.baselibrary.rx.BaseFuncBoolean
import com.example.baselibrary.rx.BaseSubscriber
import com.trello.rxlifecycle.LifecycleProvider
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

fun  <T> rx.Observable<T>.excute(baseSubscriber: BaseSubscriber<T>, lifecycleProvider: LifecycleProvider<*>){
    this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .compose(lifecycleProvider.bindToLifecycle())
        .subscribe(baseSubscriber)
}

/*
    扩展Boolean类型数据转换
 */
fun <T> rx.Observable<BaseResponse<T>>.convertBoolean(): rx.Observable<Boolean> {
    return this.flatMap(BaseFuncBoolean())
}

