package id.syarief.base.base_component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter


@Composable
fun FullAppBar(title: String,
               showBack: Boolean = false,
               onBack: () -> Unit){
    Column(Modifier.background(Color.White)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (showBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.clickable(
                        enabled = true,
                        onClick = onBack
                    ).padding(end = 16.dp)
                )
            }
            Text(
                text = title,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
        Divider(modifier = Modifier
            .height(1.dp)
            .background(Color.Gray))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditText(
    modifier: Modifier,
    hint: String,
    icon: ImageVector = Icons.Filled.Person
){
    var text by rememberSaveable {
        mutableStateOf("")
    }
    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = modifier,
        placeholder = { Text(text = hint) },
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = "")
        }
    )
}


@Composable
fun CoilImage(
    url: String,
    contentDescription: String?,
    modifier: Modifier = Modifier
) {
    val painter = rememberAsyncImagePainter(url)
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextPassword(
    modifier: Modifier,
    hint: String,
    icon: ImageVector = Icons.Filled.Person
){
    var text by rememberSaveable {
        mutableStateOf("")
    }
    var passwordVisible by rememberSaveable {
        mutableStateOf(false)
    }

    TextField(
        value = text,
        onValueChange = { text = it },
        modifier = modifier,
        placeholder = { Text(text = hint) },
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = "")
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Visibility
            else Icons.Filled.VisibilityOff

            // Please provide localized description for accessibility services
            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = {passwordVisible = !passwordVisible}){
                Icon(imageVector  = image, description)
            }
        }
    )
}

@Preview
@Composable
fun showEditText(){
    EditText(modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 48.dp),
        hint = "Username"
    )
}

@Preview
@Composable
fun showEditTextPassword(){
    EditTextPassword(modifier = Modifier
        .fillMaxWidth()
        .heightIn(min = 48.dp),
        hint = "Password"
    )
}

@Preview
@Composable
fun showFullAppBar(){
    FullAppBar(title = "Test") {
        
    }
}



