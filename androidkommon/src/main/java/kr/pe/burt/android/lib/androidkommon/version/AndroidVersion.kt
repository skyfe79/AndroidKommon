package kr.pe.burt.android.lib.androidkommon.version

/**
 * Created by burt on 2016. 6. 4..
 */
import android.os.Build

/**
 * Created by burt on 2016. 6. 3..
 */
object AndroidVersion {

    fun lollipop(): Int = Build.VERSION_CODES.LOLLIPOP
    fun kitkatWatch(): Int = Build.VERSION_CODES.KITKAT_WATCH
    fun kitkat(): Int = Build.VERSION_CODES.KITKAT
    fun jellyBeanMR2(): Int = Build.VERSION_CODES.JELLY_BEAN_MR2
    fun jellyBeanMR1(): Int = Build.VERSION_CODES.JELLY_BEAN_MR1
    fun jellyBean(): Int = Build.VERSION_CODES.JELLY_BEAN
    fun iceCreamSandwichMR1(): Int = Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1
    fun iceCreamSandwich(): Int = Build.VERSION_CODES.ICE_CREAM_SANDWICH
    fun honeycombMR2(): Int = Build.VERSION_CODES.HONEYCOMB_MR2
    fun honeycombMR1(): Int = Build.VERSION_CODES.HONEYCOMB_MR1
    fun honeycomb(): Int = Build.VERSION_CODES.HONEYCOMB
    fun gingerbreadMR1(): Int = Build.VERSION_CODES.GINGERBREAD_MR1
    fun gingerbread(): Int = Build.VERSION_CODES.GINGERBREAD
    fun froyo(): Int = Build.VERSION_CODES.FROYO
    fun eclairMR1(): Int = Build.VERSION_CODES.ECLAIR_MR1
    fun eclair01(): Int = Build.VERSION_CODES.ECLAIR_0_1
    fun eclair(): Int = Build.VERSION_CODES.ECLAIR
    fun donut(): Int = Build.VERSION_CODES.DONUT
    fun curDevelopment(): Int = Build.VERSION_CODES.CUR_DEVELOPMENT
    fun cupkake(): Int = Build.VERSION_CODES.CUPCAKE
    fun base11(): Int = Build.VERSION_CODES.BASE_1_1
    fun base(): Int = Build.VERSION_CODES.BASE

    fun current(): Int = Build.VERSION.SDK_INT

}

/***************************************************************************************************
private fun main(args: Array<String>) {
if(AndroidVersion.current() < AndroidVersion.lollipop()) println(1) else println(2)
}
 **************************************************************************************************/