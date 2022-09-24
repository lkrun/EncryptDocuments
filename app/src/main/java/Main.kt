import com.file.encryption.JJM
import com.file.encryption.enum.Algorithm
import com.file.encryption.enum.Transformation
import encryption.terminal.FileEncryptionDecryption

fun main(args: Array<String>) {

    FileEncryptionDecryption(args)




    val str="c4b988b0da1d5c6588341f5dd8ec8b6c7349aa96"


    val key = String(str.substring(0,8).toByteArray(), Charsets.UTF_8)

    JJM.setKey(key)
        .setAlgorithm(Algorithm.EDS)
        .setTransformation(Transformation.EDSECBPKCS5Padding)
        .setPath("./db/acb.db", "./db/acbEDS.db")
       // .setOnProgressMonitor { println(it) }
        .setMode(JJM.ENCRYPT_MODE)
        .commit()


 /*   JJM.setKey("12345678")
        .setAlgorithm(Algorithm.EDS)
        .setTransformation(Transformation.EDSECBPKCS5Padding)
        .setPath("./db/22.jpg", "./db/223.jpg")
        .setOnProgressMonitor {
            println(it)
        }
        .setMode(JJM.DECRYPT_MODE)
        .commit()*/
}

