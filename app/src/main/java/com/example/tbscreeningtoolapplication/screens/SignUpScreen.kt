package com.example.tbscreeningtoolapplication.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tbscreeningtoolapplication.R
import com.example.tbscreeningtoolapplication.components.NormalTextComponent

@Composable
fun SignUpScreen(){
    Surface(modifier = Modifier.fillMaxSize(),
        color = Color.White){
        NormalTextComponent(value= stringResource(id = R.string.tb_screening))

    }

}
@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()

}