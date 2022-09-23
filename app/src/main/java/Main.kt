import com.file.encryption.enum.Algorithm
import com.file.encryption.enum.Transformation
import dense.JJM
import encryption.terminal.FileEncryptionDecryption

fun main(args: Array<String>) {

    FileEncryptionDecryption(args)




    val str=""


/*    JJM.setKey(str.substring(0,8))
        .setAlgorithm(Algorithm.EDS)
        .setTransformation(Transformation.EDSECBPKCS5Padding)
        .setPath("./db/acb.db", "./db/acbEDS2.db")
       // .setOnProgressMonitor { println(it) }
        .setMode(JJM.ENCRYPT_MODE)
        .commit()*/


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

