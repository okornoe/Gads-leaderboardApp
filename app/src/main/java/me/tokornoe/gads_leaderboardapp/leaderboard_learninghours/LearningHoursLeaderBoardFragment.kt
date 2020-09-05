package me.tokornoe.gads_leaderboardapp.leaderboard_learninghours

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import me.tokornoe.gads_leaderboardapp.databinding.FragmentLearningHoursLeaderBoardBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LearningHoursLeaderBoardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LearningHoursLeaderBoardFragment : Fragment() {

    /**
     * Lazily initialize our [OverviewViewModel].
     */
    private val learningHoursLeaderBoardViewModel: LearningHoursLeaderBoardViewModel by lazy {
        ViewModelProvider(this).get(LearningHoursLeaderBoardViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_learning_hours_leader_board, container, false)
        val binding = FragmentLearningHoursLeaderBoardBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = learningHoursLeaderBoardViewModel
        binding.learningHours.adapter = LearningHoursLeaderBoardAdapter()

        return binding.root
    }
}