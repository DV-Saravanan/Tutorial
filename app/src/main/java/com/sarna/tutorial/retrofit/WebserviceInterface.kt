package com.sarna.tutorial.retrofit

interface WebserviceInterface {
    fun onWebserviceSuccess(strRes: String)
    fun onWebserviceFail(strRes: String)
}