package singleton

import java.security.MessageDigest

object HashUtils {
    private const val HEX_CHARS = "0123456789ABCDEF"
    private const val SHIFT_RIGHT = 4

    fun sha512(input: String) = hashString("SHA-512", input)

    fun sha256(input: String) = hashString("SHA-256", input)

    fun sha1(input: String) = hashString("SHA-1", input)

    /**
     * Generates a hash for a given string using the given hash type
     * @param type
     * @param input
     */
    private fun hashString(type: String, input: String): String {
        val bytes = MessageDigest
            .getInstance(type)
            .digest(input.toByteArray())
        val result = StringBuilder(bytes.size * 2)

        bytes.forEach {
            val i = it.toInt()
            result.append(HEX_CHARS[i shr SHIFT_RIGHT and 0x0f])
            result.append(HEX_CHARS[i and 0x0f])
        }

        return result.toString()
    }
}