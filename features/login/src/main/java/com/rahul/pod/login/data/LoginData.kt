package com.rahul.pod.login.data

data class LoginDataResponse(val status: String?)

data class LoginDataRequest(val login: String?,
                            val password: String?)