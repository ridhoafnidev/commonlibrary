package com.ridhoafni.commons

import okhttp3.internal.and
import java.security.MessageDigest

object UtilsSha256 {
    fun getSha256(value: String): String {
        return try {
            val md = MessageDigest.getInstance("SHA-256")
            md.update(value.toByteArray())
            bytesToHex(md.digest())
        } catch (ex: Exception) {
            throw RuntimeException(ex)
        }
    }

    private fun bytesToHex(bytes: ByteArray): String {
        val result = StringBuffer()
        for (b in bytes) result.append(
            ((b and 0xff) + 0x100).toString(16).substring(1)
        )
        return result.toString()
    }
}