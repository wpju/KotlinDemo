package com.example.usercenter.ui.service

import com.example.baselibrary.data.protocal.BaseResponse
import rx.Observable
import java.util.*

interface UserService {
    fun register(mobile:String,pwd:String,verifyCode:String): Observable<Boolean>;

}