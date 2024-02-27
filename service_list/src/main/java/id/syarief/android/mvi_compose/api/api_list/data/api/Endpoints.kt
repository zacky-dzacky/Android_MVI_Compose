package id.syarief.android.mvi_compose.api.api_list.data.api

object Endpoints {

    const val GET_USERS = "users?since=51234842"
    const val GET_USER = "users/{userLogin}"
    const val GET_REPOS_BY_USER = "users/{userLogin}/repos?sort=stars&order=desc"
}