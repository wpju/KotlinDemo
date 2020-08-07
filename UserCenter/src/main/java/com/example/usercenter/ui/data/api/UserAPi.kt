package com.example.usercenter.ui.data.api


import com.example.baselibrary.data.protocal.BaseResponse
import com.example.usercenter.ui.data.protocol.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface UserAPi {

    @POST("userCenter/register")
    fun register(@Body  req :RegisterReq) : Observable<BaseResponse<String>>
}