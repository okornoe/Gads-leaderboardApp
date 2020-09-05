package me.tokornoe.gads_leaderboardapp.leaderboard_learninghours

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import me.tokornoe.gads_leaderboardapp.model.LearningHoursDataModel
import me.tokornoe.gads_leaderboardapp.network.LeaderBoardApi
import java.lang.Exception

class LearningHoursLeaderBoardViewModel : ViewModel(){
/*    private var _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response*/

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

    private fun getLearningHoursData(){
        coroutineScope.launch {
            var getPropertiesDeferred = LeaderBoardApi.retrofitService.getHours()
                var listResult = getPropertiesDeferred.await()
            try {
                 _hoursDataList.value = listResult //exception thrown here
            } catch (e: Exception) {
                Log.d("Failure" , "no response")
               _hoursDataList.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    class Factory(): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return LearningHoursLeaderBoardViewModel() as T
        }
    }

}
