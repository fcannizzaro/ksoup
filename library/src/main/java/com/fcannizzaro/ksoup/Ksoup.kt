@file:Suppress("UNCHECKED_CAST")

package com.fcannizzaro.ksoup

import com.fcannizzaro.ksoup.util.extractList
import org.jsoup.Jsoup
import org.jsoup.nodes.Element

/**
 * Created by Francesco Cannizzaro (fcannizzaro).
 */

class Ksoup(private var doc: Element) {

    constructor(html: String) : this(Jsoup.parse(html))

    fun <T> from(instance: IKsoup): T {

        with(instance) {

            element = doc

            if (query.isNotEmpty()) {
                element = doc.select(query).first()
            }

            afterBind()

        }

        return instance as T

    }

    fun <T> fromList(clazz: IKsoup): List<T> {
        return extractList(doc, clazz)
    }

}