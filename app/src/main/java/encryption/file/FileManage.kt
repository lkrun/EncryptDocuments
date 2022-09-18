package encryption.file

import dense.JJM
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

class FileManage {


    fun init() {

        val file = File("./db/acb.db")//原文件

        val fileInputStream = FileInputStream(file)
        val readAllBytes = fileInputStream.readAllBytes()

        println(readAllBytes[0])
        println(readAllBytes[readAllBytes.size - 1])

        println("源码")

        JJM.encryption.setPassword("dfs5f4sdDSF").encryptionReadAllBytes(readAllBytes)

        val encryption = JJM.encryption.newReadAllBytes
        println(encryption[0])
        println(encryption[encryption.size - 1])
        println("加密密码")

        val file2 = File("./db/acb1.db")  //加密文件
        val fileOutputStream = FileOutputStream(file2)
        fileOutputStream.write(encryption)

        fileOutputStream.close()
        fileInputStream.close()

        val file3 = File("./db/acb2.db") //解密文件
        val fileInputStream1 = FileInputStream(file2)

        JJM.decrypt.setPassword("dfs5f4sdDSF").decryptReadAllBytes(fileInputStream1.readAllBytes())
        val decrypt = JJM.decrypt.newReadAllBytes

        println(decrypt[0])
        println(decrypt[decrypt.size - 1])
        println("解密密码")
        val fileOutputStream1 = FileOutputStream(file3)
        fileOutputStream1.write(decrypt)



        fileOutputStream1.close()
        fileInputStream1.close()



    }


}