package com.fcannizzaro.ksoup.delegates

import com.fcannizzaro.ksoup.IKsoup
import com.fcannizzaro.ksoup.util.extractText
import kotlin.reflect.KProperty

/**
 * Created by Francesco Cannizzaro (fcannizzaro).
 */

class bindText(private var query: String, private val trim: Boolean = true) {

    operator fun getValue(ref: IKsoup, property: KProperty<*>): String? = extractText(ref.element, query, trim)

}