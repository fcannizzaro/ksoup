package com.fcannizzaro.ksoup.delegates

import com.fcannizzaro.ksoup.IKsoup
import com.fcannizzaro.ksoup.util.extractText
import kotlin.reflect.KProperty

/**
 * Created by Francesco Cannizzaro (fcannizzaro).
 */

class bindText(private var query: String, private val trim: Boolean = true) {

    private var value: String? = null
    private var assigned = false

    operator fun getValue(ref: IKsoup, property: KProperty<*>): String? {

        if (!assigned && ref.element != null) {
            assigned = true
            value = extractText(ref.element!!, query, trim)
        }

        return value

    }

    operator fun setValue(ref: IKsoup, property: KProperty<*>, value: String?) {
        this.value = value
        this.assigned = true
    }

}