package com.fcannizzaro.ksoup.delegates

import com.fcannizzaro.ksoup.IKsoup
import com.fcannizzaro.ksoup.util.extractLink
import kotlin.reflect.KProperty

/**
 * Created by Francesco Cannizzaro (fcannizzaro).
 */

class bindLink(private var query: String) {

    operator fun getValue(ref: IKsoup, property: KProperty<*>): String? = extractLink(ref.element, query)

    operator fun setValue(ref: IKsoup, property: KProperty<*>, value: String?) {}

}