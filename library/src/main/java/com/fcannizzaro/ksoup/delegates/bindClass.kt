@file:Suppress("UNCHECKED_CAST")

package com.fcannizzaro.ksoup.delegates

import com.fcannizzaro.ksoup.IKsoup
import kotlin.reflect.KProperty

/**
 * Created by Francesco Cannizzaro (fcannizzaro).
 */

class bindClass(private val instance: IKsoup, private val parent: IKsoup) {

    private var value: Any? = null
    private var assigned = false

    operator fun <T> getValue(ref: IKsoup, property: KProperty<*>): T {

        if (!assigned) {

            assigned = true

            with(instance) {

                element = parent.element

                if (query.isNotEmpty() && element != null) {
                    element = element!!.select(query).first()
                }

            }

            value = instance

        }

        return value as T

    }

    operator fun <T> setValue(ref: IKsoup, property: KProperty<*>, value: T?) {
        this.value = value
        this.assigned = true
    }

}