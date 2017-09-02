package com.fcannizzaro.ksoup.delegates

import com.fcannizzaro.ksoup.IKsoup
import com.fcannizzaro.ksoup.KAttr
import com.fcannizzaro.ksoup.util.extractAttr
import kotlin.reflect.KProperty

/**
 * Created by Francesco Cannizzaro (fcannizzaro).
 */

class bindAttr(private val query: String, private val attr: String, private val trim: Boolean = true) {

    constructor(query: String, attr: KAttr, trim: Boolean = true) : this(query, attr.attr, trim)

    private var value: String? = null
    private var assigned = false

    operator fun getValue(ref: IKsoup, property: KProperty<*>): String? {

        if (!assigned && ref.element != null)  {
            assigned = true
            value = extractAttr(ref.element!!, query, attr, trim)
        }

        return value

    }

    operator fun setValue(ref: IKsoup, property: KProperty<*>, value: String?) {
        this.value = value
        this.assigned = true
    }

}