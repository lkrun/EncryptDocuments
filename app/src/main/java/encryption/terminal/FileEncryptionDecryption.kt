package encryption.terminal

import encryption.args.Args
import encryption.des.EDSFile
import encryption.xor.XOREncryptionFIle
import java.io.File

class FileEncryptionDecryption(private val args: Array<String>) {


    init {

        if (args.isNotEmpty()) {
            Args.init(args)
        }

        // val fileManage = FileManage()
        // fileManage.init()

        if (args.isNotEmpty()) {
            getFile()
        }

    }


    private fun getFile() {

        val file = File("./")

        val listFiles = file.listFiles()

        listFiles?.forEach {
            if (it.name == "jjm.jar") return@forEach
            if (!it.isDirectory) {//不是目录
                isEncryption(it)
            }

        }

        println("完成")
    }

    private fun isEncryption(file: File) {

        if (args[0] == "-a") {
            encryption(file)
        } else if (args[0] == "-b") {
            decryption(file)
        }

        if (args[0] == "-a-eds") {
            encryption(file)
        } else if (args[0] == "-b-eds") {
            decryption(file)
        }

    }

    private fun encryption(file: File) {

        println("正在 加密 ${file.name}")

        val fileOu = File("./JJM")
        if (!fileOu.isDirectory) {
            fileOu.mkdirs()
        }

        val fileOutput = File("./JJM/${file.name}")


        val xorEncryptionFIle = XOREncryptionFIle()

        if (args.size==2) {
            xorEncryptionFIle.setPassword(args[1])
        }
        xorEncryptionFIle.encrypt(file, fileOutput)


        println("正在 加密完成 ${file.name}")
    }

    private fun decryption(file: File) {

        println("正在 解密 ${file.name}")
        val fileOu = File("./JJM")
        if (!fileOu.isDirectory) {
            fileOu.mkdirs()
        }

        val fileOutput = File("./JJM/${file.name}")


        val xorEncryptionFIle = XOREncryptionFIle()

        if (args.size==2) {
            xorEncryptionFIle.setPassword(args[1])
        }
        xorEncryptionFIle.decrypt(file, fileOutput)


        println("正在 解密完成 ${file.name}")
    }









    private fun encryptionEDS(file: File) {

        println("正在 加密 ${file.name}")

        val fileOu = File("./JJM")
        if (!fileOu.isDirectory) {
            fileOu.mkdirs()
        }

        val fileOutput = File("./JJM/${file.name}")

        val edsFile = EDSFile()
        edsFile.setPassword(args[1]).encrypt(file,fileOutput)


        println("正在 加密完成 ${file.name}")
    }

    private fun decryptionEDS(file: File) {

        println("正在 解密 ${file.name}")
        val fileOu = File("./JJM")
        if (!fileOu.isDirectory) {
            fileOu.mkdirs()
        }

        val fileOutput = File("./JJM/${file.name}")

        val edsFile = EDSFile()
        edsFile.setPassword(args[1]).decrypt(file,fileOutput)

        println("正在 解密完成 ${file.name}")
    }
}