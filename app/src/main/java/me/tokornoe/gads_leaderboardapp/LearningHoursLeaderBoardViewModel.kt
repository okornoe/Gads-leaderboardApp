package me.tokornoe.gads_leaderboardapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception
import java.lang.IllegalArgumentException

class LearningHoursLeaderBoardViewModel : ViewModel(){
    private var _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    private val _property = MutableLiveData<LearningHoursDataModel>()

    val property: LiveData<LearningHoursDataModel>
            get() = _property

    //New declaration to receive response
    private val _hoursDataList = MutableLiveData<List<LearningHoursDataModel>>()

    val hoursDataList: LiveData<List<LearningHoursDataModel>>
        get() = _hoursDataList

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main
    )

    init {
        getLearningHoursData()
    }

    private fun getLearningHoursData() {
        coroutineScope.launch {
            var getPropertiesDeferred = LeaderBoardApi.retrofitService.getProperties()

            try {
                val listResult = getPropertiesDeferred.await()

                _response.value = "Success: $listResult learning hours data"
                Log.d("ViewModel", _response.value!!)
                _hoursDataList.value = listOf(listResult)
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    class Factory(): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(LearningHoursLeaderBoardViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return LearningHoursLeaderBoardViewModel() as T
            }
            throw IllegalArgumentException("Unable to construct viewModel")
        }
    }

}
