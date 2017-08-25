@file:Suppress("UNCHECKED_CAST")

package com.fcannizzaro.ksoup

import org.jsoup.nodes.Element

/**
 * Created by Francesco Cannizzaro (fcannizzaro).
 */


fun Element.first(query: String): Element? {

    val dom = select(query)

    if (dom.size > 0) {
        return dom.first()
    }

    return null

}

fun String.trim(condition: Boolean): String = if (condition) trim() else this