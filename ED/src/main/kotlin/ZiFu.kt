import java.util.*
import kotlin.collections.ArrayList

class ZiFu {
    init {
        encodingByte_EByte_D()
    }

    /**
     * Character generation
     * 生成整数变量
     */
    fun characterGeneration() {
        for (i in 1 until 128) {
            val s = "private const val byteE$i: Byte =$i"
            println(s)
        }

    }

    /**
     * Character generation2
     * 生成非整数变量
     */
    fun characterGeneration2() {
        for (i in 1 until 129) {
            val s = "private const val byteE_$i: Byte =${(i - 1).inv()}"
            println(s)
        }
    }


    private fun byteD() { //生成整数


        val list = ArrayList<Int>()
        val random = Random()



        while (list.size < 128) {

            val nextInt = random.nextInt(0, 128)
            if (!list.contains(nextInt)) {
                list.add(nextInt)
            }
        }

         var index=0
        list.forEach {
           // print("$it,")

            val s = "private const val byteD$index: Byte =$it"
            index++
            println(s)
        }

    }



    private fun byteDD() { //非整数


        val list = ArrayList<Int>()
        val random = Random()



        while (list.size < 128) {

            val nextInt = random.nextInt( 1,129)
            if (!list.contains(nextInt)) {
                list.add(nextInt)
             //   println(nextInt)
            }
        }

        var index=0
        list.forEach {
            // print("$it,")
            index++
            val s = "private const val byteD_$index: Byte =${(it - 1).inv()}"

            println(s)
        }

    }



     private fun encodingByteEByteD(){

         for (i in 1 until 128) {
             val s = "byteE$i -> byteD_$i"
             println(s)
         }

         for (i in 1 until 128) {
             val s = "byteE_$i -> byteD$i"
             println(s)
         }

     }


    private fun encodingByte_EByte_D(){

        for (i in 1 until 128) {
            val s = "byteD$i -> byteE_$i"
            println(s)
        }

        for (i in 1 until 128) {
            val s = "byteD_$i -> byteE$i"
            println(s)
        }

    }



}