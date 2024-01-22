package com.example.kakao_login

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, BuildConfig.KAKAO_NATIVE_APP_KEY)
        //공유하면 안 되는 키를 local property에 넣고 가져다가 쓴다
    }
}