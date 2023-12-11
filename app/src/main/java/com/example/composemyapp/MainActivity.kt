package com.example.composemyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * 튜토리얼 링크: https://developer.android.com/jetpack/compose/tutorial?hl=ko
 * java version: JAVA17
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MessageCard(Message("Android", "Jetpack Compose"))
        }
    }
}

// 함수를 구성 가능하게 하려면 @Composable 주석을 추가해야 합니다.
// @Preview 주석을 사용하면 앱을 빌드해서 Android 기기나 에뮬레이터에 설치하지 않고 미리 볼 수 있음
@Preview
@Composable
fun PreviewMessageCard(name: String = "zz") {
    Text(text = "Hello MessageCard, $name")
}

data class Message(val author: String, val body: String)

// Column: 수직적 정렬
// Row: 수평적 정렬
// Box: 요소를 쌓을 수 있다?(프레임인가)
@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(R.drawable.android),
            contentDescription = "Android Image",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {// 수직적 정렬 Row: 수평적 정렬
            Text(text = msg.author)
            Spacer(modifier = Modifier.height(128.dp))
            Text(text = msg.body)
        }
    }
}