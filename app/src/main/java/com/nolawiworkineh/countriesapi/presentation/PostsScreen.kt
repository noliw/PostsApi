package com.nolawiworkineh.countriesapi.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.nolawiworkineh.countriesapi.presentation.components.PelotonLoadingSpinner
import com.nolawiworkineh.countriesapi.presentation.components.PostsCard
import com.nolawiworkineh.countriesapi.presentation.components.StyledButton

@Composable
fun PostsScreenRoot(
    viewModel: PostsViewModel = hiltViewModel(),
    modifier: Modifier
) {
    val context = LocalContext.current

    // Observe the current state
    val state = viewModel.state.collectAsStateWithLifecycle().value


    state.errorMessage?.let { errorMessage ->
        Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
    }

//    // Trigger fetchPosts when the composable is loaded
//    LaunchedEffect(Unit) {
//        viewModel.onAction(PostsAction.OnGetPostsClick)
//    }

    PostsScreen(
        state = state,
        onAction = { action ->
            viewModel.onAction(action)
        }
    )
}


@Composable
fun PostsScreen(
    state: PostsState,
    onAction: (PostsAction) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Show the list of posts
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            items(
                items = state.posts,
                key = { it.id }
            ) { post ->
                PostsCard(
                    id = post.id,
                    title = post.title,
                    body = post.body
                )
            }
        }

        // Show loading spinner if the state is loading
        if (state.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                PelotonLoadingSpinner()
            }
        }

        // Show the "Get Posts" button at the bottom
        if (!state.isLoading) {
            StyledButton(
                text = "Get Posts",
                onClick = {
                    onAction(PostsAction.OnGetPostsClick)
                },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            )
        }
    }
}

@Preview
@Composable
private fun PostsScreenPreview() {

    PostsScreen(
        state = PostsState(),
        onAction = {}
    )
}
