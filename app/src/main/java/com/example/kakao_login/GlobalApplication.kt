package com.example.kakao_login

import android.app.Application
import android.util.Log
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //Kakao SDK 초기화
        KakaoSdk.init(this, "3fb9a572bb1f2e3cd66d370d2f7888dd")

        Log.d("hash", "keyhash : ${Utility.getKeyHash(this)}")
    }
}
