package me.tokornoe.gads_leaderboardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import java.lang.Character.UnicodeBlock.of

class MainActivity : AppCompatActivity() {

    private val viewModel: LearningHoursLeaderBoardViewModel by lazy {
        ViewModelProvider(this, LearningHoursLeaderBoardViewModel.Factory()).get(LearningHoursLeaderBoardViewModel::class.java)
    }

    private lateinit var learningHoursDataTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        learningHoursDataTextView = findViewById(R.id.tv_learning_hours_data)
        learningHoursDataTextView.text = viewModel.response.value
    }
}