package dense

import kotlin.math.abs

class Decrypt {


    private lateinit var key: ByteArray

    lateinit var newReadAllBytes: ByteArray
    private var a = 0
    private var i = 0

    fun setPassword(password: String): Decrypt {
        key = password.toByteArray()
        return this
    }


    fun decryptReadAllBytes(readAllBytes: ByteArray) {
        newReadAllBytes = ByteArray(readAllBytes.size)
        for ((i, byte) in readAllBytes.withIndex()) {
            this.i = i
            if (byte >= 0) { //整数
                decryptInteger(byte)
            } else { //负数
                decryptNegative(byte)
            }

            a++
            if (a == key.size) {
                a = 0
            }
        }
        key.clone()
    }

    /**
     * Decrypt integer
     *
     * @param byte 整数
     */
    private fun decryptInteger(byte: Byte) {

        var k = byte - key[a]

        if (k >= 0) {
            k -= 127
        }
        negativeAsInteger(k.toByte())
    }

    /**
     * Decrypt negative
     *
     * @param byte 负数
     */
    private fun decryptNegative(byte: Byte) {
        var k = byte + key[a] //整数  可能负数

        if (k < 0) {
            k += 128
        }
        integerAsNegative(k.toByte())
    }

    /**
     * Integer as negative
     *
     * @param byte 整数
     */
    private fun integerAsNegative(byte: Byte) {

        val k = (byte - 127).toByte()//负数

        val abs = abs(k.toInt()).toByte()  //整数

        newReadAllBytes[i] = abs
    }

    /**
     * Negative as integer
     *
     * @param byte 负数
     */
    private fun negativeAsInteger(byte: Byte) {

        val k = (byte + 128).toByte()//整数
        val inv = (k - 1).inv().toByte()

        newReadAllBytes[i] = inv
    }


}