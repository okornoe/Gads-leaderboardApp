package me.tokornoe.gads_leaderboardapp.leaderboard_learninghours

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.tokornoe.gads_leaderboardapp.R
import me.tokornoe.gads_leaderboardapp.databinding.ListItemBinding
import me.tokornoe.gads_leaderboardapp.model.LearningHoursDataModel

class LearningHoursLeaderBoardAdapter :
    ListAdapter<LearningHoursDataModel, LearningHoursLeaderBoardAdapter.LearningHoursViewHolder>(LearningHoursDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LearningHoursViewHolder {
        return LearningHoursViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_item, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: LearningHoursViewHolder, position: Int) {
        val learningHoursData = getItem(position)
        holder.bind(learningHoursData)
    }

    class LearningHoursViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(learningHoursDataModel: LearningHoursDataModel) {
            binding.property = learningHoursDataModel
            binding.executePendingBindings()
        }
    }
}

private class LearningHoursDiffCallback : DiffUtil.ItemCallback<LearningHoursDataModel>() {
    override fun areItemsTheSame(
        oldItem: LearningHoursDataModel,
        newItem: LearningHoursDataModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: LearningHoursDataModel,
        newItem: LearningHoursDataModel
    ): Boolean {
        return oldItem == newItem
    }
}