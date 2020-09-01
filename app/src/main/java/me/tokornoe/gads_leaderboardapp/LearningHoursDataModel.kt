package me.tokornoe.gads_leaderboardapp

data class LearningHoursDataModel(val name: String, val hours: Int,
                                  val country: String, val badgeUrl: String)

data class LearningIQDataModel(val name: String, val score: Int, val country: String, val badgeUrl: String)
