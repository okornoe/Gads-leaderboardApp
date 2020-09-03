package me.tokornoe.gads_leaderboardapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LearningHoursDataModel(val name: String, val hours: Int,
                                  val country: String, val badgeUrl: String) : Parcelable

@Parcelize
data class LearningIQDataModel(val name: String, val score: Int,
                               val country: String, val badgeUrl: String) : Parcelable
