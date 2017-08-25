@file:Suppress("UNCHECKED_CAST")

package com.fcannizzaro.ksoup.delegates

import com.fcannizzaro.ksoup.IKsoup
import kotlin.reflect.KProperty

/**
 * Created by Francesco Cannizzaro (fcannizzaro).
 */

class bindClass(private val instance: IKsoup, private val parent: IKsoup) {

    operator fun <T> getValue(ref: IKsoup, property: KProperty<*>): T {

        with(instance) {

            element = parent.element

            if (query.isNotEmpty()) {
                element = element.select(query).first()
            }

        }

        return instance as T

    }

}