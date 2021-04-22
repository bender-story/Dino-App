package com.rahul.dino.core.network

interface NetworkConfigInterface {
    fun getBaseURL(): String
    fun getServiceType() : ServiceType
}