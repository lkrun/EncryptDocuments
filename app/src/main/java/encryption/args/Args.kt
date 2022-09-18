package encryption.args

object Args {


    fun init(args: Array<String>) {

        if (args[0] == "help") {

            println(
                " 第一个参数\n" +
                        " help 帮助 " +
                        " -a  加密 \n" +
                        " -b  解密\n" +
                        "第二个参数\n" +
                        "密码 \n"
            )
        }

    }
}