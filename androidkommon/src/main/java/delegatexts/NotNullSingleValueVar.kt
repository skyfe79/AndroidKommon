package kr.co.desirelab.android.ranunculus.delegates

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * 단한번만 설정되어야 하는 속성에 사용한다
 * 예를 들어 싱글턴 인스턴스
 * Created by burt on 2016. 6. 2..
 */
class NotNullSingleValueVar<T>() : ReadWriteProperty<Any?, T> {

    private var value: T? = null

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return value ?: throw IllegalStateException("NotNullSingleValueVar<T> is not initialized")
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        this.value = if(this.value == null) value else throw IllegalStateException("NotNullSingleValueVar<T> is already initialized")
    }
}