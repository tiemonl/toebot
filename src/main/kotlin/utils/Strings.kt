package utils

import java.io.File

fun getResourceAsText(path: String): String {
    return File(path).readText(Charsets.UTF_8)
}