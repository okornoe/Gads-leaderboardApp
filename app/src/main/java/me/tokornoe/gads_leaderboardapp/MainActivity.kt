package me.tokornoe.gads_leaderboardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import me.tokornoe.gads_leaderboardapp.leaderboard_skill_iq.LearningIQLeaderBoardViewModel


class MainActivity : AppCompatActivity() {
/*
    private val viewModel: LearningHoursLeaderBoardViewModel by lazy {
        ViewModelProvider(this, LearningHoursLeaderBoardViewModel.Factory()).get(LearningHoursLeaderBoardViewModel::class.java)
    }*/

    //private lateinit var hoursViewModel: LearningHoursLeaderBoardViewModel
    private lateinit var iQViewModel: LearningIQLeaderBoardViewModel

    private lateinit var learningHoursDataTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

/*        hoursViewModel = ViewModelProvider(this).get(LearningHoursLeaderBoardViewModel::class.java)
        hoursViewModel.hoursDataList.observe(this, Observer { data ->
            data.listIterator().hasNext()
        })*/

        iQViewModel = ViewModelProvider(this).get(LearningIQLeaderBoardViewModel::class.java)
        iQViewModel.iQList.observe(this, Observer { data ->
            data.listIterator().hasNext()
        })

        learningHoursDataTextView = findViewById(R.id.tv_learning_hours_data)

        learningHoursDataTextView.text = iQViewModel.iQList.value.toString()
    }
}