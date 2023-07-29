package com.crxapplications.wisquiz.core.data.api

object ResponseCode {
    val SUCCESS = 0
    val NO_RESULTS = 1 // Not enough questions.
    val INVALID_PARAMETER = 2
    val TOKEN_NOT_FOUND = 3
    val TOKEN_EMPTY = 4 // All questions exhausted. Token need to be reset

}