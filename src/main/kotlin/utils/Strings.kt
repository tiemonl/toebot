package utils

fun getResourceAsText(path: String) = object {}.javaClass.classLoader.getResource(path)?.readText()