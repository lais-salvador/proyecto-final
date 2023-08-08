package com.example.app_proyecto_final.presentation.list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_proyecto_final.domain.usecase.GetProductListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListViewModel(
    private val getProductListUseCase: GetProductListUseCase
): ViewModel() {

    private var _productListFlow =  MutableStateFlow<ListState>(ListState.Idle)
    val productListFlow: StateFlow<ListState> = _productListFlow

    init {
        getData()
    }

     fun getData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _productListFlow.emit(ListState.Loading)
                val result = getProductListUseCase.invoke()
                if(result.isNotEmpty()){
                    _productListFlow.emit(ListState.ProductList(result))
                }else{
                    _productListFlow.emit(ListState.Error)
                }
            }
        }
    }
}