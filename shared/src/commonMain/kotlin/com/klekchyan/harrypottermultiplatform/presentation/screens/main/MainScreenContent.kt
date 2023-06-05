package com.klekchyan.harrypottermultiplatform.presentation.screens.main

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.klekchyan.harrypottermultiplatform.domain.entity.Character
import com.klekchyan.harrypottermultiplatform.presentation.components.TransparentSystemBars
import com.klekchyan.harrypottermultiplatform.presentation.components.scaffold.AppScaffold
import com.klekchyan.harrypottermultiplatform.presentation.screens.character.CharacterScreen
import com.klekchyan.harrypottermultiplatform.presentation.screens.main.models.CharactersType
import com.klekchyan.harrypottermultiplatform.presentation.screens.main.models.MainScreenAction
import com.klekchyan.harrypottermultiplatform.presentation.screens.main.models.MainScreenEvent
import com.klekchyan.harrypottermultiplatform.presentation.theme.AppTheme
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
internal fun MainScreenContent(vm: MainScreenViewModel) {

    val navigator = LocalNavigator.currentOrThrow

    val viewState = vm.viewStates.collectAsState()
    val action = vm.viewActions.collectAsState(null)

    val pagerState = rememberPagerState()

    LaunchedEffect(pagerState.currentPage) {
        val newType = CharactersType.values()[pagerState.currentPage]
        vm.obtainEvent(MainScreenEvent.ChangeCharactersType(newType))
    }

    LaunchedEffect(action.value) {
        action.value?.let { act ->
            when(act) {
                is MainScreenAction.OpenSpecificCharacter -> {
                    navigator.push(CharacterScreen(act.id))
                }
            }
        }
    }

    TransparentSystemBars()

    AppScaffold(
        backgroundColor = AppTheme.colors.backgroundPrimary,
        topBar = {
            //TODO Search
            Text("${pagerState.currentPage}")
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                CharactersTypeTabs(
                    modifier = Modifier,
                    pagerState = pagerState
                )
                CharactersTypePager(
                    modifier = Modifier,
                    pagerState = pagerState,
                    characters = viewState.value.characters.toImmutableList(),
                    onCharacterClick = remember {{
                        vm.obtainEvent(MainScreenEvent.SpecificCharacterClick(it))
                    }}
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun CharactersTypeTabs(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
) {
    val coroutineScope = rememberCoroutineScope()
    val lazyRowState = rememberLazyListState()

    val items by remember { mutableStateOf(CharactersType.values()) }

    TabRow(
        modifier = modifier,
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.Blue,
        indicator = { tabPositions ->
            TabIndicator(tabPositions.toImmutableList(), items[pagerState.currentPage])
        }
    ) {
        items.forEachIndexed { index, item ->
            TypeTab(
                icon = Icons.Default.Home,
                title = item.title,
                onClick = remember{{
                    coroutineScope.launch {
                        lazyRowState.animateScrollToItem(index)
                        pagerState.animateScrollToPage(index)
                    }
                }}
            )
        }
    }

//    LazyRow(
//        modifier = modifier,
//        state = lazyRowState
//    ) {
//        itemsIndexed(items = items) { index, type ->
//            val isChosen by remember(pagerState.currentPage, type) { mutableStateOf(items[pagerState.currentPage] == type) }
//            CharactersTypeTab(
//                modifier = Modifier,
//                type = type,
//                isChosen = isChosen,
//                onTabClick = remember { {
//                    coroutineScope.launch {
//                        lazyRowState.animateScrollToItem(index)
//                        pagerState.animateScrollToPage(index)
//                    }
//                } }
//            )
//        }
//    }
}

@Composable
private fun TabIndicator(
    tabPositions: ImmutableList<TabPosition>,
    type: CharactersType
) {
    val transition = updateTransition(
        type,
        label = "Tab indicator"
    )
    val indicatorLeft by transition.animateDp(
        transitionSpec = { spring(stiffness = Spring.StiffnessMedium) },
        label = "Indicator left"
    ) { page ->
        tabPositions[page.ordinal].left
    }
    val indicatorRight by transition.animateDp(
        transitionSpec = { spring(stiffness = Spring.StiffnessMedium) },
        label = "Indicator right"
    ) { page ->
        tabPositions[page.ordinal].right
    }
    Box(
        Modifier
            .fillMaxSize()
            .wrapContentSize(align = Alignment.BottomStart)
            .offset(x = indicatorLeft)
            .width(indicatorRight - indicatorLeft)
            .padding(4.dp)
            .fillMaxSize()
            .border(
                BorderStroke(2.dp, Color.Green),
                RoundedCornerShape(4.dp)
            )
    )
}

@Composable
private fun TypeTab(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = title)
    }
}

@Composable
private fun CharactersTypeTab(
    modifier: Modifier = Modifier,
    type: CharactersType,
    isChosen: Boolean,
    onTabClick: (type: CharactersType) -> Unit
) {
    val background by animateColorAsState(
        targetValue = if(isChosen) Color.Cyan else Color.Red,
        animationSpec = tween(durationMillis = 500, delayMillis = 200, easing = FastOutSlowInEasing)
    )
    Box(
        modifier = modifier
            .clip(AppTheme.shapes.medium)
            .drawBehind {
                drawRect(background)
            }
            .border(1.dp, Color.Green, AppTheme.shapes.medium)
            .clickable { onTabClick(type) }
    ) {
        Text(
            text = type.title,
            modifier = Modifier.padding(horizontal = 60.dp, vertical = 5.dp)
        )
    }
}
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterialApi::class)
@Composable
private fun CharactersTypePager(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    characters: ImmutableList<Character>,
    onCharacterClick: (id: String) -> Unit,
) {
    HorizontalPager(
        modifier = modifier.fillMaxSize(),
        pageCount = CharactersType.values().size,
        state = pagerState
    ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 10.dp)
        ) {
            items(items = characters, key = { it.id }) { character ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    elevation = 2.dp,
                    onClick = remember {{
                        onCharacterClick(character.id)
                    }},
                    content = {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = character.name,
                            textAlign = TextAlign.Center
                        )
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}