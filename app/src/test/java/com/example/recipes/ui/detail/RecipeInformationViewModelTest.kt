package com.example.recipes.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.recipes.MainDispatcherRule
import com.example.recipes.getOrAwaitValue
import com.wahyu.recipes.core.data.Async
import com.wahyu.recipes.core.domain.recipes.usecase.IRecipesUseCase
import com.wahyu.recipes.core.model.RecipeInformation
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class RecipeInformationViewModelTest {
    @get:Rule
    val instantTask = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesRule = MainDispatcherRule()

    @Mock
    private lateinit var useCase: IRecipesUseCase
    private lateinit var viewModel: RecipeInformationViewModel

    @Mock
    private lateinit var dummy: RecipeInformation

    @Before
    fun setup() {
        viewModel = RecipeInformationViewModel(useCase)
        `when`(useCase.getRecipesInformation(5)).thenReturn(flowOf(Async.Success(dummy)))
    }

    @Test
    fun test() {
        val idSelected = 5

        viewModel.getRecipeInformation(idSelected).getOrAwaitValue()
        Mockito.verify(useCase).getRecipesInformation(idSelected)
    }
}