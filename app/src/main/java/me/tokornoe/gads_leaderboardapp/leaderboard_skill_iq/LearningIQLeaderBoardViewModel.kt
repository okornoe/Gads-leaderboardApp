package me.tokornoe.gads_leaderboardapp.leaderboard_skill_iq

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import me.tokornoe.gads_leaderboardapp.network.LeaderBoardApi
import me.tokornoe.gads_leaderboardapp.model.LearningIQDataModel
import java.lang.Exception

class LearningIQLeaderBoardViewModel : ViewModel() {
    private var _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    //New declaration to receive response
    private val _iQList = MutableLiveData<List<LearningIQDataModel>>()

    val iQList: LiveData<List<LearningIQDataModel>>
        get() = _iQList

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main
    )

    init {
        getSkillIq()
    }

    private fun getSkillIq() {
        coroutineScope.launch {
            var getPropertiesDeferred = LeaderBoardApi.retrofitService.getSkillIq()

            try {
                var listResult = getPropertiesDeferred.await()

                Log.d("ViewModel", _response.value!!)
                _iQList.value = listResult
            } catch (e: Exception) {
                Log.d("Failure", "no response")
                _response.value = "Failure: ${e.message}"
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
            return LearningIQLeaderBoardViewModel() as T
        }
    }
}