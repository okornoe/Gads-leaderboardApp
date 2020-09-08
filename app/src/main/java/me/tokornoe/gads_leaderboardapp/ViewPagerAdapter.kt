package me.tokornoe.gads_leaderboardapp

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import me.tokornoe.gads_leaderboardapp.leaderboard_learninghours.LearningHoursLeaderBoardFragment
import me.tokornoe.gads_leaderboardapp.leaderboard_skill_iq.IqLeaderBoardFragment

class ViewPagerAdapter (private val myContext: Context, fm:FragmentManager,
                        internal var totalTabs: Int): FragmentPagerAdapter(fm, totalTabs) {
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> LearningHoursLeaderBoardFragment()
            1 -> IqLeaderBoardFragment()
            else -> LearningHoursLeaderBoardFragment()
        }
    }

}