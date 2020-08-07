package com.example.baselibrary.data.protocal

class BaseResponse<out T>(val status: Int,val msg: String,val data: T) {

}