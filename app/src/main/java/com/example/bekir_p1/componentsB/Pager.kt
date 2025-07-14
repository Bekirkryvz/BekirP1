package com.example.bekir_p1.componentsB

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.example.bekir_p1.model.User
import com.example.bekir_p1.pages.Page1Screen
import com.example.bekir_p1.pages.Page2Screen
import com.example.bekir_p1.pages.Page3Screen
import com.example.bekir_p1.ui.theme.LightBlue
import com.example.bekir_p1.viewmodels.UserViewModel
import com.google.accompanist.pager.rememberPagerState
import com.google.accompanist.pager.HorizontalPager


@Composable
fun Pager(modifier: Modifier = Modifier, userViewModel: UserViewModel) {
    val pagerState = rememberPagerState()

    LaunchedEffect(pagerState.currentPage) {
        userViewModel.currentPage = pagerState.currentPage
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MenuButton(
                modifier = Modifier.align(Alignment.End), userViewModel = userViewModel
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                count = 3,
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                when (page) {
                    0 -> Page1Screen()
                    1 -> Page2Screen()
                    2 -> Page3Screen()
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BottomPageIndicator(
                modifier = Modifier.padding(10.dp),
                userViewModel = userViewModel,
                currentPage = pagerState.currentPage,
                totalPages = 3
            )
        }

    }
}
