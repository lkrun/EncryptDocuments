package encryption.args

object Args {


    fun init(args: Array<String>) {

        if (args[0] == "help") {

            println(
                " 第一个参数\n" +
                        " help 帮助 " +
                        " -e  加密 \n" +
                        " -e-eds \n" +
                        " -d  解密\n" +
                        " -d-eds \n" +
                        "第二个参数\n" +
                        "密码 \n" +
                        "批量重命名 java -jar jjm.jar r 20220918- mp4\n" +
                        "加密 java -jar jjm.jar -e-jjm 格式 替换格式\n"+
                        "解密 java -jar jjm.jar -d-jjm 格式 替换格式\n"
            )
        }

    }
}