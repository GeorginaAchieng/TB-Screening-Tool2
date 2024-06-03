package com.example.tbscreeningtoolapplication.components

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LockOpen
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tbscreeningtoolapplication.R
import com.example.tbscreeningtoolapplication.ui.theme.Pink40
import com.example.tbscreeningtoolapplication.ui.theme.Purple40

@Composable
fun NormalTextComponent(value:String){
    Text(text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal
        )
        , color = colorResource(id= R.color.black),
        textAlign = TextAlign.Center
    )
}

@Composable
fun HeadingTextComponent(value:String){
    Text(text = value,
        modifier = Modifier.fillMaxWidth(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Default,
            fontStyle = FontStyle.Normal
        )
        , color = Pink40,
        textAlign = TextAlign.Center
    )
}


@Composable
fun OutlinedTextField(labelValue: String) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { text = it },
        label = { Text(text = labelValue) },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        leadingIcon = {
                      Icon(imageVector = Icons.Default.Person, contentDescription = "")
        },
        singleLine = true,
        maxLines = 1,
//        backgroundColor = PurpleGrey80,
    )

    }
@Composable
fun OutlinedTextField2(labelValue: String) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = { text = it },
        label = { Text(text = labelValue) },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Email, contentDescription = "")
        },
        singleLine = true,
        maxLines = 1,

    )

}
@Composable
fun OutlinedTextFieldPassword(labelValue: String) {
//    var text by remember { mutableStateOf("") }
    val password = remember {
        mutableStateOf("")

    }
    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = password.value,
        onValueChange = { password.value= it },
        label = { Text(text = labelValue) },
        leadingIcon = {
            Icon(imageVector = Icons.Default.LockOpen, contentDescription = "")
        },
        trailingIcon = {
            val iconImage = if(passwordVisible.value){
                Icons.Filled.Visibility
            }else{

                Icons.Filled.VisibilityOff
            }
           val description = if(passwordVisible.value){
               stringResource(id = R.string.hide_password)
           }else{
               stringResource(id = R.string.show_password)
           }
            IconButton(onClick = {passwordVisible.value=!passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription =description )
                
            }

        },
        visualTransformation = if(passwordVisible.value)VisualTransformation.None else PasswordVisualTransformation()
    )

}
@Composable
fun CheckboxComponent(value: String){
    Row(modifier= Modifier
        .fillMaxWidth()
        .heightIn(28.dp),
        verticalAlignment = Alignment.CenterVertically,
        content = {
            val checkedState = remember {
                mutableStateOf(false)
            }
            Checkbox(checked = checkedState.value,
                onCheckedChange = {checkedState.value!=checkedState.value})
            ClickableTextComponent(value = value)
        },


    )

}
@Composable
fun ClickableTextComponent(value: String) {
    val initialText = "By continuing you accept our"
    val privacyPolicyText = "Privacy Policy "
    val andText = "and"
    val termsAndConditionText = " Terms of Use"


    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Purple40)) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Purple40)) {
            pushStringAnnotation(tag = termsAndConditionText, annotation = termsAndConditionText)
            append(termsAndConditionText)
        }
        ClickableText(text = AnnotatedString(value) , onClick = { offset ->
            AnnotatedString(value).getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableTextComponent", "{$span}")
                }


            }
        )}
}





