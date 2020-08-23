package com.kj_sample.mvp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.kj_sample.mvp.presenter.ILoginPresenter
import com.kj_sample.mvp.presenter.LoginPresenterCompl
import com.kj_sample.mvp.view.ILonginView

//Viewを継承させる
class MainActivity : ILonginView,AppCompatActivity() {
    private lateinit var editUser:EditText
    private lateinit var editPass:EditText
    private lateinit var btnLogin:Button
    private lateinit var btnClear:Button
    private lateinit var progressBar:ProgressBar
    private lateinit var loginPresenter:ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //findview
        editUser = this.findViewById(R.id.et_login_username)
        editPass = this.findViewById(R.id.et_login_password)
        btnLogin = this.findViewById(R.id.btn_login_login)
        btnClear = this.findViewById(R.id.btn_login_clear)
        progressBar = this.findViewById(R.id.progress_login)

        //setListener
        btnLogin.setOnClickListener(setOnClick())
        btnClear.setOnClickListener(setOnClick())

        //init
        loginPresenter = LoginPresenterCompl(this)
        loginPresenter.setProgressBarVisiblity(View.INVISIBLE)
    }

    //ボタンタップ時処理を実装する内部クラス
    private inner class setOnClick:View.OnClickListener {
        override fun onClick(p0: View?) {
            if (p0 != null){
                when(p0.id){
                    //クリアタップ時
                    R.id.btn_login_clear -> {
                        loginPresenter.clear()
                    }

                    //ログインタップ時
                    R.id.btn_login_login -> {
                        loginPresenter.setProgressBarVisiblity(View.VISIBLE)
                        btnClear.isEnabled = false
                        btnLogin.isEnabled = false
                        loginPresenter.doLogin(editUser.text.toString(),editPass.text.toString())
                    }
                }
            }
        }
    }

    override fun onClearText() {
        //cleaボタンタップ時に実際に呼ばれている
        //viewを継承したときにこの処理も継承。処理内容を書く

        editUser.setText("")
        editPass.setText("")
    }

    override fun onLoginResult(result: Boolean, code: Int) {
        //ログインの結果を表示する処理
        //viewを継承したときにこの処理も継承。
        loginPresenter.setProgressBarVisiblity(View.INVISIBLE)
        btnLogin.isEnabled = true
        btnClear.isEnabled = true
        if(result){
            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"Login Fail, code = " + code,Toast.LENGTH_SHORT).show();
        }
    }

    override fun onSetProgressBarVisibility(visibility: Int) {
        //これもviewの継承
        //プログレスバーの表示/非表示を切り替える
        progressBar.visibility = visibility
    }

}