package com.klekchyan.harrypottermultiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform