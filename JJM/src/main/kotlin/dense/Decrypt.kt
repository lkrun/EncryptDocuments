package dense

import kotlin.math.abs

class Decrypt {


    private var key: ByteArray
    init {
        key= byteArrayOf(1,2,2,2,2,2,2)
    }
    lateinit var newReadAllBytes: ByteArray
    private var a = 0
    private var i = 0

    fun setPassword(password: String): Decrypt {

        val list = ArrayList<Byte>()
        password.toByteArray().forEach {

            it.toString().forEach { c ->
                list.add(c.toString().toInt().toByte())
            }
        }

        key = list.toByteArray()
        return this
    }


    fun decryptReadAllBytes(readAllBytes: ByteArray) {
        newReadAllBytes = ByteArray(readAllBytes.size)
        for ((i, byte) in readAllBytes.withIndex()) {
            this.i = i
            if (byte >= 0) { //整数
                integerAsNegative(byte)
            } else { //负数
                negativeAsInteger(byte)
            }

        }
        key.clone()
    }

    /**
     * Integer as negative
     *
     * @param byte 整数
     */
    private fun integerAsNegative(byte: Byte) {

        val inv = (byte - 1).inv().toByte()

        newReadAllBytes[i] = inv
    }

    /**
     * Negative as integer
     *
     * @param byte 负数
     */
    private fun negativeAsInteger(byte: Byte) {

        val abs = abs(byte.toInt()).toByte()  //整数

        newReadAllBytes[i] = abs
    }


}