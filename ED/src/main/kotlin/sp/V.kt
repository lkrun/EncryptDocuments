package sp

import EDData
import com.google.gson.Gson
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.*

class V {

    private val byteArraySize = 1024000000
    private var path: String = "./v"
    private var path2: String = "./i"


    private var suffix = ".ed"

    private var folder: String = "\\ED"

    private var name = ""


    init {


        init()


    }

    private fun init() {


        println("加密模式")

        val file = File(path)
        val listFiles = file.listFiles()

        val file2 = File(path2)
        val listFiles1 = file2.listFiles()


        if (listFiles != null && listFiles1 != null) {


            if (listFiles.size != listFiles1.size) {
                System.err.println("异常")
                return
            }


            for (i in listFiles.indices) {
                name = UUID.randomUUID().toString().replace("-", "")
                val fi1 = listFiles1[i]//i
                val fi2 = listFiles[i]//v

                val substring = fi1.name.substring(0, fi1.name.lastIndexOf("."))
                if (substring == fi2.name) {
                    encrypt(fi2)
                    encrypt(fi1)
                } else {
                    System.err.println("异常 $substring  \n ${fi2.name}")
                }

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


        val outFile = File(substring+folder, name + suffix)

        val file1 = File(substring + folder)
        if (!file1.isDirectory){//判断文件夹
            file1.mkdirs()
        }


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

}