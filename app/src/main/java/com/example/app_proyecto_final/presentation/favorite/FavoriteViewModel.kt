package com.example.app_proyecto_final.presentation.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_proyecto_final.domain.usecase.GetFavoriteListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoriteViewModel(
    private val getFavoriteListUseCase: GetFavoriteListUseCase
): ViewModel() {

    private var _productListFlow =  MutableStateFlow<FavoriteState>(FavoriteState.Idle)
    val productListFlow: StateFlow<FavoriteState> = _productListFlow

    fun getData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _productListFlow.emit(FavoriteState.Loading)
                val result = getFavoriteListUseCase.invoke()
                if(result.isNotEmpty()){
                    _productListFlow.emit(FavoriteState.ProductList(result))
                }else{
                    _productListFlow.emit(FavoriteState.Error)
                }
            }
        }
    }
}