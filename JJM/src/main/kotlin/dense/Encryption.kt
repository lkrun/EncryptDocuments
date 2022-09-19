package dense

import kotlin.math.abs

class Encryption {


    private lateinit var key: ByteArray

    lateinit var newReadAllBytes: ByteArray
    private var a = 0
    private var i = 0

    private var b: Byte = 0
    fun setPassword(password: String): Encryption {
        key = password.toByteArray()
        return this
    }

    fun encryptionReadAllBytes(readAllBytes: ByteArray) {
        newReadAllBytes = ByteArray(readAllBytes.size)

        for ((i, byte) in readAllBytes.withIndex()) {
            this.i = i
            b = byte
            if (byte.toInt() != -128) {
                if (byte >= 0) { //整数
                    integerAsNegative(byte)
                } else { //负数
                    negativeAsInteger(byte)
                }

            } else {
                newReadAllBytes[i] = byte
            }

            a++
            if (a == key.size) {
                a = 0
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

        println(inv)
        val i = (inv + 127).toByte() //整数

        println(i)
        integerEncryption(i)
    }

    /**
     * Negative as integer
     *
     * @param byte  负数
     */
    private fun negativeAsInteger(byte: Byte) {
        val abs = abs(byte.toInt())  //整数

        val l = abs - 128//负数

        negativeEncryption(l.toByte())
    }

    /**
     * Integer encryption
     *
     * @param byte 整数
     */
    private fun integerEncryption(byte: Byte) {
        var k = byte - key[a] // 负数 可能整数
        println(k)
        if (k >= 0) {
            k -= 128
        }
        println(k)
        if (k==-128){
            newReadAllBytes[i] = b
        }else{
            newReadAllBytes[i] = k.toByte() //整数
        }

    }

    /**
     * Negative encryption
     *
     * @param byte 负数
     */
    private fun negativeEncryption(byte: Byte) {

        var k = byte + key[a] //整数  可能负数

        if (k < 0) {
            k += 127
        }


        newReadAllBytes[i] = k.toByte() //整数
    }
}