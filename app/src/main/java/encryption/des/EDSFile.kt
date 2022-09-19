package encryption.des

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import javax.crypto.Cipher
import javax.crypto.CipherInputStream
import javax.crypto.CipherOutputStream
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

class EDSFile {


    private lateinit var key: String

    lateinit var newReadAllBytes: ByteArray
    private var a = 0
    private var i = 0

    fun setPassword(password: String): EDSFile {
        key = password
        return this
    }

    /**
     * Encrypt
     * 加密
     * @param npuFile
     * @param output
     */
    fun encrypt(npuFile: File, output: File) {
        val desk: SecretKey = SecretKeySpec(key.toByteArray(), "DES")
        val cipher = Cipher.getInstance("DES/CBC/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, desk)

        val fileInputStream = FileInputStream(npuFile)

        val cipherInputStream = CipherInputStream(fileInputStream, cipher)


        val fileOutputStream = FileOutputStream(output)
        fileOutputStream.write(cipherInputStream.readAllBytes())


        fileOutputStream.close()
        cipherInputStream.close()
        fileInputStream.close()
    }

    fun decrypt(npuFile: File, output: File) {
        val desk: SecretKey = SecretKeySpec(key.toByteArray(), "DES")
        val cipher = Cipher.getInstance("DES/CBC/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, desk)



        val fileInputStream = FileInputStream(npuFile)

        val fileOutputStream = FileOutputStream(output)
        val cipherOutputStream = CipherOutputStream(fileOutputStream, cipher)
        cipherOutputStream.write(fileInputStream.readAllBytes())

        cipherOutputStream.close()
        fileOutputStream.close()
        fileInputStream.close()
    }

}