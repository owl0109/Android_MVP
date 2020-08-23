package com.kj_sample.mvp.model

interface IUser {
    //モデル
    //データを所持するクラス(アクセスや参照、検索も可能？)

    fun getName(): String?

    fun getPassWord(): String?

    fun checkUserValidity(name: String?, password: String?): Int
}