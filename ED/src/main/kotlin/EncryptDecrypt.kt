import com.google.gson.Gson
import java.io.*
import java.util.*
import kotlin.collections.ArrayList

class EncryptDecrypt {

    private val byteArraySize = 1024000000
    private var path: String = "./"


    private var suffix = ".ed"

    private var folder: String = ""

    /**
     * Init
     * 当前目录
     * @param path
     */
    fun init(path: String) {

        this.path = path
    }

    fun setSuffix(s: String) {
        suffix = s
    }


    fun setFolder(f: String) {
        folder = f
    }

    /**
     * Encrypt
     * 加密
     */
    fun encrypt() {
        println("加密模式")

        val file = File(path)
        val listFiles = file.listFiles()

        if (listFiles == null) {
            if (file.name == "ED.jar") return
            encrypt(file)
            return
        } else if (listFiles.isEmpty()) {
            println("目录为null")
            return
        }

        listFiles.forEach {

            if (it.isFile) {
                if (it.name == "ED.jar") return
                encrypt(it)
            } else {
                println("目录" + it.path)
            }
        }
    }


    private fun encrypt(file: File) {
        val length1 = file.length()
        println("文件" + file.path + "  字节" + length1)
        val fileInputStream = FileInputStream(file)


        val lastIndexOf = file.path.lastIndexOf('\\')

        val substring = file.path.substring(0, lastIndexOf)

        val lastIndexOf1 = file.name.lastIndexOf(".")

        val format = file.name.substring(lastIndexOf1)
        val title = file.name.substring(0, lastIndexOf1)

        val ed = EDData(format, title)
        val gson = Gson()
        val toJson = gson.toJson(ed) + "data"

        val name = UUID.randomUUID().toString().replace("-", "")

        val outFile = File(substring, name + suffix)

        val fileOutputStream = FileOutputStream(outFile)

        fileOutputStream.write("ed".toByteArray())

        val toByteArray = toJson.toByteArray()
        toByteArray.forEachIndexed { index, byte ->
            val byte1 = EncodingDecoding.encoding(byte)
            toByteArray[index] = byte1
        }
        fileOutputStream.write(toByteArray)

        //约一个g

        if (length1 > byteArraySize) { //大文件

            val message = length1 / byteArraySize
            //   println(message)
            val message1 = length1 % byteArraySize
            //  println(message1)

            for (i in 0 until message) {
                val byteArray = ByteArray(byteArraySize)
                fileInputStream.read(byteArray)
                byteArray.forEachIndexed { index, byte ->
                    val byte1 = EncodingDecoding.encoding(byte)
                    byteArray[index] = byte1
                }
                fileOutputStream.write(byteArray)
            }

            if (message1 != 0L) {
                val byteArray = ByteArray(message1.toInt())
                fileInputStream.read(byteArray)
                byteArray.forEachIndexed { index, byte ->
                    val byte1 = EncodingDecoding.encoding(byte)
                    byteArray[index] = byte1
                }
                fileOutputStream.write(byteArray)
            }

        } else {
            val readAllBytes = fileInputStream.readAllBytes()
            readAllBytes.forEachIndexed { index, byte ->

                val byte1 = EncodingDecoding.encoding(byte)

                readAllBytes[index] = byte1
            }
            fileOutputStream.write(readAllBytes)
        }

        fileInputStream.close()
        fileOutputStream.close()
        println("加密完成" + outFile.path + " 字节 " + length1)
        if (length1 != file.length()) {
            System.err.println("数据异常 ")
        }
    }

    /**
     * Decrypt
     * 解密
     */
    fun decrypt() {
        println("解密模式")

        val file = File(path)
        val listFiles = file.listFiles()

        if (listFiles == null) {
            if (file.name == "ED.jar") return
            decrypt(file)
            return
        } else if (listFiles.isEmpty()) {
            println("目录为null")
            return
        }

        listFiles.forEach {

            if (it.isFile) {
                if (it.name == "ED.jar") return
                decrypt(it)
            } else {
                println("目录" + it.path)
            }
        }
    }

