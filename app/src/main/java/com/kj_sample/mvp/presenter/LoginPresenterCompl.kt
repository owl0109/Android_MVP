package com.kj_sample.mvp.presenter

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.kj_sample.mvp.model.IUser
import com.kj_sample.mvp.model.UserModel
import com.kj_sample.mvp.view.ILonginView


class LoginPresenterCompl(var iloginView:ILonginView?) : ILoginPresenter {
    //ViewとModel両方持っている
    //相互のやり取り仲介している
    //もしmodelのデータが○○なら××してねって命令している

    var user: IUser? = null
    var handler: Handler? = null
    init {
        //ユーザの登録
        initUser()
        //ハンドラー設定
        handler = Handler(Looper.getMainLooper())

    }
    override fun clear() {
        //viewのclearTextを実行する
        iloginView?.onClearText()
    }

    override fun doLogin(name: String?, password: String?) {
        //ログイン処理
        val code = user?.checkUserValidity(name,password)
        if(code != null) {
            //initにて作成したUserと名前/パスワードが同じか判定。
            val result = if (code != 0) false else true
            handler?.postDelayed(Runnable { iloginView?.onLoginResult(result, code) }, 500)
        }
        Log.d("[KJ_doLogin]","処理完了")
    }

    override fun setProgressBarVisiblity(visiblity: Int) {
        //プログレスバーの表示・非表示を切り替える
        iloginView?.onSetProgressBarVisibility(visiblity)
        Log.d("[KJ_setProgresBarVisiblity]","処理完了")
    }

    private fun initUser(){
        //正解ユーザーを作成。
        user = UserModel("mvp","mvp")
    }
}