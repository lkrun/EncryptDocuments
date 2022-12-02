class App(private val args: Array<String>) {
    private val encryptDecrypt = EncryptDecrypt()

    /**
     * Mode
     * 模式
     */
    private var mode = EncryptDecrypt.ED.D.name

    private var path = "./"

    private var suffix = ".ed"

    private var folder: String = "ed"

    init {
        firstParameter()

    }

    /**
     * First parameter
     * 第一个参数
     */
    private fun firstParameter() {
        if (args.isNotEmpty()) {

            when (args[0]) {

                "help" -> {
                    println(
                        "第一个参数 第二个参数 第三个参数 第四个参数 \n \n" +
                                "0 为默认参数\n" +
                                "第一个参数: \n" +
                                "help 帮助" +
                                "E 加密模式\n" +
                                "D 解密模式\n" +
                                "第二个参数:\n" +
                                "路径\n" +
                                "第三个参数: \n" +
                                "文件格式\n" +
                                "第四个参数:\n" +
                                "输出路径"
                    )
                }

                EncryptDecrypt.ED.E.name, EncryptDecrypt.ED.D.name -> {
                    mode = args[0]
                    secondParameter()
                    thirdParameter()
                    fourthParameter()
                    main()
                }

                else -> {
                    println("不是ed命令")
                }

            }
        }
    }

    /**
     * Second parameter
     * 第二个参数
     */
    private fun secondParameter() {
        if (args.size == 2) {
            if (args[1] == "0") return
            if (args[1].isNotEmpty()) {
                path = args[1]
            }
        }
    }

    /**
     * Third parameter
     * 第三个参数
     */
    private fun thirdParameter() {
        if (args.size == 3) {
            if (args[2] == "0") return
            if (args[2].isNotEmpty()) {
                suffix = args[2]
            }
        }
    }

    /**
     * Fourth parameter
     * 第4个参数
     */
    private fun fourthParameter() {
        if (args.size == 4) {
            if (args[3] == "0") return
            if (args[3].isNotEmpty()) {
                folder = args[3]
            }
        }
    }

    private fun main() {
        encryptDecrypt.init(path)
        encryptDecrypt.setSuffix(suffix)
        encryptDecrypt.setFolder("\\$folder")

        when (mode) {
            EncryptDecrypt.ED.E.name -> {
                encryptDecrypt.encrypt()
            }
            EncryptDecrypt.ED.D.name -> {
                encryptDecrypt.decrypt()
            }
            else -> {
                println("输入异常")
            }
        }


    }
}