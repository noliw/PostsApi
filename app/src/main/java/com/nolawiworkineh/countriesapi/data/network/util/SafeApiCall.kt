package com.nolawiworkineh.countriesapi.data.network.util

import com.google.gson.JsonSyntaxException
import java.io.IOException
import java.net.UnknownHostException
import java.util.concurrent.CancellationException

suspend fun <T> safeApiCall(apiCall: suspend () -> T): NetworkResponse<T> {
    return try {
        // Execute the API call and wrap the result in a Success
        NetworkResponse.Success(apiCall())
    } catch (e: Exception) {
        when (e) {
            is UnknownHostException -> {
                NetworkResponse.Error("No internet connection.")
            }
            is IOException -> {
                NetworkResponse.Error("Network error. Please try again.")
            }
            is JsonSyntaxException -> {
                NetworkResponse.Error("Data parsing error. Please try again later.")
            }
            is CancellationException -> throw e
            else -> {
                NetworkResponse.Error("Something went wrong. Please try again.")
            }
        }
    }
}
