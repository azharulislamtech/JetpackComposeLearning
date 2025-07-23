import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.me.compose.feature.two_layout_lab.presentation.CustomerProfileViewModel
import com.me.compose.feature.two_layout_lab.presentation.component.CustomerCard
import com.me.compose.feature.two_layout_lab.presentation.component.UserCard
import kotlinx.coroutines.launch
import org.burnoutcrew.reorderable.detectReorderAfterLongPress
import org.burnoutcrew.reorderable.rememberReorderableLazyListState
import org.burnoutcrew.reorderable.reorderable
import org.burnoutcrew.reorderable.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomerListScreen(viewModel: CustomerProfileViewModel = viewModel()) {
    val users = viewModel.users
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    val dragState = rememberReorderableLazyListState(onMove = { from, to ->
        viewModel.moveUser(from.index, to.index)
    })

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        LazyColumn(
            state = dragState.listState,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .reorderable(dragState)
                .detectReorderAfterLongPress(dragState)
        ) {
            items(users, key = { it.id }) { user ->
                ReorderableItem(dragState, key = user.id) { isDragging ->
                    val elevation = if (isDragging) 8.dp else 0.dp

                    CustomerCard(
                        user = user,
                        onClick = {
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar("Clicked: ${user.name}")
                            }
                        },
                        onDelete = {
                            viewModel.deleteUser(user.id)
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar("${user.name} deleted")
                            }
                        }
                    )
                }
            }
        }
    }
}
