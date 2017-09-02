package com.fcannizzaro.ksoup.delegates

import com.fcannizzaro.ksoup.IKsoup
import com.fcannizzaro.ksoup.util.extractImage
import kotlin.reflect.KProperty

/**
 * Created by Francesco Cannizzaro (fcannizzaro).
 */

class bindImage(private val query: String, private val trim: Boolean = true) {

    private var value: String? = null
    private var assigned = false

    operator fun getValue(ref: IKsoup, property: KProperty<*>): String? {

        if (!assigned && ref.element != null) {
            assigned = true
            value = extractImage(ref.element!!, query, trim)
        }

        return value

    }

    operator fun setValue(ref: IKsoup, property: KProperty<*>, value: String?) {
        this.value = value
        this.assigned = true
    }

}