    private fun decrypt(file: File) {

        println("文件" + file.path + " 字节大小" + file.length())


        val length = file.length()

        if (length > byteArraySize) {
            decryptLarge(file)
            return
        }

        val fileInputStream = FileInputStream(file)
        val readAllBytes = fileInputStream.readAllBytes()

        val string = String(readAllBytes, 0, 2)

        if (string != "ed") {
            println("不是ed加密文件")
            return
        }

        val listJson = ArrayList<Byte>()
        var ix = 0
        val b: Byte = 100
        val c: Byte = 97
        val d: Byte = 116
        val e: Byte = 97

        var isFileProperties = false

        for (i in readAllBytes.indices) {
            if (i > 1) {
                val byte1 = EncodingDecoding.decoding(readAllBytes[i])
                if (byte1 == e && jByte(readAllBytes[i - 1]) == d && jByte(readAllBytes[i - 2]) == c && jByte(readAllBytes[i - 3]) == b) {
                    listJson.removeAt(listJson.size - 1)
                    listJson.removeAt(listJson.size - 1)
                    listJson.removeAt(listJson.size - 1)
                    ix = i
                    isFileProperties = true
                    break
                } else {
                    ix = i
                    listJson.add(byte1)
                }
            }
        }

        if (isFileProperties) {
            println("提取文件属性成功")
            ix++ //向前移动一个元素
        } else {
            println("提取文件属性失败")
        }

        val string1 = String(listJson.toByteArray())
        println(string1)

        val lastIndexOf = file.path.lastIndexOf('\\')
        val substring = file.path.substring(0, lastIndexOf)

        val gson = Gson()
        val toJson = gson.fromJson(string1, EDData::class.java)
        val outFile = File(substring, toJson.title + toJson.format)
        val fileOutputStream = FileOutputStream(outFile)

        val newArrayByte = ByteArray(readAllBytes.size - ix)
        for ((ii, i) in (ix until readAllBytes.size).withIndex()) {
            val byte1 = EncodingDecoding.decoding(readAllBytes[i])
            newArrayByte[ii] = byte1
        }

        fileOutputStream.write(newArrayByte)

        fileInputStream.close()
        fileOutputStream.close()
        println("解密完成  ${outFile.path}  字节 ${outFile.length()}")

        if (length != outFile.length()) {

            System.err.println("数据异常")
        }
    }


    private fun decryptLarge(file: File) {

        var fileOutputStream: FileOutputStream? = null

        var outFile: File? = null

        val length = file.length()
        val inp = FileInputStream(file)

        val bb = ByteArray(2)
        inp.read(bb)
        val string = String(bb, 0, 2)
        if (string != "ed") {
            println("不是ed加密文件")
            return
        }
        inp.close()

        val fileInputStream = FileInputStream(file)


        val message = length / byteArraySize
        //   println(message)
        val message1 = length % byteArraySize
        //  println(message1)

        var ix = 0//属性数据最后索引

        for (ii in 0 until message.toInt()) {

            if (ii == 0) {
                val newArrayByte = ByteArray(byteArraySize)
                fileInputStream.read(newArrayByte)

                val listJson = ArrayList<Byte>()
                val b: Byte = 100
                val c: Byte = 97
                val d: Byte = 116
                val e: Byte = 97

                var isFileProperties = false

                for (i in newArrayByte.indices) {
                    if (i > 1) {
                        val byte1 = byteDecrypt(newArrayByte[i])
                        if (byte1 == e && byteDecrypt(newArrayByte[i - 1]) == d && byteDecrypt(newArrayByte[i - 2]) == c && byteDecrypt(newArrayByte[i - 3]) == b) {
                            listJson.removeAt(listJson.size - 1)
                            listJson.removeAt(listJson.size - 1)
                            listJson.removeAt(listJson.size - 1)
                            ix = i
                            isFileProperties = true
                            break
                        } else {
                            ix = i
                            listJson.add(byte1)
                        }

                    }
                }
                if (isFileProperties) {
                    println("提取大文件属性成功")
                    ix++ //向前移动一个元素
                } else {
                    println("提取大文件属性失败")
                }

                val string1 = String(listJson.toByteArray())

                println(string1)


                val lastIndexOf = file.path.lastIndexOf('\\')
                val substring = file.path.substring(0, lastIndexOf)


                val gson = Gson()
                val toJson = gson.fromJson(string1, EDData::class.java)

                outFile = File(substring + folder, toJson.title + toJson.format)

                fileOutputStream = FileOutputStream(outFile)


                val arrayByte = ByteArray(newArrayByte.size - ix)

                for ((iii, i) in (ix until newArrayByte.size).withIndex()) {

                    val byte1 = byteDecrypt(newArrayByte[i])
                    arrayByte[iii] = byte1
                }

                fileOutputStream.write(arrayByte)


            } else {

                val byteArray = ByteArray(byteArraySize)
                fileInputStream.read(byteArray)
                val arrayByteDecrypt = arrayByteDecrypt(byteArray)
                fileOutputStream!!.write(arrayByteDecrypt)

            }
        }

        if (message1 != 0L) {
            val byteArray = ByteArray(message1.toInt())
            fileInputStream.read(byteArray)
            val arrayByteDecrypt = arrayByteDecrypt(byteArray)
            fileOutputStream!!.write(arrayByteDecrypt)
        }

        fileInputStream.close()
        fileOutputStream!!.close()


        if (length - ix == outFile!!.length()) {

            println("解密完成 ${outFile.path}")

        } else {
            println("解密失败 ${outFile.path}")
        }
    }

    /**
     * Array byte decrypt
     * 字节数组解密
     * @param byteArray
     * @return
     */
    private fun arrayByteDecrypt(byteArray: ByteArray): ByteArray {

        byteArray.forEachIndexed { index, byte ->
            val byte1 = EncodingDecoding.decoding(byte)
            byteArray[index] = byte1
        }

        return byteArray
    }

    /**
     * Byte decrypt
     * 字节解密
     * @param byte
     * @return
     */
    private fun byteDecrypt(byte: Byte): Byte {

        return EncodingDecoding.decoding(byte)
    }


    private fun jByte(byte: Byte): Byte {
        return EncodingDecoding.decoding(byte)
    }

    enum class ED {
        E,
        D,
    }

}