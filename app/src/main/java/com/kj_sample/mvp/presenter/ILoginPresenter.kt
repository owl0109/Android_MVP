package com.kj_sample.mvp.presenter

interface ILoginPresenter {
    //viewに対して何かするというよりは裏で処理する感じ

    fun clear()
    fun doLogin(name: String?, passwd: String?)
    fun setProgressBarVisiblity(visiblity: Int)
}