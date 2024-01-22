package com.example.kakao_login

import KakaoAuthViewModel
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kakao_login.ui.theme.Kakao_loginTheme
import java.security.MessageDigest

class MainActivity : ComponentActivity() {

    private val kakaoAuthViewModel : KakaoAuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Kakao_loginTheme {
                // 테마에서 가져온 'background' 색상을 사용하는 표면 컨테이너
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    KakaoLoginView(kakaoAuthViewModel)
                }
            }
        }
    }

}

@Composable
fun KakaoLoginView(viewModel: KakaoAuthViewModel) {

    val isLoggedIn = viewModel.isLoggedIn.collectAsState()
    val loginStatusInfoTitle = if(isLoggedIn.value) "로그인 상태" else "로그아웃 상태"

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,//가운데 정렬
        verticalArrangement = Arrangement.spacedBy(20.dp)//간격
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {viewModel.kakaoLogin()}) {
            Text(text = "카카오 로그인")
        }
        Button(onClick = {viewModel.kakaoLogout()}) {
            Text(text = "카카오 로그아웃")
        }
        Text(
            text = loginStatusInfoTitle,
            textAlign = TextAlign.Center, // textAlign 대신에 style 사용
            fontSize = 20.sp
        )
    }
}


