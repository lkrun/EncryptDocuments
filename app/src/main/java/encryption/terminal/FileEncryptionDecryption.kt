package encryption.terminal

import dense.JJM
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class FileEncryptionDecryption(private val args: Array<String>) {


    init {
        getFile()
    }


    private fun getFile() {

        val file = File("./")

        val listFiles = file.listFiles()

        listFiles?.forEach {

            if (!it.isDirectory) {//不是目录
                isEncryption(it)
            }

        }

    }

    private fun isEncryption(file: File) {

        if (args[0] == "-a") {
            encryption(file)
        } else if (args[0] == "-b") {
            decryption(file)
        }

    }

    private fun encryption(file: File) {

        val fileInputStream = FileInputStream(file)
        val readAllBytes = fileInputStream.readAllBytes()

        JJM.encryption.setPassword(args[1]).encryptionReadAllBytes(readAllBytes)
        val fileOu = File("./JJM")
        if (!fileOu.isDirectory) {
            fileOu.mkdirs()
        }
        val fileOu2 = File("./JJM/${file.name}")
        val fileOutputStream = FileOutputStream(fileOu2)
        fileOutputStream.write(JJM.encryption.newReadAllBytes)

        fileOutputStream.close()
        fileInputStream.close()
    }

    private fun decryption(file: File) {

        val fileInputStream = FileInputStream(file)
        val readAllBytes = fileInputStream.readAllBytes()

        JJM.decrypt.setPassword(args[1]).decryptReadAllBytes(readAllBytes)
        val fileOu = File("./JJM")
        if (!fileOu.isDirectory) {
            fileOu.mkdirs()
        }
        val fileOu2 = File("./JJM/${file.name}")
        val fileOutputStream = FileOutputStream(fileOu2)
        fileOutputStream.write(JJM.decrypt.newReadAllBytes)

        fileOutputStream.close()
        fileInputStream.close()

    }
}