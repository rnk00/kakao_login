package com.example.kakao_login

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //Kakao SDK 초기화
        KakaoSdk.init(this, "66c326deead3978e4a22ff91eddc0c36")
        //공유하면 안 되는 키를 local property에 넣고 가져다가 쓴다
    }
}
