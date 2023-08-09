package com.example.app_proyecto_final.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_proyecto_final.domain.usecase.GetProductByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val getProductByIdUseCase: GetProductByIdUseCase
): ViewModel() {

    private var _productFlow =  MutableStateFlow<DetailState>(DetailState.Idle)
    val productFlow: StateFlow<DetailState> = _productFlow

     fun getProductData(id: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _productFlow.emit(DetailState.Loading)
                val result = getProductByIdUseCase.invoke(id)
                if(result.id != "")
                    _productFlow.emit(DetailState.Product(result))
                else
                    _productFlow.emit(DetailState.Error)
            }
        }
    }
}