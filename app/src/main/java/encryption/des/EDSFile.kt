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
        val cipher = Cipher.getInstance("DES/ECB/PKCS5Padding")
        cipher.init(Cipher.ENCRYPT_MODE, desk)

        val fileInputStream = FileInputStream(npuFile)

        val cipherInputStream = CipherInputStream(fileInputStream, cipher)


        val fileOutputStream = FileOutputStream(output)
           fileOutputStream.write(cipherInputStream.readAllBytes())


 /*       while (cipherInputStream.read().also { dataOfFile = it } > -1) {
            fileOutputStream.write(dataOfFile)

        }*/

        fileOutputStream.close()
        cipherInputStream.close()
        fileInputStream.close()
    }

    fun decrypt(npuFile: File, output: File) {
        val desk: SecretKey = SecretKeySpec(key.toByteArray(), "DES")
        val cipher = Cipher.getInstance("DES/ECB/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, desk)


        val fileInputStream = FileInputStream(npuFile)

        val fileOutputStream = FileOutputStream(output)
        val cipherOutputStream = CipherOutputStream(fileOutputStream, cipher)
         cipherOutputStream.write(fileInputStream.readAllBytes())

  /*      while (fileInputStream.read().also { dataOfFile = it } > -1) {
            cipherOutputStream.write(dataOfFile)

        }
*/
        cipherOutputStream.close()
        fileOutputStream.close()
        fileInputStream.close()
    }

}