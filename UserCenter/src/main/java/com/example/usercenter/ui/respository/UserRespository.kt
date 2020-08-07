package com.example.usercenter.ui.respository

import android.database.Observable
import com.example.baselibrary.data.net.RetrofitFactory
import com.example.baselibrary.data.protocal.BaseResponse
import com.example.usercenter.ui.data.api.UserAPi
import com.example.usercenter.ui.data.protocol.RegisterReq
import javax.inject.Inject

class UserRespository @Inject constructor(){
    /*
        用户注册
     */
    fun register(mobile:String,pwd:String,verifyCode:String): rx.Observable<BaseResponse<String>> {
        return RetrofitFactory.instance.create(UserAPi::class.java).register(RegisterReq(mobile,pwd,verifyCode))
    }
}