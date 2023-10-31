package com.example.customexceptions.domain

sealed class CustomException( message: String) :Exception(message) {

    class NetworkException(message: String) : CustomException(message)
    class NotFoundException(message: String) : CustomException(message)
    class RequestTimeoutException(message: String) : CustomException(message)
}

