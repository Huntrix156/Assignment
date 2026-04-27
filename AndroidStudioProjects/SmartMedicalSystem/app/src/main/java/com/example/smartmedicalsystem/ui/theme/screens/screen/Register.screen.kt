//package com.example.nexora.ui.theme.screens.Register.screen
//
//
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.imePadding
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.systemBarsPadding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.text.KeyboardOptions
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Email
//import androidx.compose.material.icons.filled.Lock
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material.icons.filled.Phone
//import androidx.compose.material.icons.filled.Visibility
//import androidx.compose.material.icons.filled.VisibilityOff
//import androidx.compose.material3.Button
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.input.KeyboardType
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.text.input.VisualTransformation
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import com.airbnb.lottie.compose.LottieAnimation
//import com.airbnb.lottie.compose.LottieCompositionSpec
//import com.airbnb.lottie.compose.LottieConstants
//import com.airbnb.lottie.compose.animateLottieCompositionAsState
//import com.airbnb.lottie.compose.rememberLottieComposition
//import com.example.nexora.R
//import com.example.nexora.data.AuthViewModel
//import com.example.nexora.navigation.ROUTE_LOGIN
//
//
//@Composable
//fun RegisterScreen(navController: NavController){
//    var username by remember { mutableStateOf("") }
//    var email by remember { mutableStateOf("") }
//    var phonenumber by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var passwordVisible by remember { mutableStateOf(false) }
//    var confirmpassword by remember { mutableStateOf("") }
//    var confirmPasswordVisible by remember { mutableStateOf(false) }
//
//
//    val authViewModel: AuthViewModel =viewModel()  //this brings the login to the screen from the AuthViewModel
//    val context = LocalContext.current
//
//    val scrollState =
//        rememberScrollState()//enable self scroll between different outlined text field
//
//    Column(
//        modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp)
//        .verticalScroll(scrollState)
//        .imePadding()              // handles keyboard
//        .systemBarsPadding()       // handles navigation bar + status bar
//        .padding(16.dp),
//    horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Top) {
//        Text(text = "Register Here", fontWeight  = FontWeight.Bold,
//            fontSize = 30.sp)
//        //------Lottie animation Widget----------//
//        LottieAnimationWidget(R.raw.kim, 300.dp)
//
//        Spacer(Modifier.width(10.dp))
//
//        //------------Username Field-------------//
//        OutlinedTextField(
//            value = username,
//            onValueChange = {username = it},
//            label = {Text(text="Username")},
//            leadingIcon = {Icon(Icons.Default.Person, contentDescription = null)},
//            modifier = Modifier
//                .fillMaxWidth()
//        )
//        Spacer(Modifier.width(10.dp))
//
//        //--------------Email Filed----------//
//        OutlinedTextField(
//            value = email,
//            onValueChange = {email = it},
//            label = {Text(text="Email")},
//            leadingIcon = {Icon(Icons.Default.Email, contentDescription = null)},
//            //--------------Email Validation------------//
//                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
//            isError = email.isNotEmpty() && !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches(),
//            supportingText = {
//                if (email.isNotEmpty() && !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//                    Text(text = "Enter a valid email e.g. example@gmail.com", color = Color.Red)
//                }
//            },
//            modifier = Modifier.fillMaxWidth(),
//            singleLine = true
//        )
//        Spacer(Modifier.width(10.dp))
//
//        //-------------Phone Number Field----------//
//        OutlinedTextField(
//            value = phonenumber,
//            onValueChange = { if (it.all { char -> char.isDigit() }) phonenumber = it },
//            label = {Text(text="Enter Phone Number")},
//            leadingIcon = {Icon(Icons.Default.Phone, contentDescription = null)},
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
//            modifier = Modifier
//                .fillMaxWidth(),
//                    singleLine = true
//        )
//        Spacer(Modifier.width(10.dp))
//
//        //--------------Password Field------------//
//        OutlinedTextField(
//            value = password,
//            onValueChange = {password = it},
//            label = {Text(text="Enter Password")},
//            leadingIcon = {Icon(Icons.Default.Lock, contentDescription = null)},
//
//            //-----------------Password Show/Hide Toggle-----------//
//            trailingIcon = {
//                IconButton(onClick = { passwordVisible = !passwordVisible }) {
//                    Icon(
//                        imageVector = if (passwordVisible) Icons.Default.VisibilityOff
//                        else Icons.Default.Visibility,
//                        contentDescription = if (passwordVisible) "Hide password"
//                        else "Show password",
//                        tint = if (passwordVisible) Color.Blue else Color.Gray
//                    )
//                }
//            },
//            visualTransformation = if (passwordVisible) VisualTransformation.None
//            else PasswordVisualTransformation(),
//            modifier = Modifier.fillMaxWidth(),
//            singleLine = true
//        )
//        Spacer(Modifier.width(10.dp))
//
//        //----------ConfirmPassword-----------//
//        OutlinedTextField(
//            value = confirmpassword,
//            onValueChange = {confirmpassword = it},
//            label = {Text(text="Confirm Password")},
//            leadingIcon = {Icon(Icons.Default.Lock, contentDescription = null)},
//
//            //------------ConfirmPassword Show/Hide Toggle--------------//
//            trailingIcon = {
//                IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
//                    Icon(
//                        imageVector = if (confirmPasswordVisible) Icons.Default.VisibilityOff
//                        else Icons.Default.Visibility,
//                        contentDescription = null
//                    )
//                }
//            },
//            visualTransformation = if (confirmPasswordVisible) VisualTransformation.None
//            else PasswordVisualTransformation(),
//            modifier = Modifier.fillMaxWidth(),
//            singleLine = true
//        )
//
//        Spacer(Modifier.width(10.dp))
//
// //------------Button For Submit---------------//
//        Button(onClick ={authViewModel.signup( //calling the authViewModel
//            username=username,
//            email = email,
//            phone = phonenumber,
//            password= password,
//            confirmpassword = confirmpassword,
//            navController= navController,
//            context= context )},
//            modifier = Modifier
//                .fillMaxWidth()
//        )
//        {Text(text="Submit")
//        }
//        Spacer(Modifier.height(10.dp))
//        Row() {
//            //--------Text Appearing In The LeftSide, Below The Login Button------------//
//            Text(
//                text = "I Have An Account", color = Color.Blue,
//            )
//            Spacer(Modifier.width(10.dp))
//            //--------Text Appearing In The RightSide, Below The Login Button With Navigation Logic------------//
//            Text(text = "Login here",
//                modifier = Modifier
//                    .clickable { navController.navigate(ROUTE_LOGIN) },)
//        }
//
//
//    }
//
//}
//
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun RegisterScreenPreview(){
//    RegisterScreen(navController = rememberNavController())
//}



package com.example.nexora.ui.theme.screens.Register.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun RegisterScreen(navController: NavController) {

//    val authViewModel: AuthViewModel = viewModel()
    val context = LocalContext.current

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        contentAlignment = Alignment.Center
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState),
            shape = MaterialTheme.shapes.large,
            elevation = CardDefaults.cardElevation(10.dp)
        ) {

            Column(
                modifier = Modifier
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Create Account",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Join us today",
                    fontSize = 16.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))

                LottieAnimationWidget(R.raw.kim, 220.dp)

                Spacer(modifier = Modifier.height(24.dp))

                // USERNAME
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("Username") },
                    leadingIcon = { Icon(Icons.Default.Person, null) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                // EMAIL
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email") },
                    leadingIcon = { Icon(Icons.Default.Email, null) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    isError = email.isNotEmpty() &&
                            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches(),
                    supportingText = {
                        if (email.isNotEmpty() &&
                            !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
                        ) {
                            Text("Invalid email format", color = Color.Red)
                        }
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                // PHONE
                OutlinedTextField(
                    value = phone,
                    onValueChange = {
                        if (it.all { char -> char.isDigit() }) phone = it
                    },
                    label = { Text("Phone Number") },
                    leadingIcon = { Icon(Icons.Default.Phone, null) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                // PASSWORD
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Password") },
                    leadingIcon = { Icon(Icons.Default.Lock, null) },
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisible = !passwordVisible
                        }) {
                            Icon(
                                imageVector = if (passwordVisible)
                                    Icons.Default.VisibilityOff
                                else Icons.Default.Visibility,
                                contentDescription = null
                            )
                        }
                    },
                    visualTransformation =
                        if (passwordVisible) VisualTransformation.None
                        else PasswordVisualTransformation(),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                // CONFIRM PASSWORD
                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    label = { Text("Confirm Password") },
                    leadingIcon = { Icon(Icons.Default.Lock, null) },
                    trailingIcon = {
                        IconButton(onClick = {
                            confirmPasswordVisible = !confirmPasswordVisible
                        }) {
                            Icon(
                                imageVector = if (confirmPasswordVisible)
                                    Icons.Default.VisibilityOff
                                else Icons.Default.Visibility,
                                contentDescription = null
                            )
                        }
                    },
                    visualTransformation =
                        if (confirmPasswordVisible) VisualTransformation.None
                        else PasswordVisualTransformation(),
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                // REGISTER BUTTON
                Button(
                    onClick = {
                        authViewModel.signup(
                            username = username,
                            email = email,
                            phone = phone,
                            password = password,
                            confirmpassword = confirmPassword,
                            navController = navController,
                            context = context
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text("Create Account")
                }

                Spacer(modifier = Modifier.height(16.dp))

                // LOGIN LINK
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Already have an account?", color = Color.Gray)

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = "Login",
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.clickable {
                            navController.navigate(ROUTE_LOGIN)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Column(
    modifier: Modifier,
    horizontalAlignment: Alignment.Horizontal,
    content: @Composable () -> Row
) {
    TODO("Not yet implemented")
}

@Composable
fun LottieAnimationWidget(lottiePath:Int,size: Dp) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(lottiePath))
    val progress by animateLottieCompositionAsState(composition, iterations = LottieConstants.IterateForever)
    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = Modifier.size(300.dp)
    )
}