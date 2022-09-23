package encryption.terminal

import encryption.dense.JJM
import encryption.args.Args
import encryption.des.EDSFile
import encryption.xor.XOREncryptionFIle
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class FileEncryptionDecryption(private val args: Array<String>) {


    init {

        if (args.isNotEmpty()) {
            Args.init(args)
        }

        // val fileManage = FileManage()
        // fileManage.init()

        if (args.isNotEmpty()) {
            isEncryption()
        }

    }


    companion object {

        const val e = "-e"
        const val d = "-d"

        const val eDES = "-e-des"
        const val dDES = "-d-des"

        const val eJJM = "-e-jjm"
        const val dJJM = "-d-jjm"

        const val r = "r"

    }

    private fun isEncryption() {

        when (args[0]) {

            e -> encryption()

            d -> decryption()

            eDES -> encryptionEDS()

            dDES -> decryptionEDS()

            eJJM -> encryptionJJM()

            dJJM -> decryptionJJM()

            r -> rename()
        }

    }


    private fun rename() {
        val file = File("./")

        val listFiles = file.listFiles()
        var aa=0
        listFiles?.forEach {
            if (it.name == "jjm.jar") return@forEach
            if (!it.isDirectory) {//不是目录
                val fileOutput = File("./${args[1]}$aa.${args[2]}")

          aa++
                val renameTo = it.renameTo(fileOutput)

                if (renameTo) {
                    println("重命名成功")
                } else {
                    println("重名失败")
                }

            }

        }

    }

    private fun encryption() {


        val file = File("./")

        val listFiles = file.listFiles()
        val fileOu = File("./JJM")
        if (!fileOu.isDirectory) {
            fileOu.mkdirs()
        }
        listFiles?.forEach {
            if (it.name == "jjm.jar") return@forEach
            if (!it.isDirectory) {//不是目录
                println("正在 加密 ${it.name}")

                val fileOutput = File("./JJM/${it.name}")


                val xorEncryptionFIle = XOREncryptionFIle()

                if (args.size == 2) {
                    xorEncryptionFIle.setPassword(args[1])
                }
                xorEncryptionFIle.encrypt(it, fileOutput)


                println("正在 加密完成 ${it.name}")
            }

        }

    }

    private fun decryption() {


        val file = File("./")

        val listFiles = file.listFiles()

        val fileOu = File("./JJM")
        if (!fileOu.isDirectory) {
            fileOu.mkdirs()
        }


        listFiles?.forEach {
            if (it.name == "jjm.jar") return@forEach
            if (!it.isDirectory) {//不是目录
                println("正在 解密 ${it.name}")

                val fileOutput = File("./JJM/${it.name}")


                val xorEncryptionFIle = XOREncryptionFIle()

                if (args.size == 2) {
                    xorEncryptionFIle.setPassword(args[1])
                }
                xorEncryptionFIle.decrypt(it, fileOutput)


                println("正在 解密完成 ${it.name}")
            }

        }


    }


    private fun encryptionEDS() {


        val file = File("./")

        val listFiles = file.listFiles()
        val fileOu = File("./JJM")
        if (!fileOu.isDirectory) {
            fileOu.mkdirs()
        }
        listFiles?.forEach {
            if (it.name == "jjm.jar") return@forEach
            if (!it.isDirectory) {//不是目录
                println("正在 加密 ${it.name}")
                val fileOutput = File("./JJM/${it.name}")

                val edsFile = EDSFile()
                edsFile.setPassword(args[1]).encrypt(it, fileOutput)
                println("正在 加密完成 ${it.name}")
            }

        }


    }

    private fun decryptionEDS() {
        val file = File("./")

        val listFiles = file.listFiles()


        val fileOu = File("./JJM")
        if (!fileOu.isDirectory) {
            fileOu.mkdirs()
        }

        listFiles?.forEach {
            if (it.name == "jjm.jar") return@forEach
            if (!it.isDirectory) {//不是目录
                println("正在 解密 ${it.name}")
                val fileOutput = File("./JJM/${it.name}")

                val edsFile = EDSFile()
                edsFile.setPassword(args[1]).decrypt(it, fileOutput)

                println("正在 解密完成 ${it.name}")
            }

        }


    }


    private fun encryptionJJM() {


        val file = File("./")

        val listFiles = file.listFiles()
        val fileOu = File("./JJM")
        if (!fileOu.isDirectory) {
            fileOu.mkdirs()
        }
        listFiles?.forEach {
            if (it.name == "jjm.jar") return@forEach
            if (!it.isDirectory) {//不是目录
                println("正在 加密 ${it.name}")

                val fileInputStream = FileInputStream(it)
                val readAllBytes = fileInputStream.readAllBytes()

                val encryption = JJM.encryption
      /*          if (args.size == 2) {
                    encryption.setPassword(args[1])
                }*/

                encryption.encryptionReadAllBytes(readAllBytes)

                val replace = it.name.replace(args[1], args[2])

                val fileOu2 = File("./JJM/${replace}")
                val fileOutputStream = FileOutputStream(fileOu2)
                fileOutputStream.write(encryption.newReadAllBytes)

                fileOutputStream.close()
                fileInputStream.close()


                println("正在 加密完成 ${it.name}")
            }

        }


    }

    private fun decryptionJJM() {
        val file = File("./")

        val listFiles = file.listFiles()


        val fileOu = File("./JJM")
        if (!fileOu.isDirectory) {
            fileOu.mkdirs()
        }

        listFiles?.forEach {
            if (it.name == "jjm.jar") return@forEach
            if (!it.isDirectory) {//不是目录
                println("正在 解密 ${it.name}")

                val fileInputStream = FileInputStream(it)
                val readAllBytes = fileInputStream.readAllBytes()

                val decrypt = JJM.decrypt

         /*       if (args.size == 2) {
                    decrypt.setPassword(args[1])
                }
*/
                decrypt.decryptReadAllBytes(readAllBytes)
                val replace = it.name.replace( args[1],args[2])

                val fileOu2 = File("./JJM/${replace}")
                val fileOutputStream = FileOutputStream(fileOu2)
                fileOutputStream.write(decrypt.newReadAllBytes)


                println("正在 解密完成 ${it.name}")
            }

        }


    }


}