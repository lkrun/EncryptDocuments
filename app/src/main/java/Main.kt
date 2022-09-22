import com.file.encryption.enum.Algorithm
import com.file.encryption.enum.Transformation
import dense.JJM
import encryption.terminal.FileEncryptionDecryption

fun main(args: Array<String>) {

    FileEncryptionDecryption(args)





    JJM.setKey("12345678")
        .setAlgorithm(Algorithm.EDS)
        .setTransformation(Transformation.EDSECBPKCS5Padding)
        .setPath("./db/11.jpg","./db/22.jpg")
        .setOnProgressMonitor {
            println(it)
        }
        .commit(JJM.ENCRYPT_MODE)
}

