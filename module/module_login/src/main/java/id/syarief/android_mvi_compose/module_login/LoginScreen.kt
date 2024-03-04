package id.syarief.android_mvi_compose.module_login

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Key
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.syarief.base.base_component.BaseTheme
import id.syarief.base.base_component.EditText
import id.syarief.base.base_component.EditTextPassword
import id.syarief.base.base_component.FullAppBar
import id.syarief.base.base_helper.ModuleManifest
import id.syarief.base.base_helper.Navigator

@Preview
@Composable
fun LoginPagePreview(){
    BaseTheme {
        LoginPage(Modifier)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(modifier: Modifier){
    var backClicked by rememberSaveable { mutableStateOf("First Page") }
    val context = LocalContext.current
    Scaffold(
        modifier = modifier,
        topBar = {
            FullAppBar(title = backClicked) {
                backClicked = "Back Clicked"
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = stringResource(R.string.didnt_have_account),
                )
                Spacer(modifier = Modifier.width(4.dp))
                ClickableText(
                    text = AnnotatedString(stringResource(R.string.here)),
                    style = TextStyle(
                        fontWeight = FontWeight.ExtraBold
                    ),
                    onClick = {
                        Log.d("LoginActivity","registrasi clicked")
                    }
                )
            }


        },
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(innerPadding),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(bottom = 80.dp)
                    .padding(16.dp),

                verticalArrangement = Arrangement.Center
            ) {
                EditText(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 56.dp),
                    hint = stringResource(R.string.username),

                    )
                Spacer(modifier = Modifier.height(8.dp))
                EditTextPassword(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 56.dp),
                    hint = stringResource(R.string.password),
                    icon = Icons.Filled.Key
                )
            }
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 80.dp)
                    .padding(16.dp)
            ){
                Button(
                    onClick = { Navigator.navigate(context, ModuleManifest.ACTIVITY_HOME){ (context as Activity).finish() } },
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Text(text = stringResource(R.string.login))
                }
            }
        }
    }
}