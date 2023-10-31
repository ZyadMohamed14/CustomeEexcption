package com.example.customexceptions.domain

enum class ErrorCode (val code: Int){
    NOT_FOUND(404),
    REQUEST_TIMEOUT(408)
}