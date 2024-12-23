package com.example.maybellinehiltmvvmflow31_05_2024.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.maybellinehiltmvvmflow31_05_2024.model.MyblineData
import com.example.maybellinehiltmvvmflow31_05_2024.repository.MyblineRepository
import com.example.maybellinehiltmvvmflow31_05_2024.utils.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyblineViewModel
@Inject constructor(private var myblineRepository: MyblineRepository):ViewModel() {

    private val _myblineStateFlow:MutableStateFlow<ApiState> = MutableStateFlow(ApiState.Empty)
     val myblineStateFlow :StateFlow<ApiState> =_myblineStateFlow

    fun getMybline(){
        viewModelScope.launch {
            _myblineStateFlow.value = ApiState.Loading
            myblineRepository.getMyblineData()
                .catch {e->
                   _myblineStateFlow.value = ApiState.Failure(e)
                }
                .collect{ data->
                _myblineStateFlow.value = ApiState.Success(data)
                }
        }
    }

   /* val mybline:LiveData<ApiState> get() = _mybline
    private val _mybline = MutableLiveData<ApiState>()

    fun getMyblineData(){
        viewModelScope.launch {
        myblineRepository.getMyblineData()
            .catch {e->
                _mybline.value = ApiState.Failure(e)
            }
            .collect{result->
           _mybline.value = ApiState.Success(result)
        }

        }
    }*/
}