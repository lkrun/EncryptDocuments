package dense

import kotlin.math.abs

class Encryption {


    private var key: ByteArray


    init {
        key= byteArrayOf(1,2,2,2,2,2,2)
    }
    lateinit var newReadAllBytes: ByteArray
    private var a = 0
    private var i = 0

    private var b: Byte = 0
    fun setPassword(password: String): Encryption {


        val list = ArrayList<Byte>()
        password.toByteArray().forEach {

            it.toString().forEach { c ->
                list.add(c.toString().toInt().toByte())
            }
        }

        key = list.toByteArray()
        return this
    }
    fun encryptionReadAllBytes(readAllBytes: ByteArray) {

        newReadAllBytes = ByteArray(readAllBytes.size)

        for ((i, byte) in readAllBytes.withIndex()) {
            this.i=i
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
        val inv = (byte - 1).inv().toByte()//负数

       // val i = (inv + 127).toByte() //整数

        //integerEncryption(i)

        newReadAllBytes[i] = inv
    }

    /**
     * Negative as integer
     *
     * @param byte  负数
     */
    private fun negativeAsInteger(byte: Byte) {
        val abs = abs(byte.toInt()).toByte()  //整数

       // val l = abs - 128//负数

       // negativeEncryption(l.toByte())
        newReadAllBytes[i] = abs
    }

    /**
     * Integer encryption
     *
     * @param byte 整数
     */
    private fun integerEncryption(byte: Byte) {
        val k = byte - key[a] // 负数 可能整数

        newReadAllBytes[i] = k.toByte() //整数


    }

    /**
     * Negative encryption
     *
     * @param byte 负数
     */
    private fun negativeEncryption(byte: Byte) {

        val k = byte + key[a] //整数  可能负数


        newReadAllBytes[i] = k.toByte() //整数
    }
}