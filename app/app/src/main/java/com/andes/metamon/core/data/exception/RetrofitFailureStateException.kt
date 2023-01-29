package com.andes.metamon.core.data.exception

class RetrofitFailureStateException(error: String?, val code: Int) : Exception(error)
