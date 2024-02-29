package id.syarief.android_mvi_compose.api.api_profile.data.dto

import com.google.gson.annotations.SerializedName

data class Profile(@SerializedName("login") val userId: String = "",
                @SerializedName("avatar_url") val avatarUrl: String = "",
                @SerializedName("html_url") val htmlUrl: String = "",
)

fun buildUserPreview() = Profile(
    userId = "51234843",
    avatarUrl = "https://avatars.githubusercontent.com/myofficework000",
    htmlUrl = "https://github.com/51234843",
)