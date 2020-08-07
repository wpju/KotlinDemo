package com.example.baselibrary.rx

import rx.Subscriber

open class BaseSubscriber<T>: Subscriber<T>() {
    override fun onNext(t: T) {
        TODO("Not yet implemented")
    }

    override fun onCompleted() {
        TODO("Not yet implemented")
    }

    override fun onError(e: Throwable?) {
        TODO("Not yet implemented")
    }
}