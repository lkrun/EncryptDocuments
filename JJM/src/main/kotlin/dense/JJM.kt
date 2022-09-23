package dense

import com.file.encryption.FileEncryption
import com.file.encryption.enum.Algorithm
import com.file.encryption.enum.Transformation
import java.io.File
import java.io.FileInputStream
import java.io.InputStream

object JJM {
    /**
     * Encrypt Mode
     * 加密
     */
    const val ENCRYPT_MODE = 1

    /**
     * Decrypt Mode
     * 解密
     */
    const val DECRYPT_MODE = 2
    val decrypt = Decrypt()

    val encryption = Encryption()

    private val fileEncryption = FileEncryption()


    fun setKey(key: String): JJM {

        setKey(key.toByteArray())

        return this
    }


    fun setKey(key: ByteArray): JJM {
        fileEncryption.setKey(key)
        return this
    }


    fun setAlgorithm(algorithm: Algorithm): JJM {
        setAlgorithm(algorithm.algorithm)
        return this
    }


    fun setAlgorithm(algorithm: String): JJM {
        fileEncryption.algorithm = algorithm
        return this
    }

    fun setTransformation(transformation: Transformation): JJM {
        setTransformation(transformation.transformation)
        return this
    }


    fun setTransformation(transformation: String): JJM {
        fileEncryption.transformation = transformation
        return this
    }

    fun setPath(inputFile: String, outputFile: String): JJM {
        setPath(File(inputFile), File(outputFile))
        return this
    }


    fun setPath(inputFile: File, outputFile: File): JJM {
        fileEncryption.inputFile = inputFile
        fileEncryption.outputFile = outputFile

        setPath(FileInputStream(inputFile), outputFile)
        return this
    }

    fun setPath(fileInputStream: InputStream, outputFile: File) {

        fileEncryption.fileInputStream = fileInputStream
        fileEncryption.outputFile = outputFile


    }

    fun setMode(mode: Int): JJM {
        fileEncryption.mode = mode
        return this
    }


    fun commit(): JJM {
        fileEncryption.commit()
        return this
    }


    fun setOnProgressMonitor(block: (Int) -> Unit): JJM {
        fileEncryption.setOnProgressMonitor(block)
        return this
    }
}