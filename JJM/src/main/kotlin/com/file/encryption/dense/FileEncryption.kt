package com.file.encryption.dense

import com.file.encryption.JJM.DECRYPT_MODE
import com.file.encryption.JJM.ENCRYPT_MODE
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import javax.crypto.Cipher
import javax.crypto.CipherInputStream
import javax.crypto.CipherOutputStream
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

class FileEncryption {


    private lateinit var key: ByteArray

    lateinit var algorithm: String

    lateinit var transformation: String

    var mode: Int = 0

    var mDecrypt: Int = 0


    lateinit var inputStream: InputStream

    lateinit var fileInputStream: FileInputStream
    lateinit var fileOutputStream: FileOutputStream

    lateinit var inputFile: File
    lateinit var outputFile: File


    lateinit var readAllBytes: ByteArray
    fun setKey(k: ByteArray) {
        key = k
    }

    /**
     * Encrypt
     * 加密
     * @param npuFile
     * @param output
     */
    private fun encrypt(npuFile: File, output: File) {
        println("加密")

        val desk: SecretKey = SecretKeySpec(key, algorithm)
        val cipher = Cipher.getInstance(transformation)
        cipher.init(Cipher.ENCRYPT_MODE, desk)

        val fileInputStream = FileInputStream(npuFile)

        val cipherInputStream = CipherInputStream(fileInputStream, cipher)


        val fileOutputStream = FileOutputStream(output)

        val available = fileInputStream.available()

        val i = available / 100

        var k = i
        var z = 0
        var dataOfFile: Int
        progressMonitor?.progressMonitorStream(0)
        if (progressMonitor != null) {
            while (cipherInputStream.read().also { dataOfFile = it } > -1) {
                z++
                if (z > k) {
                    k = z + i
                    val progress = k / i
                    progressMonitor?.progressMonitorStream(progress)
                }
                fileOutputStream.write(dataOfFile)
            }

        } else {
            fileOutputStream.write(cipherInputStream.readAllBytes())
        }


        fileOutputStream.close()
        cipherInputStream.close()
        fileInputStream.close()
    }


    private fun encrypt(fileInputStream: FileInputStream, fileOutputStream: FileOutputStream) {
        val desk: SecretKey = SecretKeySpec(key, algorithm)
        val cipher = Cipher.getInstance(transformation)
        cipher.init(Cipher.ENCRYPT_MODE, desk)

        val cipherInputStream = CipherInputStream(fileInputStream, cipher)
        // val fileOutputStream = FileOutputStream(outputFile)
        fileOutputStream.write(cipherInputStream.readAllBytes())
        fileOutputStream.close()
        cipherInputStream.close()
        fileInputStream.close()
    }


    private fun encrypt(inputStream:InputStream, fileOutputStream: FileOutputStream) {
        val desk: SecretKey = SecretKeySpec(key, algorithm)
        val cipher = Cipher.getInstance(transformation)
        cipher.init(Cipher.ENCRYPT_MODE, desk)
        val cipherInputStream = CipherInputStream(inputStream, cipher)
        fileOutputStream.write(cipherInputStream.readAllBytes())
        fileOutputStream.close()
        cipherInputStream.close()
        fileInputStream.close()
    }


    private fun decrypt(npuFile: File, output: File) {
        val desk: SecretKey = SecretKeySpec(key, algorithm)
        val cipher = Cipher.getInstance(transformation)
        cipher.init(Cipher.DECRYPT_MODE, desk)

        val fileInputStream = FileInputStream(npuFile)

        val fileOutputStream = FileOutputStream(output)
        val cipherOutputStream = CipherOutputStream(fileOutputStream, cipher)


        if (progressMonitor != null) {
            val available = fileInputStream.available()

            val i = available / 100

            var k = i
            var z = 0
            var dataOfFile: Int


            while (fileInputStream.read().also { dataOfFile = it } > -1) {

                z++
                if (z > k) {
                    k = z + i
                    val progress = k / i
                    progressMonitor?.progressMonitorStream(progress)
                }

                cipherOutputStream.write(dataOfFile)

            }
        } else {
            cipherOutputStream.write(fileInputStream.readAllBytes())
        }


        cipherOutputStream.close()
        fileOutputStream.close()
        fileInputStream.close()
    }


    private fun decrypt(fileInputStream: FileInputStream, fileOutputStream: FileOutputStream) {
        val desk: SecretKey = SecretKeySpec(key, algorithm)
        val cipher = Cipher.getInstance(transformation)
        cipher.init(Cipher.DECRYPT_MODE, desk)

        val cipherOutputStream = CipherOutputStream(fileOutputStream, cipher)
        cipherOutputStream.write(fileInputStream.readAllBytes())
        cipherOutputStream.close()
        fileOutputStream.close()
        fileInputStream.close()
    }


    private fun decrypt(fileInputStream: InputStream, fileOutputStream: FileOutputStream) {
        val desk: SecretKey = SecretKeySpec(key, algorithm)
        val cipher = Cipher.getInstance(transformation)
        cipher.init(Cipher.DECRYPT_MODE, desk)

        val cipherOutputStream = CipherOutputStream(fileOutputStream, cipher)
        cipherOutputStream.write(fileInputStream.readAllBytes())
        cipherOutputStream.close()
        fileOutputStream.close()
        fileInputStream.close()
    }


    private fun decrypt(readAllBytes: ByteArray,  fileOutputStream: FileOutputStream) {
        val desk: SecretKey = SecretKeySpec(key, algorithm)
        val cipher = Cipher.getInstance(transformation)
        cipher.init(Cipher.DECRYPT_MODE, desk)
        val cipherOutputStream = CipherOutputStream(fileOutputStream, cipher)
        cipherOutputStream.write(readAllBytes)
        cipherOutputStream.close()
        fileOutputStream.close()
    }


    fun commit() {
        when (mode) {

            ENCRYPT_MODE -> encrypt()

            DECRYPT_MODE -> decrypt()

        }
    }

    private fun decrypt() {

        when (mDecrypt) {
            0 -> decrypt(inputFile, outputFile)
            1 -> decrypt(fileInputStream, fileOutputStream)
            2 -> decrypt(inputStream, fileOutputStream)
            3 -> decrypt(readAllBytes, fileOutputStream)
        }

    }


    private fun encrypt(){
        when (mDecrypt) {
            0 ->encrypt(inputFile, outputFile)
            1 -> encrypt(fileInputStream, fileOutputStream)
            2 -> encrypt(inputStream, fileOutputStream)
            3 ->  throw IllegalArgumentException("解密不支持  ByteArray 参数")
        }

    }


    private var progressMonitor: OnProgressMonitor? = null

    interface OnProgressMonitor {


        fun progressMonitorStream(progressMonitor: Int)
    }

    fun setOnProgressMonitor(block: (Int) -> Unit) {

        progressMonitor = object : OnProgressMonitor {
            override fun progressMonitorStream(progressMonitor: Int) {
                block(progressMonitor)
            }
        }
    }


}