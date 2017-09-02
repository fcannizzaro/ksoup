@file:Suppress("UNCHECKED_CAST")

package com.fcannizzaro.ksoup.delegates

import com.fcannizzaro.ksoup.IKsoup
import com.fcannizzaro.ksoup.util.extractList
import kotlin.reflect.KProperty

/**
 * Created by Francesco Cannizzaro (fcannizzaro).
 */

class bindList(private val clazz: IKsoup) {

    private var value: List<Any>? = null
    private var assigned = false

    operator fun <T> getValue(ref: IKsoup, property: KProperty<*>): List<T> {

        if (!assigned && ref.element != null) {
            assigned = true
            value = extractList(ref.element!!, clazz)
        }

        return value as List<T>

    }

    operator fun <T> setValue(ref: IKsoup, property: KProperty<*>, value: List<T>?) {
        this.value = value as List<Any>
        this.assigned = true
    }

}