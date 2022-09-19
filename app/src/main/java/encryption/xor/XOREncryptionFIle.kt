package encryption.xor

import java.io.*


class XOREncryptionFIle {

    private var numOfEncAndDec = 564332135 //加密解密秘钥
    private var dataOfFile = 0 //文件字节内容


    fun setPassword(password: String): XOREncryptionFIle {


        numOfEncAndDec = password.toByteArray().decodeToString().toInt()
        return this
    }

    /**
     * Encrypt
     * 加密
     * @param npuFile
     * @param output
     */
    fun encrypt(npuFile: File, output: File) {
        val fis: InputStream = FileInputStream(npuFile)
        val fos: OutputStream = FileOutputStream(output)
        while (fis.read().also { dataOfFile = it } > -1) {
            fos.write(dataOfFile xor numOfEncAndDec)
        }
        fis.close()
        fos.flush()
        fos.close()
    }

    fun decrypt(npuFile: File, output: File) {


        val fis: InputStream = FileInputStream(npuFile)
        val fos: OutputStream = FileOutputStream(output)

        while (fis.read().also { dataOfFile = it } > -1) {
            fos.write(dataOfFile xor numOfEncAndDec)

        }
        fis.close()
        fos.flush()
        fos.close()
    }

}