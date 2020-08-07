package com.example.usercenter.ui.service.imp

import com.example.baselibrary.ext.convertBoolean
import com.example.usercenter.ui.respository.UserRespository
import com.example.usercenter.ui.service.UserService
import rx.Observable
import javax.inject.Inject

class UserServiceImpl @Inject constructor() : UserService {

    @Inject
    lateinit var userRepository:UserRespository
    override fun register(mobile:String,pwd:String,verifyCode:String): Observable<Boolean> {

        return userRepository.register(mobile,pwd,verifyCode).convertBoolean()
    }
}