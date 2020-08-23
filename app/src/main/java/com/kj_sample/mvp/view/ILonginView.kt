package com.kj_sample.mvp.view

//Viewには実装すべき処理を書いておく
interface ILonginView {
    //正直一番つかめていない,,,
    //viewで行うべき処理(プログレスバーを表示とか)を実装忘れないように書いておくクラス？
    //これに従ってActivityにて実装する?
    //view(layout)に対して○○をするために何かを書く

    fun onClearText()
    fun onLoginResult(result:Boolean,code:Int)
    fun onSetProgressBarVisibility(visibility:Int)
}