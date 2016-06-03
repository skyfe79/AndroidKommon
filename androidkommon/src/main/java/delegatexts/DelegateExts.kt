package kr.co.desirelab.android.ranunculus.delegates

import kotlin.properties.ReadWriteProperty

/**
 * Created by burt on 2016. 6. 2..
 */
object DelegateExts {
    fun <T> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
}

