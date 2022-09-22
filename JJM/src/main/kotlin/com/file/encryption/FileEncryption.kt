package com.file.encryption

import dense.JJM.DECRYPT_MODE
import dense.JJM.ENCRYPT_MODE
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import javax.crypto.Cipher
import javax.crypto.CipherInputStream
import javax.crypto.CipherOutputStream
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec
import javax.swing.ProgressMonitorInputStream

class FileEncryption {


    private lateinit var key: ByteArray

    lateinit var algorithm: String

    lateinit var transformation: String

    var mode: Int = 0

    lateinit var inputFile: File
    lateinit var outputFile: File
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

    private fun decrypt(npuFile: File, output: File) {
        val desk: SecretKey = SecretKeySpec(key, algorithm)
        val cipher = Cipher.getInstance(transformation)
        cipher.init(Cipher.DECRYPT_MODE, desk)

        val fileInputStream = FileInputStream(npuFile)

        val fileOutputStream = FileOutputStream(output)
        val cipherOutputStream = CipherOutputStream(fileOutputStream, cipher)

        val available = fileInputStream.available()

        val i = available / 100

        var k = i
        var z = 0
        var dataOfFile: Int
        if (progressMonitor != null) {
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


    fun commit() {
        when (mode) {

            ENCRYPT_MODE -> encrypt(inputFile, outputFile)

            DECRYPT_MODE -> decrypt(inputFile, outputFile)
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