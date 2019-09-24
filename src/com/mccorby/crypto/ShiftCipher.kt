package com.mccorby.crypto

import kotlin.math.abs

class ShiftCipher {

    fun decrypt(input: String, key: Int): String {
        return input.asSequence().map { aChar ->
            var index = KEY_SPACE.indexOf(aChar) - key % (KEY_SPACE.length)
            if (index < 0) {
                index = KEY_SPACE.length - abs(index)
            }
            KEY_SPACE[index]
        }.joinToString("")
    }

    companion object {
        const val KEY_SPACE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    }
}

fun main() {
    val shiftCipher = ShiftCipher()
    print(shiftCipher.decrypt("NYYGURFGHQRAGFVAGURPYNFFNERURERSBENERNFBA", 13))
}