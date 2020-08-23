package com.kj_sample.mvp.model

import android.os.Parcel
import android.os.Parcelable

//MVP のM(Model)担当
class UserModel(var userName:String,var password:String?) : IUser {
    //処理内容的にはデータの取得と成否判定のみ
    //DBなどにアクセスしてデータが正しいかの判断をすることが役割
    //MVCのMみたいな役割かな


    override fun getName(): String? {
        return userName
    }


    override fun getPassWord(): String? {
        return password
    }

    override fun checkUserValidity(name: String?, password: String?): Int {
        if (name==null||password==null||!name.equals(getName())||!password.equals(getPassWord())){
            return -1;
        }
        return 0
    }


}