package com.example.bekir_p1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bekir_p1.componentsB.Pager
import com.example.bekir_p1.pages.Page1Screen
import com.example.bekir_p1.pages.Page2Screen
import com.example.bekir_p1.pages.Page3Screen
import com.example.bekir_p1.ui.theme.BekirP1Theme
import com.example.bekir_p1.viewmodels.UserViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("ViewModelConstructorInComposable")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val userViewModel: UserViewModel = viewModel()
            BekirP1Theme {
                Pager(userViewModel = userViewModel)            }
        }
    }
}

