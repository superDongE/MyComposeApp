package com.example.composemyapp

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composemyapp.ui.theme.ComposeMyAppTheme
import com.example.composemyapp.ui.theme.ComposeMyAppThemeLight

/**
 * 튜토리얼 링크: https://developer.android.com/jetpack/compose/tutorial?hl=ko
 * java version: JAVA17
 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeMyAppThemeLight {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MessageCard(Message("Android", "Jetpack Compose"))
                }
            }
        }
    }
}

/**
 * surface
 * Material Design 시스템에 기반한 Compose 컨테이너
 * 일반적으로 카드 또는 패널과 같은 요소를 나타내는데 사용된다
 * 그림자, 경계선, 배경색 등과 같은 시각적 효과를 자동으로 처리하며, 표면에 컨텐츠를 배치하는데 사용됨.
 */
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard1() {
    ComposeMyAppTheme {
        Surface {
            MessageCard(msg = Message("Colleague", "Take a loog at Jetpack Compose"))
        }
    }
}

/**
 * Box
 * 단순한 컨테이너로, Compose의 레이아웃을 구성하는데 사용된다.
 * 자식 요소를 수직 또는 수평으로 정렬하고, 간격, 패딩 등의 스타일을 적용하는데 유용하다.
 * 개발자가 직접 스타일 및 배치를 제어할 수 있다.
 */

// 함수를 구성 가능하게 하려면 @Composable 주석을 추가해야 합니다.
// @Preview 주석을 사용하면 앱을 빌드해서 Android 기기나 에뮬레이터에 설치하지 않고 미리 볼 수 있음
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
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {// 수직적 정렬 Row: 수평적 정렬
            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondaryContainer,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}