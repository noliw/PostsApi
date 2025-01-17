package com.nolawiworkineh.countriesapi.data.network.util

import kotlinx.serialization.SerializationException
import java.io.IOException
import java.net.UnknownHostException
import java.util.concurrent.CancellationException

suspend fun <T> safeApiCall(apiCall: suspend () -> T): Result<T> {
    return try {
        // Execute the API call and wrap the result in a Success
        Result.Success(apiCall())
    } catch (e: UnknownHostException) {
        // No internet or host unreachable
        e.printStackTrace()
        Result.Error(Throwable("No internet connection."))
    } catch (e: IOException) {
        // General I/O issues
        e.printStackTrace()
        Result.Error(Throwable("Network error. Please try again."))
    } catch (e: SerializationException) {
        // Serialization/deserialization issues
        e.printStackTrace()
        Result.Error(Throwable("Data parsing error. Please try again later."))
    } catch (e: Exception) {
        // Handle unexpected exceptions
        if (e is CancellationException) throw e // Re-throw cancellation exceptions
        e.printStackTrace()
        Result.Error(Throwable("Something went wrong. Please try again."))
    }
}
