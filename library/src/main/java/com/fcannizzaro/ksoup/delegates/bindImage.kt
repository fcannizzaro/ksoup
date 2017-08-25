package com.fcannizzaro.ksoup.delegates

import com.fcannizzaro.ksoup.IKsoup
import com.fcannizzaro.ksoup.util.extractImage
import kotlin.reflect.KProperty

/**
 * Created by Francesco Cannizzaro (fcannizzaro).
 */

class bindImage(private var query: String) {

    operator fun getValue(ref: IKsoup, property: KProperty<*>): String? = extractImage(ref.element, query)

}
