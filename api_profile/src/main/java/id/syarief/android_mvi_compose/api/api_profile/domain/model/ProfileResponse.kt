package id.syarief.android_mvi_compose.api.api_profile.domain.model

import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    @SerializedName("blur_hash")
    val blurHash: String?,
)