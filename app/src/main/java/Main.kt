import encryption.args.Args
import encryption.terminal.FileEncryptionDecryption
import java.io.File

fun main(args: Array<String>) {

if (args.isNotEmpty()){
   Args.init(args)
}

   // val fileManage = FileManage()
   // fileManage.init()

if (args.isNotEmpty()){
    FileEncryptionDecryption(args)
}


}

