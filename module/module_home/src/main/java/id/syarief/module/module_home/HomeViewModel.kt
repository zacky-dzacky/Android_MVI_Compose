package id.syarief.module.module_home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.syarief.android_mvi_compose.api.api_profile.domain.usecase.GetProfileUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val getProfileUseCase = GetProfileUseCase()
    private val _profileState = MutableLiveData<ViewState>()

    fun getProfile() {
        val profileID = "123456"
        _profileState.value = ViewState.Loading
        viewModelScope.launch {
            when (val response = getProfileUseCase.getProfile(profileID)) {
                is GetProfileUseCase.Result.SuccessWithData<*> -> {
                    _profileState.value = ViewState.Success(response.data)
                }
                is GetProfileUseCase.Result.Error -> {
                    _profileState.value = ViewState.Error(response.exception.message ?: "asdf")
                }
                else -> {}
            }
        }
    }
}

sealed class ViewState {
    object Loading : ViewState()
    class Success<T>(val data: T) : ViewState()
    class Error(val message: String) : ViewState()
}