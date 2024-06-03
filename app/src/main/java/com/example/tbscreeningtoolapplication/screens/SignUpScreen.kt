package com.example.tbscreeningtoolapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tbscreeningtoolapplication.R
import com.example.tbscreeningtoolapplication.components.CheckboxComponent
import com.example.tbscreeningtoolapplication.components.ClickableTextComponent
import com.example.tbscreeningtoolapplication.components.HeadingTextComponent
import com.example.tbscreeningtoolapplication.components.NormalTextComponent
import com.example.tbscreeningtoolapplication.components.OutlinedTextField
import com.example.tbscreeningtoolapplication.components.OutlinedTextField2
import com.example.tbscreeningtoolapplication.components.OutlinedTextFieldPassword


@Composable
fun SignUpScreen(){
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(28.dp)
        .background(Color.White)
        ){
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponent(value = stringResource(id = R.string.tb_screening))
            HeadingTextComponent(value = stringResource(id = R.string.create_an_account))
            Spacer(modifier = Modifier.height(30.dp))
            OutlinedTextField(labelValue = "First Name")
            OutlinedTextField(labelValue = "Last Name")
            OutlinedTextField2(labelValue = "Email")
            OutlinedTextFieldPassword(labelValue = "Password")
            CheckboxComponent(value = stringResource(id = R.string.terms_and_conditions))





        }


    }

        }

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()

}