package com.caperezh.stefaninichallenge.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.caperezh.stefaninichallenge.R
import com.caperezh.stefaninichallenge.common.Category
import com.caperezh.stefaninichallenge.data.model.GridModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val searchQuery by viewModel.searchQuery.collectAsState()
    val selectedCategory by viewModel.selectedCategory.collectAsState()
    val myList:List<GridModel> =  viewModel.myList
    Box(modifier = Modifier
        .fillMaxSize()
        .padding()) {
        if (viewModel.showLoader){
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(20.dp)
            )
        }
        Column(modifier = Modifier.fillMaxSize()) {
            TextField(
                value = searchQuery,
                onValueChange = { viewModel.setSearchQuery(it) },
                label = { Text(stringResource(R.string.buscar)) },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
            var expanded by remember { mutableStateOf(false) }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.TopEnd)
            ) {
                
                Row {
                    Text(text = "Filter by",modifier = Modifier.align(Alignment.CenterVertically))
                    IconButton(onClick = { expanded = !expanded }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "More"
                        )
                    }
                }
                DropdownMenu(

                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text("All") },
                        onClick = {viewModel.filterByCategory(Category.ALL)}
                    )
                    DropdownMenuItem(
                        text = { Text("Category 1") },
                        onClick = { viewModel.filterByCategory(Category.CATEGORY_1)}
                    )
                    DropdownMenuItem(
                        text = { Text("Category 2") },
                        onClick = { viewModel.filterByCategory(Category.CATEGORY_2) }
                    )
                    DropdownMenuItem(
                        text = { Text("Category 3") },
                        onClick = { viewModel.filterByCategory(Category.CATEGORY_3) }
                    )
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                items(myList) { item ->
                    GridItemCard(item, clickItem = {
                        viewModel.showDialog(it)
                    })
                }
            }

            if (viewModel.showDialog) {
                AlertDialog(
                    onDismissRequest = { viewModel.showDialog },
                    title = { Text(text = viewModel.myItem.value.name) },
                    text = {
                        Column {
                            val context = LocalContext.current
                            val myImage = context.resources.getIdentifier(viewModel.myItem.value.image.trim(), "drawable", context.packageName)
                            Image(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp),
                                contentScale = ContentScale.FillBounds,
                                painter = painterResource(id = myImage),
                                contentDescription =""
                            )
                            Text(text = viewModel.myItem.value.developer)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = stringResource(R.string.this_is_a_generic_description_for_an_application))
                            Spacer(modifier = Modifier.height(4.dp))
                            val price = if(viewModel.myItem.value.price < 0.5) "FREE" else viewModel.myItem.value.price
                            Text(text = "$ $price")
                            RatingBar1(4, viewModel.myItem.value.rating, {})
                            Spacer(modifier = Modifier.height(4.dp))

                        } },
                    confirmButton = {
                        Button(onClick = { viewModel.dismissDialog() }) {
                            Text(text = stringResource(R.string.install))
                        }
                    },
                    dismissButton = {
                        Button(onClick = { viewModel.dismissDialog() }) {
                            Text(text = stringResource(R.string.close))
                        }
                    },
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}


@Composable
fun GridItemCard(item: GridModel, clickItem: (GridModel) -> Unit) {
    val context = LocalContext.current
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Column(modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
            ) {
            val myImage = context.resources.getIdentifier(item.image.trim(), "drawable", context.packageName)
            Card(modifier = Modifier
                .padding(4.dp)){
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(125.dp)
                        .clickable {
                            clickItem(item)
                        },
                    contentScale = ContentScale.FillBounds,
                    painter = painterResource(id = myImage),
                    contentDescription =""
                )
                Text(text = item.name, style = TextStyle(fontWeight = FontWeight.Bold))
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = item.developer)
                RatingBar1(5, item.rating, {})
                Spacer(modifier = Modifier.height(4.dp))
                val price = if(item.price < 0.5) "FREE" else item.price
                Text(text = "$ $price")
            }
        }
    }
}

@Composable
fun RatingBar1(
    maxRating: Int = 5,
    rating: Int,
    onRatingChanged: (Int) -> Unit
) {
    Row {
        for (i in 1..maxRating  +1) {
            val isSelected = i <= rating
            RatingBarItem(isSelected) {
                onRatingChanged(i)
            }
        }
    }
}

@Composable
fun RatingBarItem(
    isSelected: Boolean,
    onItemClick: () -> Unit
) {
    IconToggleButton(
        checked = isSelected,
        onCheckedChange = { onItemClick() },
        modifier = Modifier.padding(0.dp)
    ) {
        val icon = if (isSelected) Icons.Filled.Star else Icons.Outlined.Star
        val color = if (isSelected) MaterialTheme.colorScheme.background else Color.Gray
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = color,
            modifier = Modifier.width(20.dp)
        )
    }
}
