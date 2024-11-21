package cc.aa64.saigo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform