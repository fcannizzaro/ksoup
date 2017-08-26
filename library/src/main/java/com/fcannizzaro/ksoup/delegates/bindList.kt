package com.fcannizzaro.ksoup.delegates

import com.fcannizzaro.ksoup.IKsoup
import com.fcannizzaro.ksoup.util.extractList
import kotlin.reflect.KProperty

/**
 * Created by Francesco Cannizzaro (fcannizzaro).
 */

class bindList(private var clazz: IKsoup) {

    operator fun <T> getValue(ref: IKsoup, property: KProperty<*>): List<T> = extractList(ref.element, clazz)

    operator fun <T> setValue(ref: IKsoup, property: KProperty<*>, value: List<T>?) {}

}